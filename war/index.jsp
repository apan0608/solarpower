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
<script type="text/javascript" src="/scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" src="/scripts/main.js"></script>
<script type="text/javascript" src="/scripts/tooltipsy.min.js"></script>
<title>Solar Power Calculator</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<img src="images\header.jpg" alt="Solar Power Calculator" />
			<h1>
				<span>Solar Power Calculator</span>
			</h1>
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
			<h2>Calculate</h2>

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

			<p>This is a solar power calculator for grid-connected systems.</p>
			<%--
			  - need to supply default values for some of these fields (via default button?)
			  - need to add client-side (jquery) and server-side (java) validation
			  - need to add auto-detection features etc.
			  --%>
			<form action="/calculate" method="post">
				<fieldset>
					<h3>
						System location<img src="/images/tooltip.png" alt="Tooltip"
							class="tooltip"
							title="Enter the address where the system is located (e.g. 10 Solar Street, Brisbane, QLD)." />
					</h3>
					<input type="text" name="systemLocation">
					<h3>
						System cost<img src="/images/tooltip.png" alt="Tooltip"
							class="tooltip"
							title="Enter the cost of the system (e.g. 15000)." />
					</h3>
					<input type="text" name="systemCost">
					<h3>
						System size<img src="/images/tooltip.png" alt="Tooltip"
							class="tooltip"
							title="Select the size of the system, or select Custom to enter a custom value in kW (e.g. 2.95)." />
					</h3>
					
					<select name="systemSize" class="ddl">
						<c:forEach var="size" items="${systemSizes}">
							<option value="${size.value}">${size.key}</option>
						</c:forEach>
					</select>
				</fieldset>
				<fieldset>
					<h3>
						Panels and orientations<img src="/images/tooltip.png"
							alt="Tooltip" class="tooltip"
							title="Select the number of panels and their orientation. Solar panels should face north in the southern hemisphere and south in the northern hemisphere to maximise their output." />
					</h3>
					<label for="numberOfPanels">Number of panels</label><select
						name="numberOfPanels" class="ddl" id="numberOfPanels">
						<c:forEach var="number" items="${numberOfPanels}">
							<option value="${number.value}">${number.key}</option>
						</c:forEach>
					</select> <label for="panelOrientation">Orientation</label><select
						name="panelOrientation" class="ddl" id="panelOrientation">
						<c:forEach var="orientation" items="${panelOrientations}">
							<option value="${orientation.value}">${orientation.key}</option>
						</c:forEach>
					</select><input type="button" value="Add panel bank">
					<h3>
						Average annual panel efficiency loss rate<img
							src="/images/tooltip.png" alt="Tooltip" class="tooltip"
							title="Enter the average annual rate at which the panels will lose their efficiency. The industry standard of at least 90% output in the 10th year and 80% output in the 25th year can be represented by an average annual loss rate of 0.83%." />
					</h3>
					<input type="text" name="panelEfficiencyLoss">
				</fieldset>
				<fieldset>
					<h3>
						Inverter efficiency<img src="/images/tooltip.png" alt="Tooltip"
							class="tooltip"
							title="Enter the inverter efficiency, i.e. the percentage of power the inverter is typically able to convert from DC (power generated by solar panels) to AC (power available to your home or the grid). The industry standard for grid-connected inverters is about 93% or better." />
					</h3>
					<input type="text" name="inverterEfficiency">
					<h3>
						Replacement inverter<img src="/images/tooltip.png" alt="Tooltip"
							class="tooltip"
							title="Choose if you want to include the cost of a replacement inverter in your calculations. The industry standard for the lifespan of grid-connected inverters is 10-20 years, but most warranties are for 5-10 years." />
					</h3>
					<input type="radio" name="replacementInverter" class="rb" id="yes"
						value="yes"><label for="yes">Yes</label><input
						type="radio" name="replacementInverter" class="rb" id="no"
						value="no"><label for="no">No</label>
				</fieldset>
				<fieldset>
					<h3>
						Average daily hours of sunlight<img src="/images/tooltip.png"
							alt="Tooltip" class="tooltip"
							title="Select the average number of hours of sunlight the system will receive each day." />
					</h3>
					<select name="hoursOfSunlight">
						<c:forEach var="hours" items="${hoursOfSunlight}">
							<option value="${hours.value}">${hours.key}</option>
						</c:forEach>
					</select>
					<h3>
						Average daily power usage<img src="/images/tooltip.png"
							alt="Tooltip" class="tooltip"
							title="Enter the average amount of power used in your household each day in kWh." />
					</h3>
					<input type="text" name="dailyPowerUsage">
					<h3>
						Average daytime power usage<img src="/images/tooltip.png"
							alt="Tooltip" class="tooltip"
							title="Enter the average amount of power used in daylight hours in your household each day in kWh." />
					</h3>
					<input type="text" name="daytimePowerUsage">
				</fieldset>
				<fieldset>
					<h3>
						Tariffs<img src="/images/tooltip.png" alt="Tooltip"
							class="tooltip"
							title="Enter the tariff rate in c/kWh and the average percentage of power usage to which the tariff applies." />
					</h3>
					<label for="tariffRate">Tariff rate</label><input type="text"
						name="tariffRate" class="tf" id="tariffRate"> <label
						for="tariffPercentage">Average percentage of power usage</label><input
						type="text" name="tariffPercentage" class="tf"
						id="tariffPercentage"><input type="button"
						value="Add tariff">
					<h3>
						Additional fees<img src="/images/tooltip.png" alt="Tooltip"
							class="tooltip"
							title="Enter the annual sum of any additional fees you might pay, such as service fees." />
					</h3>
					<input type="text" name="additionalFees">
					<h3>
						Average annual tariff rate increase<img src="/images/tooltip.png"
							alt="Tooltip" class="tooltip"
							title="Enter the average annual increase in your tariff rates (a conservative estimate like 5% would suffice)." />
					</h3>
					<input type="text" name="tariffIncrease">
					<h3>
						Feed-in tariff rate<img src="/images/tooltip.png" alt="Tooltip"
							class="tooltip"
							title="Enter the feed-in tariff rate in c/kWh for power you on-sell to the grid (this may not apply to you)." />
					</h3>
					<input type="text" name="feedinTariff">
				</fieldset>
				<input type="submit" value="Submit" name="calculationDataForm" />
			</form>
		</div>
		<div id="push"></div>
		<div id="footer">Copyright © 2012 MGSD Technology</div>
	</div>
</body>
</html>