<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="placementContour.css" >
		<title>Page d'identification</title>
	</head>
	<!-- page dacceuil, page de logging -->
		<body>
			<%
				//code java
				// on récupère les paramètres
				String log = "";
				request.setAttribute("log", log);
				String mdp = "";
				request.setAttribute("mdp", mdp);
				String newMdp = "";
				request.setAttribute("newMdp", newMdp);
				String newLog = "";
				request.setAttribute("newLog", newLog);
			%>
			<h1> Bienvenue dans la VinylCollection</h1>
			<center>
			<hr>
				<h2 style=color:blue>Personne - formulaire</h2>
					
					<form action="logging.do" method="post">
						<table>
							<tr>
								<td>Nom</td>
								<td><input name="log" value="<%= log %>" type="text" size="20"></td>
							</tr>
							<tr>
						<td>Mdp</td>
						<td><input type="password" name="mdp" value="<%= mdp %>" type="text" size="20"></td>
						</tr>
						</table>
						
						<table>
							<tr>
								<td><input type="submit" value="Envoyer"></td>
							</tr>
						</table>
					</form>
					<ul>
	                   <li><a href="/mini-Projet-Web/pagePrincipale.jsp" > Go vers le site</a></li>
	                   <p></p>
	               </ul>
	               <hr>
	               <h2 style=color:blue>Nouvel utilisateur </h2>
	               <form action="newUser.do" method="post">
						<table>
							<tr>
								<td>Nom*</td>
								<td><input name="newLog" value="<%= newLog %>" type="text" size="20"></td>
							</tr>
							<tr>
						<td>Mdp*</td>
						<td><input type="password" name="newMdp" value="<%= newMdp %>" type="text" size="20"></td>
						</tr>
						</table>
						<p></p>
						<h6 style=color:red>(*) : champs obligatoires</h6>
						<p></p>
						<table>
							<tr>
								<td><input type="submit" value="Créer nouvel utilisateur"></td>
							</tr>
						</table>
					</form>
				</center>
		</body>
</html>