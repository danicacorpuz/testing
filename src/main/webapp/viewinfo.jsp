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
				for(int i=0; i<agelist.size(); i++) {
					out.println("<h3> Age Range: " + agelist.get(i).toString() + "</h3>");
				}
			}
			
			if(request.getAttribute("gender") != null) {
				List<String> genderlist = (List<String>) request.getAttribute("gender");
				for(int j=0; j<genderlist.size(); j++) {
					out.println("<h3> Gender: " + genderlist.get(i).toString() + "</h3>");
				}
			}
		%>
		
    </body>
</html>
