import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getContinueShoppingButton() {
        return findElement(SearchPageLocators.continueShoppingButtonLocator);
    }

    public WebElement get0ResultsFoundMessage() {
        return findElement(SearchPageLocators._0ResultsMessageLocator);
    }

    public WebElement getSearchResult() {
        return findElement(SearchPageLocators.searchResultsLocator);
    }

    public void sortByPriceLowToHigh() {
         driver.findElements(SearchPageLocators.sortingProductsByPriceLocator).get(1).click();
    }

    public void sortByPriceHighToLow() {
        driver.findElements(SearchPageLocators.sortingProductsByPriceLocator).get(2).click();
    }



    public int productSize() {
        return driver.findElements(SearchPageLocators.productTitleLocator).size();
    }


    public String getSearchTitle() {
        return driver.findElement(SearchPageLocators.searchPageTitle).getText();
    }

    public boolean searchTileExists() {
        if(driver.findElements(SearchPageLocators.searchPageTitle).size() != 0) {
            return true;
        }
        return false;
    }


    public String getProductTitle(int index) {
        return driver.findElements(SearchPageLocators.productTitleLocator).get(index).getText();
    }

    public ProductPage getProduct(int index) {
         driver.findElements(SearchPageLocators.productLocator).get(index).click();
         return new ProductPage(driver);
    }

    public ProductPage saveProduct(int index) {
        driver.findElements(SearchPageLocators.productLocator).get(index);
        return new ProductPage(driver);
    }



    public double getProductPriceAsNumber(int index){
        WebElement price = findElement(SearchPageLocators.productPriceLocator);
        String priceString = driver.findElements(SearchPageLocators.productPriceLocator).get(index).getText();
        String priceWithoutCurrencySymbol = priceString.replaceAll("[^0-9.]", "");
        double priceNumber = Double.parseDouble(priceWithoutCurrencySymbol);
        return priceNumber;
    }

    public void addToCart(int index) {
//        driver.findElements(By.className("addBasketLinck")).get(index).click();
        WebElement addToCartButton = driver.findElements(By.className("addBasketLinck")).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();

    }

}
