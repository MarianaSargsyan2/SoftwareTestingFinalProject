import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart extends BasePage {

    public Cart(WebDriver driver) {
        super(driver);
    }


    public String getCartPageTitle() {
        return driver.findElements(CartLocators.pageTitle).get(0).getText();
    }

    public List<WebElement> getCartElements() {
        return driver.findElements(CartLocators.poductsList);
    }



    public int getNumberOfItemInCart() {
        if(getCartPageTitle().equals("Զամբյուղ")) {
            return driver.findElements(CartLocators.poductsList).size();
        }
         return 0;
    }

    public int getProductQuantity(int index){
        String numStr = driver.findElements(CartLocators.poductsList).get(index).findElements(CartLocators.productQuantityLocator).get(index).toString();
        int quantity = Integer.parseInt(numStr);
        return quantity;
    }

    public WebElement getPlusButton(int idex){
        return driver.findElements(CartLocators.plusButtonLocator).get(idex);
    }

    public WebElement getMinusButton(int idex){
        return driver.findElements(CartLocators.minusButtonLocator).get(idex);
    }

    public WebElement getRemoveAll() {
        return findElement(CartLocators.removeAllLocator);
    }

    public WebElement getRemoveButton(int index) {
        return driver.findElements(CartLocators.removeLocator).get(index);
    }
}
