<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>This is a calculating page.</p>
    
    <form action="/calculate" method="post">
    <p>System location</p><br>
      <div><select name="location">
  	      <option value="qld">Queensland</option>
          <option value="vic">Victoria</option>
          <option value="nsw">New South Wales</option>
          <option value="sa">South Australia</option>
          <option value="wa">Western Australia</option>
          <option value="tas">Tasmania</option>
      </select></div>
      
      <p>Hours of sunlight per day</p><br>
      <div><select name="hoursOfSun">
	   	  <option value="12">12</option>
	   	  <option value="11">11</option>
	      <option value="10">10</option>
	      <option value="9">9</option>
	      <option value="8">8</option>
	      <option value="7">7</option>
	      <option value="6">6</option>
 	      <option value="5">5</option>
	      <option value="4">4</option>
	      <option value="3">3</option>
	      <option value="2">2</option>
	      <option value="1">1</option>           
      </select></div>
      
      <p>System size</p><br>
      <div><select name="size">
	   	  <option value="1.0">1.0kW</option>
	   	  <option value="1.5">1.5kW</option>
	      <option value="2.0">2.0kW</option>
	      <option value="2.5">2.5kW</option>
	      <option value="3.0">3.0kW</option>
	      <option value="4.0">4.0kW</option>
	      <option value="4.5">4.5kW</option>
 	      <option value="5.0">5.0kW</option>     
 	      <option value="5.5">5.5kW</option>
 	      <option value="6.0">6.0kW</option>       
      </select></div>
      
      <p>System cost</p><br>
      <div><input type="text" name="cost"></div>
      
      <p>Number of panels</p><br>
      <div><select name="numOfPanels">
	   	  <option value="4">4</option>
	   	  <option value="6">6</option>
	      <option value="8">8</option>
	      <option value="10">10</option>
	      <option value="12">12</option>
	      <option value="14">14</option>
	      <option value="16">16</option>
 	      <option value="18">18</option>     
 	      <option value="20">20</option>
      </select></div>
      
      <p>Panel orientations</p><br>
      <div><select name="oriOfPanels">
	   	  <option value="20">20 degrees</option>
	   	  <option value="25">25 degrees</option>
	      <option value="30">30 degrees</option>
	      <option value="35">35 degrees</option>
	      <option value="40">40 degrees</option>
	      <option value="45">45 degrees</option>
	      <option value="50">50 degrees</option>
 	      <option value="55">55 degrees</option>     
 	      <option value="60">60 degrees</option>
      </select></div>
        
      <p>Monthly Electricity Usage</p><br>
      <div><input type="text" name="usage"></div>

      <p>Electricity tariffs</p><br>
      <div><input type="text" name="tariff"></div>
      
      <div><input type="submit" value="Submit" /></div>
      
    </form>
    <p>for testing:
    the location that user selected is: <b> ${selectedlocation}</b></p>
    






</body>
</html>