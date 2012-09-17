package solarpowertest;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import solarpower.servlets.InterfaceBuilder;

public class InterfaceBuilderTest {
    
    private InterfaceBuilder builder;
    private LinkedHashMap<String, Double> systemSizes;
    private LinkedHashMap<String, Double> numberOfPanels;
    private LinkedHashMap<String, Double> panelOrientations;
    private LinkedHashMap<String, Double> hoursOfSunlight;
    private Double NEGATIVE_ONE = -1.0;
    private Double NEGATIVE_TWO = -2.0;
    
    @Before
    public void setUp() {
        builder = new InterfaceBuilder();
        systemSizes = builder.buildSystemSizes();
        numberOfPanels = builder.buildNumberOfPanels();
        panelOrientations = builder.buildPanelOrientations();
        hoursOfSunlight = builder.buildHoursOfSunlight();
    }
    
    @Test
    public void systemSizesHasSelectOption() {
        assertEquals(NEGATIVE_ONE, systemSizes.get("Select..."));
    }
    
    @Test
    public void systemSizesHasCorrectLowerBound() throws Exception {
        systemSizes.get("0.5kW");
    }
    
    @Test
    public void systemSizesHasFirstOption() {
        assertEquals((Double) 1.0, systemSizes.get("1kW"));
    }
    
    @Test
    public void systemSizesHasLastOption() {
        assertEquals((Double) 6.0, systemSizes.get("6kW"));
    }
    
    @Test
    public void systemSizesHasCorrectUpperBound() throws Exception {
        systemSizes.get("6.5kW");
    }
    
    @Test
    public void systemSizesHasCustomOption() {
        assertEquals(NEGATIVE_TWO, systemSizes.get("Custom"));
    }
    
    @Test
    public void numberOfPanelsHasSelectOption() {
        assertEquals(NEGATIVE_ONE, numberOfPanels.get("Select..."));
    }
    
    @Test
    public void numberOfPanelsHasCorrectLowerBound() throws Exception {
        numberOfPanels.get("0");
    }
    
    @Test
    public void numberOfPanelsHasFirstOption() {
        assertEquals((Double) 1.0, numberOfPanels.get("1"));
    }
    
    @Test
    public void numberOfPanelsHasLastOption() {
        assertEquals((Double) 50.0, numberOfPanels.get("50"));
    }
    
    @Test
    public void numberOfPanelsHasCorrectUpperBound() throws Exception {
        numberOfPanels.get("51");
    }
    
    @Test
    public void panelOrientationsHasSelectOption() {
        assertEquals(NEGATIVE_ONE, panelOrientations.get("Select..."));
    }
    
    @Test
    public void panelOrientationsHasFirstOption() {
        assertEquals((Double) 0.0, panelOrientations.get("N (0°)"));
    }
    
    @Test
    public void panelOrientationsHasLastOption() {
        assertEquals((Double) 337.5, panelOrientations.get("NNW (337.5°)"));
    }
    
    @Test
    public void hoursOfSunlightHasSelectOption() {
        assertEquals(NEGATIVE_ONE, hoursOfSunlight.get("Select..."));
    }
    
    @Test
    public void hoursOfSunlightHasFirstOption() {
        assertEquals((Double) 0.0, hoursOfSunlight.get("0"));
    }
    
    @Test
    public void hoursOfSunlightHasLastOption() {
        assertEquals((Double) 24.0, hoursOfSunlight.get("24"));
    }
    
    @Test
    public void hoursOfSunlightHasCorrectUpperBound() throws Exception {
        hoursOfSunlight.get("25");
    }
}