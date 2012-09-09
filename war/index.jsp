<%--
  - Author: MGSD Technology
  - Date:
  - Description:
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/stylesheets/main.css" />
<title>Solar Power Calculator</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<img src="images\header.jpg" alt="Solar Power Calculator" />
		</div>
		<div id="menu">
			<ul>
				<li><a href="index.jsp" style="color: #FFFFFF">Home</a></li>
				<li><a href="index.jsp">Example</a>
					<ul>
						<li><a href="index.jsp">Nested</a></li>
						<li><a href="index.jsp">List</a></li>
					</ul></li>
			</ul>
		</div>
		<div id="sidebar">
			<ul>
				<li><a href="index.jsp" style="color: #DD4B39">Home</a></li>
				<li><a href="index.jsp">Example</a>
					<ul>
						<li><a href="index.jsp">Nested</a></li>
						<li><a href="index.jsp">List</a></li>
					</ul></li>
			</ul>
		</div>
		<div id="content">
			<p>This is a calculating page.</p>

			<%
			    UserService userService = UserServiceFactory.getUserService();
			    User user = userService.getCurrentUser();
			    if (user != null) {
			        pageContext.setAttribute("user", user);
			%>
			<p>
				Hello, ${fn:escapeXml(user.nickname)}! (You can <a
					href="<%=userService.createLogoutURL(request.getRequestURI())%>">sign
					out</a>.)
			</p>
			<%
			    } else {
			%>
			<p>
				Hello! <a
					href="<%=userService.createLoginURL(request.getRequestURI())%>">Sign
					in</a> to save your calculating data and view calculation history.
			</p>
			<%
			    }
			%>

			<form action="/calculate" method="post">
				<p>System location</p>
				<div>
					<select name="location">
						<option value="Queensland">Queensland</option>
						<option value="Victoria">Victoria</option>
						<option value="New South Wales">New South Wales</option>
						<option value="South Australia">South Australia</option>
						<option value="Western Australia">Western Australia</option>
						<option value="Tasmania">Tasmania</option>
					</select>
				</div>

				<br>
				<p>Hours of sunlight per day</p>
				<div>
					<select name="hoursOfSunlight">
						<c:forEach var="hours" items="${hoursOfSunlight}">
							<option value="${hours.value}">${hours.key}</option>
						</c:forEach>
					</select>
				</div>

				<br>
				<p>System size</p>
				<%--build system size drop-down list--%>
				<div>
					<select name="systemSize">
						<c:forEach var="size" items="${systemSizes}">
							<option value="${size.value}">${size.key}</option>
						</c:forEach>
					</select>
				</div>
				<br>
				<p>System cost</p>
				<div>
					<input type="text" name="cost">
				</div>

				<br>
				<p>Number of panels</p>
				<div>
					<select name="numberOfPanels">
						<c:forEach var="number" items="${numberOfPanels}">
							<option value="${number.value}">${number.key}</option>
						</c:forEach>
					</select>
				</div>

				<br>
				<p>Panel orientations</p>
				<div>
					<select name="panelOrientation">
						<c:forEach var="orientation" items="${panelOrientations}">
							<option value="${orientation.value}">${orientation.key}</option>
						</c:forEach>
					</select>
				</div>

				<br>
				<p>Monthly Electricity Usage</p>
				<div>
					<input type="text" name="usage">
				</div>

				<br>
				<p>Electricity tariffs</p>
				<div>
					<input type="text" name="tariff">
				</div>

				<div>
					<input type="submit" value="Submit" name="calculationDataForm" />
				</div>
			</form>
		</div>
		<div id="push"></div>
		<div id="footer">Copyright © 2012 MGSD Technology</div>
	</div>
</body>
</html>