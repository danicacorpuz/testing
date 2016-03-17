<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample</title>
    </head>
    <body>
		<h1>Information Extraction Complete</h1>
		
		<%
			if(request.getAttribute("length") != null) {
				out.println("<h3> Length: " + request.getAttribute("length") + "</h3>");
			}
		%>
		
    </body>
</html>
