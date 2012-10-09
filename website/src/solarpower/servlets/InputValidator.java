package solarpower.servlets;

public class InputValidator {
    
    public Boolean isPositive(double n) {
        return (n >= 0);
    }
    
    public Boolean isValidPercentage(double p) {
        return ((p >= 0) && (p <= 100));
    }
    
    public Boolean isValidTime(double h) {
        return ((h > 0) && (h <= 24));
    }
    
    public void systemSize(double size) throws ValidationException {
        if (!isPositive(size)) {
            throw new ValidationException("System size must be positive");
        }
    }
    
    public void systemCost(double cost) throws ValidationException {
        if (!isPositive(cost)) {
            throw new ValidationException("System cost must be positive");
        }
    }
    
    public void northRoofDensity(double percent) throws ValidationException {
        if (!isValidPercentage(percent)) {
            throw new ValidationException("Percentage must be between 0 and 100");
        }
    }
    
    public void westRoofDensity(double percent) throws ValidationException {
        if (!isValidPercentage(percent)) {
            throw new ValidationException("Percentage must be between 0 and 100");
        }
    }
    
    public void northRoofEfficiencyLoss(double percent) throws ValidationException {
        if (!isValidPercentage(percent)) {
            throw new ValidationException("Percentage must be between 0 and 100");
        }
    }
    
    public void westRoofEfficiencyLoss(double percent) throws ValidationException {
        if (!isValidPercentage(percent)) {
            throw new ValidationException("Percentage must be between 0 and 100");
        }
    }
    
    public void panelAgeEfficiencyLoss(double percent) throws ValidationException {
        if (!isValidPercentage(percent)) {
            throw new ValidationException("Percentage must be between 0 and 100");
        }
    }
    
    public void inverterReplacementCost(double cost) throws ValidationException {
        if (!isPositive(cost)) {
            throw new ValidationException("Inverter replacement cost must be positive");
        }
    }
    
    public void sunlightDailyHours(double hours) throws ValidationException {
        if (!isValidTime(hours)) {
            throw new ValidationException(
                    "Average Daily Hours of Sunlight must be between 0 and 24");
        }
    }
    
    public void dailyAvgUsage(double usage) throws ValidationException {
        if (!isPositive(usage)) {
            throw new ValidationException("Daily Average Usage must be positive");
        }
    }
    
    public void dayTimeHourlyUsage(double usage) throws ValidationException {
        if (!isPositive(usage)) {
            throw new ValidationException("Day Time Hourly Usage must be positive");
        }
    }
    
    public void annualTariff11Cost(double cost) throws ValidationException {
        if (!isPositive(cost)) {
            throw new ValidationException("Annual Tariff 11 Cost must be positive");
        }
    }
    
    public void annualTariff33Cost(double cost) throws ValidationException {
        if (!isPositive(cost)) {
            throw new ValidationException("Annual Tariff 33 Cost must be positive");
        }
    }
    
    public void tariff11Fee(double fee) throws ValidationException {
        if (!isPositive(fee)) {
            throw new ValidationException("Tariff 11 Fee must be positive");
        }
    }
    
    public void tariff33Fee(double fee) throws ValidationException {
        if (!isPositive(fee)) {
            throw new ValidationException("Tariff 33 Fee must be positive");
        }
    }
    
    public void feedInFee(double fee) throws ValidationException {
        if (!isPositive(fee)) {
            throw new ValidationException("Feed in Fee must be positive");
        }
    }
    
    public void annualTariffIncrease(double percent) throws ValidationException {
        if (!isPositive(percent)) {
            throw new ValidationException("Annual Tariff Increase must be positive");
        }
    }
    
    public void investmentReturnRate(double rate) throws ValidationException {
        if (!isPositive(rate)) {
            throw new ValidationException("Investment Return Rate must be positive");
        }
    }
}