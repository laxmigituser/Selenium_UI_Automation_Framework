package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentFactory;
import reports.ExtentManager;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {
    static ExtentReports report;
    static ExtentTest test;

    public void onTestStart(ITestResult result) {
        //before each TC
        test = report.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }
    public void onTestSuccess(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test case: "+ result.getMethod().getMethodName()+" is passed");
        ExtentFactory.getInstance().removeExtentObj();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test case: "+ result.getMethod().getMethodName()+" is failed");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
        //code for screenshot
        try {
            String screenshotPath = ScreenshotUtils.captureScreenshot(result.getName());
            if(screenshotPath != null){
                ExtentFactory.getInstance().getExtent().fail("Test Failed")
                        .addScreenCaptureFromPath(screenshotPath);

            }
             } catch (Exception e) {
            e.printStackTrace();
        }


//        File src=((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
//        Date date = new Date();
//        String actualdate = format.format(date);
//        String sspath = System.getProperty("user.dir")+
//                "/Reports/screenshots/"+actualdate+".jpeg";
//        File dest = new File(sspath);
//        try {
//            FileUtils.copyFile(src,dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //add ss to report
//        ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(sspath, "TC Failure ss");
        ExtentFactory.getInstance().removeExtentObj();
    }

    public void onTestSkipped(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test case: "+ result.getMethod().getMethodName()+" is skipped");
        ExtentFactory.getInstance().removeExtentObj();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    public void onStart(ITestContext context) {
        //setup the extent object
        try {
            report = ExtentManager.setUpExtentReport();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onFinish(ITestContext context) {
        //close extent object
        report.flush();

    }
}
