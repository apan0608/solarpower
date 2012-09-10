// USE THIS SERVLET

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
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.taskdefs.XSLTProcess.Factory;

public class SolarpowerServlet extends HttpServlet implements Servlet {
    
    // private static String CALCULATE = "/calculate.jsp";
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static String HOME = "/index.jsp";
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        // if(req.getParameterMap().containsKey("calculate")){
        // resp.sendRedirect(CALCULATE);
        // } else {
        //resp.sendRedirect(HOME);
        // }
        
    }

// added this but i don't know if we're still gonna use it?
/*    // build collections for form
    public static LinkedHashMap<String, Double> BuildSystemSizes() {
        LinkedHashMap<String, Double> systemSizes = new LinkedHashMap<String, Double>();
        
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
        
        return systemSizes;
    }
    
    public static LinkedHashMap<String, Integer> BuildNoOfPanels() {
        LinkedHashMap<String, Integer> noOfPanels = new LinkedHashMap<String, Integer>();
        
        noOfPanels.put("4", 4);
        noOfPanels.put("6", 6);
        noOfPanels.put("8", 8);
        noOfPanels.put("10", 10);
        noOfPanels.put("12", 12);      
        noOfPanels.put("14", 14);
        noOfPanels.put("16", 16);
        noOfPanels.put("18", 18);
        noOfPanels.put("20", 20);
        
        return noOfPanels;
    }
    
    public static LinkedHashMap<String, Integer> BuildPanelsOrientation() {
        LinkedHashMap<String, Integer> panelsOrientation = new LinkedHashMap<String, Integer>();
    	
    	panelsOrientation.put("20 degrees", 20); 
    	panelsOrientation.put("25 degrees", 25); 
    	panelsOrientation.put("30 degrees", 30); 
    	panelsOrientation.put("35 degrees", 35); 
    	panelsOrientation.put("40 degrees", 40); 
    	panelsOrientation.put("45 degrees", 45); 
    	panelsOrientation.put("50 degrees", 50); 
    	panelsOrientation.put("55 degrees", 55); 
    	panelsOrientation.put("60 degrees", 60); 
    	
    	return panelsOrientation;
    }*/
    
    
}
