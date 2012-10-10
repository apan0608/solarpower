package solarpowertest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import solarpower.servlets.InputValidator;

public class InputValidatorTest {
    
    private InputValidator val;
    
    @Before
    public void setUp() {
        val = new InputValidator();
    }
    
    @Test
    public void isCustomSelection() {
        assertTrue(val.isCustomSelection("-2.0"));
    }
    
    @Test
    public void isNotCustomSelection() {
        assertFalse(val.isCustomSelection(""));
    }
    
    @Test
    public void isNull() {
        assertTrue(val.isNull(null));
    }
    
    @Test
    public void isNotNull() {
        assertFalse(val.isNull(""));
    }
    
    @Test
    public void isEmpty() {
        assertTrue(val.isEmpty(""));
    }
    
    @Test
    public void isNotEmpty() {
        assertFalse(val.isEmpty(" "));
    }
    
    @Test
    public void isNullOrEmpty() {
        assertTrue(val.isNullOrEmpty(null));
    }
    
    @Test
    public void isNullOrEmpty2() {
        assertTrue(val.isNullOrEmpty(""));
    }
    
    @Test
    public void isNotNullOrEmpty() {
        assertFalse(val.isNullOrEmpty(" "));
    }
    
    @Test
    public void isInvalidSelection() {
        assertTrue(val.isInvalidSelection("-1.0"));
    }
    
    @Test
    public void isValidSelection() {
        assertFalse(val.isInvalidSelection(""));
    }
    
    @Test
    public void isInvalidDropdown() {
        assertTrue(val.isInvalidDropdown(null));
    }
    
    @Test
    public void isInvalidDropdown2() {
        assertTrue(val.isInvalidDropdown(""));
    }
    
    @Test
    public void isInvalidDropdown3() {
        assertTrue(val.isInvalidDropdown("-1.0"));
    }
    
    @Test
    public void isValidDropdown() {
        assertFalse(val.isInvalidDropdown(" "));
    }
    
    @Test
    public void isValidNumber() {
        assertTrue(val.isValidNumber("0"));
    }
    
    @Test
    public void isValidNumber2() {
        assertTrue(val.isValidNumber(".1"));
    }
    
    @Test
    public void isValidNumber3() {
        assertTrue(val.isValidNumber("2.3"));
    }
    
    @Test
    public void isValidNumber4() {
        assertTrue(val.isValidNumber("456.789"));
    }
    
    @Test
    public void isInvalidNumber() {
        assertFalse(val.isValidNumber("0 dollars"));
    }
    
    @Test
    public void isInvalidNumber2() {
        assertFalse(val.isValidNumber("1 2"));
    }
    
    @Test
    public void isInvalidNumber3() {
        assertFalse(val.isValidNumber("3."));
    }
    
    @Test
    public void isInvalidNumber4() {
        assertFalse(val.isValidNumber("$4"));
    }
    
    @Test
    public void isInvalidNumberField() {
        assertTrue(val.isInvalidNumberField(null));
    }
    
    @Test
    public void isInvalidNumberField2() {
        assertTrue(val.isInvalidNumberField(""));
    }
    
    @Test
    public void isInvalidNumberField3() {
        assertTrue(val.isInvalidNumberField("0 dollars"));
    }
    
    @Test
    public void isInvalidNumberField4() {
        assertTrue(val.isInvalidNumberField("1 2"));
    }
    
    @Test
    public void isInvalidNumberField5() {
        assertTrue(val.isInvalidNumberField("3."));
    }
    
    @Test
    public void isInvalidNumberField6() {
        assertTrue(val.isInvalidNumberField("$4"));
    }
    
    @Test
    public void isValidNumberField() {
        assertFalse(val.isInvalidNumberField("0"));
    }
    
    @Test
    public void isValidNumberField2() {
        assertFalse(val.isInvalidNumberField(".1"));
    }
    
    @Test
    public void isValidNumberField3() {
        assertFalse(val.isInvalidNumberField("2.3"));
    }
    
    @Test
    public void isValidNumberField4() {
        assertFalse(val.isInvalidNumberField("456.789"));
    }
    
    @Test
    public void isInvalidSystemSize() {
        assertTrue(val.isInvalidSystemSize(null));
    }
    
