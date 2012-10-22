package solarpowertest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import solarpower.SolarCalculator;

public class SolarCalculatorTest {
    
    private SolarCalculator cal;
    private double[] cumulativeSavingsOver25Years;
    
    @Before
    public void SetUp() {
        cal = new SolarCalculator();
        cumulativeSavingsOver25Years = new double[25];
        double cumulativeSavings = 1000;
        for (int i = 0; i < cumulativeSavingsOver25Years.length; i++) {
            cumulativeSavingsOver25Years[i] = cumulativeSavings;
            cumulativeSavings += 1000 + cumulativeSavings * 0.07;
        }
    }
    
    @Test
    public void calcBlankField() {
        assertEquals(0, cal.calcBlankField(""), 0);
    }
    
    @Test
    public void calcBlankField2() {
        assertEquals(0, cal.calcBlankField("0"), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency() {
        assertEquals(1, cal.calcPanelOrientationEfficiency(-1, 0.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency2() {
        assertEquals(0.95, cal.calcPanelOrientationEfficiency(-2, 22.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency3() {
        assertEquals(0.95, cal.calcPanelOrientationEfficiency(-3, 337.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency4() {
        assertEquals(0.90, cal.calcPanelOrientationEfficiency(-4, 45.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency5() {
        assertEquals(0.90, cal.calcPanelOrientationEfficiency(-5, 315.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency6() {
        assertEquals(0.85, cal.calcPanelOrientationEfficiency(-6, 67.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency7() {
        assertEquals(0.85, cal.calcPanelOrientationEfficiency(-7, 292.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency8() {
        assertEquals(0.80, cal.calcPanelOrientationEfficiency(-8, 90.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency9() {
        assertEquals(0.80, cal.calcPanelOrientationEfficiency(-9, 270.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency10() {
        assertEquals(0.75, cal.calcPanelOrientationEfficiency(-10, 112.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency11() {
        assertEquals(0.75, cal.calcPanelOrientationEfficiency(-11, 247.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency12() {
        assertEquals(0.70, cal.calcPanelOrientationEfficiency(-12, 135.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency13() {
        assertEquals(0.70, cal.calcPanelOrientationEfficiency(-13, 225.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency14() {
        assertEquals(0.65, cal.calcPanelOrientationEfficiency(-14, 157.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency15() {
        assertEquals(0.65, cal.calcPanelOrientationEfficiency(-15, 202.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency16() {
        assertEquals(0.60, cal.calcPanelOrientationEfficiency(-16, 180.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency17() {
        assertEquals(0.60, cal.calcPanelOrientationEfficiency(1, 0.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency18() {
        assertEquals(0.65, cal.calcPanelOrientationEfficiency(2, 22.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency19() {
        assertEquals(0.65, cal.calcPanelOrientationEfficiency(3, 337.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency20() {
        assertEquals(0.70, cal.calcPanelOrientationEfficiency(4, 45.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency21() {
        assertEquals(0.70, cal.calcPanelOrientationEfficiency(5, 315.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency22() {
        assertEquals(0.75, cal.calcPanelOrientationEfficiency(6, 67.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency23() {
        assertEquals(0.75, cal.calcPanelOrientationEfficiency(7, 292.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency24() {
        assertEquals(0.80, cal.calcPanelOrientationEfficiency(8, 90.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency25() {
        assertEquals(0.80, cal.calcPanelOrientationEfficiency(9, 270.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency26() {
        assertEquals(0.85, cal.calcPanelOrientationEfficiency(10, 112.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency27() {
        assertEquals(0.85, cal.calcPanelOrientationEfficiency(11, 247.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency28() {
        assertEquals(0.90, cal.calcPanelOrientationEfficiency(12, 135.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency29() {
        assertEquals(0.90, cal.calcPanelOrientationEfficiency(13, 225.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency30() {
        assertEquals(0.95, cal.calcPanelOrientationEfficiency(14, 157.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency31() {
        assertEquals(0.95, cal.calcPanelOrientationEfficiency(15, 202.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency32() {
        assertEquals(1, cal.calcPanelOrientationEfficiency(16, 180.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency33() {
        assertEquals(1, cal.calcPanelOrientationEfficiency(0, 0.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency34() {
        assertEquals(0.95, cal.calcPanelOrientationEfficiency(0, 22.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency35() {
        assertEquals(0.95, cal.calcPanelOrientationEfficiency(0, 337.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficienc36() {
        assertEquals(0.90, cal.calcPanelOrientationEfficiency(0, 45.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency37() {
        assertEquals(0.90, cal.calcPanelOrientationEfficiency(0, 315.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency38() {
        assertEquals(0.85, cal.calcPanelOrientationEfficiency(0, 67.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency39() {
        assertEquals(0.85, cal.calcPanelOrientationEfficiency(0, 292.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency40() {
        assertEquals(0.80, cal.calcPanelOrientationEfficiency(0, 90.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency41() {
        assertEquals(0.80, cal.calcPanelOrientationEfficiency(0, 270.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency42() {
        assertEquals(0.85, cal.calcPanelOrientationEfficiency(0, 112.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency43() {
        assertEquals(0.85, cal.calcPanelOrientationEfficiency(0, 247.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency44() {
        assertEquals(0.90, cal.calcPanelOrientationEfficiency(0, 135.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency45() {
        assertEquals(0.90, cal.calcPanelOrientationEfficiency(0, 225.0), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency46() {
        assertEquals(0.95, cal.calcPanelOrientationEfficiency(0, 157.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency47() {
        assertEquals(0.95, cal.calcPanelOrientationEfficiency(0, 202.5), 0);
    }
    
    @Test
    public void calcPanelOrientationEfficiency48() {
        assertEquals(1, cal.calcPanelOrientationEfficiency(0, 180.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency() {
        assertEquals(1, cal.calcPanelTiltEfficiency(-1, 15.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency2() {
        assertEquals(1, cal.calcPanelTiltEfficiency(1, 15.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency3() {
        assertEquals(0.9, cal.calcPanelTiltEfficiency(-1, 30.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency4() {
        assertEquals(0.9, cal.calcPanelTiltEfficiency(1, 30.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency5() {
        assertEquals(0.8, cal.calcPanelTiltEfficiency(-45, 0.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency6() {
        assertEquals(0.8, cal.calcPanelTiltEfficiency(45, 0.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency7() {
        assertEquals(0.8, cal.calcPanelTiltEfficiency(-1, 45.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency8() {
        assertEquals(0.8, cal.calcPanelTiltEfficiency(1, 45.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency9() {
        assertEquals(0.7, cal.calcPanelTiltEfficiency(-1, 60.0), 0);
    }
    
    @Test
    public void calcPanelTiltEfficiency10() {
        assertEquals(0.6, cal.calcPanelTiltEfficiency(1, 65.0), 0);
    }
    
    @Test
    public void calcDailySolarGenerationWithOnePanelBank() {
        assertEquals(20.9,
                cal.calcDailySolarGenerationWithOnePanelBank(0.0, 45.0, -45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithOnePanelBank2() {
        assertEquals(12.54,
                cal.calcDailySolarGenerationWithOnePanelBank(0.0, 45.0, 45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithTwoPanelBanks() {
        assertEquals(20.44, cal.calcDailySolarGenerationWithTwoPanelBanks(5, 0.0, 45.0, 4, 22.5,
                50.0, -45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithTwoPanelBanks2() {
        assertEquals(13, cal.calcDailySolarGenerationWithTwoPanelBanks(5, 0.0, 45.0, 4, 22.5,
                50.0, 45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithThreePanelBanks() {
        assertEquals(20.03, cal.calcDailySolarGenerationWithThreePanelBanks(5, 0.0, 45.0, 4, 22.5,
                50.0, 3, 45.0, 55.0, -45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithThreePanelBanks2() {
        assertEquals(13.41, cal.calcDailySolarGenerationWithThreePanelBanks(5, 0.0, 45.0, 4, 22.5,
                50.0, 3, 45.0, 55.0, 45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithFourPanelBanks() {
        assertEquals(19.71, cal.calcDailySolarGenerationWithFourPanelBanks(5, 0.0, 45.0, 4, 22.5,
                50.0, 3, 45.0, 55.0, 2, 67.5, 60.0, -45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithFourPanelBanks2() {
        assertEquals(13.73, cal.calcDailySolarGenerationWithFourPanelBanks(5, 0.0, 45.0, 4, 22.5,
                50.0, 3, 45.0, 55.0, 2, 67.5, 60.0, 45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithFivePanelBanks() {
        assertEquals(19.4, cal.calcDailySolarGenerationWithFivePanelBanks(5, 0.0, 45.0, 4, 22.5,
                50.0, 3, 45.0, 55.0, 2, 67.5, 60.0, 1, 90.0, 65.0, -45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcDailySolarGenerationWithFivePanelBanks2() {
        assertEquals(13.82, cal.calcDailySolarGenerationWithFivePanelBanks(5, 0.0, 45.0, 4, 22.5,
                50.0, 3, 45.0, 55.0, 2, 67.5, 60.0, 1, 90.0, 65.0, 45, 5.0, 95, 8.0), 0.01);
    }
    
    @Test
    public void calcRoundedDouble() {
        assertEquals("0.00", cal.calcRoundedDouble(0));
    }
    
    @Test
    public void calcRoundedDouble2() {
        assertEquals("0.10", cal.calcRoundedDouble(.1));
    }
    
    @Test
    public void calcRoundedDouble3() {
        assertEquals("2.30", cal.calcRoundedDouble(2.3));
    }
    
    @Test
    public void calcRoundedDouble4() {
        assertEquals("4567.89", cal.calcRoundedDouble(4567.89));
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
        assertEquals(0, cal.calcDailySolarUsed(0.01, 0), 0);
    }
    
    @Test
    public void calcDailySolarUsed5() {
        assertEquals(1, cal.calcDailySolarUsed(1, 1.01), 0);
    }
    
    @Test
    public void calcDailySolarExported() {
        assertEquals(0, cal.calcDailySolarExported(0, 1), 0);
    }
    
    @Test
    public void calcDailySolarExported2() {
        assertEquals(0, cal.calcDailySolarExported(-0.01, 1), 0);
    }
    
    @Test
    public void calcDailySolarExported3() {
        assertEquals(0, cal.calcDailySolarExported(1, 1), 0);
    }
    
    @Test
    public void calcDailySolarExported4() {
        assertEquals(0, cal.calcDailySolarExported(1.01, 1.01), 0);
    }
    
    @Test
    public void calcDailySolarExported5() {
        assertEquals(1, cal.calcDailySolarExported(1, 0), 0);
    }
    
    @Test
    public void calcDailySolarExported6() {
        assertEquals(0.01, cal.calcDailySolarExported(0.01, 0), 0);
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
        assertEquals(10.52, cal.calcDailySavingsWithOneTariff(50.05, 20, 10.01, 5.05), 0.01);
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
        assertEquals(10.12,
                cal.calcDailySavingsWithTwoTariffs(50.05, 80.08, 40, 19.92, 20, 10.01, 5.05), 0.01);
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
                0.01);
    }
    
    @Test
    public void calcDailySavingsWithThreeTariffs6() {
        assertEquals(9.31, cal.calcDailySavingsWithThreeTariffs(50.05, 60.06, 40, 19.97, 30, 19.97,
                20, 10.01, 5.05), 0.01);
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
        assertEquals(8.11, cal.calcDailySavingsWithFourTariffs(50.05, 40.04, 40, 19.98, 30, 19.99,
                20, 19.99, 20, 10.01, 5.05), 0.01);
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
        assertEquals(6.5, cal.calcDailySavingsWithFiveTariffs(50, 20.02, 40, 19.98, 30, 19.99, 20,
                19.99, 10, 20.02, 20, 10, 5), 0.01);
    }
    
    @Test
    public void calcTariffRate() {
        assertEquals(0, cal.calcTariffRate(0, 0), 0);
    }
    
    @Test
    public void calcTariffRate2() {
        assertEquals(0, cal.calcTariffRate(0, 7), 0);
    }
    
    @Test
    public void calcTariffRate3() {
        assertEquals(20, cal.calcTariffRate(20, 0), 0);
    }
    
    @Test
    public void calcTariffRate4() {
        assertEquals(21.4, cal.calcTariffRate(20, 7), 0);
    }
    
    @Test
    public void calcBreakEvenPoint() {
        assertEquals(1, cal.calcBreakEvenPoint(0, cumulativeSavingsOver25Years));
    }
    
    @Test
    public void calcBreakEvenPoint2() {
        assertEquals(1, cal.calcBreakEvenPoint(1000, cumulativeSavingsOver25Years));
    }
    
    @Test
    public void calcBreakEvenPoint3() {
        assertEquals(2, cal.calcBreakEvenPoint(1001, cumulativeSavingsOver25Years));
    }
    
    @Test
    public void calcBreakEvenPoint4() {
        assertEquals(99, cal.calcBreakEvenPoint(100000, cumulativeSavingsOver25Years));
    }
}