/**
 * This servlet retrive the history calculation results of a user and display it in the 
 * calculate.jsp page.
 */
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

/**
 * @author Administrator
 *
 */
public class HistoryResultsServlet extends HttpServlet implements Servlet{
	
	 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		 showhistory(req, resp);

	    }
	
	
	 public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,
	        ServletException {
			 clearHistory(req, resp);		 	    	 
	 }
	 
	 private void showhistory(HttpServletRequest req, HttpServletResponse resp) throws IOException,
     ServletException {
		 /*initial user service, and get user information.
		 if user logged in, show data. Otherwise, redirected user to login page*/
	     UserService userService = UserServiceFactory.getUserService();
	     User user = userService.getCurrentUser();
	    if (user == null) {
	    	resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
	     }
	    
		 /*initial data store service and get history calculation data that's stored
		  in datastore to display on the calculate.jsp page*/
		 Key resultKey = KeyFactory.createKey("result", user.getUserId());
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		 
	     String calresults = "";
	     Query query = new Query("calculation", resultKey).addSort("date",
	               Query.SortDirection.DESCENDING);
	     List<Entity> results = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
	     if (results.isEmpty()) {
	         calresults = "This is no history results to display.";
	     } else {
	         for (Entity aresult : results) {
	             calresults += (aresult.getProperty("date") + "\n" + aresult.getProperty("content") + "\n\n");
	         }
	     }	        
	     req.setAttribute("history", calresults);
	     req.getRequestDispatcher("/calculate.jsp?result=").forward(req, resp);	        	
	 }
	
	
	
	 private void clearHistory(HttpServletRequest req, HttpServletResponse resp) throws IOException,
     ServletException {
		 UserService userService = UserServiceFactory.getUserService();
	     User user = userService.getCurrentUser();
	     Key resultKey = KeyFactory.createKey("result", user.getUserId());
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		 
		 Query query = new Query("calculation", resultKey).addSort("date",
	                Query.SortDirection.DESCENDING);
	        List<Entity> results = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
	        if (!results.isEmpty()) {
	            for (Entity aresult : results) {
	                datastore.delete(aresult.getKey());
	                }
	        }
		 	 
	     resp.sendRedirect("/calculate.jsp?result=cleardata");
	 
	 }

}
