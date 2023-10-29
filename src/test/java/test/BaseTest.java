package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.geco.driver","C:\\Users\\jakub\\OneDrive\\Pulpit\\Programowanko\\Selenium\\gecodriver-v0.33.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
