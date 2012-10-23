<%--
  - Author: MGSD Technology
  - Date: 23 October 2012
  - Description:
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>Solar Power Calculator</title>
<meta charset="UTF-8">
<link href="/stylesheets/main.css" type="text/css" rel="stylesheet" />
<script src="/scripts/jquery-1.8.1.js" type="text/javascript"></script>
<script src="/scripts/main.js" type="text/javascript"></script>
<script src="/scripts/tooltipsy.min.js" type="text/javascript"></script>
<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAZm_mPUozK_s1588VtsTER4yIMEhmr_4k&sensor=false"
	type="text/javascript">
	
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<img alt="Solar Power Calculator" src="images/header.jpg" />
			<h1>
				<span>Solar Power Calculator</span>
			</h1>
			<div id="menu">
				<ul>
					<li><a style="color: #FFFFFF" href="index.jsp">Home</a></li>
					<%--<li><a href="/history">History</a></li>--%>
				</ul>
			</div>
		</div>
		<div id="sidebar">
			<ul>
				<li><a style="color: #DD4B39" href="index.jsp">Home</a></li>
				<%--<li><a href="/history">History</a></li>--%>
			</ul>
		</div>
		<div id="content">
			<h2>Calculate</h2>
			<%--<%
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
			%>--%>
			<p>This is a solar power calculator for grid-connected systems
				over a period of 25 years. It will calculate average daily and
				annual solar generation, average daily and annual savings, and
				cumulative savings. It will also calculate if and when you'll break
				even, and the return if the system expenses were invested instead.</p>
			<p>
				<a id="populateFields">Click here</a> to populate the <em>Average
					annual panel efficiency loss</em> and <em>Inverter efficiency</em>
				fields with industry standard values.
			</p>
			<p>* indicates a required field.</p>
			<form id="form">
				<fieldset>
					<h3>
						System location *<img class="tt"
							title="Enter the address where the system is located and click <em>Confirm location</em> to select from a list of matching locations."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="systemLocation" type="text" name="systemLocation"><input
						id="confirmLocation" type="button" value="Confirm location">
					<div id="divConfirmedLocation">
						<label>Select location</label><select id="confirmedLocation"
							name="confirmedLocation"></select>
					</div>
					<p id="errConfirmedLocation" class="em"></p>
					<h3>
						System cost<img class="tt"
							title="Enter the cost of the system (e.g. 15000)." alt="Tooltip"
							src="/images/tooltip.png" />
					</h3>
					<label class="cl">$</label><input id="systemCost" type="text"
						name="systemCost">
					<h3>
						System size *<img class="tt"
							title="Select the size of the system, or select <em>Custom</em> to enter a custom value in kW (e.g. 2.95)."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<select id="systemSize" class="ddl" name="systemSize">
						<c:forEach var="size" items="${systemSizes}">
							<option value="${size.value}">${size.key}</option>
						</c:forEach>
					</select><label class="css">Enter size</label><input id="customSystemSize"
						class="css" type="text" name="customSystemSize"><label
						class="css">kW</label>
				</fieldset>
				<fieldset>
					<h3>
						Panel banks *<img class="tt"
							title="For each panel bank, select the number of panels, their orientation and their tilt angle. Solar panels should face north in the southern hemisphere and south in the northern hemisphere to maximise their output."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<div id="panelBank1" class="pb">
						<label>Number of panels</label><select id="numberOfPanels1"
							class="ddl" name="numberOfPanels1">
							<c:forEach var="number" items="${numberOfPanels}">
								<option value="${number.value}">${number.key}</option>
							</c:forEach>
						</select><label>Orientation</label><select id="panelOrientation1"
							class="ddl" name="panelOrientation1">
							<c:forEach var="orientation" items="${panelOrientations}">
								<option value="${orientation.value}">${orientation.key}</option>
							</c:forEach>
						</select><label>Tilt</label><select id="panelTilt1" class="ddl"
							name="panelTilt1">
							<c:forEach var="tilt" items="${panelTilts}">
								<option value="${tilt.value}">${tilt.key}</option>
							</c:forEach>
						</select><input id="addPanelBank" class="btn" type="button"
							value="Add panel bank"><input id="removePanelBank"
							class="btn" type="button" value="Remove" disabled="disabled">
					</div>
					<h3>
						Average annual panel efficiency loss *<img class="tt"
							title="Enter the average annual loss in panel efficiency. The industry standard of at least 90% output in the 10th year and 80% output in the 25th year can be represented by an average annual loss of 0.83% per annum."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="panelEfficiencyLoss" type="text"
						name="panelEfficiencyLoss"><label>% p.a.</label>
				</fieldset>
				<fieldset>
					<h3>
						Inverter efficiency *<img class="tt"
							title="Enter the inverter efficiency, i.e. the percentage of power the inverter is typically able to convert from DC (power generated by solar panels) to AC (power available to your home or the grid). The industry standard for most grid-connected inverters is about 95% or better."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="inverterEfficiency" type="text"
						name="inverterEfficiency"><label>%</label>
					<h3>
						Replacement inverter *<img class="tt"
							title="Choose if you want to include the cost of a replacement inverter in your calculations. The industry standard for the lifespan of grid-connected inverters is 10-20 years, but most warranties are for 5-10 years. If you're unsure of the cost, use 20% of the total system cost as an estimate."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="yes" class="rb" type="radio" value="Yes"
						name="replacementInverter"><label for="yes">Yes</label><input
						id="no" class="rb" type="radio" value="No"
						name="replacementInverter"><label for="no">No</label><label
						id="lblReplacementCost" class="rc">Enter cost</label><label
						id="lblReplacementCostCurrency" class="cl">$</label><input
						id="replacementCost" class="rc" type="text" name="replacementCost">
				</fieldset>
				<fieldset>
					<h3>
						Average daily hours of sunlight *<img class="tt"
							title="Select the average number of hours of sunlight the system will receive each day."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<select name="hoursOfSunlight" id="hoursOfSunlight">
						<c:forEach var="hours" items="${hoursOfSunlight}">
							<option value="${hours.value}">${hours.key}</option>
						</c:forEach>
					</select>
					<h3>
						Average daily power usage *<img class="tt"
							title="Enter the average amount of power used in your household each day in kWh."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="dailyPowerUsage" type="text" name="dailyPowerUsage"><label>kWh</label>
					<h3>
						Average daytime power usage *<img class="tt"
							title="Enter the average amount of power used in daylight hours in your household each day in kWh."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="daytimePowerUsage" type="text" name="daytimePowerUsage"><label>kWh</label>
				</fieldset>
				<fieldset>
					<h3>
						Tariffs *<img class="tt"
							title="For each tariff, enter the tariff rate in c/kWh and the average percentage of power usage to which the tariff applies (the sum of the average percentages should equal 100%)."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<div id="tariff1" class="tr">
						<label>Tariff rate</label><input id="tariffRate1" type="text"
							name="tariffRate1"><label class="tl">c/kWh</label><label>Average
							percentage of power usage</label><input id="tariffPercentage1"
							type="text" name="tariffPercentage1"><label class="tl">%</label><input
							id="addTariff" class="btn" type="button" value="Add tariff"><input
							id="removeTariff" class="btn" type="button" value="Remove"
							disabled="disabled">
					</div>
					<h3>
						Average annual tariff rate increase *<img class="tt"
							title="Enter the average annual increase in tariff rates (a conservative estimate like 7% per annum would suffice)."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="tariffIncrease" type="text" name="tariffIncrease"><label>%
						p.a.</label>
					<h3>
						Feed-in tariff rate<img class="tt"
							title="Enter the feed-in tariff rate in c/kWh for power on-sold to the grid (this may not apply)."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="feedinTariff" type="text" name="feedinTariff"><label>c/kWh</label>
				</fieldset>
				<fieldset>
					<h3>
						Average annual interest rate for comparison<img class="tt"
							title="Enter the average annual interest rate used to calculate the return if the system expenses were invested instead (a conservative estimate like 5% per annum would suffice)."
							alt="Tooltip" src="/images/tooltip.png" />
					</h3>
					<input id="interestRate" type="text" name="interestRate"><label>%
						p.a.</label>
				</fieldset>
				<p>
					DISCLAIMER: Although every attempt has been made to make this solar
					power calculator as accurate as possible, we cannot guarantee the
					accuracy of its calculations. If you accept that any calculations
					should be used as a guide only, you may submit your details by
					clicking <em>Submit</em> below.
				</p>
				<input id="submitForm" type="button" value="Submit" />
			</form>
			<div id="divResults"></div>
		</div>
		<div id="push"></div>
		<div id="footer">Copyright © 2012 MGSD Technology</div>
	</div>
</body>
</html>