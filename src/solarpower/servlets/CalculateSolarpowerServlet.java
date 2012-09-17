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

/*
 * Perform all kinds of calculations. And in later development, enable user service 
 * and save results to datastore.
 * @author Shenchen Pan 
 * */
public class CalculateSolarpowerServlet extends HttpServlet implements Servlet {
    
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
        
        String calculate = req.getParameter("calculationDataForm");
        String submit = "Submit";
        if (calculate.equalsIgnoreCase(submit)) {
            calculate(req, resp);         
        }
    }
    
    private void calculate(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {
        
        System.getProperty("user.name");
        System.out.println(System.getProperty("user.name"));
        // req.setAttribute("location", System.getProperty("user.name"));
        String ip = getIPAddress();
        req.setAttribute("location", ip);
        
        double generation = 0.0;
        // Entity statics =
        String systemLocation = req.getParameter("systemLocation");
        double systemCost = Double.parseDouble(req.getParameter("systemCost"));// need to convert
        double systemSize = Double.parseDouble(req.getParameter("systemSize"));
        double hoursOfSunlight = Double.parseDouble(req.getParameter("hoursOfSunlight"));// daily
        double numberOfPanels = Double.parseDouble(req.getParameter("numberOfPanels1"));
        double panelOrientation = Double.parseDouble(req.getParameter("panelOrientation1"));// orientation
        double tariffRate = Double.parseDouble(req.getParameter("tariffRate1"));
        
        double dailyPowerUsage = Double.parseDouble(req.getParameter("dailyPowerUsage"));// monthly
        
        // also be stored in datastore
        String content = "Details of the system: " + "\n" + "\tSize:  "
                + req.getParameter("systemSize")
                + "kwh"
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
                + "kw per day"
                + "\n"
                + "\tTariff rate:  "
                + req.getParameter("tariffRate1")
                + "\n\n"
                + "The daily electricity generation of the systen is: "
                + generation
                + "kw"
                + "\n"
                + "----------------------------------------------------------------------------\n\n";
        
        req.setAttribute("history", content);
        // initiate user service and store data
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        // if user not logged in yet, go back to calculate page and not store data
        if (user == null) {
        	req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        
        /*
         * Create the key, store data entity into the parent of this entity
         */
        Key resultKey = KeyFactory.createKey("result", user.getUserId());
        
        Date date = new Date();
        Entity result = new Entity("calculation", resultKey);
        result.setProperty("user", user);
        result.setProperty("date", date);
        result.setProperty("content", content);
        
        // initial datastore service and put entity in datastore
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(result);
        
        req.setAttribute("userid", user.getUserId());
        req.setAttribute("selectedlocation", systemLocation);
        req.getRequestDispatcher("/index.jsp?result " + "something").forward(req, resp);
        
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