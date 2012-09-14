/**
 * 
 */
package solarpower.entities;

import org.apache.jasper.servlet.JspServlet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * @author Shenchen Pan
 * 
 *         Entity class are already implemented for data store. Do we really need a customized
 *         entity??? This entity class is to store the data of a certain solarpower system.
 *         Including size, cost, number of panels, panel efficiency loss, inverter efficiency,
 *         inverter replacement, inverter cost
 * 
 */

public class solarpowerSystems extends com.google.apphosting.api.DatastorePb.GetResponse.Entity {
    
    public static int size;
    public static double cost;
    public static int noOfPanels;
    public static double efficiencyLoss;
    public static double inverterEfficiency;
    public static double inverterReplacement;
    public static double inverterCost;
    
    private solarpowerSystems() {
    }
    
}