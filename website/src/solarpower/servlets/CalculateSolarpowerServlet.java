package solarpower.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.jasper.servlet.JspServlet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

import solarpower.entities.SolarCalculator;

/*
 * Perform all kinds of calculations. And in later development, enable user service 
 * and save results to datastore.
 * @author
 * */
public class CalculateSolarpowerServlet extends HttpServlet implements Servlet {
    
    String calResults = "";
    
    // implement it to automatically track user's location and pre fill the form
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        resp.sendRedirect("/calculate.jsp");
        
    }
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {
        
        calculation(req);
        
        resp.setContentType("text/html");
        resp.getWriter().write(calResults);
        // String calculate = req.getParameter("calculationDataForm");
        // String submit = "Submit";
        // if (calculate.equalsIgnoreCase(submit)) {
        // calculate(req, resp);
        // }
        
    }
    
    /*
     * Input validation. Call the InputValidator class to validate all the fields in the form. Send
     * an error message to the form.
     */
    private void inputValidate(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        
    }
    
    /*
     * get the form data. Perform calculations and save results into datastore if user has logged
     * in.
     */
    private void calculation(HttpServletRequest req) throws IOException, ServletException {
        SolarCalculator calc = new SolarCalculator();
        
        // Entity statics
        String systemLocation = req.getParameter("confirmedLocation");
        double systemCost = Double.parseDouble(req.getParameter("systemCost"));// need to convert
        double systemSize = Double.parseDouble(req.getParameter("systemSize"));
        double hoursOfSunlight = Double.parseDouble(req.getParameter("hoursOfSunlight"));// daily
        
        // Check for more than one panel bank
        double numberOfPanels1 = Double.parseDouble(req.getParameter("numberOfPanels1"));
        double panelOrientation1 = Double.parseDouble(req.getParameter("panelOrientation1"));// orientation
        
        // new added
        double panelEfficiencyLoss = Double.parseDouble(req.getParameter("panelEfficiencyLoss"));// orientation
        
        // new added
        double replacementCost = Double.parseDouble(req.getParameter("replacementCost"));// orientation
        
        double tariffRate = Double.parseDouble(req.getParameter("tariffRate1"));
        // new added
        double tariffIncrease = Double.parseDouble(req.getParameter("tariffIncrease"));
        // new added
        double tariffPercentage1 = Double.parseDouble(req.getParameter("tariffPercentage1"));
        // new added
        double feedinTariff = Double.parseDouble(req.getParameter("feedinTariff"));
        // new added
        
        double inverterEfficiency = Double.parseDouble(req.getParameter("inverterEfficiency"));
        
        double dailyPowerUsage = Double.parseDouble(req.getParameter("dailyPowerUsage"));// daily
        // new added
        double daytimePowerUsage = Double.parseDouble(req.getParameter("daytimePowerUsage"));// daily
        
        double dailySolarGeneration = calc.calculateDailyGeneration(systemSize,
                inverterEfficiency / 100, hoursOfSunlight, panelOrientation1, 1);
        
        double annualSolarGeneration = calc.calculateAnnualGeneration(systemSize,
                inverterEfficiency / 100, hoursOfSunlight, panelOrientation1, 1);
        
        double dailySolarUsed = calc.calcDailySolarUsed(daytimePowerUsage, hoursOfSunlight);
        
        double dailySolarExported = calc.calcDailySolarExported(dailySolarGeneration,
                dailySolarUsed);
        
        double dailySavings = calc.calcDailySavings(dailySolarUsed, tariffRate, dailySolarExported,
                feedinTariff);
        
        double annualSavings = calc.calcAnnualSavings(dailySavings);
        
        double cumulativeSavings = calc.calcCumulativeSavings(annualSavings);
        
        double breakEvenPoint = calc.calcBreakEvenPoint(systemCost, annualSavings);
        
        double investmentReturn = calc.calcInvestmentReturn(systemCost);
        
        // also be stored in datastore
        String content = "Details of the system: " + "\n" + "\tSize:  "
                + req.getParameter("systemSize")
                + "kw"
                + "\n"
                + "\tCost:  "
                + "$"
                + req.getParameter("systemCost")
                + "\n"
                + "\tNumber of panels:  "
                + req.getParameter("numberOfPanels1")
                + "\n"
                + "\tOrientation of the panels:  "
                + req.getParameter("panelOrientation1")
                + "\n\n"
                + "User defined information: "
                + "\n"
                + "\tSystem location:  "
                + req.getParameter("systemLocation")
                + "\n"
                + "\tHours of sunlight:  "
                + req.getParameter("hoursOfSunlight")
                + " per day"
                + "\n"
                + "\tElectricity usage of user:  "
                + req.getParameter("dailyPowerUsage")
                + "kWh per day"
                + "\n"
                + "\tTariff rate:  "
                + req.getParameter("tariffRate1")
                + "\n\n"
                + "Daily power generation of the system: "
                + dailySolarGeneration
                + "kWh\n"
                + "Annual power generation of the system: "
                + annualSolarGeneration
                + "kWh\n"
                + "Daily solar used: "
                + dailySolarUsed
                + "kWh\n"
                + "Daily solar exported: "
                + dailySolarExported
                + "kWh\n"
                + "Daily savings: $"
                + dailySavings
                + "\n"
                + "Annual savings: $"
                + annualSavings
                + "\n"
                + "Cumulative savings: $"
                + cumulativeSavings
                + "\n"
                + "You will break even after: "
                + breakEvenPoint
                + " years\n"
                + "The equivalent investment return after 25 years would be: $"
                + investmentReturn
                + "\n"
                + "----------------------------------------------------------------------------\n\n";
        
        calResults = content;
        
        // initiate user service and store data
        UserService userService = UserServiceFactory.getUserService();
        // get current user
        User user = userService.getCurrentUser();
        // if user is logged in, store data into datastore
        if (user != null) {
            /*
             * Create the key, store data entity into the parent of this entity
             */
            // create new key called 'result' under the current user
            Key resultKey = KeyFactory.createKey("result", user.getUserId());
            
            Date date = new Date();
            // create new entity under the ancestor resultKey
            Entity result = new Entity("calculation", resultKey);
            // set the properties of new entity 'result'
            result.setProperty("user", user);
            result.setProperty("date", date);
            result.setProperty("content", content);
            
            // initial datastore service and put entity 'result' into datastore
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            datastore.put(result);
        }
    }
    
    private String getIPAddress() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
            return ip.toString();
            
        } catch (UnknownHostException e) {
            
            e.printStackTrace();
            
        }
        return "Ip address not found";
        
    }
    
}