    @Test
    public void isInvalidSystemSize2() {
        assertTrue(val.isInvalidSystemSize(""));
    }
    
    @Test
    public void isInvalidSystemSize3() {
        assertTrue(val.isInvalidSystemSize("-1.0"));
    }
    
    @Test
    public void isInvalidSystemSize4() {
        assertTrue(val.isInvalidSystemSize("0kw"));
    }
    
    @Test
    public void isInvalidSystemSize5() {
        assertTrue(val.isInvalidSystemSize("1 2"));
    }
    
    @Test
    public void isInvalidSystemSize6() {
        assertTrue(val.isInvalidSystemSize("3."));
    }
    
    @Test
    public void isValidSystemSize() {
        assertFalse(val.isInvalidSystemSize("0"));
    }
    
    @Test
    public void isValidSystemSize2() {
        assertFalse(val.isInvalidSystemSize(".1"));
    }
    
    @Test
    public void isValidSystemSize3() {
        assertFalse(val.isInvalidSystemSize("2.3"));
    }
    
    @Test
    public void isValidSystemSize4() {
        assertFalse(val.isInvalidSystemSize("456.789"));
    }
    
    @Test
    public void isInvalidPanelBank() {
        assertTrue(val.isInvalidPanelBank(null, null, null));
    }
    
    @Test
    public void isInvalidPanelBank2() {
        assertTrue(val.isInvalidPanelBank(null, "0", "0"));
    }
    
    @Test
    public void isInvalidPanelBank3() {
        assertTrue(val.isInvalidPanelBank("0", "", "0"));
    }
    
    @Test
    public void isInvalidPanelBank4() {
        assertTrue(val.isInvalidPanelBank("0", "0", "-1.0"));
    }
    
    @Test
    public void isValidPanelBank() {
        assertFalse(val.isInvalidPanelBank("0", "0", "0"));
    }
    
    @Test
    public void isInvalidPercentage() {
        assertTrue(val.isInvalidPercentage("-1"));
    }
    
    @Test
    public void isInvalidPercentage2() {
        assertTrue(val.isInvalidPercentage("-0.1"));
    }
    
    @Test
    public void isInvalidPercentage3() {
        assertTrue(val.isInvalidPercentage("101"));
    }
    
    @Test
    public void isInvalidPercentage4() {
        assertTrue(val.isInvalidPercentage("100.1"));
    }
    
    @Test
    public void isValidPercentage() {
        assertFalse(val.isInvalidPercentage("0"));
    }
    
    @Test
    public void isValidPercentage2() {
        assertFalse(val.isInvalidPercentage("0.1"));
    }
    
    @Test
    public void isValidPercentage3() {
        assertFalse(val.isInvalidPercentage("100"));
    }
    
    @Test
    public void isInvalidPercentageField() {
        assertTrue(val.isInvalidPercentageField(null));
    }
    
    @Test
    public void isInvalidPercentageField2() {
        assertTrue(val.isInvalidPercentageField(""));
    }
    
    @Test
    public void isInvalidPercentageField3() {
        assertTrue(val.isInvalidPercentageField("0 percent"));
    }
    
    @Test
    public void isInvalidPercentageField4() {
        assertTrue(val.isInvalidPercentageField("1 2"));
    }
    
    @Test
    public void isInvalidPercentageField5() {
        assertTrue(val.isInvalidPercentageField("3."));
    }
    
    @Test
    public void isInvalidPercentageField6() {
        assertTrue(val.isInvalidPercentageField("4%"));
    }
    
    @Test
    public void isInvalidPercentageField8() {
        assertTrue(val.isInvalidPercentageField("-1"));
    }
    
    @Test
    public void isInvalidPercentageField9() {
        assertTrue(val.isInvalidPercentageField("-0.1"));
    }
    
    @Test
    public void isInvalidPercentageField10() {
        assertTrue(val.isInvalidPercentageField("101"));
    }
    
    @Test
    public void isInvalidPercentageField11() {
        assertTrue(val.isInvalidPercentageField("100.1"));
    }
    
    @Test
    public void isValidPercentageField() {
        assertFalse(val.isInvalidPercentageField("0"));
    }
    
