import org.openqa.selenium.By;

public class CartLocators {
    public static final By removeAllLocator = By.className("remove_all");
    public static final By removeLocator = By.className("remove");
    public static final By pageTitle = By.cssSelector("h1.basket_block_title");
    public static final By poductsList = By.cssSelector("button.addBasketLinck");
    public static final By productQuantityLocator = By.className("basket-item-amount-filed-block");
    public static final By plusButtonLocator = By.className("basket-item-amount-btn-plus");
    public static final By minusButtonLocator = By.className("basket-item-amount-btn-minus");
}

