import org.junit.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest{

    @Test
    public void addItemQuantityTest(){
        HomePage homePage = new HomePage(driver);
        String searchTerm = "սալիկ";
        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        searchPage.addToCart(0);
        searchPage.addToCart(1);
        Cart cart = homePage.openTheCart();
        int quantity = cart.getProductQuantity(0);
        cart.getPlusButton(0).click();
        assertTrue(cart.getProductQuantity(0) == quantity++);

    }

    @Test
    public void reduceItemQuantityTest(){
        HomePage homePage = new HomePage(driver);
        String searchTerm = "սալիկ";
        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        searchPage.addToCart(0);
        searchPage.addToCart(1);
        Cart cart = homePage.openTheCart();
        int quantity = cart.getProductQuantity(0);
        if(quantity == 1) {
            cart.getMinusButton(0).click();
            assertTrue(cart.getNumberOfItemInCart() == quantity);
        }
        cart.getMinusButton(0).click();
        assertTrue(cart.getProductQuantity(0) == quantity--);

    }

    @Test
    public void removeAllTest() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "սալիկ";
        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        searchPage.addToCart(0);
        searchPage.addToCart(1);
        Cart cart = homePage.openTheCart();
        cart.getRemoveAll().click();
        assertTrue(cart.getNumberOfItemInCart() == 0);

    }

    @Test
    public void removeItemTest() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "սալիկ";
        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        searchPage.addToCart(0);
        searchPage.addToCart(1);
        Cart cart = homePage.openTheCart();
        int numberOfItems = cart.getNumberOfItemInCart();
        cart.getRemoveButton(0).click();
        assertTrue(cart.getNumberOfItemInCart() == numberOfItems--);

    }
}
