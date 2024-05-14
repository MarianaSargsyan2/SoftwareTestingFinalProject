import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class ProductPageTest extends BaseTest{

    //check if the add to cart button is displayed
    @Test
    public void addToCartButtonIsDisplayedTest(){
        HomePage homePage = new HomePage(driver);
        String searchTerm = "սալիկ";
        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        ProductPage productPage = searchPage.getProduct(1);
        assertTrue(productPage.getAddToCartButton().isDisplayed(), "Cart notification not displayed");

    }

    //testing add to cart button



}
