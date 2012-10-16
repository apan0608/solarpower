package solarpower.servlets;

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
    
    // zero or more numbers followed by zero or one decimal point followed by one or more numbers
    public boolean isValidNumber(String value) {
        return value.matches("(\\d*)(\\.\\d+)?");
    }
    
    public boolean isInvalidNumberField(String value) {
        return isNullOrEmpty(value) || !isValidNumber(value);
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
    
    public boolean isInvalidPercentageField(String value) {
        return isInvalidNumberField(value) || isInvalidPercentage(value);
    }
    
    public boolean isYesValue(String value) {
        return value.equals("Yes");
    }
    
    public boolean isInvalidReplacementCost(String value, boolean costNeeded) {
        if (costNeeded) {
            return isInvalidNumberField(value);
        }
        return false;
    }
    
    public boolean isInvalidPowerUsage(String value, String value2) {
        double dailyPower = Double.parseDouble(value);
        double daytimePower = Double.parseDouble(value2);
        return dailyPower < daytimePower;
    }
    
    public boolean isInvalidTariff(String value, String value2) {
        return isInvalidNumberField(value) || isInvalidPercentageField(value2);
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
    
    // public Boolean isPositive(double n) {
    // return (n >= 0);
    // }
    //
    // public Boolean isValidPercentage(double p) {
    // return ((p >= 0) && (p <= 100));
    // }
    //
    // public Boolean isValidTime(double h) {
    // return ((h > 0) && (h <= 24));
    // }
    //
    // public void systemSize(double size) throws Exception {
    // if (!isPositive(size)) {
    // throw new Exception("System size must be positive");
    // }
    // }
    //
    // public void systemCost(double cost) throws Exception {
    // if (!isPositive(cost)) {
    // throw new Exception("System cost must be positive");
    // }
    // }
    //
    // public void northRoofDensity(double percent) throws Exception {
    // if (!isValidPercentage(percent)) {
    // throw new Exception("Percentage must be between 0 and 100");
    // }
    // }
    //
    // public void westRoofDensity(double percent) throws Exception {
    // if (!isValidPercentage(percent)) {
    // throw new Exception("Percentage must be between 0 and 100");
    // }
    // }
    //
    // public void northRoofEfficiencyLoss(double percent) throws Exception {
    // if (!isValidPercentage(percent)) {
    // throw new Exception("Percentage must be between 0 and 100");
    // }
    // }
    //
    // public void westRoofEfficiencyLoss(double percent) throws Exception {
    // if (!isValidPercentage(percent)) {
    // throw new Exception("Percentage must be between 0 and 100");
    // }
    // }
    //
    // public void panelAgeEfficiencyLoss(double percent) throws Exception {
    // if (!isValidPercentage(percent)) {
    // throw new Exception("Percentage must be between 0 and 100");
    // }
    // }
    //
    // public void inverterReplacementCost(double cost) throws Exception {
    // if (!isPositive(cost)) {
    // throw new Exception("Inverter replacement cost must be positive");
    // }
    // }
    //
    // public void sunlightDailyHours(double hours) throws Exception {
    // if (!isValidTime(hours)) {
    // throw new Exception("Average Daily Hours of Sunlight must be between 0 and 24");
    // }
    // }
    //
    // public void dailyAvgUsage(double usage) throws Exception {
    // if (!isPositive(usage)) {
    // throw new Exception("Daily Average Usage must be positive");
    // }
    // }
    //
    // public void dayTimeHourlyUsage(double usage) throws Exception {
    // if (!isPositive(usage)) {
    // throw new Exception("Day Time Hourly Usage must be positive");
    // }
    // }
    //
    // public void annualTariff11Cost(double cost) throws Exception {
    // if (!isPositive(cost)) {
    // throw new Exception("Annual Tariff 11 Cost must be positive");
    // }
    // }
    //
    // public void annualTariff33Cost(double cost) throws Exception {
    // if (!isPositive(cost)) {
    // throw new Exception("Annual Tariff 33 Cost must be positive");
    // }
    // }
    //
    // public void tariff11Fee(double fee) throws Exception {
    // if (!isPositive(fee)) {
    // throw new Exception("Tariff 11 Fee must be positive");
    // }
    // }
    //
    // public void tariff33Fee(double fee) throws Exception {
    // if (!isPositive(fee)) {
    // throw new Exception("Tariff 33 Fee must be positive");
    // }
    // }
    //
    // public void feedInFee(double fee) throws Exception {
    // if (!isPositive(fee)) {
    // throw new Exception("Feed in Fee must be positive");
    // }
    // }
    //
    // public void annualTariffIncrease(double percent) throws Exception {
    // if (!isPositive(percent)) {
    // throw new Exception("Annual Tariff Increase must be positive");
    // }
    // }
    //
    // public void investmentReturnRate(double rate) throws Exception {
    // if (!isPositive(rate)) {
    // throw new Exception("Investment Return Rate must be positive");
    // }
    // }
}