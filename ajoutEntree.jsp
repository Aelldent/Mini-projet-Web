<%@page import="com.servlet.model.modeleBaseDeDonnee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ajouter une entrée</title>
</head>
	<body>
	<center>
	<%@ include file="/contour.jsp"%>
		<!-- par la suite, des requetes sql -->
		<h1> Nouvelle entrée : </h1>
		<hr>
			<h3> Vous avez ajouté :</h3>
				<p>
					l'album : <%=request.getParameter("nomAlbum") %>
					, de l'artiste : <%=request.getParameter("nomArtiste") %>
					, son titre : <%=request.getParameter("titreSoundtrack") %>
				</p>
		<p> Retour à la page de recherche :  <a href="/mini-Projet-Web/pageRecherche.jsp"> cliquer ici !</a></p>
	</center>
	</body>
</html>