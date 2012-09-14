/*
 * Author: MGSD Technology
 * Date:
 * Description:
 */

// when page has loaded
$(function() {

	// number of panel banks
	var numPanelBanks = 1;

	// number of tariffs
	var numTariffs = 1;

	// add tooltips
	$(".tooltip").tooltipsy({
		offset : [ 5, 0 ]
	});

	// NEED FUNCTION FOR SYSTEM LOCATION
	
	
	

	// add custom system size text field
	$("#systemSize").change(function() {
		if ($(this).val() == "-2.0") {
			$(".css").show();
		} else {
			$(".css").hide();
		}
	});

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
			$("#lblCurrency").show();
		} else {
			$(".rc").hide();
			$("#lblCurrency").hide();
		}
	});

	// add tariff
	$("#addTariff").click(
			function() {

				// new number of tariffs
				var newNumTariffs = numTariffs + 1;

				// clone previous div and increment id attribute
				var newDiv = $("#tariff" + numTariffs).clone().attr("id",
						"tariff" + newNumTariffs);

				// increment text field attributes
				newDiv.children("#tariffRate" + numTariffs).attr("id",
						"tariffRate" + newNumTariffs).attr("name",
						"tariffRate" + newNumTariffs);

				// increment text field attributes
				newDiv.children("#tariffPercentage" + numTariffs).attr("id",
						"tariffPercentage" + newNumTariffs).attr("name",
						"tariffPercentage" + newNumTariffs);

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

});