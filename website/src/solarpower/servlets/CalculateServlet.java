package solarpower.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import solarpower.entities.SolarCalculator;

public class CalculateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    String systemSizeParameter;
    int numPanelBanks;
    String numberOfPanels1Parameter;
    String panelOrientation1Parameter;
    String panelTilt1Parameter;
    String numberOfPanels2Parameter;
    String panelOrientation2Parameter;
    String panelTilt2Parameter;
    String numberOfPanels3Parameter;
    String panelOrientation3Parameter;
    String panelTilt3Parameter;
    String numberOfPanels4Parameter;
    String panelOrientation4Parameter;
    String panelTilt4Parameter;
    String numberOfPanels5Parameter;
    String panelOrientation5Parameter;
    String panelTilt5Parameter;
    boolean costNeeded;
    int numTariffs;
    String tariffRate1Parameter;
    String tariffPercentage1Parameter;
    String tariffRate2Parameter;
    String tariffPercentage2Parameter;
    String tariffRate3Parameter;
    String tariffPercentage3Parameter;
    String tariffRate4Parameter;
    String tariffPercentage4Parameter;
    String tariffRate5Parameter;
    String tariffPercentage5Parameter;
    
    InputValidator val = new InputValidator();
    SolarCalculator cal = new SolarCalculator();
    
    boolean inputIsValid = true;
    
    String error = "<h2>Results</h2><p>No results were returned.</p><p>";
    String confirmedLocationError = error
            + "Please ensure you have entered a valid system location, clicked <em>Confirm location</em> and selected from a list of matching locations.</p>";
    String systemCostError = error
            + "Please ensure you have entered a valid system cost (numbers only).</p>";
    String systemSizeError = error
            + "Please ensure you have selected or entered a valid system size (numbers only; must be greater than 0).</p>";
    String panelBankError = error
            + "Please ensure you have selected a number of panels, orientation and tilt angle for each panel bank.</p>";
    String panelEfficiencyLossError = error
            + "Please ensure you have entered a valid average annual panel efficiency loss (numbers only).</p>";
    String inverterEfficiencyError = error
            + "Please ensure you have entered a valid inverter efficiency (numbers only).</p>";
    String replacementInverterError = error
            + "Please ensure you have specified whether or not you want to include the cost of a replacement inverter in your calculations.</p>";
    String replacementCostError = error
            + "Please ensure you have entered a valid replacement inverter cost (numbers only).</p>";
    String hoursOfSunlightError = error
            + "Please ensure you have selected an average daily hours of sunlight.</p>";
    String dailyPowerUsageError = error
            + "Please ensure you have entered a valid average daily power usage (numbers only).</p>";
    String daytimePowerUsageError = error
            + "Please ensure you have entered a valid average daytime power usage (numbers only).</p>";
    String powerUsageError = error
            + "Please ensure the average daytime power usage is less than or equal to the average daily power usage.</p>";
    String tariffError = error
            + "Please ensure you have entered a valid tariff rate and average percentage of power usage for each tariff (numbers only).</p>";
    String tariffPercentageError = error
            + "Please ensure the sum of the average percentages of power usage equals 100%.</p>";
    String tariffIncreaseError = error
            + "Please ensure you have entered a valid average annual tariff rate increase (numbers only).</p>";
    String feedinTariffError = error
            + "Please ensure you have entered a valid feed-in tariff rate (numbers only).</p>";
    String results;
    
    double confirmedLocation;
    double systemCost;
    double systemSize;
    double numberOfPanels1;
    double panelOrientation1;
    double panelTilt1;
    double numberOfPanels2;
    double panelOrientation2;
    double panelTilt2;
    double numberOfPanels3;
    double panelOrientation3;
    double panelTilt3;
    double numberOfPanels4;
    double panelOrientation4;
    double panelTilt4;
    double numberOfPanels5;
    double panelOrientation5;
    double panelTilt5;
    double panelEfficiencyLoss;
    double inverterEfficiency;
    String replacementInverter;
    double replacementCost;
    double hoursOfSunlight;
    double dailyPowerUsage;
    double daytimePowerUsage;
    double tariffRate1;
    double tariffPercentage1;
    double tariffRate2;
    double tariffPercentage2;
    double tariffRate3;
    double tariffPercentage3;
    double tariffRate4;
    double tariffPercentage4;
    double tariffRate5;
    double tariffPercentage5;
    double tariffIncrease;
    double feedinTariff;
    
    double dailySolarGeneration;
    double[] dailySolarGenerationOver25Years = new double[25];
    double[] annualSolarGenerationOver25Years = new double[25];
    double[] dailySolarUsedOver25Years = new double[25];
    double[] dailySolarExportedOver25Years = new double[25];
    double[] dailySavingsOver25Years = new double[25];
    double[] annualSavingsOver25Years = new double[25];
    double[] cumulativeSavingsOver25Years = new double[25];
    
    public CalculateServlet() {
        super();
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {
        
        // set variables to default values
        systemSizeParameter = "systemSize";
        numPanelBanks = 1;
        numberOfPanels1Parameter = "numberOfPanels1";
        panelOrientation1Parameter = "panelOrientation1";
        panelTilt1Parameter = "panelTilt1";
        numberOfPanels2Parameter = "numberOfPanels1";
        panelOrientation2Parameter = "panelOrientation1";
        panelTilt2Parameter = "panelTilt1";
        numberOfPanels3Parameter = "numberOfPanels1";
        panelOrientation3Parameter = "panelOrientation1";
        panelTilt3Parameter = "panelTilt1";
        numberOfPanels4Parameter = "numberOfPanels1";
        panelOrientation4Parameter = "panelOrientation1";
        panelTilt4Parameter = "panelTilt1";
        numberOfPanels5Parameter = "numberOfPanels1";
        panelOrientation5Parameter = "panelOrientation1";
        panelTilt5Parameter = "panelTilt1";
        costNeeded = false;
        numTariffs = 1;
        tariffRate1Parameter = "tariffRate1";
        tariffPercentage1Parameter = "tariffPercentage1";
        tariffRate2Parameter = "tariffRate1";
        tariffPercentage2Parameter = "tariffPercentage1";
        tariffRate3Parameter = "tariffRate1";
        tariffPercentage3Parameter = "tariffPercentage1";
        tariffRate4Parameter = "tariffRate1";
        tariffPercentage4Parameter = "tariffPercentage1";
        tariffRate5Parameter = "tariffRate1";
        tariffPercentage5Parameter = "tariffPercentage1";
        
        // check if system size is custom
        if (val.isCustomSelection(req.getParameter("systemSize"))) {
            systemSizeParameter = "customSystemSize";
        }
        
        // get number of panel banks
        for (int i = 2; i < 6; i++) {
            if (!val.isNull(req.getParameter("numberOfPanels" + i))) {
                numPanelBanks = i;
            }
        }
        
        // set panel bank parameters according to number of panel banks
        if (numPanelBanks > 1) {
            numberOfPanels2Parameter = "numberOfPanels2";
            panelOrientation2Parameter = "panelOrientation2";
            panelTilt2Parameter = "panelTilt2";
            if (numPanelBanks > 2) {
                numberOfPanels3Parameter = "numberOfPanels3";
                panelOrientation3Parameter = "panelOrientation3";
                panelTilt3Parameter = "panelTilt3";
                if (numPanelBanks > 3) {
                    numberOfPanels4Parameter = "numberOfPanels4";
                    panelOrientation4Parameter = "panelOrientation4";
                    panelTilt4Parameter = "panelTilt4";
                    if (numPanelBanks > 4) {
                        numberOfPanels5Parameter = "numberOfPanels5";
                        panelOrientation5Parameter = "panelOrientation5";
                        panelTilt5Parameter = "panelTilt5";
                    }
                }
            }
        }
        
        // check if replacement inverter cost is needed
        if (!val.isNull(req.getParameter("replacementInverter"))) {
            costNeeded = val.isYesValue(req.getParameter("replacementInverter"));
        }
        
        // get number of tariffs
        for (int i = 2; i < 6; i++) {
            if (!val.isNull(req.getParameter("tariffRate" + i))) {
                numTariffs = i;
            }
        }
        
        // set tariff parameters according to number of tariffs
        if (numTariffs > 1) {
            tariffRate2Parameter = "tariffRate2";
            tariffPercentage2Parameter = "tariffPercentage2";
            if (numTariffs > 2) {
                tariffRate3Parameter = "tariffRate3";
                tariffPercentage3Parameter = "tariffPercentage3";
                if (numTariffs > 3) {
                    tariffRate4Parameter = "tariffRate4";
                    tariffPercentage4Parameter = "tariffPercentage4";
                    if (numTariffs > 4) {
                        tariffRate5Parameter = "tariffRate5";
                        tariffPercentage5Parameter = "tariffPercentage5";
                    }
                }
            }
        }
        
        // validate all fields and output appropriate error messages
        if (val.isInvalidDropdown(req.getParameter("confirmedLocation"))) {
            outputError(confirmedLocationError);
        } else if (val.isInvalidNumberField(req.getParameter("systemCost"))) {
            outputError(systemCostError);
        } else if (val.isInvalidSystemSize(req.getParameter(systemSizeParameter))) {
            outputError(systemSizeError);
        } else if (val
                .isInvalidPanelBank(req.getParameter(numberOfPanels1Parameter),
                        req.getParameter(panelOrientation1Parameter),
                        req.getParameter(panelTilt1Parameter))) {
            outputError(panelBankError);
        } else if (val
                .isInvalidPanelBank(req.getParameter(numberOfPanels2Parameter),
                        req.getParameter(panelOrientation2Parameter),
                        req.getParameter(panelTilt2Parameter))) {
            outputError(panelBankError);
        } else if (val
                .isInvalidPanelBank(req.getParameter(numberOfPanels3Parameter),
                        req.getParameter(panelOrientation3Parameter),
                        req.getParameter(panelTilt3Parameter))) {
            outputError(panelBankError);
        } else if (val
                .isInvalidPanelBank(req.getParameter(numberOfPanels4Parameter),
                        req.getParameter(panelOrientation4Parameter),
                        req.getParameter(panelTilt4Parameter))) {
            outputError(panelBankError);
        } else if (val
                .isInvalidPanelBank(req.getParameter(numberOfPanels5Parameter),
                        req.getParameter(panelOrientation5Parameter),
                        req.getParameter(panelTilt5Parameter))) {
            outputError(panelBankError);
        } else if (val.isInvalidPercentageField(req.getParameter("panelEfficiencyLoss"))) {
            outputError(panelEfficiencyLossError);
        } else if (val.isInvalidPercentageField(req.getParameter("inverterEfficiency"))) {
            outputError(inverterEfficiencyError);
        } else if (val.isNull(req.getParameter("replacementInverter"))) {
            outputError(replacementInverterError);
        } else if (val.isInvalidReplacementCost(req.getParameter("replacementCost"), costNeeded)) {
            outputError(replacementCostError);
        } else if (val.isInvalidDropdown(req.getParameter("hoursOfSunlight"))) {
            outputError(hoursOfSunlightError);
        } else if (val.isInvalidNumberField(req.getParameter("dailyPowerUsage"))) {
            outputError(dailyPowerUsageError);
        } else if (val.isInvalidNumberField(req.getParameter("daytimePowerUsage"))) {
            outputError(daytimePowerUsageError);
        } else if (val.isInvalidPowerUsage(req.getParameter("dailyPowerUsage"),
                req.getParameter("daytimePowerUsage"))) {
            outputError(powerUsageError);
        } else if (val.isInvalidTariff(req.getParameter(tariffRate1Parameter),
                req.getParameter(tariffPercentage1Parameter))) {
            outputError(tariffError);
        } else if (val.isInvalidTariff(req.getParameter(tariffRate2Parameter),
                req.getParameter(tariffPercentage2Parameter))) {
            outputError(tariffError);
        } else if (val.isInvalidTariff(req.getParameter(tariffRate3Parameter),
                req.getParameter(tariffPercentage3Parameter))) {
            outputError(tariffError);
        } else if (val.isInvalidTariff(req.getParameter(tariffRate4Parameter),
                req.getParameter(tariffPercentage4Parameter))) {
            outputError(tariffError);
        } else if (val.isInvalidTariff(req.getParameter(tariffRate5Parameter),
                req.getParameter(tariffPercentage5Parameter))) {
            outputError(tariffError);
        } else if (val.isInvalidTariffPercentage(req.getParameter(tariffPercentage1Parameter),
                req.getParameter(tariffPercentage2Parameter),
                req.getParameter(tariffPercentage3Parameter),
                req.getParameter(tariffPercentage4Parameter),
                req.getParameter(tariffPercentage5Parameter), numTariffs)) {
            outputError(tariffPercentageError);
        } else if (val.isInvalidPercentageField(req.getParameter("tariffIncrease"))) {
            outputError(tariffIncreaseError);
        } else if (val.isInvalidNumberField(req.getParameter("feedinTariff"))) {
            outputError(feedinTariffError);
        } else {
            inputIsValid = true;
        }
        
        // get form data if it is all valid
        if (inputIsValid) {
            confirmedLocation = Double.parseDouble(req.getParameter("confirmedLocation"));
            systemCost = Double.parseDouble(req.getParameter("systemCost"));
            systemSize = Double.parseDouble(req.getParameter(systemSizeParameter));
            numberOfPanels1 = Double.parseDouble(req.getParameter("numberOfPanels1"));
            panelOrientation1 = Double.parseDouble(req.getParameter("panelOrientation1"));
            panelTilt1 = Double.parseDouble(req.getParameter("panelTilt1"));
            
            // get more panel bank data according to number of panel banks
            if (numPanelBanks > 1) {
                numberOfPanels2 = Double.parseDouble(req.getParameter("numberOfPanels2"));
                panelOrientation2 = Double.parseDouble(req.getParameter("panelOrientation2"));
                panelTilt2 = Double.parseDouble(req.getParameter("panelTilt2"));
                if (numPanelBanks > 2) {
                    numberOfPanels3 = Double.parseDouble(req.getParameter("numberOfPanels3"));
                    panelOrientation3 = Double.parseDouble(req.getParameter("panelOrientation3"));
                    panelTilt3 = Double.parseDouble(req.getParameter("panelTilt3"));
                    if (numPanelBanks > 3) {
                        numberOfPanels4 = Double.parseDouble(req.getParameter("numberOfPanels4"));
                        panelOrientation4 = Double.parseDouble(req
                                .getParameter("panelOrientation4"));
                        panelTilt4 = Double.parseDouble(req.getParameter("panelTilt4"));
                        if (numPanelBanks > 4) {
                            numberOfPanels5 = Double.parseDouble(req
                                    .getParameter("numberOfPanels5"));
                            panelOrientation5 = Double.parseDouble(req
                                    .getParameter("panelOrientation5"));
                            panelTilt5 = Double.parseDouble(req.getParameter("panelTilt5"));
                        }
                    }
                }
            }
            panelEfficiencyLoss = Double.parseDouble(req.getParameter("panelEfficiencyLoss"));
            inverterEfficiency = Double.parseDouble(req.getParameter("inverterEfficiency"));
            replacementInverter = req.getParameter("replacementInverter");
            
            // get inverter replacement cost data if it is needed
            if (costNeeded) {
                replacementCost = Double.parseDouble(req.getParameter("replacementCost"));
            }
            hoursOfSunlight = Double.parseDouble(req.getParameter("hoursOfSunlight"));
            dailyPowerUsage = Double.parseDouble(req.getParameter("dailyPowerUsage"));
            daytimePowerUsage = Double.parseDouble(req.getParameter("daytimePowerUsage"));
            tariffRate1 = Double.parseDouble(req.getParameter("tariffRate1"));
            tariffPercentage1 = Double.parseDouble(req.getParameter("tariffPercentage1"));
            
            // get more tariff data according to number of tariffs
            if (numTariffs > 1) {
                tariffRate2 = Double.parseDouble(req.getParameter("tariffRate2"));
                tariffPercentage2 = Double.parseDouble(req.getParameter("tariffPercentage2"));
                if (numTariffs > 2) {
                    tariffRate3 = Double.parseDouble(req.getParameter("tariffRate3"));
                    tariffPercentage3 = Double.parseDouble(req.getParameter("tariffPercentage3"));
                    if (numTariffs > 3) {
                        tariffRate4 = Double.parseDouble(req.getParameter("tariffRate4"));
                        tariffPercentage4 = Double.parseDouble(req
                                .getParameter("tariffPercentage4"));
                        if (numTariffs > 4) {
                            tariffRate5 = Double.parseDouble(req.getParameter("tariffRate5"));
                            tariffPercentage5 = Double.parseDouble(req
                                    .getParameter("tariffPercentage5"));
                        }
                    }
                }
            }
            tariffIncrease = Double.parseDouble(req.getParameter("tariffIncrease"));
            feedinTariff = Double.parseDouble(req.getParameter("feedinTariff"));
            
            // calculations done here, still need lots of work
            // -----------------------------------------------
            // double dailySolarGeneration = cal.calculateDailyGeneration(systemSize,
            // inverterEfficiency / 100, hoursOfSunlight, panelOrientation1, 1);
            //
            // double annualSolarGeneration = cal.calculateAnnualGeneration(systemSize,
            // inverterEfficiency / 100, hoursOfSunlight, panelOrientation1, 1);
            
            // ////
            
            double panelEfficiency = 1;
            
            switch (numPanelBanks) {
                case 1:
                    dailySolarGeneration = cal.calcDailySolarGenerationWithOnePanelBank(
                            panelOrientation1, panelTilt1, confirmedLocation, systemSize,
                            inverterEfficiency, hoursOfSunlight);
                    for (int i = 0; i < 25; i++) {
                        dailySolarGenerationOver25Years[i] = dailySolarGeneration * panelEfficiency;
                        panelEfficiency = panelEfficiency - (panelEfficiencyLoss / 100);
                        if (panelEfficiency < 0) {
                            panelEfficiency = 0;
                        }
                    }
                    break;
                case 2:
                    dailySolarGeneration = cal.calcDailySolarGenerationWithTwoPanelBanks(
                            numberOfPanels1, panelOrientation1, panelTilt1, numberOfPanels2,
                            panelOrientation2, panelTilt2, confirmedLocation, systemSize,
                            inverterEfficiency, hoursOfSunlight);
                    for (int i = 0; i < 25; i++) {
                        dailySolarGenerationOver25Years[i] = dailySolarGeneration * panelEfficiency;
                        panelEfficiency = panelEfficiency - (panelEfficiencyLoss / 100);
                        if (panelEfficiency < 0) {
                            panelEfficiency = 0;
                        }
                    }
                    break;
                case 3:
                    dailySolarGeneration = cal.calcDailySolarGenerationWithThreePanelBanks(
                            numberOfPanels1, panelOrientation1, panelTilt1, numberOfPanels2,
                            panelOrientation2, panelTilt2, numberOfPanels3, panelOrientation3,
                            panelTilt3, confirmedLocation, systemSize, inverterEfficiency,
                            hoursOfSunlight);
                    for (int i = 0; i < 25; i++) {
                        dailySolarGenerationOver25Years[i] = dailySolarGeneration * panelEfficiency;
                        panelEfficiency = panelEfficiency - (panelEfficiencyLoss / 100);
                        if (panelEfficiency < 0) {
                            panelEfficiency = 0;
                        }
                    }
                    break;
                case 4:
                    dailySolarGeneration = cal.calcDailySolarGenerationWithFourPanelBanks(
                            numberOfPanels1, panelOrientation1, panelTilt1, numberOfPanels2,
                            panelOrientation2, panelTilt2, numberOfPanels3, panelOrientation3,
                            panelTilt3, numberOfPanels4, panelOrientation4, panelTilt4,
                            confirmedLocation, systemSize, inverterEfficiency, hoursOfSunlight);
                    for (int i = 0; i < 25; i++) {
                        dailySolarGenerationOver25Years[i] = dailySolarGeneration * panelEfficiency;
                        panelEfficiency = panelEfficiency - (panelEfficiencyLoss / 100);
                        if (panelEfficiency < 0) {
                            panelEfficiency = 0;
                        }
                    }
                    break;
                case 5:
                    dailySolarGeneration = cal.calcDailySolarGenerationWithFivePanelBanks(
                            numberOfPanels1, panelOrientation1, panelTilt1, numberOfPanels2,
                            panelOrientation2, panelTilt2, numberOfPanels3, panelOrientation3,
                            panelTilt3, numberOfPanels4, panelOrientation4, panelTilt4,
                            numberOfPanels5, panelOrientation5, panelTilt5, confirmedLocation,
                            systemSize, inverterEfficiency, hoursOfSunlight);
                    for (int i = 0; i < 25; i++) {
                        dailySolarGenerationOver25Years[i] = dailySolarGeneration * panelEfficiency;
                        panelEfficiency = panelEfficiency - (panelEfficiencyLoss / 100);
                        if (panelEfficiency < 0) {
                            panelEfficiency = 0;
                        }
                    }
                    break;
            }
            
            for (int i = 0; i < 25; i++) {
                annualSolarGenerationOver25Years[i] = dailySolarGenerationOver25Years[i] * 365;
                dailySolarUsedOver25Years[i] = cal.calcDailySolarUsed(daytimePowerUsage,
                        dailySolarGenerationOver25Years[i]);
                dailySolarExportedOver25Years[i] = cal.calcDailySolarExported(
                        dailySolarGenerationOver25Years[i], dailySolarUsedOver25Years[i]);
            }
            
            switch (numTariffs) {
                case 1:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithOneTariff(tariffRate1,
                                dailySolarUsedOver25Years[i], dailySolarExportedOver25Years[i],
                                feedinTariff);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithTwoTariffs(
                                tariffRate1, tariffPercentage1, tariffRate2, tariffPercentage2,
                                dailySolarUsedOver25Years[i], dailySolarExportedOver25Years[i],
                                feedinTariff);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithThreeTariffs(
                                tariffRate1, tariffPercentage1, tariffRate2, tariffPercentage2,
                                tariffRate3, tariffPercentage3, dailySolarUsedOver25Years[i],
                                dailySolarExportedOver25Years[i], feedinTariff);
                    }
                    break;
                case 4:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithFourTariffs(
                                tariffRate1, tariffPercentage1, tariffRate2, tariffPercentage2,
                                tariffRate3, tariffPercentage3, tariffRate4, tariffPercentage4,
                                dailySolarUsedOver25Years[i], dailySolarExportedOver25Years[i],
                                feedinTariff);
                    }
                    break;
                case 5:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithFiveTariffs(
                                tariffRate1, tariffPercentage1, tariffRate2, tariffPercentage2,
                                tariffRate3, tariffPercentage3, tariffRate4, tariffPercentage4,
                                tariffRate5, tariffPercentage5, dailySolarUsedOver25Years[i],
                                dailySolarExportedOver25Years[i], feedinTariff);
                    }
                    break;
            }
            
            double cumulativeSavings = 0;
            
            for (int i = 0; i < 25; i++) {
                annualSavingsOver25Years[i] = dailySavingsOver25Years[i] * 365;
                cumulativeSavings += annualSavingsOver25Years[i];
                cumulativeSavingsOver25Years[i] = cumulativeSavings;
            }
            
            // double breakEvenPoint = cal.calcBreakEvenPoint(systemCost, annualSavings);
            
            // double investmentReturn = cal.calcInvestmentReturn(systemCost);
            
            // results string constructed here, still needs work
            // -------------------------------------------------
            results = "<h2>Results</h2><p>System location latitude: " + confirmedLocation
                    + "<br />System cost: $" + systemCost + "<br />System size: " + systemSize
                    + "kW<br /><br />Panel bank: " + numberOfPanels1 + " panels, "
                    + panelOrientation1 + "&deg; orientation, " + panelTilt1 + "&deg; tilt";
            
            if (numPanelBanks > 1) {
                results += "<br />Panel bank: " + numberOfPanels2 + " panels, " + panelOrientation2
                        + "&deg; orientation, " + panelTilt2 + "&deg; tilt";
                if (numPanelBanks > 2) {
                    results += "<br />Panel bank: " + numberOfPanels3 + " panels, "
                            + panelOrientation3 + "&deg; orientation, " + panelTilt3 + "&deg; tilt";
                    if (numPanelBanks > 3) {
                        results += "<br />Panel bank: " + numberOfPanels4 + " panels, "
                                + panelOrientation4 + "&deg; orientation, " + panelTilt4
                                + "&deg; tilt";
                        if (numPanelBanks > 4) {
                            results += "<br />Panel bank: " + numberOfPanels5 + " panels, "
                                    + panelOrientation5 + "&deg; orientation, " + panelTilt5
                                    + "&deg; tilt";
                        }
                    }
                }
            }
            
            results += "<br />Average annual panel efficiency loss rate: " + panelEfficiencyLoss
                    + "%<br /><br />Inverter efficiency: " + inverterEfficiency
                    + "%<br />Replacement inverter: " + replacementInverter;
            
            if (costNeeded) {
                results += "<br />Replacement inverter cost: $" + replacementCost;
            }
            
            results += "<br /><br />Average daily hours of sunlight: " + hoursOfSunlight
                    + "<br />Average daily power usage: " + dailyPowerUsage
                    + "kWh<br />Average daytime power usage: " + daytimePowerUsage
                    + "kWh<br /><br />Tariff: " + tariffRate1 + "c/kWh, " + tariffPercentage1
                    + "% average percentage of power usage";
            
            if (numTariffs > 1) {
                results += "<br />Tariff: " + tariffRate2 + " c/kWh, " + tariffPercentage2
                        + "% average percentage of power usage";
                if (numTariffs > 2) {
                    results += "<br />Tariff: " + tariffRate3 + " c/kWh, " + tariffPercentage3
                            + "% average percentage of power usage";
                    if (numTariffs > 3) {
                        results += "<br />Tariff: " + tariffRate4 + " c/kWh, " + tariffPercentage4
                                + "% average percentage of power usage";
                        if (numTariffs > 4) {
                            results += "<br />Tariff: " + tariffRate5 + " c/kWh, "
                                    + tariffPercentage5 + "% average percentage of power usage";
                        }
                    }
                }
            }
            
            results += "<br />Average annual tariff rate increase: " + tariffIncrease
                    + "%<br />Feed-in tariff rate: " + feedinTariff
                    + "c/kWh</p><p>Average daily solar generation over 25 years: ";
            
            for (int i = 0; i < 25; i++) {
                results += dailySolarGenerationOver25Years[i] + "kWh, ";
            }
            
            results += "</p><p>Average annual solar generation over 25 years: ";
            
            for (int i = 0; i < 25; i++) {
                results += annualSolarGenerationOver25Years[i] + "kWh, ";
            }
            
            results += "</p><p>Daily savings over 25 years: ";
            
            for (int i = 0; i < 25; i++) {
                results += "$" + dailySavingsOver25Years[i] + ", ";
            }
            
            results += "</p><p>Annual savings over 25 years: ";
            
            for (int i = 0; i < 25; i++) {
                results += "$" + annualSavingsOver25Years[i] + ", ";
            }
            
            results += "</p><p>Cumulative savings over 25 years: ";
            
            for (int i = 0; i < 25; i++) {
                results += "$" + cumulativeSavingsOver25Years[i] + ", ";
            }
            
        }
        
        // output string as response
        resp.setContentType("text/plain");
        PrintWriter output = resp.getWriter();
        output.print(results);
        output.flush();
        output.close();
    }
    
    // set error message as output string
    public void outputError(String error) {
        inputIsValid = false;
        results = error;
    }
}