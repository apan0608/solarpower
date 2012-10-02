package solarpowertest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://mgsdtech.appspot.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("systemLocation")).clear();
        driver.findElement(By.id("systemLocation")).sendKeys("100 Test St");
        driver.findElement(By.id("confirmLocation")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (driver.findElement(By.id("divConfirmedLocation")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        new Select(driver.findElement(By.id("confirmedLocation"))).selectByVisibleText("100 Test St, South Hill, Oamaru 9400, New Zealand");
        driver.findElement(By.id("systemCost")).clear();
        driver.findElement(By.id("systemCost")).sendKeys("15000");
        new Select(driver.findElement(By.id("systemSize"))).selectByVisibleText("3kW");
        new Select(driver.findElement(By.id("numberOfPanels1"))).selectByVisibleText("10");
        new Select(driver.findElement(By.id("panelOrientation1"))).selectByVisibleText("N (0°)");
        driver.findElement(By.id("panelEfficiencyLoss")).clear();
        driver.findElement(By.id("panelEfficiencyLoss")).sendKeys("0.8");
        driver.findElement(By.id("inverterEfficiency")).clear();
        driver.findElement(By.id("inverterEfficiency")).sendKeys("95");
        driver.findElement(By.id("no")).click();
        new Select(driver.findElement(By.name("hoursOfSunlight"))).selectByVisibleText("6");
        driver.findElement(By.id("dailyPowerUsage")).clear();
        driver.findElement(By.id("dailyPowerUsage")).sendKeys("40");
        driver.findElement(By.id("daytimePowerUsage")).clear();
        driver.findElement(By.id("daytimePowerUsage")).sendKeys("20");
        driver.findElement(By.id("tariffRate1")).clear();
        driver.findElement(By.id("tariffRate1")).sendKeys("20");
        driver.findElement(By.id("tariffPercentage1")).clear();
        driver.findElement(By.id("tariffPercentage1")).sendKeys("100");
        driver.findElement(By.id("additionalFees")).clear();
        driver.findElement(By.id("additionalFees")).sendKeys("250");
        driver.findElement(By.id("tariffIncrease")).clear();
        driver.findElement(By.id("tariffIncrease")).sendKeys("6");
        driver.findElement(By.id("feedinTariff")).clear();
        driver.findElement(By.id("feedinTariff")).sendKeys("10");
        driver.findElement(By.name("calculationDataForm")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}