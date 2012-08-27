package solarpower;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.util.Date;
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
	
//private static String CALCULATE = "/calculate.jsp";
private static String HOME ="/index.jsp";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
//		if(req.getParameterMap().containsKey("calculate")){
//            resp.sendRedirect(CALCULATE);
//		} else {
			resp.sendRedirect(HOME);
//		}
        
    }
}
