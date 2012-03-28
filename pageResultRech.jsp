<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Résultat de la recherche</title>
</head>
	<body>
	<%@ include file="/contour.jsp"%>
		<!-- requete sql, qui vont afficher les result -->
	<div style="width:50%;margin:auto;text-align:center;">
		<p>Vous avez saisi : </p>
		<ul>
			<li>ALBUM : <%=request.getParameter("nomAlbum") %></li>
			<li>ARTISTE : <%=request.getParameter("nomArtiste") %></li>
			<li>TITRE : <%=request.getParameter("titreSoundtrack") %></li>
		</ul>
		
		<p> Informations supplémentaires </p>
		<ul>
			<li>featuring : <%=request.getParameter("Featuring") %></li>
			<li>musicPlayer : <%=request.getParameter("musicPlayer") %></li>
			<li>audioEngineer : <%=request.getParameter("audioEngineer") %></li>
			<li>lyricsWriter : <%=request.getParameter("lyricsWriter") %></li>
			<li>musicWriter : <%=request.getParameter("musicWriter") %></li>
			<li>rythm : <%=request.getParameter("rythm") %></li>
			<li>originalVersion : <%=request.getParameter("originalVersion") %></li>
			<li>label : <%=request.getParameter("label") %></li>
			<li>playingTime : <%=request.getParameter("playingTime") %></li>
			<li>releaseDate : <%=request.getParameter("releaseDate") %></li>
			<li>style : <%=request.getParameter("style") %></li>
		</ul>
		
		<p>Nouvelle recherche :  <a href="/mini-Projet-Web/pageRecherche.jsp"> cliquer ici !</a></p>
	</div>

	</body>
</html>