<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Le Président est ...</title>
</head>
<body>
	<h1>Le Président est ...</h1>
	<img  src="image/presidents.png"/>
	 <% 
        String comment = request.getParameter("user-comment");
	 	if (comment==null) {
	 		comment = "";
	 	}
     %>
    <p>Vous: <%= comment %></p>
	<form action="" method="post">
	
		<textarea name="user-comment"></textarea>
		<input type="submit" value="C'est mon avis"/>
	</form>

</body>
</html>