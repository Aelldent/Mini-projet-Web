<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
	<body>
	<%@ include file="/contour.jsp"%>
		<center>
			<h1 style="color:green"> Liste des coWorkers</h1>
			<select name = "liste des coWorkers">
			<%
				ArrayList<String> listeCoW = new ArrayList<String>();
				listeCoW = (ArrayList<String>)request.getAttribute("listeCoW");
				for (String temp : listeCoW)
				{
					out.println("<option>"); out.println(temp); out.println("</option>");
				}
			%>
			</select>
		</center>
	</body>
</html>