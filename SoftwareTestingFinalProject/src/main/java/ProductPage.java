import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        return findElement(ProductPageLocators.addToCartButtonLocator);
    }


    public void addToCart(int index) {
        driver.findElements(ProductPageLocators.addToCartButtonLocator).get(index).click();
    }
}
