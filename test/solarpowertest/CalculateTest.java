package solarpowertest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import solarpower.entities.SolarCalculator;

public class CalculateTest {
	
	SolarCalculator calc;
	double sysSize;
	double invEff;
	double sunHours;
	double panEff;
	double orient;
	double result;
	
	@Before
	public void SetUp(){
		calc = new SolarCalculator();
	}
	
	
	@Test
	public void DailyGenNormal(){
		sysSize = 5;
		invEff = .93;
		sunHours = 5;
		panEff = 1;
		orient = 0;
		result = calc.calculateDailyGeneration(sysSize, invEff, sunHours, orient);
		assertEquals(23.25, result, 0.01);
	}
	
	@Test
	public void DailyGenOrient(){
		sysSize = 5;
		invEff = .93;
		sunHours = 5;
		panEff = 1;
		orient = 50;
		result = calc.calculateDailyGeneration(sysSize, invEff, sunHours, orient);
		assertEquals(19.7625, result, 0.01);
	}

}
