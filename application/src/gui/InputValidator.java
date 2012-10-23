package gui;

public class InputValidator {
    
//    public boolean isCustomSelection(String value) {
//        return value.equals("-2.0");
//    }
    
    public boolean isNull(String value) {
        boolean isNull = false;
        if (value == null) {
            isNull = true;
        }
        return isNull;
    }
    
    public boolean isEmpty(String value) {
        boolean isEmpty = false;
        if (value == "") {
            isEmpty = true;
        }
        return isEmpty;
    }
    
    public boolean isNullOrEmpty(String value) {
        boolean isNullOrEmpty = false;
        boolean isNull = isNull(value);
        boolean isEmpty = isEmpty(value);
        if ((isNull = true) || (isEmpty = true)) {
            isNullOrEmpty = true;
        }
        return isNullOrEmpty;
    }
    
//    public boolean isInvalidSelection(String value) {
//        return value.equals("-1.0");
//    }
//    
//    public boolean isInvalidDropdown(String value) {
//        return isNullOrEmpty(value) || isInvalidSelection(value);
//    }
//    
//    // zero or more numbers followed by zero or one decimal point followed by one or two numbers
//    public double isValidNumber(double value) {
//        return value;
//    }
//    
//    public boolean isInvalidNumberField(String value, boolean required) {
//        if (required) {
//            return isNullOrEmpty(value) || !isValidNumber(value);
//        } else {
//            if (isEmpty(value)) {
//                return false;
//            } else {
//                return !isValidNumber(value);
//            }
//        }
//    }
//    
    public boolean isGreaterThanZero(double value) {
        boolean isGreaterThanZero = false;
        if (value > 0) {
            isGreaterThanZero = true;
        }
        return isGreaterThanZero;
    }
    
    public boolean isLessThan360(double value) {
        boolean isLessThan360 = false;
        if (value < 360 ) {
            isLessThan360 = true;
        }
        return isLessThan360;
    }
    
    public boolean isLessThan24(double value) {
        boolean isLessThan24 = false;
        if (value < 24 ) {
            isLessThan24 = true;
        }
        return isLessThan24;
    }
    
