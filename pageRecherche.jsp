<%@page import="com.servlet.model.modeleBaseDeDonnee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Page de recherche</title>
	</head>
	<body>
		<%@ include file="/contour.jsp"%>
		<center>
		<h1> Recherche dans la dataBase </h1>
		</center>
		
		<!-- le formulaire de recherche -->
		<%
			//String nomAlbum=request.getParameter("nomAlbum");
			//if(nomAlbum==null) 
			//	nomAlbum="";
			String nomAlbum = "NA";
			request.setAttribute("nomAlbum", nomAlbum);
			String nomArtiste = "NA";
			request.setAttribute("nomArtiste", nomArtiste);
			String titreSoundtrack = "NA";
			request.setAttribute("titreSoundtrack", titreSoundtrack);
			String Featuring = "NA";
			request.setAttribute("Featuring", Featuring);
			String musicPlayer = "NA";
			request.setAttribute("musicPlayer", musicPlayer);
			String audioEngineer = "NA";
			request.setAttribute("audioEngineer", audioEngineer);
			String lyricsWriter = "NA";
			request.setAttribute("lyricsWriter", lyricsWriter);
			

			String musicWriter=request.getParameter("musicWriter");
			if(musicWriter==null) 
				musicWriter="NA";
			String rythm=request.getParameter("rythm");
			if(rythm==null) 
				rythm="NA";
			String originalVersion=request.getParameter("originalVersion");
			if(originalVersion==null) 
				originalVersion="NA";
			String label=request.getParameter("label");
			if(label==null) 
				label="NA";
			String playingTime=request.getParameter("playingTime");
			if(playingTime==null) 
				playingTime="NA";
			String releaseDate=request.getParameter("releaseDate");
			if(releaseDate==null) 
				releaseDate="NA";
			String style=request.getParameter("style");
			if(style==null) 
				style="NA";

		%>
		<div style="margin-top:20px">
		<center>
			<h1> Recherche globale </h1>
			<form action="rechercheDataBase.do" method="post">
				<table>
					<tr>
						<td>Nom de l'album</td>
						<td><input name="nomAlbum" value="<%= nomAlbum %>" type="text" size="40"></td>
					</tr>
					<tr>
						<td>Nom de l'artiste**</td>
						<td><input name="nomArtiste" value="<%= nomArtiste %>" type="text" size="40"></td>
					</tr>
					<tr>
						<td>titre du morceau**</td>
						<td><input name="titreSoundtrack" value="<%= titreSoundtrack %>" type="text" size="20"></td>
					</tr>
				</table>
				<h6 style=color:green>(**) les paramètres de recherche possible</h6>
				
			<h1> Recherche avancée </h1>
				<table>
					<tr>
						<td>Featuring</td>
						<td><input name="Featuring" value="<%= Featuring %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>MusicPlayer</td>
						<td><input name="musicPlayer" value="<%= musicPlayer %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>AudioEngineer</td>
						<td><input name="audioEngineer" value="<%= audioEngineer %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>LyricsWriter</td>
						<td><input name="lyricsWriter" value="<%= lyricsWriter %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>MusicWriter</td>
						<td><input name="musicWriter" value="<%= musicWriter %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>Rythm</td>
						<td><input name="rythm" value="<%= rythm %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>OriginalVersion</td>
						<td><input name="originalVersion" value="<%= originalVersion %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>Label</td>
						<td><input name="label" value="<%= label %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>PlayingTime</td>
						<td><input name="playingTime" value="<%= playingTime %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>ReleaseDate</td>
						<td><input name="releaseDate" value="<%= releaseDate %>" type="text" size="20"></td>
					</tr>
					<tr>
						<td>Style</td>
						<td><input name="style" value="<%= style %>" type="text" size="20"></td>
					</tr>
				</table>
		
		
				<table>
					<tr>
						<td><input type="submit" name="valider" value="Envoyer"></td>
						<td><input type="reset" value="Effacer"></td>
					</tr>
				</table>
			</form>
			
			<p></p>
			<form action="ajoutEntreeList.do" method="post">
				<table>
					<tr>
						<td><input type="submit" value="Ajouter une entrée (affichage liste)"></td>
					</tr>
				</table>
			</form>
			
			<p></p>
			<h1>Ajouter une entrée dans la dataBase</h1>
			<form action="ajoutEntree.do" method="post">
				<table>
					<tr>
						<td><input type="submit" value="Ajouter une entrée"></td>
					</tr>
				</table>
			</form>
		</center>
		</div>	
	</body>
</html>