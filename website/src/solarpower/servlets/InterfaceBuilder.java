package solarpower.servlets;

import java.util.LinkedHashMap;

public class InterfaceBuilder {
    
    public LinkedHashMap<String, Double> buildSystemSizes() {
        LinkedHashMap<String, Double> systemSizes = new LinkedHashMap<String, Double>();
        systemSizes.put("Select...", -1.0);
        systemSizes.put("1kW", 1.0);
        systemSizes.put("1.5kW", 1.5);
        systemSizes.put("2kW", 2.0);
        systemSizes.put("2.5kW", 2.5);
        systemSizes.put("3kW", 3.0);
        systemSizes.put("3.5kW", 3.5);
        systemSizes.put("4kW", 4.0);
        systemSizes.put("4.5kW", 4.5);
        systemSizes.put("5kW", 5.0);
        systemSizes.put("5.5kW", 5.5);
        systemSizes.put("6kW", 6.0);
        systemSizes.put("Custom", -2.0);
        return systemSizes;
    }
    
    public LinkedHashMap<String, Double> buildNumberOfPanels() {
        LinkedHashMap<String, Double> numberOfPanels = new LinkedHashMap<String, Double>();
        numberOfPanels.put("Select...", -1.0);
        for (Double i = 1.0; i < 51.0; i++) {
            numberOfPanels.put(i.toString().replace(".0", ""), i);
        }
        return numberOfPanels;
    }
    
    public LinkedHashMap<String, Double> buildPanelOrientations() {
        LinkedHashMap<String, Double> panelOrientations = new LinkedHashMap<String, Double>();
        panelOrientations.put("Select...", -1.0);
        panelOrientations.put("N (0°)", 0.0);
        panelOrientations.put("NNE (22.5°)", 22.5);
        panelOrientations.put("NE (45°)", 45.0);
        panelOrientations.put("ENE (67.5°)", 67.5);
        panelOrientations.put("E (90°)", 90.0);
        panelOrientations.put("ESE (112.5°)", 112.5);
        panelOrientations.put("SE (135°)", 135.0);
        panelOrientations.put("SSE (157.5°)", 157.5);
        panelOrientations.put("S (180°)", 180.0);
        panelOrientations.put("SSW (202.5°)", 202.5);
        panelOrientations.put("SW (225°)", 225.0);
        panelOrientations.put("WSW (247.5°)", 247.5);
        panelOrientations.put("W (270°)", 270.0);
        panelOrientations.put("WNW (292.5°)", 292.5);
        panelOrientations.put("NW (315°)", 315.0);
        panelOrientations.put("NNW (337.5°)", 337.5);
        return panelOrientations;
    }
    
    public LinkedHashMap<String, Double> buildHoursOfSunlight() {
        LinkedHashMap<String, Double> hoursOfSunlight = new LinkedHashMap<String, Double>();
        hoursOfSunlight.put("Select...", -1.0);
        for (Double i = 0.0; i < 25.0; i++) {
            hoursOfSunlight.put(i.toString().replace(".0", ""), i);
        }
        return hoursOfSunlight;
    }
}