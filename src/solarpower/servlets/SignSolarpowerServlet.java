// WE SHOULDN'T NEED THIS SERVLET

package solarpower.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class SignSolarpowerServlet extends HttpServlet implements Servlet {
	 /**
     * use for later, after the web interface is implemented. 
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
             throws IOException {
       UserService userService = UserServiceFactory.getUserService();
       User user = userService.getCurrentUser();
       if (user != null) {
           resp.setContentType("text/plain");
           resp.getWriter().println("Hello, " + user.getNickname());
       } else {
           resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
       }
   }

}
