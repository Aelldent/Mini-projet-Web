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
		<%
			 	
		%>
		<center>
		<h1> Page de résultats </h1>
		<table>
			<caption> Résultats recherches</caption>
				<thead>
					<tr>
						<%
							ArrayList<String> entete = (ArrayList<String>)request.getAttribute("entete");
							for (String temp : entete)
							{
								out.write("<th>"); out.write(temp); out.write("</th>");
							}
						%>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td> </td>
					</tr>
				</tbody>
		</table>
		</center>
	</body>
</html>