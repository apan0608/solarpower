package solarpowertest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import solarpower.InputValidator;

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
        assertTrue(val.isValidNumber("4567.89"));
    }
    
    @Test
    public void isInvalidNumber() {
        assertFalse(val.isValidNumber("$0"));
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
        assertFalse(val.isValidNumber("4.567"));
    }
    
    @Test
    public void isInvalidNumberField() {
        assertTrue(val.isInvalidNumberField(null, true));
    }
    
    @Test
    public void isInvalidNumberField2() {
        assertTrue(val.isInvalidNumberField("", true));
    }
    
    @Test
    public void isInvalidNumberField3() {
        assertTrue(val.isInvalidNumberField("$0", true));
    }
    
    @Test
    public void isInvalidNumberField4() {
        assertTrue(val.isInvalidNumberField("1 2", true));
    }
    
    @Test
    public void isInvalidNumberField5() {
        assertTrue(val.isInvalidNumberField("3.", true));
    }
    
    @Test
    public void isInvalidNumberField6() {
        assertTrue(val.isInvalidNumberField("4.567", true));
    }
    
    @Test
    public void isInvalidNumberField7() {
        assertTrue(val.isInvalidNumberField("$0", false));
    }
    
    @Test
    public void isInvalidNumberField8() {
        assertTrue(val.isInvalidNumberField("1 2", false));
    }
    
    @Test
    public void isInvalidNumberField9() {
        assertTrue(val.isInvalidNumberField("3.", false));
    }
    
    @Test
    public void isInvalidNumberField10() {
        assertTrue(val.isInvalidNumberField("4.567", false));
    }
    
    @Test
    public void isValidNumberField() {
        assertFalse(val.isInvalidNumberField("0", true));
    }
    
    @Test
    public void isValidNumberField2() {
        assertFalse(val.isInvalidNumberField(".1", true));
    }
    
    @Test
    public void isValidNumberField3() {
        assertFalse(val.isInvalidNumberField("2.3", true));
    }
    
    @Test
    public void isValidNumberField4() {
        assertFalse(val.isInvalidNumberField("4567.89", true));
    }
    
    @Test
    public void isValidNumberField5() {
        assertFalse(val.isInvalidNumberField("", false));
    }
    
    @Test
    public void isValidNumberField6() {
        assertFalse(val.isInvalidNumberField(".1", false));
    }
    
    @Test
    public void isValidNumberField7() {
        assertFalse(val.isInvalidNumberField("2.3", false));
    }
    
    @Test
    public void isValidNumberField8() {
        assertFalse(val.isInvalidNumberField("4567.89", false));
    }
    
    @Test
    public void isGreaterThanZero() {
        assertTrue(val.isGreaterThanZero("1"));
    }
    
    @Test
    public void isGreaterThanZero2() {
        assertTrue(val.isGreaterThanZero("0.01"));
    }
    
    @Test
    public void isNotGreaterThanZero() {
        assertFalse(val.isGreaterThanZero("0"));
    }
    
    @Test
    public void isNotGreaterThanZero2() {
        assertFalse(val.isGreaterThanZero("-0.01"));
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
    public void isInvalidSystemSize7() {
        assertTrue(val.isInvalidSystemSize("4.567"));
    }
    
    @Test
    public void isInvalidSystemSize8() {
        assertTrue(val.isInvalidSystemSize("0"));
    }
    
    @Test
    public void isInvalidSystemSize9() {
        assertTrue(val.isInvalidSystemSize("-0.01"));
    }
    
    @Test
    public void isValidSystemSize() {
        assertFalse(val.isInvalidSystemSize("1"));
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
        assertFalse(val.isInvalidSystemSize("4567.89"));
    }
    
    @Test
    public void isValidSystemSize5() {
        assertFalse(val.isInvalidSystemSize("0.01"));
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
        assertTrue(val.isInvalidPercentage("-0.01"));
    }
    
    @Test
    public void isInvalidPercentage3() {
        assertTrue(val.isInvalidPercentage("101"));
    }
    
    @Test
    public void isInvalidPercentage4() {
        assertTrue(val.isInvalidPercentage("100.01"));
    }
    
    @Test
    public void isValidPercentage() {
        assertFalse(val.isInvalidPercentage("0"));
    }
    
    @Test
    public void isValidPercentage2() {
        assertFalse(val.isInvalidPercentage("0.01"));
    }
    
    @Test
    public void isValidPercentage3() {
        assertFalse(val.isInvalidPercentage("100"));
    }
    
    @Test
    public void isInvalidPercentageField() {
        assertTrue(val.isInvalidPercentageField(null, true));
    }
    
    @Test
    public void isInvalidPercentageField2() {
        assertTrue(val.isInvalidPercentageField("", true));
    }
    
    @Test
    public void isInvalidPercentageField3() {
        assertTrue(val.isInvalidPercentageField("0%", true));
    }
    
    @Test
    public void isInvalidPercentageField4() {
        assertTrue(val.isInvalidPercentageField("1 2", true));
    }
    
    @Test
    public void isInvalidPercentageField5() {
        assertTrue(val.isInvalidPercentageField("3.", true));
    }
    
    @Test
    public void isInvalidPercentageField6() {
        assertTrue(val.isInvalidPercentageField("4.567", true));
    }
    
    @Test
    public void isInvalidPercentageField7() {
        assertTrue(val.isInvalidPercentageField("-1", true));
    }
    
    @Test
    public void isInvalidPercentageField8() {
        assertTrue(val.isInvalidPercentageField("-0.01", true));
    }
    
    @Test
    public void isInvalidPercentageField9() {
        assertTrue(val.isInvalidPercentageField("101", true));
    }
    
    @Test
    public void isInvalidPercentageField10() {
        assertTrue(val.isInvalidPercentageField("100.01", true));
    }
    
    @Test
    public void isInvalidPercentageField11() {
        assertTrue(val.isInvalidPercentageField("0%", false));
    }
    
    @Test
    public void isInvalidPercentageField12() {
        assertTrue(val.isInvalidPercentageField("1 2", false));
    }
    
    @Test
    public void isInvalidPercentageField13() {
        assertTrue(val.isInvalidPercentageField("3.", false));
    }
    
    @Test
    public void isInvalidPercentageField14() {
        assertTrue(val.isInvalidPercentageField("4.567", false));
    }
    
    @Test
    public void isInvalidPercentageField15() {
        assertTrue(val.isInvalidPercentageField("-1", false));
    }
    
    @Test
    public void isInvalidPercentageField16() {
        assertTrue(val.isInvalidPercentageField("-0.01", false));
    }
    
    @Test
    public void isInvalidPercentageField17() {
        assertTrue(val.isInvalidPercentageField("101", false));
    }
    
    @Test
    public void isInvalidPercentageField18() {
        assertTrue(val.isInvalidPercentageField("100.01", false));
    }
    
    @Test
    public void isValidPercentageField() {
        assertFalse(val.isInvalidPercentageField("0", true));
    }
    
    @Test
    public void isValidPercentageField2() {
        assertFalse(val.isInvalidPercentageField(".1", true));
    }
    
    @Test
    public void isValidPercentageField3() {
        assertFalse(val.isInvalidPercentageField("0.01", true));
    }
    
    @Test
    public void isValidPercentageField4() {
        assertFalse(val.isInvalidPercentageField("100", true));
    }
    
    @Test
    public void isValidPercentageField5() {
        assertFalse(val.isInvalidPercentageField("", false));
    }
    
    @Test
    public void isValidPercentageField6() {
        assertFalse(val.isInvalidPercentageField("0", false));
    }
    
    @Test
    public void isValidPercentageField7() {
        assertFalse(val.isInvalidPercentageField(".1", false));
    }
    
    @Test
    public void isValidPercentageField8() {
        assertFalse(val.isInvalidPercentageField("0.01", false));
    }
    
    @Test
    public void isValidPercentageField9() {
        assertFalse(val.isInvalidPercentageField("100", false));
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
        assertTrue(val.isInvalidReplacementCost("$0", true));
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
        assertTrue(val.isInvalidReplacementCost("4.567", true));
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
        assertFalse(val.isInvalidReplacementCost("4567.89", true));
    }
    
    @Test
    public void isInvalidPowerUsage() {
        assertTrue(val.isInvalidPowerUsage("1", "2"));
    }
    
    @Test
    public void isInvalidPowerUsage2() {
        assertTrue(val.isInvalidPowerUsage("1", "1.1"));
    }
    
    @Test
    public void isInvalidPowerUsage3() {
        assertTrue(val.isInvalidPowerUsage("1.01", "1.1"));
    }
    
    @Test
    public void isValidPowerUsage() {
        assertFalse(val.isInvalidPowerUsage("1", "1"));
    }
    
    @Test
    public void isValidPowerUsage2() {
        assertFalse(val.isInvalidPowerUsage("1", "0.9"));
    }
    
    @Test
    public void isValidPowerUsage3() {
        assertFalse(val.isInvalidPowerUsage("1.01", "0.9"));
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
        assertTrue(val.isInvalidTariff("$0", "0"));
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
        assertTrue(val.isInvalidTariff("4.567", "0"));
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
        assertTrue(val.isInvalidTariff("0", "0%"));
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
        assertTrue(val.isInvalidTariff("0", "4.567"));
    }
    
    @Test
    public void isInvalidTariff14() {
        assertTrue(val.isInvalidTariff("0", "-1"));
    }
    
    @Test
    public void isInvalidTariff15() {
        assertTrue(val.isInvalidTariff("0", "-0.01"));
    }
    
    @Test
    public void isInvalidTariff16() {
        assertTrue(val.isInvalidTariff("0", "101"));
    }
    
    @Test
    public void isInvalidTariff17() {
        assertTrue(val.isInvalidTariff("0", "100.01"));
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
        assertFalse(val.isInvalidTariff("4567.89", "0"));
    }
    
    @Test
    public void isValidTariff5() {
        assertFalse(val.isInvalidTariff("0", ".1"));
    }
    
    @Test
    public void isValidTariff6() {
        assertFalse(val.isInvalidTariff("0", "0.01"));
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
        assertTrue(val.isInvalidTariffPercentage("0", "99.99", "0", "0", "0", 2));
    }
    
    @Test
    public void isInvalidTariffPercentage3() {
        assertTrue(val.isInvalidTariffPercentage("0", "0", "100.01", "0", "0", 3));
    }
    
    @Test
    public void isInvalidTariffPercentage4() {
        assertTrue(val.isInvalidTariffPercentage("0", "0", "0", "100.01", "0", 4));
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
        assertFalse(val.isInvalidTariffPercentage("0", ".01", "9.99", "90", "100", 4));
    }
    
    @Test
    public void isValidTariffPercentage5() {
        assertFalse(val.isInvalidTariffPercentage("0", ".01", "9.99", "40", "50", 5));
    }
}