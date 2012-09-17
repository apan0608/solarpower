package solarpower.entities;

public class SolarCalculator {

	public double calculateDailyGeneration(double sysSize, double invEff, double hoursSun, double Orientation){
    	//orientation is dodgy
    	double result = sysSize*invEff*hoursSun;
    	if(Orientation > 0 && Orientation < 90 || Orientation > 270 && Orientation < 360){//Between North and east
    		result*= .85;
    	}else if(Orientation >= 90 && Orientation <= 270){
    		result*=.8;
    	}
    	return result;
    }
}
