<%--THIS PAGE CAN USED TO DISPLAY CALCLATION RESULTS--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>This page displays results of calculations</p>    
    <p>
		<div><textarea name="content" rows="3" cols="60">
		${history}</textarea></div>
	</p>
    <p>location of the user ${location}</p>



    <a href = "/index.jsp">Back to previous page</a><br>
   

    <form action="/another servlet" method="post">
		<div>
			<input type="submit" value="Clear Results" name="ClearDataForm"/>
		</div>
	</form>











</body>
</html>