    @Test
    public void isValidPercentageField2() {
        assertFalse(val.isInvalidPercentageField(".1"));
    }
    
    @Test
    public void isValidPercentageField3() {
        assertFalse(val.isInvalidPercentageField("0.1"));
    }
    
    @Test
    public void isValidPercentageField4() {
        assertFalse(val.isInvalidPercentageField("100"));
    }
    
    @Test
    public void isYesValue() {
        assertTrue(val.isYesValue("Yes"));
    }
    
    @Test
    public void isNotYesValue() {
        assertFalse(val.isYesValue("No"));
    }
    
    @Test
    public void isInvalidReplacementCost() {
        assertTrue(val.isInvalidReplacementCost(null, true));
    }
    
    @Test
    public void isInvalidReplacementCost2() {
        assertTrue(val.isInvalidReplacementCost("", true));
    }
    
    @Test
    public void isInvalidReplacementCost3() {
        assertTrue(val.isInvalidReplacementCost("0 dollars", true));
    }
    
    @Test
    public void isInvalidReplacementCost4() {
        assertTrue(val.isInvalidReplacementCost("1 2", true));
    }
    
    @Test
    public void isInvalidReplacementCost5() {
        assertTrue(val.isInvalidReplacementCost("3.", true));
    }
    
    @Test
    public void isInvalidReplacementCost6() {
        assertTrue(val.isInvalidReplacementCost("$4", true));
    }
    
    @Test
    public void isValidReplacementCost() {
        assertFalse(val.isInvalidReplacementCost(null, false));
    }
    
    @Test
    public void isValidReplacementCost2() {
        assertFalse(val.isInvalidReplacementCost("0", true));
    }
    
    @Test
    public void isValidReplacementCost3() {
        assertFalse(val.isInvalidReplacementCost(".1", true));
    }
    
    @Test
    public void isValidReplacementCost4() {
        assertFalse(val.isInvalidReplacementCost("2.3", true));
    }
    
    @Test
    public void isValidReplacementCost5() {
        assertFalse(val.isInvalidReplacementCost("456.789", true));
    }
    
    @Test
    public void isInvalidTariff() {
        assertTrue(val.isInvalidTariff(null, null));
    }
    
    @Test
    public void isInvalidTariff2() {
        assertTrue(val.isInvalidTariff(null, "0"));
    }
    
    @Test
    public void isInvalidTariff3() {
        assertTrue(val.isInvalidTariff("", "0"));
    }
    
    @Test
    public void isInvalidTariff4() {
        assertTrue(val.isInvalidTariff("0 dollars", "0"));
    }
    
    @Test
    public void isInvalidTariff5() {
        assertTrue(val.isInvalidTariff("1 2", "0"));
    }
    
    @Test
    public void isInvalidTariff6() {
        assertTrue(val.isInvalidTariff("3.", "0"));
    }
    
    @Test
    public void isInvalidTariff7() {
        assertTrue(val.isInvalidTariff("$4", "0"));
    }
    
    @Test
    public void isInvalidTariff8() {
        assertTrue(val.isInvalidTariff("0", null));
    }
    
    @Test
    public void isInvalidTariff9() {
        assertTrue(val.isInvalidTariff("0", ""));
    }
    
    @Test
    public void isInvalidTariff10() {
        assertTrue(val.isInvalidTariff("0", "0 percent"));
    }
    
    @Test
    public void isInvalidTariff11() {
        assertTrue(val.isInvalidTariff("0", "1 2"));
    }
    
    @Test
    public void isInvalidTariff12() {
        assertTrue(val.isInvalidTariff("0", "3."));
    }
    
    @Test
    public void isInvalidTariff13() {
        assertTrue(val.isInvalidTariff("0", "4%"));
    }
    
    @Test
    public void isInvalidTariff14() {
        assertTrue(val.isInvalidTariff("0", "-1"));
    }
    
    @Test
    public void isInvalidTariff15() {
        assertTrue(val.isInvalidTariff("0", "-0.1"));
    }
    
    @Test
    public void isInvalidTariff16() {
        assertTrue(val.isInvalidTariff("0", "101"));
    }
    
