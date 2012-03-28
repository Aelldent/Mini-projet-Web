<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<%
			// on récupère les données du modèle
			String log=(String)request.getAttribute("log");
			String mdp=(String)request.getAttribute("mdp");
		%>
		
		<h2>le nom d'user est :</h2>
			<h3> <%= log %> </h3>
			
		<h2> son mdp est : </h2>
			<h3> <%= mdp %> </h3>
	</body>
</html>