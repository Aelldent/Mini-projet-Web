<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Nouvel utilisateur</title>
</head>
	<body>
	<%@ include file="/contour.jsp"%>
	<hr>
		<center>
			<h1>Votre compte a bien été créé</h1>
			<p>Vous êtes enregistré en tant que :</p>
			<ul>user : <%=request.getParameter("newLog") %></ul>
			<ul>mdp : <%=request.getParameter("newMdp") %></ul>
			<p></p>
			<a href="/mini-Projet-Web/pagePrincipale.jsp" > Connection à VinylCollection</a>
		</center>
	</body>
</html>