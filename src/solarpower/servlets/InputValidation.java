package solarpower.servlets;

public class InputValidation {
	
	public void systemSize(double size) throws ValidationException
	{
		if(size<0)
		{
			throw new ValidationException ("System size must be positive");
		}
	}
	
	public void systemCost(double cost) throws ValidationException
	{
		if(cost<0)
		{
			throw new ValidationException ("System cost must be positive");
		}
	}
	
	public void northRoofDensity(double percent) throws ValidationException
	{
		if((percent<0)||(percent>100))
		{
			throw new ValidationException ("Percentage must be between 0 and 100");
		}
	}
	
	public void westRoofDensity(double percent) throws ValidationException
	{
		if((percent<0)||(percent>100))
		{
			throw new ValidationException ("Percentage must be between 0 and 100");
		}
	}
	
	public void northRoofEfficiencyLoss(double percent) throws ValidationException
	{
		if((percent<0)||(percent>100))
		{
			throw new ValidationException ("Percentage must be between 0 and 100");
		}
	}
	
	public void westRoofEfficiencyLoss(double percent) throws ValidationException
	{
		if((percent<0)||(percent>100))
		{
			throw new ValidationException ("Percentage must be between 0 and 100");
		}
	}
	
	public void panelAgeEfficiencyLoss(double percent) throws ValidationException
	{
		if((percent<0)||(percent>100))
		{
			throw new ValidationException ("Percentage must be between 0 and 100");
		}
	}
	
	public void inverterReplacementCost(double cost) throws ValidationException
	{
		if(cost<0)
		{
			throw new ValidationException ("Inverter replacement cost must be positive");
		}
	}
	
	public void sunlightDailyHours (double hours) throws ValidationException
	{
		if((hours<0)||(hours>24))
		{
			throw new ValidationException ("Average Daily Hours of Sunlight must be between 0 and 24");
		}
	}
	
	public void dailyAvgUsage(double usage) throws ValidationException
	{
		if(usage<0)
		{
			throw new ValidationException ("Daily Average Usage must be positive");
		}
	}
	
	public void dayTimeHourlyUsage(double usage) throws ValidationException
	{
		if(usage<0)
		{
			throw new ValidationException ("Day Time Hourly Usage must be positive");
		}
	}
	
	public void annualTariff11Cost(double cost) throws ValidationException
	{
		if(cost<0)
		{
			throw new ValidationException ("Annual Tariff 11 Cost must be positive");
		}
	}
	
	public void annualTariff33Cost(double cost) throws ValidationException
	{
		if(cost<0)
		{
			throw new ValidationException ("Annual Tariff 33 Cost must be positive");
		}
	}
	
	public void tariff11Fee(double fee) throws ValidationException
	{
		if(fee<0)
		{
			throw new ValidationException ("Tariff 11 Fee must be positive");
		}
	}
	
	public void tariff33Fee(double fee) throws ValidationException
	{
		if(fee<0)
		{
			throw new ValidationException ("Tariff 33 Fee must be positive");
		}
	}
	
	public void feedInFee(double fee) throws ValidationException
	{
		if(fee<0)
		{
			throw new ValidationException ("Feed in Fee must be positive");
		}
	}
	
	public void annualTariffIncrease(double percent) throws ValidationException
	{
		if(percent<0)
		{
			throw new ValidationException ("Annual Tariff Increase must be positive");
		}
	}
	
	public void investmentReturnRate(double rate) throws ValidationException
	{
		if(rate<0)
		{
			throw new ValidationException ("Investment Return Rate must be positive");
		}
	}
}
