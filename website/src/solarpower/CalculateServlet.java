package solarpower;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            + "Please ensure you have entered a valid system cost or left it blank (numbers only; no more than two decimal places).</p>";
    String systemSizeError = error
            + "Please ensure you have selected or entered a valid system size (numbers only; no more than two decimal places; must be greater than zero).</p>";
    String panelBankError = error
            + "Please ensure you have selected a number of panels, orientation and tilt angle for each panel bank.</p>";
    String panelEfficiencyLossError = error
            + "Please ensure you have entered a valid average annual panel efficiency loss (numbers only; no more than two decimal places).</p>";
    String inverterEfficiencyError = error
            + "Please ensure you have entered a valid inverter efficiency (numbers only; no more than 2 decimal places).</p>";
    String replacementInverterError = error
            + "Please ensure you have specified whether or not you want to include the cost of a replacement inverter in your calculations.</p>";
    String replacementCostError = error
            + "Please ensure you have entered a valid replacement inverter cost (numbers only; no more than two decimal places).</p>";
    String hoursOfSunlightError = error
            + "Please ensure you have selected an average daily hours of sunlight.</p>";
    String dailyPowerUsageError = error
            + "Please ensure you have entered a valid average daily power usage (numbers only; no more than two decimal places).</p>";
    String daytimePowerUsageError = error
            + "Please ensure you have entered a valid average daytime power usage (numbers only; no more than two decimal places).</p>";
    String powerUsageError = error
            + "Please ensure the average daytime power usage is less than or equal to the average daily power usage.</p>";
    String tariffError = error
            + "Please ensure you have entered a valid tariff rate and average percentage of power usage for each tariff (numbers only; no more than two decimal places).</p>";
    String tariffPercentageError = error
            + "Please ensure the sum of the average percentages of power usage equals 100%.</p>";
    String tariffIncreaseError = error
            + "Please ensure you have entered a valid average annual tariff rate increase (numbers only; no more than two decimal places).</p>";
    String feedinTariffError = error
            + "Please ensure you have entered a valid feed-in tariff rate or left it blank (numbers only; no more than two decimal places).</p>";
    String interestRateError = error
            + "Please ensure you have entered a valid average annual interest rate for comparison or left it blank (numbers only; no more than two decimal places).</p>";
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
    double newTariffRate1;
    double tariffRate2;
    double tariffPercentage2;
    double newTariffRate2;
    double tariffRate3;
    double tariffPercentage3;
    double newTariffRate3;
    double tariffRate4;
    double tariffPercentage4;
    double newTariffRate4;
    double tariffRate5;
    double tariffPercentage5;
    double newTariffRate5;
    double tariffIncrease;
    double feedinTariff;
    double interestRate;
    
    double[] dailySolarGenerationOver25Years = new double[25];
    double[] annualSolarGenerationOver25Years = new double[25];
    double[] dailySolarUsedOver25Years = new double[25];
    double[] dailySolarExportedOver25Years = new double[25];
    double[] dailySavingsOver25Years = new double[25];
    double[] annualSavingsOver25Years = new double[25];
    double[] cumulativeSavingsOver25Years = new double[25];
    double[] cumulativeInvestmentReturnOver25Years = new double[25];
    
    int breakEvenPoint;
    double averageDailySolarGeneration;
    double averageAnnualSolarGeneration;
    double averageDailySavings;
    double averageAnnualSavings;
    
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
        for (int i = 2; i <= 5; i++) {
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
        for (int i = 2; i <= 5; i++) {
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
        } else if (val.isInvalidNumberField(req.getParameter("systemCost"), false)) {
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
        } else if (val.isInvalidPercentageField(req.getParameter("panelEfficiencyLoss"), true)) {
            outputError(panelEfficiencyLossError);
        } else if (val.isInvalidPercentageField(req.getParameter("inverterEfficiency"), true)) {
            outputError(inverterEfficiencyError);
        } else if (val.isNull(req.getParameter("replacementInverter"))) {
            outputError(replacementInverterError);
        } else if (val.isInvalidReplacementCost(req.getParameter("replacementCost"), costNeeded)) {
            outputError(replacementCostError);
        } else if (val.isInvalidDropdown(req.getParameter("hoursOfSunlight"))) {
            outputError(hoursOfSunlightError);
        } else if (val.isInvalidNumberField(req.getParameter("dailyPowerUsage"), true)) {
            outputError(dailyPowerUsageError);
        } else if (val.isInvalidNumberField(req.getParameter("daytimePowerUsage"), true)) {
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
        } else if (val.isInvalidPercentageField(req.getParameter("tariffIncrease"), true)) {
            outputError(tariffIncreaseError);
        } else if (val.isInvalidNumberField(req.getParameter("feedinTariff"), false)) {
            outputError(feedinTariffError);
        } else if (val.isInvalidPercentageField(req.getParameter("interestRate"), false)) {
            outputError(interestRateError);
        } else {
            inputIsValid = true;
        }
        
        // get form data if it is all valid
        if (inputIsValid) {
            confirmedLocation = Double.parseDouble(req.getParameter("confirmedLocation"));
            systemCost = cal.calcBlankField(req.getParameter("systemCost"));
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
            newTariffRate1 = tariffRate1;
            
            // get more tariff data according to number of tariffs
            if (numTariffs > 1) {
                tariffRate2 = Double.parseDouble(req.getParameter("tariffRate2"));
                tariffPercentage2 = Double.parseDouble(req.getParameter("tariffPercentage2"));
                newTariffRate2 = tariffRate2;
                if (numTariffs > 2) {
                    tariffRate3 = Double.parseDouble(req.getParameter("tariffRate3"));
                    tariffPercentage3 = Double.parseDouble(req.getParameter("tariffPercentage3"));
                    newTariffRate3 = tariffRate3;
                    if (numTariffs > 3) {
                        tariffRate4 = Double.parseDouble(req.getParameter("tariffRate4"));
                        tariffPercentage4 = Double.parseDouble(req
                                .getParameter("tariffPercentage4"));
                        newTariffRate4 = tariffRate4;
                        if (numTariffs > 4) {
                            tariffRate5 = Double.parseDouble(req.getParameter("tariffRate5"));
                            tariffPercentage5 = Double.parseDouble(req
                                    .getParameter("tariffPercentage5"));
                            newTariffRate5 = tariffRate5;
                        }
                    }
                }
            }
            tariffIncrease = Double.parseDouble(req.getParameter("tariffIncrease"));
            feedinTariff = cal.calcBlankField(req.getParameter("feedinTariff"));
            interestRate = cal.calcBlankField(req.getParameter("interestRate"));
            
            double dailySolarGeneration;
            double panelEfficiency = 1;
            
            // calculate daily solar generation over 25 years according to number of panel banks
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
            
            // calculate annual solar generation and daily solar used/exported over 25 years
            for (int i = 0; i < 25; i++) {
                annualSolarGenerationOver25Years[i] = dailySolarGenerationOver25Years[i] * 365;
                dailySolarUsedOver25Years[i] = cal.calcDailySolarUsed(daytimePowerUsage,
                        dailySolarGenerationOver25Years[i]);
                dailySolarExportedOver25Years[i] = cal.calcDailySolarExported(
                        dailySolarGenerationOver25Years[i], dailySolarUsedOver25Years[i]);
            }
            
            // calculate daily savings over 25 years according to number of tariffs
            switch (numTariffs) {
                case 1:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithOneTariff(
                                newTariffRate1, dailySolarUsedOver25Years[i],
                                dailySolarExportedOver25Years[i], feedinTariff);
                        newTariffRate1 = cal.calcTariffRate(newTariffRate1, tariffIncrease);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithTwoTariffs(
                                newTariffRate1, tariffPercentage1, newTariffRate2,
                                tariffPercentage2, dailySolarUsedOver25Years[i],
                                dailySolarExportedOver25Years[i], feedinTariff);
                        newTariffRate1 = cal.calcTariffRate(newTariffRate1, tariffIncrease);
                        newTariffRate2 = cal.calcTariffRate(newTariffRate2, tariffIncrease);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithThreeTariffs(
                                newTariffRate1, tariffPercentage1, newTariffRate2,
                                tariffPercentage2, newTariffRate3, tariffPercentage3,
                                dailySolarUsedOver25Years[i], dailySolarExportedOver25Years[i],
                                feedinTariff);
                        newTariffRate1 = cal.calcTariffRate(newTariffRate1, tariffIncrease);
                        newTariffRate2 = cal.calcTariffRate(newTariffRate2, tariffIncrease);
                        newTariffRate3 = cal.calcTariffRate(newTariffRate3, tariffIncrease);
                    }
                    break;
                case 4:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithFourTariffs(
                                newTariffRate1, tariffPercentage1, newTariffRate2,
                                tariffPercentage2, newTariffRate3, tariffPercentage3,
                                newTariffRate4, tariffPercentage4, dailySolarUsedOver25Years[i],
                                dailySolarExportedOver25Years[i], feedinTariff);
                        newTariffRate1 = cal.calcTariffRate(newTariffRate1, tariffIncrease);
                        newTariffRate2 = cal.calcTariffRate(newTariffRate2, tariffIncrease);
                        newTariffRate3 = cal.calcTariffRate(newTariffRate3, tariffIncrease);
                        newTariffRate4 = cal.calcTariffRate(newTariffRate4, tariffIncrease);
                    }
                    break;
                case 5:
                    for (int i = 0; i < 25; i++) {
                        dailySavingsOver25Years[i] = cal.calcDailySavingsWithFiveTariffs(
                                newTariffRate1, tariffPercentage1, newTariffRate2,
                                tariffPercentage2, newTariffRate3, tariffPercentage3,
                                newTariffRate4, tariffPercentage4, newTariffRate5,
                                tariffPercentage5, dailySolarUsedOver25Years[i],
                                dailySolarExportedOver25Years[i], feedinTariff);
                        newTariffRate1 = cal.calcTariffRate(newTariffRate1, tariffIncrease);
                        newTariffRate2 = cal.calcTariffRate(newTariffRate2, tariffIncrease);
                        newTariffRate3 = cal.calcTariffRate(newTariffRate3, tariffIncrease);
                        newTariffRate4 = cal.calcTariffRate(newTariffRate4, tariffIncrease);
                        newTariffRate5 = cal.calcTariffRate(newTariffRate5, tariffIncrease);
                    }
                    break;
            }
            
            double cumulativeSavings = 0;
            
            // calculate annual/cumulative savings over 25 years
            for (int i = 0; i < 25; i++) {
                annualSavingsOver25Years[i] = dailySavingsOver25Years[i] * 365;
                cumulativeSavings += annualSavingsOver25Years[i];
                cumulativeSavingsOver25Years[i] = cumulativeSavings;
            }
            
            double totalCost = systemCost;
            
            if (costNeeded) {
                totalCost += replacementCost;
            }
            
            // calculate break even point
            breakEvenPoint = cal.calcBreakEvenPoint(totalCost, cumulativeSavingsOver25Years);
            
            double cumulativeInvestmentReturn = totalCost;
            
            // calculate cumulative investment return over 25 years
            for (int i = 0; i < 25; i++) {
                cumulativeInvestmentReturn += cumulativeInvestmentReturn * interestRate / 100;
                cumulativeInvestmentReturnOver25Years[i] = cumulativeInvestmentReturn;
            }
            
            // construct results string
            results = "<h2>Results</h2>"
                    + "<p><a id=\"toggleResults\">Click here</a> to toggle between simple and advanced results.</p>";
            
            // get simple results
            results += "<span id=\"simpleResults\">" + "<h3>Break even point</h3>";
            outputBreakEvenPoint();
            results += "<h3>Solar generation</h3>" + "<p>";
            outputDailySolar();
            results += "<br />";
            outputAnnualSolar();
            results += "</p>" + "<h3>Savings</h3>" + "<p>";
            outputDailySavings();
            results += "<br />";
            outputAnnualSavings();
            results += "<br />";
            outputCumulativeSavings();
            results += "</p>" + "<h3>Investment return</h3>";
            outputInvestmentReturn();
            results += "</span>";
            
            // get advanced results
            results += "<span id=\"advancedResults\">" + "<h3>Break even point</h3>";
            outputBreakEvenPoint();
            results += "<h3>Solar generation</h3>" + "<p>";
            outputDailySolar();
            results += "</p>";
            outputDailySolarTable();
            results += "<p>";
            outputAnnualSolar();
            results += "</p>";
            outputAnnualSolarTable();
            results += "<h3>Savings</h3>" + "<p>";
            outputDailySavings();
            results += "</p>";
            outputDailySavingsTable();
            results += "<p>";
            outputAnnualSavings();
            results += "</p>";
            outputAnnualSavingsTable();
            results += "<p>";
            outputCumulativeSavings();
            results += "</p>";
            outputCumulativeSavingsTable();
            results += "<h3>Investment return</h3>";
            outputInvestmentReturn();
            outputInvestmentReturnTable();
            results += "</span>";
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
    
    // add daily solar generation to output string
    public void outputDailySolar() {
        averageDailySolarGeneration = 0;
        for (int i = 0; i < 25; i++) {
            averageDailySolarGeneration += dailySolarGenerationOver25Years[i];
        }
        averageDailySolarGeneration = averageDailySolarGeneration / 25;
        results += "Average daily generation over 25 years: "
                + cal.calcRoundedDouble(averageDailySolarGeneration) + "kWh";
    }
    
    // add annual solar generation to output string
    public void outputAnnualSolar() {
        averageAnnualSolarGeneration = 0;
        for (int i = 0; i < 25; i++) {
            averageAnnualSolarGeneration += annualSolarGenerationOver25Years[i];
        }
        averageAnnualSolarGeneration = averageAnnualSolarGeneration / 25;
        results += "Average annual generation over 25 years: "
                + cal.calcRoundedDouble(averageAnnualSolarGeneration) + "kWh";
    }
    
    // add daily savings to output string
    public void outputDailySavings() {
        averageDailySavings = 0;
        for (int i = 0; i < 25; i++) {
            averageDailySavings += dailySavingsOver25Years[i];
        }
        averageDailySavings = averageDailySavings / 25;
        results += "Average daily savings over 25 years: $"
                + cal.calcRoundedDouble(averageDailySavings);
    }
    
    // add annual savings to output string
    public void outputAnnualSavings() {
        averageAnnualSavings = 0;
        for (int i = 0; i < 25; i++) {
            averageAnnualSavings += annualSavingsOver25Years[i];
        }
        averageAnnualSavings = averageAnnualSavings / 25;
        results += "Average annual savings over 25 years: $"
                + cal.calcRoundedDouble(averageAnnualSavings);
    }
    
    // add cumulative savings to output string
    public void outputCumulativeSavings() {
        results += "Cumulative savings after 25 years: $"
                + cal.calcRoundedDouble(cumulativeSavingsOver25Years[24]);
    }
    
    // add break even point to output string
    public void outputBreakEvenPoint() {
        if (breakEvenPoint == 99) {
            results += "<p>You won't break even after 25 years.</p>";
        } else {
            results += "<p>You will break even after " + breakEvenPoint;
            if (breakEvenPoint == 1) {
                results += " year.</p>";
            } else {
                results += " years.</p>";
            }
        }
    }
    
    // add investment return to output string
    public void outputInvestmentReturn() {
        if (interestRate > 0) {
            results += "<p>Equivalent investment return after 25 years (including system expenses): $"
                    + cal.calcRoundedDouble(cumulativeInvestmentReturnOver25Years[24]) + "</p>";
        } else {
            results += "<p>Enter a valid average annual interest rate for comparison to calculate the equivalent investment return after 25 years (including system expenses).</p>";
        }
    }
    
    // add daily solar generation table to output string
    public void outputDailySolarTable() {
        results += "<table><tr><td>Year</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Daily</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>" + cal.calcRoundedDouble(dailySolarGenerationOver25Years[i])
                    + "kWh</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Daily</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>" + cal.calcRoundedDouble(dailySolarGenerationOver25Years[i])
                    + "kWh</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Daily</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>" + cal.calcRoundedDouble(dailySolarGenerationOver25Years[i])
                    + "kWh</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Daily</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>" + cal.calcRoundedDouble(dailySolarGenerationOver25Years[i])
                    + "kWh</td>";
        }
        results += "</tr></table>";
    }
    
    // add annual solar generation table to output string
    public void outputAnnualSolarTable() {
        results += "<table><tr><td>Year</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Annual</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>" + cal.calcRoundedDouble(annualSolarGenerationOver25Years[i])
                    + "kWh</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Annual</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>" + cal.calcRoundedDouble(annualSolarGenerationOver25Years[i])
                    + "kWh</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Annual</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>" + cal.calcRoundedDouble(annualSolarGenerationOver25Years[i])
                    + "kWh</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Annual</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>" + cal.calcRoundedDouble(annualSolarGenerationOver25Years[i])
                    + "kWh</td>";
        }
        results += "</tr></table>";
    }
    
    // add daily savings table to output string
    public void outputDailySavingsTable() {
        results += "<table><tr><td>Year</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Daily</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>$" + cal.calcRoundedDouble(dailySavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Daily</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>$" + cal.calcRoundedDouble(dailySavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Daily</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>$" + cal.calcRoundedDouble(dailySavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Daily</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>$" + cal.calcRoundedDouble(dailySavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table>";
    }
    
    // add annual savings table to output string
    public void outputAnnualSavingsTable() {
        results += "<table><tr><td>Year</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Annual</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>$" + cal.calcRoundedDouble(annualSavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Annual</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>$" + cal.calcRoundedDouble(annualSavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Annual</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>$" + cal.calcRoundedDouble(annualSavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Annual</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>$" + cal.calcRoundedDouble(annualSavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table>";
    }
    
    // add cumulative savings table to output string
    public void outputCumulativeSavingsTable() {
        results += "<table><tr><td>Year</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Cumulative</td>";
        for (int i = 0; i < 7; i++) {
            results += "<td>$" + cal.calcRoundedDouble(cumulativeSavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Cumulative</td>";
        for (int i = 7; i < 14; i++) {
            results += "<td>$" + cal.calcRoundedDouble(cumulativeSavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Cumulative</td>";
        for (int i = 14; i < 21; i++) {
            results += "<td>$" + cal.calcRoundedDouble(cumulativeSavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table><table><tr><td>Year</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>" + (i + 1) + "</td>";
        }
        results += "</tr><tr><td>Cumulative</td>";
        for (int i = 21; i < 25; i++) {
            results += "<td>$" + cal.calcRoundedDouble(cumulativeSavingsOver25Years[i]) + "</td>";
        }
        results += "</tr></table>";
    }
    
    // add investment return table to output string
    public void outputInvestmentReturnTable() {
        if (interestRate > 0 && cumulativeInvestmentReturnOver25Years[0] > 0) {
            results += "<table><tr><td>Year</td>";
            for (int i = 0; i < 7; i++) {
                results += "<td>" + (i + 1) + "</td>";
            }
            results += "</tr><tr><td>Return</td>";
            for (int i = 0; i < 7; i++) {
                results += "<td>$"
                        + cal.calcRoundedDouble(cumulativeInvestmentReturnOver25Years[i]) + "</td>";
            }
            results += "</tr></table><table><tr><td>Year</td>";
            for (int i = 7; i < 14; i++) {
                results += "<td>" + (i + 1) + "</td>";
            }
            results += "</tr><tr><td>Return</td>";
            for (int i = 7; i < 14; i++) {
                results += "<td>$"
                        + cal.calcRoundedDouble(cumulativeInvestmentReturnOver25Years[i]) + "</td>";
            }
            results += "</tr></table><table><tr><td>Year</td>";
            for (int i = 14; i < 21; i++) {
                results += "<td>" + (i + 1) + "</td>";
            }
            results += "</tr><tr><td>Return</td>";
            for (int i = 14; i < 21; i++) {
                results += "<td>$"
                        + cal.calcRoundedDouble(cumulativeInvestmentReturnOver25Years[i]) + "</td>";
            }
            results += "</tr></table><table><tr><td>Year</td>";
            for (int i = 21; i < 25; i++) {
                results += "<td>" + (i + 1) + "</td>";
            }
            results += "</tr><tr><td>Return</td>";
            for (int i = 21; i < 25; i++) {
                results += "<td>$"
                        + cal.calcRoundedDouble(cumulativeInvestmentReturnOver25Years[i]) + "</td>";
            }
            results += "</tr></table>";
        }
    }
    
    // add system details to output string
    public void outputSystemDetails() {
        results += "<p>System location latitude: " + confirmedLocation + "<br />System cost: $"
                + systemCost + "<br />System size: " + systemSize + "kW<br /><br />Panel bank: "
                + numberOfPanels1 + " panels, " + panelOrientation1 + "&deg; orientation, "
                + panelTilt1 + "&deg; tilt";
        
        if (numPanelBanks > 1) {
            results += "<br />Panel bank: " + numberOfPanels2 + " panels, " + panelOrientation2
                    + "&deg; orientation, " + panelTilt2 + "&deg; tilt";
            if (numPanelBanks > 2) {
                results += "<br />Panel bank: " + numberOfPanels3 + " panels, " + panelOrientation3
                        + "&deg; orientation, " + panelTilt3 + "&deg; tilt";
                if (numPanelBanks > 3) {
                    results += "<br />Panel bank: " + numberOfPanels4 + " panels, "
                            + panelOrientation4 + "&deg; orientation, " + panelTilt4 + "&deg; tilt";
                    if (numPanelBanks > 4) {
                        results += "<br />Panel bank: " + numberOfPanels5 + " panels, "
                                + panelOrientation5 + "&deg; orientation, " + panelTilt5
                                + "&deg; tilt";
                    }
                }
            }
        }
        
        results += "<br />Average annual panel efficiency loss rate: " + panelEfficiencyLoss
                + "% p.a.<br /><br />Inverter efficiency: " + inverterEfficiency
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
            results += "<br />Tariff: " + tariffRate2 + "c/kWh, " + tariffPercentage2
                    + "% average percentage of power usage";
            if (numTariffs > 2) {
                results += "<br />Tariff: " + tariffRate3 + "c/kWh, " + tariffPercentage3
                        + "% average percentage of power usage";
                if (numTariffs > 3) {
                    results += "<br />Tariff: " + tariffRate4 + "c/kWh, " + tariffPercentage4
                            + "% average percentage of power usage";
                    if (numTariffs > 4) {
                        results += "<br />Tariff: " + tariffRate5 + "c/kWh, " + tariffPercentage5
                                + "% average percentage of power usage";
                    }
                }
            }
        }
        
        results += "<br />Average annual tariff rate increase: " + tariffIncrease
                + "% p.a.<br />Feed-in tariff rate: " + feedinTariff
                + "c/kWh<br /><br />Average annual interest rate for comparison: " + interestRate
                + "% p.a.</p>";
    }
}