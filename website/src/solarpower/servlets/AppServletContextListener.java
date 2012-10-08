package solarpower.servlets;

import java.util.LinkedHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppServletContextListener implements ServletContextListener {
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        InterfaceBuilder builder = new InterfaceBuilder();
        LinkedHashMap<String, Double> systemSizes = builder.buildSystemSizes();
        event.getServletContext().setAttribute("systemSizes", systemSizes);
        LinkedHashMap<String, Double> numberOfPanels = builder.buildNumberOfPanels();
        event.getServletContext().setAttribute("numberOfPanels", numberOfPanels);
        LinkedHashMap<String, Double> panelOrientations = builder.buildPanelOrientations();
        event.getServletContext().setAttribute("panelOrientations", panelOrientations);
        LinkedHashMap<String, Double> hoursOfSunlight = builder.buildHoursOfSunlight();
        event.getServletContext().setAttribute("hoursOfSunlight", hoursOfSunlight);
    }
}