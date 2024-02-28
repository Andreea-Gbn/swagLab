package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.BaseClass;

import static pages.InventoryPage.*;

public class InventorySteps {


    @Then("The user can see the Swan Lab Home Page")
    public void theUserCanSeeTheSwanLabHomePage() {
        inventoryPageIsLoaded();
        Assert.assertTrue(shoppingCartLogoIsDisplayed());

    }


    @Then("The user can see the product list title")
    public void theUserCanSeeTheProductListTitle() {
        Assert.assertTrue(itemListIsDisplayed());
    }

    @And("The picture and the product title are displayed")
    public void thePictureTheProductTitleAreDisplayed() {
        pictureIsDisplayed();
        itemNameIsDisplayed();
    }

    @Then("The user can see also the price and the {string} button")
    public void theUserCanSeeAlsoThePriceAndTheButton(String button) {
        Assert.assertTrue(priceIsDisplayed());
        Assert.assertTrue(addToCartButtonIsVisible());
        Assert.assertTrue(addToCartButton(button));
    }

    @And("The user sort the product list by Name from Z to A")
    public void theUserSortTheProductListByNameZToA() {
        clickOnSortFilterButton();
        sortItemsByNameZA();
        BaseClass.waitFor(5);
        //        wait added here to check the filter was clicked correct
    }

    @And("The user sort the product list by Price from high to low")
    public void theUserSortTheProductListByPriceFromHighToLow() {
        clickOnSortFilterButton();
        sortItemsByPriceDescending();
        BaseClass.waitFor(5);
//        wait added here to check the filter was clicked correct
    }

    @Then("The product list are filtered by {string}")
    public void theProductListAreFilteredBy(String option) {
        checkSortingFilter(option);
        checkThatProductsAreSorted(option);
    }

}
