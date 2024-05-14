import org.openqa.selenium.By;

public class SearchPageLocators {
    public static final By continueShoppingButtonLocator = By.className("search_zero_btn");
    public static final By _0ResultsMessageLocator = By.className("search_title_zero");
    public static final By searchResultsLocator = By.className("col-md-9");
    public static final By sortingProductsByPriceLocator = By.cssSelector("a.catalog_sort_btn");

    public static final By productTitleLocator = By.cssSelector("div[class=\"offer_product_bottom_block\"] > a > p");
    public static final By searchPageTitle = By.cssSelector("h4.search_title");
    public static final By productPriceLocator = By.cssSelector("div[class^=\"price_add\"] > article > p");
    public static final By productLocator = By.className("product-item-container");
}
