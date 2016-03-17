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
			int i = 0;
			if(request.getAttribute("age") != null) {
				List<String> agelist = (List<String>) request.getAttribute("age");
				out.println("Age List: ");
				for(i=0; i<agelist.size(); i++) {
					out.println("<h3>" + agelist.get(i) + "</h3>");
				}
			}
			
			if(request.getAttribute("gender") != null) {
				List<String> genderlist = (List<String>) request.getAttribute("gender");
				out.println("Gender List: ");
				for(i=0; i<genderlist.size(); i++) {
					out.println("<h3>" + genderlist.get(i) + "</h3>");
				}
			}
		%>
		
    </body>
</html>
