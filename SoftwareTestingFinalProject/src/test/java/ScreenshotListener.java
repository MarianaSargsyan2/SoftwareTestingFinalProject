import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BasePage) result.getInstance()).driver;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = new File("screenshots/" + result.getName() + ".png");
        screenshot.getScreenshotAs(OutputType.FILE);
    }
}
