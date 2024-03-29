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
<title>Le Pr�sident est ...</title>
</head>
<body>
	<h1>Le Pr�sident est ...</h1>
	<% President president = President.getPresident(); 
	if (president != null) { %>
		<img src="<%=president.image %>"/><br>
		<h2><%=president.name %></h2>
	<%  } else { %>
	<img  src="image/presidents.png"/><br/>
	<strong>Le pr�sident ne sera annonc� qu'� partir du workshop</strong><br/>
	<br>
	<%  }  %>

	<% UserService userService = UserServiceFactory.getUserService();
	   User user = userService.getCurrentUser();
	   if (user == null) { %>
	   Bonjour, <a href="<%=userService.createLoginURL(request.getRequestURI())%>">identifiez-vous</a> 
	   avant de pouvoir <b>commenter l'�lection</b>
	   <% } else { %>
		   
			 <% 
		        String userComment = request.getParameter("user-comment");
		        if (userComment!=null) {
		        	StoredComments.store(userComment, user.getNickname());
		        }
		        
		        List<Comment> comments = StoredComments.retrieveAll();
		        for (Comment comment : comments) {
		        %>
				    <%=comment.getUser()%> : <%=comment.getText()%><br/>
		        <% } %>

			<form action="" method="post">
			
				<textarea name="user-comment"></textarea>
				<input type="submit" value="C'est mon avis"/>
			</form>
			<a href="<%=userService.createLogoutURL(request.getRequestURI()) %>">d�connexion</a>
	<%  } 	%>

</body>
</html>