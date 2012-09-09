// WE SHOULDN'T NEED THIS SERVLET

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
public class CalculateSolarpowerServlet extends HttpServlet implements Servlet{

	//implement it to automatically track user's location and pre fill the form 
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
             throws IOException {
      resp.sendRedirect("/calculate.jsp");

   }
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    /*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {  	
		
		String calculate = req.getParameter("calculationDataForm");
		String clear = req.getParameter("ClearDataForm");
		String submit="Submit";
		//if the request sent from index.jsp. do calculate
		if(calculate.equalsIgnoreCase(submit)){
			calculate(req,resp);
			//System.out.println(calculate.equalsIgnoreCase("Submit"));
		} else if(clear.equalsIgnoreCase(submit)) {
			
			 resp.sendRedirect("/calculate.jsp?result=" + "failed");
		}
  }
	
	private void calculate(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {  

		System.getProperty("user.name");
		System.out.println(System.getProperty("user.name"));
		//req.setAttribute("location", System.getProperty("user.name"));
		String ip = getIPAddress();
		req.setAttribute("location", ip);
		
		double generation = 0.0;
		//Entity statics = 
		String loc = req.getParameter("location");
		double cost = Double.parseDouble(req.getParameter("cost"));//need to convert
		double size = Double.parseDouble(req.getParameter("size"));
		int hours = Integer.parseInt(req.getParameter("hoursOfSun"));//daily
		double tariff = Double.parseDouble(req.getParameter("tariff"));
		int numOfPanels = Integer.parseInt(req.getParameter("numOfPanels"));
		int oriOfPanels = Integer.parseInt(req.getParameter("oriOfPanels"));//orientation
		double usage =  Double.parseDouble(req.getParameter("usage"));//monthly
			
		//also be stored in datastore 
		String content = "Details of the system: " + "\n" + 
                "\tSize:  " + req.getParameter("size") + "kwh" + "\n" +
        		"\tCost:  " + "$" + req.getParameter("cost") + "\n" +
                "\tNumber of panels:  " + req.getParameter("numOfPanels") + "\n" +
        		"\tOrientation of the panels:  " + req.getParameter("oriOfPanels") + "\n\n" +
                "User defined information: " + "\n" +
        		"\tLocation:  " + req.getParameter("location") + "\n" +
                "\tHours of sunlight:  "  + req.getParameter("hoursOfSun") + " per day" + "\n" +
        		"\tElectricity usage of user:  " + req.getParameter("usage") + "kw per day" + "\n" +
                "\tTariff:  " + req.getParameter("tariff") + "\n\n" +
        		"The daily electricity generation of the systen is: " + generation + "kw" + "\n" +
                "----------------------------------------------------------------------------\n\n";  
        
		
		//initiate user service and store data
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
		//if user not logged in yet, go back to calculate page and not store data
        if(user == null){
        	req.setAttribute("history", content);
    		//redirect to /calculate page, send data of loc to the page
    		req.getRequestDispatcher("/calculate.jsp").forward(req, resp);
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
               
        //initial datastore service and put entity in datastore
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(result);

        //retrieve all the calculation data of a user from data store, and display 

        
        String calresults = "";
        // Run an ancestor query to ensure we see the most up-to-date
        // view of the Greetings belonging to the selected Guestbook.
        Query query = new Query("calculation", resultKey).addSort("date", Query.SortDirection.DESCENDING);
        List<Entity> results = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
        if (results.isEmpty()) {
            calresults = "This is no history results to display.";
        } else {
            for (Entity aresult : results) {
            	calresults += (aresult.getProperty("date") + "\n" + aresult.getProperty("content") + "\n\n");
                }               
        }
      
        req.setAttribute("history", calresults);       
 //       resp.sendRedirect("/calculate.jsp?result=" + "something");
		req.setAttribute("userid", user.getUserId());		
		req.setAttribute("selectedlocation", loc);
		//redirect to /calculate page, send data of loc to the page
		//req.getRequestDispatcher("/calculate.jsp").forward(req, resp);
		req.getRequestDispatcher("/calculate.jsp?result="+"something").forward(req, resp);
	
	}
	
	private String getIPAddress(){
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
