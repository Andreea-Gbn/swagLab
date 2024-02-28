package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static pages.CheckoutPage.checkoutButtonIsDisplayed;
import static utils.BaseClass.driver;

public class ShoppingPage {


    private static final By continueShoppingButton = new By.ById("continue-shopping");

    private static final By yourCartTitle = new By.ByXPath("//span[@class='title']");
    private static final By addToCartBackpack = new By.ById("add-to-cart-sauce-labs-backpack");
    private static final By addToCartBikeLight = new By.ById("add-to-cart-sauce-labs-bike-light");
    private static final By addToCartBoltTshirt = new By.ById("add-to-cart-sauce-labs-bolt-t-shirt");
    private static final By removeFromCartBikeLight = new By.ById("remove-sauce-labs-bike-light");
    private static final By removeFromCartBoltTshirt = new By.ById("remove-sauce-labs-backpack");
    public static final String TITLE = "title";
    public static final String QUANTITY = "quantity";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";

    public static boolean continueShoppingButtonIsDisplayed() {
        return driver.findElement(continueShoppingButton).isDisplayed();
    }


    public static boolean yourCartTitleIsDisplayed() {
        return driver.findElement(yourCartTitle).isDisplayed();
    }

    public static void checkIfYourCartPageIsDisplayed() {
        Assert.assertTrue(continueShoppingButtonIsDisplayed());
        Assert.assertTrue(checkoutButtonIsDisplayed());
        Assert.assertTrue(yourCartTitleIsDisplayed());

    }

    public static void addToCartBackpack() {
        driver.findElement(addToCartBackpack).click();
    }

    public static void addToCartBikeLight() {
        driver.findElement(addToCartBikeLight).click();
    }

    public static void addToCartBoltTshirt() {
        driver.findElement(addToCartBoltTshirt).click();
    }

    public static void removeFromCartBoltTshirt() {
        driver.findElement(removeFromCartBoltTshirt).click();
    }

    public static void removeFromCartBikeLight() {
        driver.findElement(removeFromCartBikeLight).click();
    }

    public static boolean checkItemName() {
//       Retrieve all titles of the items from the cart
        List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));

//        Extract tje text of each title element
        List<String> itemsTitles = itemNames.stream().map(WebElement::getText).collect(Collectors.toList());

//        Expected item titles (replace with the actual expected titles)
        List<String> expectedTitles = List.of("Sauce Labs Backpack", "Sauce Labs Bike Light");
        @SuppressWarnings("unused")
        boolean allTitlesSelectedAreDisplayed = true;
        for (String expectedTitle : expectedTitles) {
            if (!itemsTitles.contains(expectedTitle)) {
                allTitlesSelectedAreDisplayed = false;
                break;
            }
        }

        return allTitlesSelectedAreDisplayed;
    }

    public static boolean checkItemDescription() {
        @SuppressWarnings("unused")
        boolean allDescriptionAreDisplayed = true;
        List<WebElement> descriptionLocator = driver.findElements(By.className("inventory_item_desc"));
        List<String> itemsDescriptions = descriptionLocator.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedTitles = List.of("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        for (String itemDescription : itemsDescriptions) {
            if (!expectedTitles.contains(itemDescription)) {
                allDescriptionAreDisplayed = false;
                break;

            }
        }
        return allDescriptionAreDisplayed;
    }

    public static boolean checkItemQuantity(Integer number) {

        WebElement containerElement = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        String countItemCountText = containerElement.getText();
        int actualCartItemCount = Integer.parseInt(countItemCountText);
        int expectedCartItemCount = number;

        if (actualCartItemCount == expectedCartItemCount) {
            System.out.println("Number of items in the cart is validated successfully");
        } else {
            System.out.println("Validation failed: Number of items in the cart does not match the expected count!");
        }


        return true;
    }

    public static boolean checkItemPrice() {

        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<String> itemPrices = priceElements.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> expectedItemPrices = List.of("$29.99", "$9.99");
        @SuppressWarnings("unused")
        boolean allPricesMatches = true;
        for (int i = 0; i < expectedItemPrices.size(); i++) {
            if (!itemPrices.get(i).equals(expectedItemPrices.get(i))) {
                allPricesMatches = false;
                break;
            }
        }

        return allPricesMatches;
    }

    public static void checkProductDetails(String info) {
        switch (info) {
            case TITLE:
                Assert.assertTrue(checkItemName());
                break;
            case QUANTITY:
                Assert.assertTrue(checkItemQuantity(2));
                break;
            case DESCRIPTION:
                Assert.assertTrue(checkItemDescription());
                break;
            case PRICE:
                Assert.assertTrue(checkItemPrice());
                break;
            default:
                Assert.fail("info not found!!!");
        }
    }
    public static void removeItemsFromChart(String info) {
        switch (info) {
            case "one":
               removeFromCartBikeLight();
                break;
            case "second":
               removeFromCartBoltTshirt();
                break;
            default:
                Assert.fail("info not found!!!");
        }
    }
}
