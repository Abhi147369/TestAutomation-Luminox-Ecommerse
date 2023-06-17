package extentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportExample {
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        // Initialize the extent report
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Create a test instance
        test = extent.createTest("Extent Report Example", "This is an example test case");
    }

    @Test
    public void testMethod() {
        // Log test steps and status
        test.log(Status.INFO, "Starting the test");
        test.log(Status.PASS, "Test step 1 passed");
        test.log(Status.PASS, "Test step 2 passed");
        test.log(Status.FAIL, "Test step 3 failed");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Log the test result
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        } else {
            test.log(Status.PASS, "Test Passed");
        }

        // End the test and generate the report
        extent.flush();
    }
}
