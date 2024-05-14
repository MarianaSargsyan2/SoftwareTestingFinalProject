import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public static WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }
}
