<%@ page import="com.servlet.test.model.ColorModel" %>
<html>
	<body>
	<h1 style="color:<%=request.getAttribute("colorString") %>">
		Récupération de l'attribut "<em>colorString</em>"
	</h1>
	</body>
</html>