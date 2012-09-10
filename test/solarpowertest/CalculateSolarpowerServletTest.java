package solarpowertest;

import static org.junit.Assert.*;

import java.io.IOException;

//import net.sourceforge.jwebunit.junit.WebTester;
//import net.sourceforge.jwebunit.util.TestingEngineRegistry;

import org.junit.Before;
import org.junit.Test;

import solarpower.servlets.CalculateSolarpowerServlet;
//import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class CalculateSolarpowerServletTest{
    
    //NEED TO ADD SELENIUM LIBRARY TO BUILD PATH FOR TESTING AND USE IT INSTEAD OF JWEBUNIT
    //I WILL FIGURE OUT HOW TO DO THIS --DANE
    
	private static final String WEBSITE_URL = "http://localhost:8888/solarpower";
//	private WebTester webTester;
//    @Before
//    public void start() {
//        webTester = new WebTester();
//        webTester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
//        webTester.getTestContext().setBaseUrl(WEBSITE_URL);
//   
//    }
//    
//    @Test
//    public void sanity() throws Exception {
//        webTester.beginAt("/index.jsp");
//        webTester.assertTitleEquals("Solar Power Calculator");
//    }
}
    


