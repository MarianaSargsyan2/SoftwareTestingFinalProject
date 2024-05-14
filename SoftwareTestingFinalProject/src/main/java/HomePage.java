import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchBox() {
        return findElement(HomePageLocators.searchBoxLocator);
    }

    public WebElement getSearchIcon(){
        return findElement(HomePageLocators.searchIcon);
    }

    public SearchPage searchForProduct(String productName) {
        WebElement searchBox = getSearchBox();
        WebElement searchIcon = getSearchIcon();
        searchBox.sendKeys(productName);
        searchIcon.click();
        return new SearchPage(driver);
    }

    public WebElement getCart() {
        return driver.findElements(HomePageLocators.cartButton).get(1);
    }

    public Cart openTheCart(){
        WebElement cart = getCart();
        cart.click();
        return new Cart(driver);
    }
}