    @Test
    public void isInvalidTariff17() {
        assertTrue(val.isInvalidTariff("0", "100.1"));
    }
    
    @Test
    public void isValidTariff() {
        assertFalse(val.isInvalidTariff("0", "0"));
    }
    
    @Test
    public void isValidTariff2() {
        assertFalse(val.isInvalidTariff(".1", "0"));
    }
    
    @Test
    public void isValidTariff3() {
        assertFalse(val.isInvalidTariff("2.3", "0"));
    }
    
    @Test
    public void isValidTariff4() {
        assertFalse(val.isInvalidTariff("456.789", "0"));
    }
    
    @Test
    public void isValidTariff5() {
        assertFalse(val.isInvalidTariff("0", ".1"));
    }
    
    @Test
    public void isValidTariff6() {
        assertFalse(val.isInvalidTariff("0", "0.1"));
    }
    
    @Test
    public void isValidTariff7() {
        assertFalse(val.isInvalidTariff("0", "100"));
    }
    
    @Test
    public void isInvalidTariffPercentage() {
        assertTrue(val.isInvalidTariffPercentage("0", "0", "0", "0", "0", 1));
    }
    
    @Test
    public void isInvalidTariffPercentage2() {
        assertTrue(val.isInvalidTariffPercentage("0", "99.9", "0", "0", "0", 2));
    }
    
    @Test
    public void isInvalidTariffPercentage3() {
        assertTrue(val.isInvalidTariffPercentage("0", "0", "100.1", "0", "0", 3));
    }
    
    @Test
    public void isInvalidTariffPercentage4() {
        assertTrue(val.isInvalidTariffPercentage("0", "0", "0", "100.00001", "0", 4));
    }
    
    @Test
    public void isInvalidTariffPercentage5() {
        assertTrue(val.isInvalidTariffPercentage("10", "20", "30", "40", "50", 5));
    }
    
    @Test
    public void isValidTariffPercentage() {
        assertFalse(val.isInvalidTariffPercentage("100", "100", "100", "100", "100", 1));
    }
    
    @Test
    public void isValidTariffPercentage2() {
        assertFalse(val.isInvalidTariffPercentage("0", "100", "100", "100", "100", 2));
    }
    
    @Test
    public void isValidTariffPercentage3() {
        assertFalse(val.isInvalidTariffPercentage("0.0", "50.0", "50.0", "100", "100", 3));
    }
    
    @Test
    public void isValidTariffPercentage4() {
        assertFalse(val.isInvalidTariffPercentage("0", ".1", "9.9", "90", "100", 4));
    }
    
    @Test
    public void isValidTariffPercentage5() {
        assertFalse(val.isInvalidTariffPercentage("0", ".1", "9.9", "40", "50", 5));
    }
    
    // @Test(expected = Exception.class)
    // public void nullString() throws Exception {
    // val.stringIsNull(null);
    // }
    
