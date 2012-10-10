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
    
    String error = "<h2>Results</h2>No results were returned. ";
    String confirmedLocationError = error + "Please ensure you have selected a system location.";
    String systemCostError = error + "Please ensure you have entered a valid system cost.";
    String systemSizeError = error
            + "Please ensure you have selected or entered a valid system size.";
    String panelBankError = error
            + "Please ensure you have selected a number of panels, orientation and tilt for each panel bank.";
    String panelEfficiencyLossError = error
            + "Please ensure you have entered a valid average annual panel efficiency loss rate.";
    String inverterEfficiencyError = error
            + "Please ensure you have entered a valid inverter efficiency.";
    String replacementInverterError = error
            + "Please ensure you have specified whether or not you want a replacement inverter.";
    String replacementCostError = error
            + "Please ensure you have entered a valid replacement inverter cost.";
    String hoursOfSunlightError = error
            + "Please ensure you have selected an average daily hours of sunlight.";
    String dailyPowerUsageError = error
            + "Please ensure you have entered a valid average daily power usage.";
    String daytimePowerUsageError = error
            + "Please ensure you have entered a valid average daytime power usage.";
    String tariffError = error
            + "Please ensure you have entered a valid tariff rate and average percentage of power usage for each tariff.";
    String tariffPercentageError = error
            + "Please ensure the sum of the average percentages of power usage for each tariff equals 100%.";
    String tariffIncreaseError = error
            + "Please ensure you have entered a valid average annual tariff rate increase.";
    String feedinTariffError = error
            + "Please ensure you have entered a valid feed-in tariff rate.";
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
            
            //calculations done here, still need lots of work
            //-----------------------------------------------
            double dailySolarGeneration = cal.calculateDailyGeneration(systemSize,
                    inverterEfficiency / 100, hoursOfSunlight, panelOrientation1, 1);
            
            double annualSolarGeneration = cal.calculateAnnualGeneration(systemSize,
                    inverterEfficiency / 100, hoursOfSunlight, panelOrientation1, 1);
            
            double dailySolarUsed = cal.calcDailySolarUsed(daytimePowerUsage, hoursOfSunlight);
            
            double dailySolarExported = cal.calcDailySolarExported(dailySolarGeneration,
                    dailySolarUsed);
            
            double dailySavings = cal.calcDailySavings(dailySolarUsed, tariffRate1,
                    dailySolarExported, feedinTariff);
            
            double annualSavings = cal.calcAnnualSavings(dailySavings);
            
            double cumulativeSavings = cal.calcCumulativeSavings(annualSavings);
            
            double breakEvenPoint = cal.calcBreakEvenPoint(systemCost, annualSavings);
            
            double investmentReturn = cal.calcInvestmentReturn(systemCost);
            
            //results string constructed here, still needs work
            //-------------------------------------------------
            results = "<h2>Results</h2>System location latitude: " + confirmedLocation
                    + "<br />System cost: " + systemCost + "<br />System size: " + systemSize
                    + "<br />Average annual panel efficiency loss rate: " + panelEfficiencyLoss
                    + "<br />Inverter efficiency: " + inverterEfficiency
                    + "<br />Replacement inverter: " + replacementInverter;
            
            if (costNeeded) {
                results += "<br />Replacement inverter cost: " + replacementCost;
            }
            
            results += "<br />Average daily hours of sunlight: "
                    + hoursOfSunlight
                    + "<br />Average daily power usage: "
                    + dailyPowerUsage
                    + "<br />Average daytime power usage: "
                    + daytimePowerUsage
                    + "<br />Average annual tariff rate increase: "
                    + tariffIncrease
                    + "<br />Feed-in tariff rate: "
                    + feedinTariff
                    + "<br /><br />Daily power generation of the system: "
                    + dailySolarGeneration
                    + "kWh<br />"
                    + "Annual power generation of the system: "
                    + annualSolarGeneration
                    + "kWh<br />"
                    + "Daily solar used: "
                    + dailySolarUsed
                    + "kWh<br />"
                    + "Daily solar exported: "
                    + dailySolarExported
                    + "kWh<br />"
                    + "Daily savings: $"
                    + dailySavings
                    + "<br />"
                    + "Annual savings: $"
                    + annualSavings
                    + "<br />"
                    + "Cumulative savings: $"
                    + cumulativeSavings
                    + "<br />"
                    + "You will break even after: "
                    + breakEvenPoint
                    + " years<br />"
                    + "The equivalent investment return after 25 years would be: $"
                    + investmentReturn
                    + "<br />"
                    + "----------------------------------------------------------------------------\n\n";
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