/*
 * Author: MGSD Technology
 * Date: 23 October 2012
 * Description:
 */

// when page has loaded
$(function() {

	// number of panel banks
	var numPanelBanks = 1;

	// number of tariffs
	var numTariffs = 1;

	// type of results to show
	var resultsType = "simple";

	// populate text fields
	$("#populateFields").click(function() {
		$("#panelEfficiencyLoss").val("0.83");
		$("#inverterEfficiency").val("95");
		// $("#tariffIncrease").val("7");
	});

	// add tooltips
	$(".tt").tooltipsy({
		offset : [ 5, 0 ]
	});

	// confirm location when text field is active and enter key is pressed
	$("#systemLocation").keypress(function(event) {
		if (event.keyCode == 13) {
			$("#confirmLocation").click();
		}
	});

	// get matching locations
	$("#confirmLocation").click(
			function() {

				// get geocoder object and system location text field value
				var geocoder = new google.maps.Geocoder();
				var address = $("#systemLocation").val();

				// pass geocoder object with system location text field value
				geocoder.geocode({
					"address" : address
				}, function(results, status) {

					// at least one result is returned
					if (status == google.maps.GeocoderStatus.OK) {

						// hide error message
						$("#errConfirmedLocation").hide();

						// prepare drop-down list
						$("#confirmedLocation").empty();
						$("#confirmedLocation").append(
								'<option value="-1.0">Select...</option>');

						// add results to drop-down list
						for (i = 0; i < results.length; i++) {
							$("#confirmedLocation").append(
									'<option value="'
											+ results[i].geometry.location
													.lat() + '">'
											+ results[i].formatted_address
											+ '</option>');
						}

						// show div containing drop-down list
						$("#divConfirmedLocation").show();

					} else { // no results are returned

						// hide div containing drop-down list
						$("#divConfirmedLocation").hide();

						// empty drop-down list
						$("#confirmedLocation").empty();

						// prepare error message
						$("#errConfirmedLocation").empty();
						$("#errConfirmedLocation").append(
								"No locations were found. Error code: "
										+ status);

						// show error message
						$("#errConfirmedLocation").show();
					}
				});
			});

	// add custom system size text field
	$("#systemSize").change(function() {
		if ($(this).val() == "-2.0") {
			$(".css").show();
		} else {
			$(".css").hide();
		}
	});

	// add custom system size text field if it disappears on reload
	if ($("#systemSize").val() == "-2.0") {
		$(".css").show();
	}

	// add panel bank
	$("#addPanelBank").click(
			function() {

				// new number of panel banks
				var newNumPanelBanks = numPanelBanks + 1;

				// clone previous div and increment id attribute
				var newDiv = $("#panelBank" + numPanelBanks).clone().attr("id",
						"panelBank" + newNumPanelBanks);

				// increment drop-down list attributes
				newDiv.children("#numberOfPanels" + numPanelBanks).attr("id",
						"numberOfPanels" + newNumPanelBanks).attr("name",
						"numberOfPanels" + newNumPanelBanks);

				// increment drop-down list attributes
				newDiv.children("#panelOrientation" + numPanelBanks).attr("id",
						"panelOrientation" + newNumPanelBanks).attr("name",
						"panelOrientation" + newNumPanelBanks);

				// increment drop-down list attributes
				newDiv.children("#panelTilt" + numPanelBanks).attr("id",
						"panelTilt" + newNumPanelBanks).attr("name",
						"panelTilt" + newNumPanelBanks);

				// hide add button
				newDiv.children("#addPanelBank").hide();

				// hide remove button
				newDiv.children("#removePanelBank").hide();

				// add new div after previous div
				$("#panelBank" + numPanelBanks).after(newDiv);

				// enable remove button
				$("#removePanelBank").removeAttr("disabled");

				// increment number of panel banks
				numPanelBanks++;

				// limit number of panel banks
				if (numPanelBanks == 5) {
					$("#addPanelBank").attr("disabled", "disabled");
				}
			});

	// remove panel bank
	$("#removePanelBank").click(function() {

		// remove last panel bank
		$("#panelBank" + numPanelBanks).remove();

		// enable add button
		$("#addPanelBank").removeAttr("disabled");

		// decrement number of panel banks
		numPanelBanks--;

		// disable remove button if only one panel bank exists
		if (numPanelBanks == 1) {
			$("#removePanelBank").attr("disabled", "disabled");
		}
	});

	// add replacement inverter cost text field
	$(".rb").change(function() {
		if ($("#yes").is(":checked")) {
			$(".rc").show();
			$("#lblReplacementCostCurrency").show();
		} else {
			$(".rc").hide();
			$("#lblReplacementCostCurrency").hide();
		}
	});

	// add replacement inverter cost text field if it disappears on reload
	if ($("#yes").is(":checked")) {
		$(".rc").show();
		$("#lblReplacementCostCurrency").show();
	}

	// add tariff
	$("#addTariff").click(
			function() {

				// tariff percentage total
				var percentageTotal = 0;

				// new tariff percentage
				var newPercentage = 0;

				// round tariff percentages and get rounded total
				for ( var i = 1; i <= numTariffs; i++) {
					var percentage = $("#tariff" + i).children(
							"#tariffPercentage" + i).val();
					if (percentage > 0) {
						percentage = parseFloat($("#tariff" + i).children(
								"#tariffPercentage" + i).val());
					} else {
						percentage = 0;
					}
					var roundedPercentage = percentage.toFixed(2);
					$("#tariff" + i).children("#tariffPercentage" + i).val(
							roundedPercentage);
					percentageTotal += parseFloat(roundedPercentage);
				}

				// get new tariff percentage
				if (percentageTotal < 100) {
					newPercentage = 100 - percentageTotal;
				}

				// new number of tariffs
				var newNumTariffs = numTariffs + 1;

				// clone previous div and increment id attribute
				var newDiv = $("#tariff" + numTariffs).clone().attr("id",
						"tariff" + newNumTariffs);

				// increment text field attributes
				newDiv.children("#tariffRate" + numTariffs).attr("id",
						"tariffRate" + newNumTariffs).attr("name",
						"tariffRate" + newNumTariffs).attr("value", "");

				// increment text field attributes
				newDiv.children("#tariffPercentage" + numTariffs).attr("id",
						"tariffPercentage" + newNumTariffs).attr("name",
						"tariffPercentage" + newNumTariffs).attr("value",
						newPercentage.toFixed(2));

				// hide add button
				newDiv.children("#addTariff").hide();

				// hide remove button
				newDiv.children("#removeTariff").hide();

				// add new div after previous div
				$("#tariff" + numTariffs).after(newDiv);

				// enable remove button
				$("#removeTariff").removeAttr("disabled");

				// increment number of tariffs
				numTariffs++;

				// limit number of tariffs
				if (numTariffs == 5) {
					$("#addTariff").attr("disabled", "disabled");
				}
			});

	// remove tariff
	$("#removeTariff").click(function() {

		// remove last tariff
		$("#tariff" + numTariffs).remove();

		// enable add button
		$("#addTariff").removeAttr("disabled");

		// decrement number of tariffs
		numTariffs--;

		// disable remove button if only one tariff exists
		if (numTariffs == 1) {
			$("#removeTariff").attr("disabled", "disabled");
		}
	});

	// submit form
	$("#submitForm").click(function() {

		// post form data to calculate page/servlet
		$.post("calculate", $("#form").serialize(), function(data) {

			// alert($("#form").serialize());

			// set content of results div to output from servlet
			$("#divResults").html(data);

			// show and hide correct types of results
			if (resultsType == "simple") {
				$("#simpleResults").show();
				$("#advancedResults").hide();
			} else {
				$("#advancedResults").show();
				$("#simpleResults").hide();
			}

			// toggle between different types of results
			$("#toggleResults").click(function() {
				if ($("#simpleResults").is(":visible")) {
					$("#advancedResults").show();
					$("#simpleResults").hide();
					resultsType = "advanced";
				} else {
					$("#simpleResults").show();
					$("#advancedResults").hide();
					resultsType = "simple";
				}
			});
		});
	});
});
// var errorFlag = false;
// var errorMessage = "";
// /*
// * Send data of calculation form to the calculate servlet and get results from
// * the same servlet. Show the results in the result rextarea without reloading
// * the index page.
// */
// function loadXMLDoc() {
// var xmlhttp;
// if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
// xmlhttp = new XMLHttpRequest();
// } else {// code for IE6, IE5
// xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
// }
// xmlhttp.onreadystatechange = function() {
// // if the response has been received
// if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
// // set the id 'results' to visible
// document.getElementById("results").style.visibility = "visible";
// // put response text into the textarea
// document.getElementById("ajaxresponse").innerHTML = xmlhttp.responseText;
// // mouse cursor focus on the textarea
// document.getElementById("ajaxresponse").focus();
// }
// }
// // var sysLoc = document.getElementById("tryit").value;
// // var querystring = "?&systemLocation=" + sysLoc + "&number=" + "123456";
// var querystring = getFormData();
// if (errorFlag == true) {// if errors in user input
// document.getElementById("errorflag").innerHTML = errorMessage;
// document.getElementById("errorflag").style.color = "red";
// document.getElementById("errorflag").scrollIntoView();
// } else if (errorFlag == false) {// if no input errors, forward form data and
// // get server response
// // document.getElementById("errorflag").innerHTML="No errors";
// xmlhttp.open("POST", "/calculate" + querystring, true);
// xmlhttp.setRequestHeader("Content-type",
// "application/x-www-form-urlencoded");
// // xmlhttp.send(formObject);
// xmlhttp.send();
// }
// }
// function getFormData() {
// errorFlag = false; // 06/10
// errorMessage = "";
// var formData = "?";
// // get all the data from the form, not worry about the added fields yet!
// // need to add them
// var conLoc = document.getElementById("confirmedLocation").value; // !=
// // 1.0
// var sysCost = document.getElementById("systemCost").value;// >0 numeric
// var sysSize = document.getElementById("systemSize").value;// != 1.0
// var noPanel1 = document.getElementById("numberOfPanels1").value;// != 1.0
// var panelOri1 = document.getElementById("panelOrientation1").value;// !=
// // 1.0
// var effLoss = document.getElementById("panelEfficiencyLoss").value;// >0
// // <100
// // numeric
// var inverEff = document.getElementById("inverterEfficiency").value;// >0
// // <100
// // numeric
// var repCost = "";// >0 numeric
// // yes radio button is checked
// if (document.getElementById("yes").checked) {
// repCost = document.getElementById("replacementCost").value; // >0
// // numeric
// } else if (document.getElementById("no").checked) {
// repCost = "0";
// }
// var hoursSun = document.getElementById("hoursOfSunlight").value;// != 1.0
// var dailyUsage = document.getElementById("dailyPowerUsage").value;// >0
// // numeric
// var daytimeUsage = document.getElementById("daytimePowerUsage").value;// >0
// // <daily
// // usage
// var tarRate1 = document.getElementById("tariffRate1").value;// >0
// var tarPer1 = document.getElementById("tariffPercentage1").value;// >0
// // <100
// var tarIncrease = document.getElementById("tariffIncrease").value;// >0
// // <100
// var feedinTar = document.getElementById("feedinTariff").value;// >0
// /*
// * do the validation. For field in selection box, value != -1.0, for normal
// * numbers, value is numeric, and is larger than 0. For percentage, value is
// * numeric and is larger than 0 but less than 100
// */
// // check the selection box input first
// if (conLoc == "-1.0" || sysSize == "-1.0" || noPanel1 == "-1.0"
// || panelOri1 == "-1.0" || hoursSun == "-1.0") {
// errorFlag = true;
// errorMessage += "One or more selection fields unchecked. ";
// // check normal number input. Convert the number and compare to 0.
// } else if (!(Number(sysCost) >= 0) || !(Number(dailyUsage) >= 0)
// || !(Number(tarRate1) >= 0) || !(Number(feedinTar) >= 0)
// || !(Number(repCost) >= 0) || !(Number(daytimeUsage) >= 0)) {
// errorFlag = true;
// errorMessage += "Invalid number entry. ";
// // check percentage number input. Convert number and compare to 0 and
// // 100
// // up till here is all working
// } else if (!((Number(effLoss) >= 0) && (Number(effLoss) <= 100))
// || !((Number(inverEff) >= 0) && (Number(inverEff) <= 100))
// || !((Number(tarPer1) >= 0) && (Number(tarPer1) <= 100))
// || !((Number(tarIncrease) >= 0) && (Number(tarIncrease) <= 100))) {
// errorFlag = true;
// errorMessage += "Invalid percentage entry. ";
// } else if (!(Number(dailyUsage) >= Number(daytimeUsage))) {
// errorFlag = true;
// errorMessage += "Daily time power usage should not be larger than daily
// uasge. ";
// } else {// input all correct, get data from form
// formData += "&confirmedLocation=" + conLoc + "&systemCost=" + sysCost
// + "&systemSize=" + sysSize + "&numberOfPanels1=" + noPanel1
// + "&panelOrientation1=" + panelOri1 + "&panelEfficiencyLoss="
// + effLoss + "&inverterEfficiency=" + inverEff
// + "&replacementCost=" + repCost + "&hoursOfSunlight="
// + hoursSun + "&dailyPowerUsage=" + dailyUsage
// + "&daytimePowerUsage=" + daytimeUsage + "&tariffRate1="
// + tarRate1 + "&tariffPercentage1=" + tarPer1
// + "&tariffIncrease=" + tarIncrease + "&feedinTariff="
// + feedinTar;
// errorFlag = false;
// }
// return formData;
// }