    public boolean isValidSystemSize(double value) {
        boolean isValidSystemSize = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidSystemSize = true;
        }
        return isValidSystemSize;
    }
    
    public boolean isValidNoOfPanel(double value) {
        boolean isValidNoOfPanel = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidNoOfPanel = true;
        }
        return isValidNoOfPanel;
    }
    
    public boolean isValidPanOrientation(double value) {
        boolean isValidPanOrientation = false; 
        boolean isGreaterThanZero = isGreaterThanZero(value);
        boolean isLessThan24 = isLessThan24(value);
        if ((isGreaterThanZero = true) && (isLessThan24 = true)) {
            isValidPanOrientation = true;
        }
        return isValidPanOrientation;
    }
    
    public boolean isValidHoursOfSunlight(double value) {
        boolean isValidHoursOfSunlight = false; 
        boolean isGreaterThanZero = isGreaterThanZero(value);
        boolean isLessThan360 = isLessThan360(value);
        if ((isGreaterThanZero = true) && (isLessThan360 = true)) {
            isValidHoursOfSunlight = true;
        }
        return isValidHoursOfSunlight;
    }
    
    public boolean isValidSystemCost(double value) {
        boolean isValidSystemCost = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidSystemCost = true;
        }
        return isValidSystemCost;
    }
    
    public boolean isValidDailyPowerUsage(double value) {
        boolean isValidPowerUsage = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidPowerUsage = true;
        }
        return isValidPowerUsage;
    }
    
    public boolean isValidTariffRate(double value) {
        boolean isValidTariffRate = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidTariffRate = true;
        }
        return isValidTariffRate;
    }
    
    public boolean isValidInverterEfficiency(double value) {
        boolean isValidInverterEfficiency = false;
        boolean isValidPercentage = isValidPercentage(value);
        if (isValidPercentage = true) {
            isValidInverterEfficiency = true;
        }
        return isValidInverterEfficiency;
    }
    
    public boolean isValidPanelEfficiencyLossRate(double value) {
        boolean isValidPanelEfficiencyLossRate = false;
        boolean isValidPercentage = isValidPercentage(value);
        if (isValidPercentage = true) {
            isValidPanelEfficiencyLossRate = true;
        }
        return isValidPanelEfficiencyLossRate;
    }
    
    public boolean isValidPercentage(double value) {
        boolean isValidPercentage = false;
        if ((value >= 0) && (value <= 100)) {
            isValidPercentage = true;
        }        
        return isValidPercentage;
    }
    
    public boolean isValidInverterReplacementCost(double value) {
        boolean isValidInverterReplacementCost = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidInverterReplacementCost = true;
        }
        return isValidInverterReplacementCost;
    }
    
    public boolean isValidPercentagePowerUsage(double value) {
        boolean isValidPercentagePowerUsage = false;
        boolean isValidPercentage = isValidPercentage(value);
        if (isValidPercentage = true) {
            isValidPercentagePowerUsage = true;
        }
        return isValidPercentagePowerUsage;
    }
    
    public boolean isValidAdditionalFees(double value) {
        boolean isValidAdditionalFees = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidAdditionalFees = true;
        }
        return isValidAdditionalFees;
    }
    
    public boolean isValidTariffRateIncrease(double value) {
        boolean isValidTariffRateIncrease = false;
        boolean isValidPercentage = isValidPercentage(value);
        if (isValidPercentage = true) {
            isValidTariffRateIncrease = true;
        }
        return isValidTariffRateIncrease;
    }
    
    public boolean isValidFeedInTariffRate(double value) {
        boolean isValidFeedInTariffRate = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidFeedInTariffRate = true;
        }
        return isValidFeedInTariffRate;
    }
    
    public boolean isValidDaytimePowerUsage(double value) {
        boolean isValidDaytimePowerUsage = false;
        boolean isGreaterThanZero = isGreaterThanZero(value);
        if (isGreaterThanZero = true) {
            isValidDaytimePowerUsage = true;
        }
        return isValidDaytimePowerUsage;
    }
    
//    public boolean isInvalidPercentageField(String value, boolean required) {
//        if (required) {
//            return isInvalidNumberField(value, true) || isInvalidPercentage(value);
//        } else {
//            if (isEmpty(value)) {
//                return false;
//            } else {
//                return !isValidNumber(value) || isInvalidPercentage(value);
//            }
//        }
//    }  
//        
//    public boolean isYesValue(String value) {
//        return value.equals("Yes");
//    }
//    
//    public boolean isInvalidReplacementCost(String value, boolean costNeeded) {
//        if (costNeeded) {
//            return isInvalidNumberField(value, true);
//        }
//        return false;
//    }
//    
//    public boolean isInvalidPowerUsage(String value, String value2) {
//        double dailyPower = Double.parseDouble(value);
//        double daytimePower = Double.parseDouble(value2);
//        return dailyPower < daytimePower;
//    }
//    
////    public boolean isInvalidTariff(String value, String value2) {
////        return isInvalidNumberField(value, true) || isInvalidPercentageField(value2, true);
////    }
////    
//    public boolean isInvalidTariffPercentage(String value, String value2, String value3,
//            String value4, String value5, int numTariffs) {
//        double percentage = Double.parseDouble(value);
//        double percentage2 = Double.parseDouble(value2);
//        double percentage3 = Double.parseDouble(value3);
//        double percentage4 = Double.parseDouble(value4);
//        double percentage5 = Double.parseDouble(value5);
//        if (numTariffs == 1) {
//            return percentage != 100;
//        } else if (numTariffs == 2) {
//            return percentage + percentage2 != 100;
//        } else if (numTariffs == 3) {
//            return percentage + percentage2 + percentage3 != 100;
//        } else if (numTariffs == 4) {
//            return percentage + percentage2 + percentage3 + percentage4 != 100;
//        } else {
//            return percentage + percentage2 + percentage3 + percentage4 + percentage5 != 100;
//        }
//    }
}