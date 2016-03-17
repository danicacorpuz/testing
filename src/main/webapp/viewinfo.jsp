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
			if(request.getAttribute("age") != null) {
				List<String> agelist = (List<String>) request.getAttribute("age");
				out.println("Age List: ");
				for(int i=0; i<agelist.size(); i++) {
					out.println("<h3>" + agelist.get(i) + "</h3>");
				}
			}
		%>
		
    </body>
</html>
