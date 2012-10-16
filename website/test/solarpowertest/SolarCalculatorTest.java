package solarpowertest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import solarpower.entities.SolarCalculator;

public class SolarCalculatorTest {
    
    SolarCalculator cal;
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
        cal = new SolarCalculator();
        
        // Default values
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
        result = cal.calculateDailyGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(23.25, result, 0.001);
    }
    
    @Test
    public void DailyGenSouth() {
        orient = 180;
        result = cal.calculateDailyGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(15.34, result, 0.001);
    }
    
    @Test
    public void DailyGenEast() {
        orient = 90;
        result = cal.calculateDailyGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(19.30, result, 0.001);
    }
    
    @Test
    public void DailyGenWest() {
        orient = 270;
        result = cal.calculateDailyGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(19.30, result, 0.001);
    }
    
    @Test
    public void AnnualGenNorth() {
        result = cal.calculateAnnualGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(8486.25, result, 0.01);
    }
    
    @Test
    public void AnnualGenSouth() {
        orient = 180;
        result = cal.calculateAnnualGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(5600.92, result, 0.001);
    }
    
    @Test
    public void AnnualGenEast() {
        orient = 90;
        result = cal.calculateAnnualGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(7043.59, result, 0.001);
    }
    
    @Test
    public void AnnualGenWest() {
        orient = 270;
        result = cal.calculateAnnualGenerationRound(sysSize, invEff, sunHours, orient, panEff);
        assertEquals(7043.59, result, 0.001);
    }
    
    @Test
    public void Year25GenNorth() {
        
        result = cal.calculateGenerationRound(years, sysSize, invEff, sunHours, orient, panEffDrop);
        assertEquals(191025.49, result, 0.01);
    }
    
    @Test
    public void Year25GenSouth() {
        orient = 180;
        result = cal.calculateGenerationRound(years, sysSize, invEff, sunHours, orient, panEffDrop);
        assertEquals(126076.82, result, 0.001);
    }
    
    @Test
    public void Year25GenEast() {
        orient = 90;
        result = cal.calculateGenerationRound(years, sysSize, invEff, sunHours, orient, panEffDrop);
        assertEquals(158551.15, result, 0.001);
    }
    
    @Test
    public void Year25GenWest() {
        orient = 270;
        result = cal.calculateGenerationRound(years, sysSize, invEff, sunHours, orient, panEffDrop);
        assertEquals(158551.15, result, 0.001);
    }
    
    // ////
    
    @Test
    public void calcPanelOrientationEfficiency() {
        assertEquals(100, cal.calcPanelOrientationEfficiency(0, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency() {
        assertEquals(100, cal.calcPanelTiltEfficiency(0, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency2() {
        assertEquals(100, cal.calcPanelTiltEfficiency(0, 15), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency3() {
        assertEquals(90, cal.calcPanelTiltEfficiency(0, 16), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency4() {
        assertEquals(90, cal.calcPanelTiltEfficiency(0, 30), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency5() {
        assertEquals(80, cal.calcPanelTiltEfficiency(0, 31), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency6() {
        assertEquals(80, cal.calcPanelTiltEfficiency(0, 45), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency7() {
        assertEquals(70, cal.calcPanelTiltEfficiency(0, 46), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency8() {
        assertEquals(70, cal.calcPanelTiltEfficiency(0, 60), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency9() {
        assertEquals(60, cal.calcPanelTiltEfficiency(0, 61), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency10() {
        assertEquals(60, cal.calcPanelTiltEfficiency(0, 90), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency11() {
        assertEquals(100, cal.calcPanelTiltEfficiency(-15, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency12() {
        assertEquals(90, cal.calcPanelTiltEfficiency(-16, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency13() {
        assertEquals(90, cal.calcPanelTiltEfficiency(-30, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency14() {
        assertEquals(80, cal.calcPanelTiltEfficiency(-31, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency15() {
        assertEquals(80, cal.calcPanelTiltEfficiency(-45, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency16() {
        assertEquals(70, cal.calcPanelTiltEfficiency(-46, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency17() {
        assertEquals(70, cal.calcPanelTiltEfficiency(-60, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency18() {
        assertEquals(60, cal.calcPanelTiltEfficiency(-61, 0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency19() {
        assertEquals(60, cal.calcPanelTiltEfficiency(-90, 0), 0);
    }
    
    @Test
    public void calcDailySolarUsed() {
        assertEquals(0, cal.calcDailySolarUsed(0, 0), 0);
    }
    
    @Test
    public void calcDailySolarUsed2() {
        assertEquals(0, cal.calcDailySolarUsed(1, 0), 0);
    }
    
    @Test
    public void calcDailySolarUsed3() {
        assertEquals(1, cal.calcDailySolarUsed(1, 2), 0);
    }
    
    @Test
    public void calcDailySolarUsed4() {
        assertEquals(0, cal.calcDailySolarUsed(0.00001, 0), 0);
    }
    
    @Test
    public void calcDailySolarUsed5() {
        assertEquals(1, cal.calcDailySolarUsed(1, 1.00001), 0);
    }
    
    @Test
    public void calcDailySolarExported() {
        assertEquals(0, cal.calcDailySolarExported(0, 1), 0);
    }
    
    @Test
    public void calcDailySolarExported2() {
        assertEquals(0, cal.calcDailySolarExported(-0.00001, 1), 0);
    }
    
    @Test
    public void calcDailySolarExported3() {
        assertEquals(0, cal.calcDailySolarExported(1, 1), 0);
    }
    
    @Test
    public void calcDailySolarExported4() {
        assertEquals(0, cal.calcDailySolarExported(1.00001, 1.00001), 0);
    }
    
    @Test
    public void calcDailySolarExported5() {
        assertEquals(1, cal.calcDailySolarExported(1, 0), 0);
    }
    
    @Test
    public void calcDailySolarExported6() {
        assertEquals(0.00001, cal.calcDailySolarExported(0.00001, 0), 0);
    }
    
    @Test
    public void calcDailySavingsWithOneTariff() {
        assertEquals(0, cal.calcDailySavingsWithOneTariff(0, 0, 0, 0), 0);
    }
    
    @Test
    public void calcDailySavingsWithOneTariff2() {
        assertEquals(10, cal.calcDailySavingsWithOneTariff(50, 20, 0, 0), 0);
    }
    
    @Test
    public void calcDailySavingsWithOneTariff3() {
        assertEquals(0.5, cal.calcDailySavingsWithOneTariff(0, 0, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithOneTariff4() {
        assertEquals(10.5, cal.calcDailySavingsWithOneTariff(50, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithOneTariff5() {
        assertEquals(10.515505, cal.calcDailySavingsWithOneTariff(50.05, 20, 10.01, 5.05),
                0.00000000000001);
    }
    
    @Test
    public void calcDailySavingsWithTwoTariffs() {
        assertEquals(0, cal.calcDailySavingsWithTwoTariffs(0, 0, 0, 0, 0, 0, 0), 0);
    }
    
    @Test
    public void calcDailySavingsWithTwoTariffs2() {
        assertEquals(10.5, cal.calcDailySavingsWithTwoTariffs(50, 100, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithTwoTariffs3() {
        assertEquals(10.5, cal.calcDailySavingsWithTwoTariffs(0, 0, 50, 100, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithTwoTariffs4() {
        assertEquals(10.1, cal.calcDailySavingsWithTwoTariffs(50, 80, 40, 20, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithTwoTariffs5() {
        assertEquals(10.115113,
                cal.calcDailySavingsWithTwoTariffs(50.05, 80.08, 40, 19.92, 20, 10.01, 5.05),
                0.00000000000001);
    }
    
    @Test
    public void calcDailySavingsWithThreeTariffs() {
        assertEquals(0, cal.calcDailySavingsWithThreeTariffs(0, 0, 0, 0, 0, 0, 0, 0, 0), 0);
    }
    
    @Test
    public void calcDailySavingsWithThreeTariffs2() {
        assertEquals(10.5, cal.calcDailySavingsWithThreeTariffs(50, 100, 0, 0, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithThreeTariffs3() {
        assertEquals(10.5, cal.calcDailySavingsWithThreeTariffs(0, 0, 50, 100, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithThreeTariffs4() {
        assertEquals(10.5, cal.calcDailySavingsWithThreeTariffs(0, 0, 0, 0, 50, 100, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithThreeTariffs5() {
        assertEquals(9.3, cal.calcDailySavingsWithThreeTariffs(50, 60, 40, 20, 30, 20, 20, 10, 5),
                0.00000000000001);
    }
    
    @Test
    public void calcDailySavingsWithThreeTariffs6() {
        assertEquals(9.313311, cal.calcDailySavingsWithThreeTariffs(50.05, 60.06, 40, 19.97, 30,
                19.97, 20, 10.01, 5.05), 0.00000000000001);
    }
    
    @Test
    public void calcDailySavingsWithFourTariffs() {
        assertEquals(0, cal.calcDailySavingsWithFourTariffs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0);
    }
    
    @Test
    public void calcDailySavingsWithFourTariffs2() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFourTariffs(50, 100, 0, 0, 0, 0, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFourTariffs3() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFourTariffs(0, 0, 50, 100, 0, 0, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFourTariffs4() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFourTariffs(0, 0, 0, 0, 50, 100, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFourTariffs5() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFourTariffs(0, 0, 0, 0, 0, 0, 50, 100, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFourTariffs6() {
        assertEquals(8.1,
                cal.calcDailySavingsWithFourTariffs(50, 40, 40, 20, 30, 20, 20, 20, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFourTariffs7() {
        assertEquals(8.110909, cal.calcDailySavingsWithFourTariffs(50.05, 40.04, 40, 19.98, 30,
                19.99, 20, 19.99, 20, 10.01, 5.05), 0.00000000000001);
    }
    
    @Test
    public void calcDailySavingsWithFiveTariffs() {
        assertEquals(0, cal.calcDailySavingsWithFiveTariffs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                0);
    }
    
    @Test
    public void calcDailySavingsWithFiveTariffs2() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFiveTariffs(50, 100, 0, 0, 0, 0, 0, 0, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFiveTariffs3() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFiveTariffs(0, 0, 50, 100, 0, 0, 0, 0, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFiveTariffs4() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFiveTariffs(0, 0, 0, 0, 50, 100, 0, 0, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFiveTariffs5() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFiveTariffs(0, 0, 0, 0, 0, 0, 50, 100, 0, 0, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFiveTariffs6() {
        assertEquals(10.5,
                cal.calcDailySavingsWithFiveTariffs(0, 0, 0, 0, 0, 0, 0, 0, 50, 100, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFiveTariffs7() {
        assertEquals(6.5, cal.calcDailySavingsWithFiveTariffs(50, 20, 40, 20, 30, 20, 20, 20, 10,
                20, 20, 10, 5), 0);
    }
    
    @Test
    public void calcDailySavingsWithFiveTariffs8() {
        assertEquals(6.4998, cal.calcDailySavingsWithFiveTariffs(50, 20.02, 40, 19.98, 30, 19.99,
                20, 19.99, 10, 20.02, 20, 10, 5), 0);
    }
}
