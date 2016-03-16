<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample</title>
    </head>
    <body>
		<form action ="AlchemyandRedisServlet" method="post">
                <input type="text" name="imageURL">
                <input type="submit" value="Extract Information" />
        </form>
		
		<%
			if(request.getAttribute("age") != null) {
				out.println("<h3> Age Range: " + request.getAttribute("age") + "</h3>");
			}
			
			if(request.getAttribute("gender") != null) {
				out.println("<h3> Gender: " + request.getAttribute("gender") + "</h3>");
			}
		%>
		
    </body>
</html>
