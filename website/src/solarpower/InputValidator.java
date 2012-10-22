package solarpower;

public class InputValidator {
    
    public boolean isCustomSelection(String value) {
        return value.equals("-2.0");
    }
    
    public boolean isNull(String value) {
        return value == null;
    }
    
    public boolean isEmpty(String value) {
        return value == "";
    }
    
    public boolean isNullOrEmpty(String value) {
        return isNull(value) || isEmpty(value);
    }
    
    public boolean isInvalidSelection(String value) {
        return value.equals("-1.0");
    }
    
    public boolean isInvalidDropdown(String value) {
        return isNullOrEmpty(value) || isInvalidSelection(value);
    }
    
    // zero or more numbers followed by zero or one decimal point followed by one or two numbers
    public boolean isValidNumber(String value) {
        return value.matches("(\\d*)(\\.\\d{1,2})?");
    }
    
    public boolean isInvalidNumberField(String value, boolean required) {
        if (required) {
            return isNullOrEmpty(value) || !isValidNumber(value);
        } else {
            if (isEmpty(value)) {
                return false;
            } else {
                return !isValidNumber(value);
            }
        }
    }
    
    public boolean isGreaterThanZero(String value) {
        double number = Double.parseDouble(value);
        return number > 0;
    }
    
    public boolean isInvalidSystemSize(String value) {
        return isInvalidDropdown(value) || !isValidNumber(value) || !isGreaterThanZero(value);
    }
    
    public boolean isInvalidPanelBank(String value, String value2, String value3) {
        return isInvalidDropdown(value) || isInvalidDropdown(value2) || isInvalidDropdown(value3);
    }
    
    public boolean isInvalidPercentage(String value) {
        double percentage = Double.parseDouble(value);
        return percentage < 0 || percentage > 100;
    }
    
    public boolean isInvalidPercentageField(String value, boolean required) {
        if (required) {
            return isInvalidNumberField(value, true) || isInvalidPercentage(value);
        } else {
            if (isEmpty(value)) {
                return false;
            } else {
                return !isValidNumber(value) || isInvalidPercentage(value);
            }
        }
    }
    
    public boolean isYesValue(String value) {
        return value.equals("Yes");
    }
    
    public boolean isInvalidReplacementCost(String value, boolean costNeeded) {
        if (costNeeded) {
            return isInvalidNumberField(value, true);
        }
        return false;
    }
    
    public boolean isInvalidPowerUsage(String value, String value2) {
        double dailyPower = Double.parseDouble(value);
        double daytimePower = Double.parseDouble(value2);
        return dailyPower < daytimePower;
    }
    
    public boolean isInvalidTariff(String value, String value2) {
        return isInvalidNumberField(value, true) || isInvalidPercentageField(value2, true);
    }
    
    public boolean isInvalidTariffPercentage(String value, String value2, String value3,
            String value4, String value5, int numTariffs) {
        double percentage = Double.parseDouble(value);
        double percentage2 = Double.parseDouble(value2);
        double percentage3 = Double.parseDouble(value3);
        double percentage4 = Double.parseDouble(value4);
        double percentage5 = Double.parseDouble(value5);
        if (numTariffs == 1) {
            return percentage != 100;
        } else if (numTariffs == 2) {
            return percentage + percentage2 != 100;
        } else if (numTariffs == 3) {
            return percentage + percentage2 + percentage3 != 100;
        } else if (numTariffs == 4) {
            return percentage + percentage2 + percentage3 + percentage4 != 100;
        } else {
            return percentage + percentage2 + percentage3 + percentage4 + percentage5 != 100;
        }
    }
}