// src/main/java/utils/ScreenshotUtils.java
package utils;

import driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static String captureScreenshot(String testName) {
        try {
            WebDriver driver = DriverFactory.getInstance().getDriver();
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String destPath = System.getProperty("user.dir") + "/Reports/screenshots/" + testName + "_" + timestamp + ".png";
            File destFile = new File(destPath);
            FileUtils.copyFile(srcFile, destFile);
            // Return relative path for report embedding
            return "screenshots/" + testName + "_" + timestamp + ".png";
        } catch (Exception e) {
            return null;
        }
    }
}