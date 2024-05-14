import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nortun.am/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
