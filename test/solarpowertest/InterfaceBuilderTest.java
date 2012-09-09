package solarpowertest;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Test;

import solarpower.servlets.InterfaceBuilder;


public class InterfaceBuilderTest {

	@Test
	public void testNumberOfPanels1() {
		LinkedHashMap<String, Double> numberOfPanels = InterfaceBuilder.BuildNumberOfPanels();
        assertEquals((Double)1.0, numberOfPanels.get("1"));
	}
	
	@Test
	public void testNumberOfPanels2() {
		LinkedHashMap<String, Double> numberOfPanels = InterfaceBuilder.BuildNumberOfPanels();
    	assertEquals((Double)50.0, numberOfPanels.get("50"));
	}
	
	@Test
	public void testSystemSize1() {
		LinkedHashMap<String, Double> sizes = InterfaceBuilder.BuildSystemSizes();
    	assertEquals((Double)1.0, sizes.get("1kW"));
	}
	
	@Test
	public void testSystemSize2() {
		LinkedHashMap<String, Double> sizes = InterfaceBuilder.BuildSystemSizes();
    	assertEquals((Double)6.0, sizes.get("6kW"));
	}
	
	
	@Test
	public void testPanelOrientations1() {
		LinkedHashMap<String, Double> panelOrientations = InterfaceBuilder.BuildPanelOrientations();
        assertEquals((Double)0.0, panelOrientations.get("N (0�)"));
	}
	
	@Test
	public void testPanelOrientations2() {
		LinkedHashMap<String, Double> panelOrientations = InterfaceBuilder.BuildPanelOrientations();
        assertEquals((Double) 337.5, panelOrientations.get("NNW (337.5�)"));
	}

	@Test
	public void testHoursOfSunlight1() {
		LinkedHashMap<String, Double> HoursOfSunlight = InterfaceBuilder.BuildHoursOfSunlight();
        assertEquals((Double)0.0, HoursOfSunlight.get("0"));
	}
	
	@Test
	public void testHoursOfSunlight2() {
		LinkedHashMap<String, Double> HoursOfSunlight = InterfaceBuilder.BuildHoursOfSunlight();
        assertEquals((Double)24.0, HoursOfSunlight.get("24"));
	}
}
