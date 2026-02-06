package base;

import driver.BrowserFactory;
import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import page_objects.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws IOException {
        WebDriver driver_obj = BrowserFactory.createDriver(browser);
        DriverFactory.getInstance().setDriver(driver_obj);
        WebDriver driver = DriverFactory.getInstance().getDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().quitDriver();
    }
}
