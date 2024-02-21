package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.time.Duration;

public class InventoryPage extends BaseClass {


    public By appLogo = new By.ByClassName("app_logo");
    private static final By shoppingCartLogo = new By.ByClassName("shopping_cart_link");
    private static final By pageHeading = new By.ByXPath("//span[contains(text(),'Products')]");
    private static final By itemName = new By.ByClassName("inventory_item_name");
    private static final By itemList = new By.ByClassName("inventory_item");
    private static final By price = new By.ByClassName("inventory_item_price");
    private static final By addToCartButton = new By.ByXPath("//button[contains(text(),'Add to cart')]");
    private static final By sortFilterButton = new By.ByXPath("//select[@class='product_sort_container']");
    private static final By sortByNameZA = new By.ByXPath("//option[contains(text(),'Name (Z to A)')]");
    private static final By sortByPriceDescending = new By.ByXPath("//option[contains(text(),'Price (high to low)')]");

    public static void inventoryPageIsLoaded() {
        driver.findElement(pageHeading).getText();
    }

    public static boolean shoppingCartLogoIsDisplayed() {
        return driver.findElement(shoppingCartLogo).isDisplayed();
    }

    public static boolean itemNameIsDisplayed() {
        return driver.findElement(itemName).isDisplayed();
    }

    public static void itemListIsDisplayed() {
        driver.findElement(itemList).isDisplayed();
    }

    public static void priceIsDisplayed() {
        driver.findElement(price).isDisplayed();
    }

    public static boolean addToCartButtonIsVisible() {
        return driver.findElement(addToCartButton).isDisplayed();

    }

    public static boolean addToCartButton(String text) {
        return driver.findElement(addToCartButton).getText().contains(text);
    }

    public static void clickOnSortFilterButton() {
        driver.findElement(sortFilterButton).click();
    }

    public static void sortItemsByNameZA() {
        driver.findElement(sortByNameZA).click();
    }

    public static void sortItemsByPriceDescending() {
        driver.findElement(sortByPriceDescending).click();
    }

    public static boolean itemsAreSortedByAToZ(String text) {
        return driver.findElement(sortByNameZA).getText().contains(text);
    }

    public static boolean itemsAreSortByPriceDescending(String text) {
        return driver.findElement(sortByPriceDescending).getText().contains(text);
    }

    public static void checkSortingFilter(String filter) {
        if (filter.contains("Name (Z to A)")) {
            Assert.assertTrue(itemsAreSortedByAToZ(filter));
        } else if (filter.contains("Price (high to low)")) {
            Assert.assertTrue(itemsAreSortByPriceDescending(filter));
        } else {
            Assert.fail();
        }
    }
}
