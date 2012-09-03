// USE THIS SERVLET

package solarpower;

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
        resp.sendRedirect(HOME);
        // }
        
        // make collections available to JSP
        req.setAttribute("systemSizes", BuildSystemSizes());
        
        
    }
    
    // build collections for form
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
    
   
}
