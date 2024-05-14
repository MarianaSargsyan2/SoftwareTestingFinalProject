import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.Locale;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    //check whether the search field is present
    @Test
    public void searchBoxIsPresentTest() {
        HomePage homePage = new HomePage(driver);
        WebElement searchBox = homePage.getSearchBox();
        assertTrue(searchBox.isDisplayed());
    }

    //testing if the search icon is displayed
    @Test
    public void searchIconIsDisplayedTest() {
        HomePage homePage = new HomePage(driver);
        WebElement searchIcon = homePage.getSearchIcon();
        assertTrue(searchIcon.isDisplayed());
    }

    //testing that empty search navigates to the page with 0 results
    @Test
    public void emptySearchTest(){
        HomePage homePage = new HomePage(driver);
        WebElement searchIcon = homePage.getSearchIcon();
        searchIcon.click();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.equals("https://nortun.am/search/index.php?q=&s=Search"), "Did not navigate to the desired page");
    }

    //testing a valid message appears after empty test
    @Test
    public void _0ResultsFoundMessageDisplayedTest(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        WebElement searchIcon = homePage.getSearchIcon();
        searchIcon.click();
        WebElement message = searchPage.get0ResultsFoundMessage();
        assertTrue(message.isDisplayed(), "Message is not displayed");
    }

    //testing that button to continue shopping is displayed;
    @Test
    public void continueShoppingButtonIsDisplayedAfterEmptySearchTest(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        WebElement searchIcon = homePage.getSearchIcon();
        searchIcon.click();
        WebElement continueShoppingButton = searchPage.getContinueShoppingButton();
        assertTrue(continueShoppingButton.isDisplayed());
    }

    //testing that continue shopping button leads to catalog
    @Test
    public void continueShoppingButtonLeadsToCatalogTest(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        WebElement searchIcon = homePage.getSearchIcon();
        searchIcon.click();
        WebElement continueShoppingButton = searchPage.getContinueShoppingButton();
        continueShoppingButton.click();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.equals("https://nortun.am/catalog/"));
    }

    //testing that a message is displayed when there are no results
    @Test
    public void noResultsFoundMessageDisplayedTest() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        String searchTerm = "sofa";

        homePage.searchForProduct(searchTerm);
        WebElement message = searchPage.get0ResultsFoundMessage();
        assertTrue(message.isDisplayed(), "Message is not displayed");
    }

    //continue button is displayed when nothing is found
    @Test
    public void continueShoppingButtonIsDisplayedWhenNothingIsFoundTest(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        String searchTerm = "sofa";
        homePage.searchForProduct(searchTerm);
        WebElement continueShoppingButton = searchPage.getContinueShoppingButton();
        assertTrue(continueShoppingButton.isDisplayed());
    }
    //testing that submitting a valid search navigates to the search resul page
    @Test
    public void searchWithValidTermTest() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "doors";

        SearchPage searchPage = homePage.searchForProduct(searchTerm);

        assertTrue(searchPage.searchTileExists());
        assertTrue(searchPage.getSearchTitle().contains("որոնման արդյունքները"));

    }

    //testing whether results are displayed
    @Test
    public void resultsDisplayedAfterValidSearchTest() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "սալիկ";

        SearchPage searchPage = homePage.searchForProduct(searchTerm);
        for (int i = 0; i < searchPage.productSize(); ++i) {
            assertTrue(searchPage.getProductTitle(i).toLowerCase().contains("սալիկ"));
        }
    }

    @Test
    public void openCartTest() {
        HomePage homePage = new HomePage(driver);
        Cart cartPage = homePage.openTheCart();
        assertTrue(cartPage.getCartPageTitle().contains("Զամբյուղ"));
    }


}