    // // Enter a negative system size
    // @Test(expected = Exception.class)
    // public void negativeSystemSize() throws Exception {
    // validate.systemSize(-3.0);
    // }
    //
    // // Enter a negative system cost
    // @Test(expected = Exception.class)
    // public void negativeSystemCost() throws Exception {
    // validate.systemCost(-1000.0);
    // }
    //
    // // Enter a negative percentage of panel on North
    // @Test(expected = Exception.class)
    // public void negativePercentNorth() throws Exception {
    // validate.northRoofDensity(-15.5);
    // }
    //
    // // Set the panel's density to be 106%
    // @Test(expected = Exception.class)
    // public void invalidPercentNorth() throws Exception {
    // validate.northRoofDensity(106.0);
    // }
    //
    // // Enter a negative percentage of panel on West
    // @Test(expected = Exception.class)
    // public void negativePercentWest() throws Exception {
    // validate.westRoofDensity(-27.5);
    // }
    //
    // // Set the panel's density to be 150.%
    // @Test(expected = Exception.class)
    // public void invalidPercentWest() throws Exception {
    // validate.westRoofDensity(150.5);
    // }
    //
    // // Enter a negative percentage represented for the Efficiency Loss (North Roof)
    // @Test(expected = Exception.class)
    // public void negativeNorthRoofEfficiencyLoss() throws Exception {
    // validate.northRoofEfficiencyLoss(-27.1);
    // }
    //
    // // Enter a percentage over 100% for the Efficiency Loss (North Roof)
    // @Test(expected = Exception.class)
    // public void invalidNorthRoofEfficiencyLoss() throws Exception {
    // validate.northRoofEfficiencyLoss(200.1);
    // }
    //
    // // Enter a negative percentage represented for the Efficiency Loss (West Roof)
    // @Test(expected = Exception.class)
    // public void negativeWestRoofEfficiencyLoss() throws Exception {
    // validate.westRoofEfficiencyLoss(-17.5);
    // }
    //
    // // Enter a percentage over 100% for the Efficiency Loss ( Roof)
    // @Test(expected = Exception.class)
    // public void invalidWestRoofEfficiencyLoss() throws Exception {
    // validate.westRoofEfficiencyLoss(210.1);
    // }
    //
    // // Enter a negative percentage represented for the Panel Age Efficiency Loss
    // @Test(expected = Exception.class)
    // public void negativePanelAgeEfficiencyLoss() throws Exception {
    // validate.panelAgeEfficiencyLoss(-66.5);
    // }
    //
    // // Enter a percentage over 100% for the Panel Age Efficiency Loss
    // @Test(expected = Exception.class)
    // public void invalidPanelAgeEfficiencyLoss() throws Exception {
    // validate.panelAgeEfficiencyLoss(110.1);
    // }
    //
    // // Enter a negative Inverter Replacement Cost
    // @Test(expected = Exception.class)
    // public void negativeInverterReplacementCost() throws Exception {
    // validate.inverterReplacementCost(-4000.0);
    // }
    //
    // // Enter a negative Average Daily Hours of Sunlight
    // @Test(expected = Exception.class)
    // public void negativeSunlightDailyHours() throws Exception {
    // validate.sunlightDailyHours(-3.0);
    // }
    //
    // // Set the Average Daily Hours of Sunlight to be 25 hours
    // @Test(expected = Exception.class)
    // public void invalidSunlightDailyHours() throws Exception {
    // validate.sunlightDailyHours(25.0);
    // }
    //
    // // Enter a negative Daily Average Usage
    // @Test(expected = Exception.class)
    // public void negativedailyAvgUsage() throws Exception {
    // validate.dailyAvgUsage(-40.0);
    // }
    //
    // // Enter a negative Day Time Hourly Usage
    // @Test(expected = Exception.class)
    // public void negativeDayTimeHourlyUsage() throws Exception {
    // validate.dayTimeHourlyUsage(-1.0);
    // }
    //
    // // Enter a negative Annual Tariff 11 Cost
    // @Test(expected = Exception.class)
    // public void negativeAnnualTariff11Cost() throws Exception {
    // validate.annualTariff11Cost(-2460.0);
    // }
    //
    // // Enter a negative Annual Tariff 33 Cost
    // @Test(expected = Exception.class)
    // public void negativeAnnualTariff33Cost() throws Exception {
    // validate.annualTariff33Cost(-185.0);
    // }
    //
    // // Enter a negative Tariff 11 Fee
    // @Test(expected = Exception.class)
    // public void negativeTariff11Fee() throws Exception {
    // validate.tariff11Fee(-0.1941);
    // }
    //
    // // Enter a negative Tariff 33 Fee
    // @Test(expected = Exception.class)
    // public void negativeTariff33Fee() throws Exception {
    // validate.tariff33Fee(-0.11);
    // }
    //
    // // Enter a negative Feed in Fee
    // @Test(expected = Exception.class)
    // public void negativeFeedInFee() throws Exception {
    // validate.feedInFee(-0.5);
    // }
    //
    // // Enter a negative Annual Tariff Increase
    // @Test(expected = Exception.class)
    // public void negativeAnnualTariffIncrease() throws Exception {
    // validate.annualTariffIncrease(-5.0);
    // }
    //
    // // Enter a negative Investment Return Rate
    // @Test(expected = Exception.class)
    // public void negativeInvestmentReturnRate() throws Exception {
    // validate.investmentReturnRate(-5.0);
    // }
}