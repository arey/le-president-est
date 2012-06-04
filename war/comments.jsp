<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="com.google.appengine.api.users.*" %>
<%@ page import="com.moi.lepresident.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Le Président est ...</title>
</head>
<body>
	<h1>Le Président est ...</h1>
	<img  src="image/presidents.png"/>
	<br>

	<% UserService userService = UserServiceFactory.getUserService();
	   User user = userService.getCurrentUser();
	   if (user == null) { %>
	   Bonjour, <a href="<%=userService.createLoginURL(request.getRequestURI())%>">identifiez-vous</a> 
	   avant de pouvoir <b>commenter l'élection</b>
	   <% } else { %>
		   
			 <% 
		        String userComment = request.getParameter("user-comment");
		        if (userComment!=null) {
		        	StoredComments.store(userComment, user.getNickname());
		        }
		        
		        List<Entity> comments = StoredComments.retrieveAll();
		        for (Entity comment : comments) {
		        %>
				    <%=comment.getProperty("user")%> : <%=comment.getProperty("text")%><br/>
		        <% } %>

			<form action="" method="post">
			
				<textarea name="user-comment"></textarea>
				<input type="submit" value="C'est mon avis"/>
			</form>
			<a href="<%=userService.createLogoutURL(request.getRequestURI()) %>">déconnexion</a>
	<%  } 	%>

</body>
</html>