
var errorFlag = false;
var errorMessage = "";
/*
 * Send data of calculation form to the calculate servlet and get results from the same servlet. 
 * Show the results in the result rextarea without reloading the index page. 
 */
function loadXMLDoc()
{
	var xmlhttp;
	
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function() {
	  //if the response has been received
		if (xmlhttp.readyState==4 && xmlhttp.status==200)  {
			//set the id 'results' to visible 
			document.getElementById("results").style.visibility = "visible";
			//put response text into the textarea
			document.getElementById("ajaxresponse").innerHTML=xmlhttp.responseText;
			//mouse cursor focus on the textarea
			document.getElementById("ajaxresponse").focus();
			}
  }
	//var sysLoc = documnet.getElementById("tryit").value;
	
	//var sysLoc = document.getElementById("tryit").value;
	//var querystring = "?&systemLocation=" + sysLoc + "&number=" + "123456";

	var querystring = getFormData(); 
	
	if(errorFlag == true){//if errors in user input
		document.getElementById("errorflag").innerHTML=errorMessage;
		document.getElementById("errorflag").style.color = "red";
		document.getElementById("errorflag").scrollIntoView();
	} else if(errorFlag == false){//if no input errors, forward form data and get server response
		//document.getElementById("errorflag").innerHTML="No errors";
	    xmlhttp.open("POST","/calculate" +querystring,true);
	    //xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");	    
	    //xmlhttp.send(formObject);
	    xmlhttp.send();
	}
	
	

}

function getFormData(){
	errorFlag = false; //06/10
	errorMessage="";
	
	var formData= "?";
	//get all the data from the form, not worry about the added fields yet! need to add them
	var conLoc = document.getElementById("confirmedLocation").value; //!= 1.0
	var sysCost = document.getElementById("systemCost").value;//>0 numeric
	var sysSize = document.getElementById("systemSize").value;//!= 1.0
	var noPanel1 = document.getElementById("numberOfPanels1").value;//!= 1.0
	var panelOri1 = document.getElementById("panelOrientation1").value;//!= 1.0	
	var effLoss = document.getElementById("panelEfficiencyLoss").value;//>0 <100 numeric	
	var inverEff = document.getElementById("inverterEfficiency").value;//>0 <100 numeric
	
	var repCost = "";//>0 numeric
	//yes radio button is checked
	if(document.getElementById("yes").checked) {
		  repCost = document.getElementById("replacementCost").value; //>0 numeric
	}else if(document.getElementById("no").checked) {
		repCost = "0";
	}
	
	var hoursSun = document.getElementById("hoursOfSunlight").value;//!= 1.0	
	var dailyUsage = document.getElementById("dailyPowerUsage").value;//>0 numeric	
	var daytimeUsage = document.getElementById("daytimePowerUsage").value;//>0 <daily usage	
	var tarRate1 = document.getElementById("tariffRate1").value;//>0
	var tarPer1 = document.getElementById("tariffPercentage1").value;//>0 <100
	var addFees = document.getElementById("additionalFees").value;//>0	
	var tarIncrease = document.getElementById("tariffIncrease").value;//>0 <100
	var feedinTar = document.getElementById("feedinTariff").value;//>0

	/*do the validation. For field in selection box, value != -1.0,
	 * for normal numbers, value is numeric, and is larger than 0. For percentage, 
	 * value is numeric and is larger than 0 but less than 100 
	*/
	//check the selection box input first
	if(conLoc=="-1.0" || sysSize=="-1.0" || noPanel1=="-1.0" || panelOri1=="-1.0" || 
			hoursSun=="-1.0"){
		errorFlag = true;
		errorMessage += "One or more selection fields unchecked.  ";
		//check normal number input. Convert the number and compare to 0. 
	} else if(!(Number(sysCost)>0) || !(Number(dailyUsage)>0) ||!(Number(tarRate1)>0) ||
			!(Number(addFees)>0) || !(Number(feedinTar)>0) ||!(Number(repCost)>=0) ||
			!(Number(daytimeUsage)>0)){
		errorFlag = true;
		errorMessage +="Invalid number entry.  ";	
	//check percentage number input. Convert number and compare to 0 and 100
	//up till here is all working	
	} else if(!((Number(effLoss)>0) && (Number(effLoss)<100)) || 
			!((Number(inverEff)>0) && (Number(inverEff)<100)) ||
			!((Number(tarPer1)>0) && (Number(tarPer1)<100)) || 
			!((Number(tarIncrease)>0) && (Number(tarIncrease)<100))){
		errorFlag = true;
		errorMessage +="Invalid percentage entry.  ";			
	} else if(!(Number(dailyUsage) >= Number(daytimeUsage))){
		errorFlag = true;
		errorMessage +="Daily time power usage should not be larger than daily uasge.  ";	
	} else {//input all correct, get data from form
		formData +="&confirmedLocation="  +  conLoc +
        "&systemCost=" + sysCost +
        "&systemSize=" + sysSize +
        "&numberOfPanels1=" + noPanel1 +
        "&panelOrientation1=" + panelOri1 +
        "&panelEfficiencyLoss=" +effLoss +
        "&inverterEfficiency=" + inverEff +
        "&replacementCost=" + repCost +
        "&hoursOfSunlight=" +  hoursSun +
        "&dailyPowerUsage=" + dailyUsage +
        "&daytimePowerUsage=" + daytimeUsage +
        "&tariffRate1=" + tarRate1 +
        "&tariffPercentage1=" + tarPer1 +
        "&additionalFees=" + addFees +
        "&tariffIncrease=" + tarIncrease +
        "&feedinTariff=" + feedinTar;
		errorFlag = false;
	}	
	           
	return formData;	
}

