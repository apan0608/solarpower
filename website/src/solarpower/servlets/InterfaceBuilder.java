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
        panelOrientations.put("N (0&deg;)", 0.0);
        panelOrientations.put("NNE (22.5&deg;)", 22.5);
        panelOrientations.put("NE (45&deg;)", 45.0);
        panelOrientations.put("ENE (67.5&deg;)", 67.5);
        panelOrientations.put("E (90&deg;)", 90.0);
        panelOrientations.put("ESE (112.5&deg;)", 112.5);
        panelOrientations.put("SE (135&deg;)", 135.0);
        panelOrientations.put("SSE (157.5&deg;)", 157.5);
        panelOrientations.put("S (180&deg;)", 180.0);
        panelOrientations.put("SSW (202.5&deg;)", 202.5);
        panelOrientations.put("SW (225&deg;)", 225.0);
        panelOrientations.put("WSW (247.5&deg;)", 247.5);
        panelOrientations.put("W (270&deg;)", 270.0);
        panelOrientations.put("WNW (292.5&deg;)", 292.5);
        panelOrientations.put("NW (315&deg;)", 315.0);
        panelOrientations.put("NNW (337.5&deg;)", 337.5);
        return panelOrientations;
    }
    
    public LinkedHashMap<String, Double> buildPanelTilts() {
        LinkedHashMap<String, Double> panelTilts = new LinkedHashMap<String, Double>();
        panelTilts.put("Select...", -1.0);
        panelTilts.put("0&deg;", 0.0);
        panelTilts.put("5&deg;", 5.0);
        panelTilts.put("10&deg;", 10.0);
        panelTilts.put("15&deg;", 15.0);
        panelTilts.put("20&deg;", 20.0);
        panelTilts.put("25&deg;", 25.0);
        panelTilts.put("30&deg;", 30.0);
        panelTilts.put("35&deg;", 35.0);
        panelTilts.put("40&deg;", 40.0);
        panelTilts.put("45&deg;", 45.0);
        panelTilts.put("50&deg;", 50.0);
        panelTilts.put("55&deg;", 55.0);
        panelTilts.put("60&deg;", 60.0);
        panelTilts.put("65&deg;", 65.0);
        panelTilts.put("70&deg;", 70.0);
        panelTilts.put("75&deg;", 75.0);
        panelTilts.put("80&deg;", 80.0);
        panelTilts.put("85&deg;", 85.0);
        panelTilts.put("90&deg;", 90.0);
        return panelTilts;
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