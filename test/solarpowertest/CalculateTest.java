package solarpowertest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import solarpower.entities.SolarCalculator;

public class CalculateTest {
    
    SolarCalculator calc;
    int years;
    double sysSize;
    double invEff;
    double sunHours;
    double panEff;
    double panEffDrop;
    double orient;
    double result;
    
    @Before
    public void SetUp() {
        calc = new SolarCalculator();
        
        //Default values
    	years = 25;
        sysSize = 5;
        invEff = .93;
        sunHours = 5;
        orient = 0;
        panEff = 1;
        panEffDrop = 0.0083;
    }
    
    @Test
    public void DailyGenNorth() {
        result = calc.calculateDailyGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(23.25, result, 0.001);
    }
    
    @Test
    public void DailyGenSouth() {
        orient = 180;
        result = calc.calculateDailyGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(15.34, result, 0.001);
    }
    @Test
    public void DailyGenEast(){
        orient = 90;
        result = calc.calculateDailyGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(19.30, result, 0.001);
    }
    @Test
    public void DailyGenWest(){
        orient = 270;
        result = calc.calculateDailyGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(19.30, result, 0.001);
    }
    @Test
    public void AnnualGenNorth(){
        result = calc.calculateAnnualGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(8486.25, result, 0.01);
    }
    @Test
    public void AnnualGenSouth() {
        orient = 180;
        result = calc.calculateAnnualGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(5600.92, result, 0.001);
    }
    @Test
    public void AnnualGenEast(){
        orient = 90;
        result = calc.calculateAnnualGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(7043.59, result, 0.001);
    }
    @Test
    public void AnnualGenWest(){
        orient = 270;
        result = calc.calculateAnnualGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(7043.59, result, 0.001);
    }
    
    @Test
    public void Year25GenNorth(){
    	
        result = calc.calculateGenerationRound(years, sysSize, invEff, sunHours, orient, panEffDrop);
        assertEquals(191025.49, result, 0.01);
    }
    @Test
    public void Year25GenSouth() {
        orient = 180;
        result = calc.calculateGenerationRound(years, sysSize, invEff, sunHours, orient, panEffDrop);
        assertEquals(126076.82, result, 0.001);
    }
    @Test
    public void Year25GenEast(){
        orient = 90;
        result = calc.calculateGenerationRound(years, sysSize, invEff, sunHours, orient, panEffDrop);
        assertEquals(158551.15, result, 0.001);
    }
    @Test
    public void Year25GenWest(){
        orient = 270;
        result = calc.calculateGenerationRound(years, sysSize, invEff, sunHours, orient, panEffDrop);
        assertEquals(158551.15, result, 0.001);
    }
}
