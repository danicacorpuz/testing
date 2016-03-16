<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample</title>
    </head>
    <body>
		<h1>Information Extraction Complete</h1>
		<%
		
			if(request.getAttribute("age") != null) {
				out.println("<h3> Age Range: " + request.getAttribute("age") + "</h3>");
			}
			
			if(request.getAttribute("gender") != null) {
				out.println("<h3> Gender: " + request.getAttribute("gender") + "</h3>");
			}
			
			if(request.getAttribute("port") != null) {
				out.println("<h3> Gender: " + request.getAttribute("port") + "</h3>");
			}
			
			if(request.getAttribute("password") != null) {
				out.println("<h3> Gender: " + request.getAttribute("password") + "</h3>");
			}
			
			if(request.getAttribute("host") != null) {
				out.println("<h3> Gender: " + request.getAttribute("host") + "</h3>");
			}
		
		%>
		
    </body>
</html>
