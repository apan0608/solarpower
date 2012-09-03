// WE SHOULDN'T NEED THIS SERVLET

package solarpower;

import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.jasper.servlet.JspServlet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/*
 * Perform all kinds of calculations. And in later development, enable user service 
 * and save results to datastore.
 * @author Shenchen Pan 
 * */
public class CalculateSolarpowerServlet extends HttpServlet implements Servlet{

	//implement it to automatically track user's location and pre fill the form 
//	public void doGet(HttpServletRequest req, HttpServletResponse resp)
//             throws IOException {
//      resp.sendRedirect("/calculate.jsp");

//   }
	
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
		double generation = 0.0;
		//Entity statics = 
		String loc = req.getParameter("location");
		double cost = Double.parseDouble(req.getParameter("cost"));//need to convert
		double size = Double.parseDouble(req.getParameter("size"));
		int hours = Integer.parseInt(req.getParameter("hoursOfSun"));//daily
		double tariff = Double.parseDouble(req.getParameter("tariff"));
		int numOfPanels = Integer.parseInt(req.getParameter("numOfPanels"));
		int oriOfPanels = Integer.parseInt(req.getParameter("oriOfPanels"));
		double usage =  Double.parseDouble(req.getParameter("usage"));//monthly
		
		//initiate user service and store data
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
		//if user not logged in yet, go back to calculate page and not store data
        if(user.getUserId() == null){
        	req.setAttribute("selectedlocation", loc);
    		//redirect to /calculate page, send data of loc to the page
    		req.getRequestDispatcher("/calculate.jsp").forward(req, resp);

        }
        
        Key result = KeyFactory.createKey("result", user.getUserId());
        String content = req.getParameter("location") + req.getParameter("cost") +
        		req.getParameter("size") + req.getParameter("hoursOfSun")+
        		req.getParameter("tariff") + req.getParameter("numOfPanels") +
        		req.getParameter("oriOfPanels") + req.getParameter("usage") + 
        		"the calculation result is: " + generation;
        Date date = new Date();
//        The following code snippet constructs the Greeting entity in the 
//         same entity group as the guestbook to which it belongs:
//        result set the parent of the entity, calculation" is the entity name 
        Entity Calculation = new Entity("calculation", result);
        Calculation.setProperty("user", user);
        Calculation.setProperty("date", date);
        Calculation.setProperty("content", content);
//         initial datastore service and out entity in datastore
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(Calculation);
        
        resp.sendRedirect("/calculate.jsp?result=" + "something");
		
		
		
//		req.setAttribute("selectedlocation", loc);
		//redirect to /calculate page, send data of loc to the page
//		req.getRequestDispatcher("/calculate.jsp").forward(req, resp);

        //resp.sendRedirect("/calculate.jsp");

  }
	
	
}
