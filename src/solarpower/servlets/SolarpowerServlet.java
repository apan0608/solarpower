package solarpower.servlets;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.util.Date;
import java.util.LinkedHashMap;
import java.io.IOException;

import java.util.logging.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.taskdefs.XSLTProcess.Factory;

public class SolarpowerServlet extends HttpServlet implements Servlet {
    
    private static final long serialVersionUID = 1L;
    
    private String systemLocation;
    private double systemCost;
    private double systemSize;
    private double numberOfPanels;
    private double panelOrientation;
    private double panelEfficiencyLoss;
    private double inverterEfficiency;
    private String replacementInverter;
    private double hoursOfSunlight;
    private double dailyPowerUsage;
    private double daytimePowerUsage;
    private double tariffRate;
    private double tariffPercentage;
    private double additionalFees;
    private double tariffIncrease;
    private double feedinTariff;
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {
        
    }
    
    // this is experimental, feel free to comment everything out
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {
        
        try {
            systemLocation = req.getParameter("systemLocation");
            systemCost = Double.parseDouble(req.getParameter("systemCost"));
            systemSize = Double.parseDouble(req.getParameter("systemSize"));
            numberOfPanels = Double.parseDouble(req.getParameter("numberOfPanels"));
            panelOrientation = Double.parseDouble(req.getParameter("panelOrientation"));
            panelEfficiencyLoss = Double.parseDouble(req.getParameter("panelEfficiencyLoss"));
            inverterEfficiency = Double.parseDouble(req.getParameter("inverterEfficiency"));
            replacementInverter = req.getParameter("replacementInverter");
            hoursOfSunlight = Double.parseDouble(req.getParameter("hoursOfSunlight"));
            dailyPowerUsage = Double.parseDouble(req.getParameter("dailyPowerUsage"));
            daytimePowerUsage = Double.parseDouble(req.getParameter("daytimePowerUsage"));
            tariffRate = Double.parseDouble(req.getParameter("tariffRate"));
            tariffPercentage = Double.parseDouble(req.getParameter("tariffPercentage"));
            additionalFees = Double.parseDouble(req.getParameter("additionalFees"));
            tariffIncrease = Double.parseDouble(req.getParameter("tariffIncrease"));
            feedinTariff = Double.parseDouble(req.getParameter("feedinTariff"));
        } catch (Exception e) {
        }
        
        StringBuilder output = new StringBuilder();
        output.append(systemLocation);
        output.append(systemCost);
        output.append("test");
        
        req.setAttribute("output", output);
        
    }
    
}