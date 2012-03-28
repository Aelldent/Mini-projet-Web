<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
	<body>
		<h1> bienvenue chez les erreurs de la base de données</h1>
		<p>Page de d'identification :  <a href="testJsp.jsp"> cliquer ici !</a></p>
		
		<h1>user : <%=request.getParameter("log") %></h1>
		<h1> mdp : <%=request.getParameter("mdp") %></h1>
		<p></p>
		<h1>NewUser : <%=request.getParameter("newLog") %></h1>
		<h1> NewMdp : <%=request.getParameter("newMdp") %></h1>
		<h1> Artist : <%=request.getParameter("nomArtiste") %></h1>
		
	</body>
</html>