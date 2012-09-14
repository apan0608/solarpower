//package solarpowertest;
//
//import java.util.LinkedHashMap;
//import solarpower.servlets.SolarpowerServlet;
//
//import net.sourceforge.jwebunit.junit.*;
//
//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class SolarpowerServletTest {
//    
//	private WebTester tester;
//    
//	@Before
//	public void prepare() {
//        tester = new WebTester();
//        tester.setBaseUrl("http://localhost:8888");
//    }
//	
//	// test the pages actually exist
//	@Test
//    public void homePageTest() {
//    	tester.beginAt("index.jsp"); // Open the browser on http://localhose:8888/index.jsp
//    	tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.HOME"); // the home page should be titled "HOME"
//    }
//	
//	// I'm assuming we'll have a different page for login?
//	@Test
//    public void loginPageTest() {
//    	tester.beginAt("login.jsp"); // Open the browser on http://localhose:8888/login.jsp
//    	tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.LOGIN"); // the login page should be titled "LOGIN"
//    }
//	
//	@Test
//    public void calculatePageTest() {
//    	tester.beginAt("calculate.jsp"); // Open the browser on http://localhose:8888/calculate.jsp
//    	tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.CALCULATE"); // the calculate page should be titled "CALCULATe"
//    }
//	
//	// test pages links
//	
//	// go to login page from home page
//    @Test
//    public void homeToLoginPageLinkTest() {
//        tester.beginAt("index.jsp"); 
//        tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.HOME"); 
//        tester.assertLinkPresent("Login"); // there should be a "Login" link
//        tester.clickLink("Login"); // click the link
//        tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.LOGIN"); // we should now be on the login page
//    }
//    
//    // go to calculate page from home page
//    @Test
//    public void HomeToCalcPageLinkTest() {
//        tester.beginAt("index.jsp"); 
//        tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.HOME"); 
//        tester.assertLinkPresent("Calculate"); // there should be a "Calculate" link
//        tester.clickLink("Calculate"); // click the link
//        tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.CALCULATE"); // we should now be on the Calculate page
//    }
//    
//    // go to home page from login page
//    public void loginToHomePageLinkTest() {
//        tester.beginAt("login.jsp"); 
//        tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.LOGIN"); 
//        tester.assertLinkPresent("Home"); // there should be a "Home" link
//        tester.clickLink("Home"); // click the link
//        tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.HOME"); // we should now be on the Home page
//    }
//    
//    // go to home page from calculate page
//    @Test
//    public void calcToHomePageLinkTest() {
//    	tester.beginAt("calculate.jsp"); 
//        tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.CALCULATE"); 
//        tester.assertLinkPresent("Home"); // there should be a "Home" link
//        tester.clickLink("Home"); // click the link
//        tester.assertTitleEquals("solarpower.servlets.SolarpowerServlet.HOME"); // we should now be on the Home page
//    }
//    
//    // test logging in
//    @SuppressWarnings("deprecation")
//	@Test
//    public void testLogin() {
//        tester.beginAt("login.jsp");
//        tester.assertTitleEquals("Login");    // we should be on the login page
//
//        // fill out the form
//        tester.assertLinkNotPresent("Logout"); // there shouldn't be a "Logout" link yet since we're not logged in yet
//        tester.assertFormPresent("loginForm");
//        tester.assertFormElementPresent("user");
//        tester.assertFormElementPresent("password");
//        tester.setTextField("user", "cedric");
//        tester.setTextField("password", "test123");
//        tester.assertFormElementEquals("user", "cedric");
//        tester.submit();
//        
//        // now that we have filled out the form, we should now be logged in
//        // we can assert that we can logout
//        tester.assertLinkPresent("Logout");	
//    }
//
//	
//    @Test
//    public void buildSystemSizesTest() {
//        LinkedHashMap<String, Double> sizes = SolarpowerServlet.BuildSystemSizes();
//        assertEquals((Double)1.0, sizes.get("1kW"));
//    }
//    
//    @Test
//    public void buildNoOfPanelsTest() {
//        LinkedHashMap<String, Integer> noOfPanels = SolarpowerServlet.BuildNoOfPanels();
//        assertEquals((Integer)4, noOfPanels.get("4"));
//    }
//    
//    @Test
//    public void buildPanelsOrientationTest() {
//        LinkedHashMap<String, Integer> panelsOrientation = SolarpowerServlet.BuildPanelsOrientation();
//        assertEquals((Integer)20, panelsOrientation.get("20 degrees"));
//    }
//    
// }