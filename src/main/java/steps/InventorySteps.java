package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.InventoryPage;
import utils.BaseClass;

public class InventorySteps {


    InventoryPage inventoryPage = new InventoryPage();

    @Then("The user can see the Swan Lab Home Page")
    public void theUserCanSeeTheSwanLabHomePage() {
        InventoryPage.inventoryPageIsLoaded();
        InventoryPage.shoppingCartLogoIsDisplayed();

    }


    @Then("The user can see the product list title")
    public void theUserCanSeeTheProductListTitle() {
        InventoryPage.itemListIsDisplayed();
    }

    @And("The picture and the product title are displayed")
    public void thePictureTheProductTitleAreDisplayed() {
        InventoryPage.pictureIsDisplayed();
        InventoryPage.itemNameIsDisplayed();
    }

    @Then("The user can see also the price and the {string} button")
    public void theUserCanSeeAlsoThePriceAndTheButton(String button) {
        InventoryPage.priceIsDisplayed();
        InventoryPage.addToCartButtonIsVisible();
        Assert.assertTrue(InventoryPage.addToCartButton(button));
    }

    @And("The user sort the product list by Name from Z to A")
    public void theUserSortTheProductListByNameZToA() {
        InventoryPage.clickOnSortFilterButton();
        InventoryPage.sortItemsByNameZA();
        BaseClass.waitFor(5);
        //        wait added here to check the filter was clicked correct
    }

    @And("The user sort the product list by Price from high to low")
    public void theUserSortTheProductListByPriceFromHighToLow() {
        InventoryPage.clickOnSortFilterButton();
        InventoryPage.sortItemsByPriceDescending();
        BaseClass.waitFor(5);
//        wait added here to check the filter was clicked correct
    }

    @Then("The product list are filtered by {string}")
    public void theProductListAreFilteredBy(String option) {
        InventoryPage.checkSortingFilter(option);
        InventoryPage.checkThatProductsAreSorted(option);
    }
}
