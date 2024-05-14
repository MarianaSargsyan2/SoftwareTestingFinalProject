import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class SearchPageTest extends BaseTest{

    //testing whether the button to sort by price form high to low is present
    @Test
    public void sortByPriceHighToLowIsDisplayedTest() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        String searchTerm = "doors";

        homePage.searchForProduct(searchTerm);


    }

    @Test
    public void sortByPriceLowToHighIsDisplayedTest() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        String searchTerm = "doors";

        homePage.searchForProduct(searchTerm);

        //WebElement sortFromHighToLowButton = searchPage.getPriceLowToHighButton();
      //  assertTrue(sortFromHighToLowButton.isDisplayed(), "Button is not visible");

    }

    //testing that products are sorted by price from low to high
    @Test
    public void sortedLowToHighTest() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "սալիկ";
        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        searchPage.sortByPriceLowToHigh();
        double[] sortedPrice = new double[searchPage.productSize()];
        for (int i = 0; i < searchPage.productSize(); ++i) {
            sortedPrice[i] = searchPage.getProductPriceAsNumber(i);
        }

        for (int i = 0; i < sortedPrice.length - 1; i++) {
            assertTrue(sortedPrice[i] <= sortedPrice[i + 1]);
        }

    }

    //testing that products are sorted by price from high to low
    @Test
    public void sortedHighToLowTest() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "սալիկ";
        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        searchPage.sortByPriceHighToLow();
        double[] sortedPrice = new double[searchPage.productSize()];
        for (int i = 0; i < searchPage.productSize(); ++i) {
            sortedPrice[i] = searchPage.getProductPriceAsNumber(i);
        }

        for (int i = 0; i < sortedPrice.length - 1; i++) {
            assertTrue(sortedPrice[i] >= sortedPrice[i + 1]);
        }

    }

    @Test
    public void addToCartTest(){
        HomePage homePage = new HomePage(driver);
        Cart cart = homePage.openTheCart();
        int currentNumberOfElements = cart.getNumberOfItemInCart();
        String searchTerm = "սալիկ";
        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        searchPage.addToCart(0);
        ProductPage product1 = searchPage.saveProduct(0);
        cart = homePage.openTheCart();
        assertTrue(cart.getNumberOfItemInCart() == currentNumberOfElements + 1);
        assertTrue(cart.getCartElements().contains(product1));

    }

}
