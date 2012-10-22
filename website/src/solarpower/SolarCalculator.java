package solarpower;

import java.text.DecimalFormat;

public class SolarCalculator {
    
    private double MISC_EFFICIENCY = 0.55;
    
    public double calcBlankField(String value) {
        if (value == "") {
            return 0;
        } else {
            return Double.parseDouble(value);
        }
    }
    
    public double calcPanelOrientationEfficiency(double confirmedLocation, double panelOrientation) {
        if (confirmedLocation < 0) {
            if (panelOrientation == 0.0) {
                return 1;
            } else if (panelOrientation == 22.5 || panelOrientation == 337.5) {
                return 0.95;
            } else if (panelOrientation == 45.0 || panelOrientation == 315.0) {
                return 0.90;
            } else if (panelOrientation == 67.5 || panelOrientation == 292.5) {
                return 0.85;
            } else if (panelOrientation == 90.0 || panelOrientation == 270.0) {
                return 0.80;
            } else if (panelOrientation == 112.5 || panelOrientation == 247.5) {
                return 0.75;
            } else if (panelOrientation == 135.0 || panelOrientation == 225.0) {
                return 0.70;
            } else if (panelOrientation == 157.5 || panelOrientation == 202.5) {
                return 0.65;
            } else {
                return 0.60;
            }
        } else if (confirmedLocation > 0) {
            if (panelOrientation == 180.0) {
                return 1;
            } else if (panelOrientation == 157.5 || panelOrientation == 202.5) {
                return 0.95;
            } else if (panelOrientation == 135.0 || panelOrientation == 225.0) {
                return 0.90;
            } else if (panelOrientation == 112.5 || panelOrientation == 247.5) {
                return 0.85;
            } else if (panelOrientation == 90.0 || panelOrientation == 270.0) {
                return 0.80;
            } else if (panelOrientation == 67.5 || panelOrientation == 292.5) {
                return 0.75;
            } else if (panelOrientation == 45.0 || panelOrientation == 315.0) {
                return 0.70;
            } else if (panelOrientation == 22.5 || panelOrientation == 337.5) {
                return 0.65;
            } else {
                return 0.60;
            }
        } else {
            if (panelOrientation == 0.0 || panelOrientation == 180.0) {
                return 1;
            } else if (panelOrientation == 22.5 || panelOrientation == 337.5
                    || panelOrientation == 157.5 || panelOrientation == 202.5) {
                return 0.95;
            } else if (panelOrientation == 45.0 || panelOrientation == 315.0
                    || panelOrientation == 135.0 || panelOrientation == 225.0) {
                return 0.90;
            } else if (panelOrientation == 67.5 || panelOrientation == 292.5
                    || panelOrientation == 112.5 || panelOrientation == 247.5) {
                return 0.85;
            } else {
                return 0.80;
            }
        }
    }
    
    public double calcPanelTiltEfficiency(double confirmedLocation, double panelTilt) {
        double newLocation = confirmedLocation;
        if (newLocation < 0) {
            newLocation = newLocation * -1;
        }
        if (panelTilt >= newLocation - 15 && panelTilt <= newLocation + 15) {
            return 1;
        } else if (panelTilt >= newLocation - 30 && panelTilt <= newLocation + 30) {
            return 0.90;
        } else if (panelTilt >= newLocation - 90 && panelTilt <= newLocation + 45) {
            return 0.80;
        } else if (panelTilt <= newLocation + 60) {
            return 0.70;
        } else {
            return 0.60;
        }
    }
    
    public double calcDailySolarGenerationWithOnePanelBank(double panelOrientation1,
            double panelTilt1, double confirmedLocation, double systemSize,
            double inverterEfficiency, double hoursOfSunlight) {
        double orientationEfficiency1 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation1);
        double tiltEfficiency1 = calcPanelTiltEfficiency(confirmedLocation, panelTilt1);
        return orientationEfficiency1 * tiltEfficiency1 * systemSize * (inverterEfficiency / 100)
                * hoursOfSunlight * MISC_EFFICIENCY;
    }
    
    public double calcDailySolarGenerationWithTwoPanelBanks(double numberOfPanels1,
            double panelOrientation1, double panelTilt1, double numberOfPanels2,
            double panelOrientation2, double panelTilt2, double confirmedLocation,
            double systemSize, double inverterEfficiency, double hoursOfSunlight) {
        double percentageOfPanels1 = numberOfPanels1 / (numberOfPanels1 + numberOfPanels2);
        double orientationEfficiency1 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation1);
        double tiltEfficiency1 = calcPanelTiltEfficiency(confirmedLocation, panelTilt1);
        double percentageOfPanels2 = numberOfPanels2 / (numberOfPanels1 + numberOfPanels2);
        double orientationEfficiency2 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation2);
        double tiltEfficiency2 = calcPanelTiltEfficiency(confirmedLocation, panelTilt2);
        double solarGeneration1 = percentageOfPanels1 * orientationEfficiency1 * tiltEfficiency1
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration2 = percentageOfPanels2 * orientationEfficiency2 * tiltEfficiency2
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        return solarGeneration1 + solarGeneration2;
    }
    
    public double calcDailySolarGenerationWithThreePanelBanks(double numberOfPanels1,
            double panelOrientation1, double panelTilt1, double numberOfPanels2,
            double panelOrientation2, double panelTilt2, double numberOfPanels3,
            double panelOrientation3, double panelTilt3, double confirmedLocation,
            double systemSize, double inverterEfficiency, double hoursOfSunlight) {
        double percentageOfPanels1 = numberOfPanels1
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3);
        double orientationEfficiency1 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation1);
        double tiltEfficiency1 = calcPanelTiltEfficiency(confirmedLocation, panelTilt1);
        double percentageOfPanels2 = numberOfPanels2
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3);
        double orientationEfficiency2 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation2);
        double tiltEfficiency2 = calcPanelTiltEfficiency(confirmedLocation, panelTilt2);
        double percentageOfPanels3 = numberOfPanels3
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3);
        double orientationEfficiency3 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation3);
        double tiltEfficiency3 = calcPanelTiltEfficiency(confirmedLocation, panelTilt3);
        double solarGeneration1 = percentageOfPanels1 * orientationEfficiency1 * tiltEfficiency1
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration2 = percentageOfPanels2 * orientationEfficiency2 * tiltEfficiency2
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration3 = percentageOfPanels3 * orientationEfficiency3 * tiltEfficiency3
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        return solarGeneration1 + solarGeneration2 + solarGeneration3;
    }
    
    public double calcDailySolarGenerationWithFourPanelBanks(double numberOfPanels1,
            double panelOrientation1, double panelTilt1, double numberOfPanels2,
            double panelOrientation2, double panelTilt2, double numberOfPanels3,
            double panelOrientation3, double panelTilt3, double numberOfPanels4,
            double panelOrientation4, double panelTilt4, double confirmedLocation,
            double systemSize, double inverterEfficiency, double hoursOfSunlight) {
        double percentageOfPanels1 = numberOfPanels1
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4);
        double orientationEfficiency1 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation1);
        double tiltEfficiency1 = calcPanelTiltEfficiency(confirmedLocation, panelTilt1);
        double percentageOfPanels2 = numberOfPanels2
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4);
        double orientationEfficiency2 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation2);
        double tiltEfficiency2 = calcPanelTiltEfficiency(confirmedLocation, panelTilt2);
        double percentageOfPanels3 = numberOfPanels3
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4);
        double orientationEfficiency3 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation3);
        double tiltEfficiency3 = calcPanelTiltEfficiency(confirmedLocation, panelTilt3);
        double percentageOfPanels4 = numberOfPanels4
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4);
        double orientationEfficiency4 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation4);
        double tiltEfficiency4 = calcPanelTiltEfficiency(confirmedLocation, panelTilt4);
        double solarGeneration1 = percentageOfPanels1 * orientationEfficiency1 * tiltEfficiency1
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration2 = percentageOfPanels2 * orientationEfficiency2 * tiltEfficiency2
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration3 = percentageOfPanels3 * orientationEfficiency3 * tiltEfficiency3
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration4 = percentageOfPanels4 * orientationEfficiency4 * tiltEfficiency4
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        return solarGeneration1 + solarGeneration2 + solarGeneration3 + solarGeneration4;
    }
    
    public double calcDailySolarGenerationWithFivePanelBanks(double numberOfPanels1,
            double panelOrientation1, double panelTilt1, double numberOfPanels2,
            double panelOrientation2, double panelTilt2, double numberOfPanels3,
            double panelOrientation3, double panelTilt3, double numberOfPanels4,
            double panelOrientation4, double panelTilt4, double numberOfPanels5,
            double panelOrientation5, double panelTilt5, double confirmedLocation,
            double systemSize, double inverterEfficiency, double hoursOfSunlight) {
        double percentageOfPanels1 = numberOfPanels1
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4 + numberOfPanels5);
        double orientationEfficiency1 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation1);
        double tiltEfficiency1 = calcPanelTiltEfficiency(confirmedLocation, panelTilt1);
        double percentageOfPanels2 = numberOfPanels2
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4 + numberOfPanels5);
        double orientationEfficiency2 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation2);
        double tiltEfficiency2 = calcPanelTiltEfficiency(confirmedLocation, panelTilt2);
        double percentageOfPanels3 = numberOfPanels3
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4 + numberOfPanels5);
        double orientationEfficiency3 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation3);
        double tiltEfficiency3 = calcPanelTiltEfficiency(confirmedLocation, panelTilt3);
        double percentageOfPanels4 = numberOfPanels4
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4 + numberOfPanels5);
        double orientationEfficiency4 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation4);
        double tiltEfficiency4 = calcPanelTiltEfficiency(confirmedLocation, panelTilt4);
        double percentageOfPanels5 = numberOfPanels5
                / (numberOfPanels1 + numberOfPanels2 + numberOfPanels3 + numberOfPanels4 + numberOfPanels5);
        double orientationEfficiency5 = calcPanelOrientationEfficiency(confirmedLocation,
                panelOrientation5);
        double tiltEfficiency5 = calcPanelTiltEfficiency(confirmedLocation, panelTilt5);
        double solarGeneration1 = percentageOfPanels1 * orientationEfficiency1 * tiltEfficiency1
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration2 = percentageOfPanels2 * orientationEfficiency2 * tiltEfficiency2
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration3 = percentageOfPanels3 * orientationEfficiency3 * tiltEfficiency3
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration4 = percentageOfPanels4 * orientationEfficiency4 * tiltEfficiency4
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        double solarGeneration5 = percentageOfPanels5 * orientationEfficiency5 * tiltEfficiency5
                * systemSize * (inverterEfficiency / 100) * hoursOfSunlight * MISC_EFFICIENCY;
        return solarGeneration1 + solarGeneration2 + solarGeneration3 + solarGeneration4
                + solarGeneration5;
    }
    
    public String calcRoundedDouble(double value) {
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);
    }
    
    public double calcDailySolarUsed(double daytimePowerUsage, double dailySolarGeneration) {
        if (daytimePowerUsage < dailySolarGeneration) {
            return daytimePowerUsage;
        } else {
            return dailySolarGeneration;
        }
    }
    
    public double calcDailySolarExported(double dailySolarGeneration, double dailySolarUsed) {
        if (dailySolarGeneration <= 0 || dailySolarGeneration - dailySolarUsed <= 0) {
            return 0;
        } else {
            return dailySolarGeneration - dailySolarUsed;
        }
    }
    
    public double calcDailySavingsWithOneTariff(double tariffRate1, double dailySolarUsed,
            double dailySolarExported, double feedinTariff) {
        double tariffSavings = dailySolarUsed * (tariffRate1 / 100);
        double feedinRevenue = dailySolarExported * (feedinTariff / 100);
        return tariffSavings + feedinRevenue;
    }
    
    public double calcDailySavingsWithTwoTariffs(double tariffRate1, double tariffPercentage1,
            double tariffRate2, double tariffPercentage2, double dailySolarUsed,
            double dailySolarExported, double feedinTariff) {
        double tariff1Savings = dailySolarUsed * (tariffPercentage1 / 100) * (tariffRate1 / 100);
        double tariff2Savings = dailySolarUsed * (tariffPercentage2 / 100) * (tariffRate2 / 100);
        double feedinRevenue = dailySolarExported * (feedinTariff / 100);
        return tariff1Savings + tariff2Savings + feedinRevenue;
    }
    
    public double calcDailySavingsWithThreeTariffs(double tariffRate1, double tariffPercentage1,
            double tariffRate2, double tariffPercentage2, double tariffRate3,
            double tariffPercentage3, double dailySolarUsed, double dailySolarExported,
            double feedinTariff) {
        double tariff1Savings = dailySolarUsed * (tariffPercentage1 / 100) * (tariffRate1 / 100);
        double tariff2Savings = dailySolarUsed * (tariffPercentage2 / 100) * (tariffRate2 / 100);
        double tariff3Savings = dailySolarUsed * (tariffPercentage3 / 100) * (tariffRate3 / 100);
        double feedinRevenue = dailySolarExported * (feedinTariff / 100);
        return tariff1Savings + tariff2Savings + tariff3Savings + feedinRevenue;
    }
    
    public double calcDailySavingsWithFourTariffs(double tariffRate1, double tariffPercentage1,
            double tariffRate2, double tariffPercentage2, double tariffRate3,
            double tariffPercentage3, double tariffRate4, double tariffPercentage4,
            double dailySolarUsed, double dailySolarExported, double feedinTariff) {
        double tariff1Savings = dailySolarUsed * (tariffPercentage1 / 100) * (tariffRate1 / 100);
        double tariff2Savings = dailySolarUsed * (tariffPercentage2 / 100) * (tariffRate2 / 100);
        double tariff3Savings = dailySolarUsed * (tariffPercentage3 / 100) * (tariffRate3 / 100);
        double tariff4Savings = dailySolarUsed * (tariffPercentage4 / 100) * (tariffRate4 / 100);
        double feedinRevenue = dailySolarExported * (feedinTariff / 100);
        return tariff1Savings + tariff2Savings + tariff3Savings + tariff4Savings + feedinRevenue;
    }
    
    public double calcDailySavingsWithFiveTariffs(double tariffRate1, double tariffPercentage1,
            double tariffRate2, double tariffPercentage2, double tariffRate3,
            double tariffPercentage3, double tariffRate4, double tariffPercentage4,
            double tariffRate5, double tariffPercentage5, double dailySolarUsed,
            double dailySolarExported, double feedinTariff) {
        double tariff1Savings = dailySolarUsed * (tariffPercentage1 / 100) * (tariffRate1 / 100);
        double tariff2Savings = dailySolarUsed * (tariffPercentage2 / 100) * (tariffRate2 / 100);
        double tariff3Savings = dailySolarUsed * (tariffPercentage3 / 100) * (tariffRate3 / 100);
        double tariff4Savings = dailySolarUsed * (tariffPercentage4 / 100) * (tariffRate4 / 100);
        double tariff5Savings = dailySolarUsed * (tariffPercentage5 / 100) * (tariffRate5 / 100);
        double feedinRevenue = dailySolarExported * (feedinTariff / 100);
        return tariff1Savings + tariff2Savings + tariff3Savings + tariff4Savings + tariff5Savings
                + feedinRevenue;
    }
    
    public double calcTariffRate(double tariffRate, double tariffIncrease) {
        return tariffRate + tariffRate / 100 * tariffIncrease;
    }
    
    public int calcBreakEvenPoint(double totalCost, double[] cumulativeSavingsOver25Years) {
        for (int i = 0; i < cumulativeSavingsOver25Years.length; i++) {
            if (totalCost <= cumulativeSavingsOver25Years[i]) {
                return i + 1;
            }
        }
        return 99;
    }
}