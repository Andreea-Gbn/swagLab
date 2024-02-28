package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.BaseClass;

import static pages.InventoryPage.*;
import static pages.ShoppingPage.*;

public class ShoppingSteps {


    @Given("The user is on Products page")
    public void theUserIsOnProductsPage() {
        inventoryPageIsLoaded();

    }

    @When("The user click on Shopping Cart image")
    public void theUserClickOnShoppingCartImage() {
        Assert.assertTrue(shoppingCartLogoIsDisplayed());
        clickShoppingCartLogo();
    }

    @Then("The Your Cart page is displayed")
    public void theYourCartPageIsDisplayed() {
        checkIfYourCartPageIsDisplayed();

    }

    @When("The user add to chart two products")
    public void theUserAddToChartTwoProducts() {
        addToCartBackpack();
        addToCartBikeLight();
    }

    @Then("The user can check if {string} is displayed")
    public void theUserCanCheckIfIsDisplayed(String info) {
        checkProductDetails(info);
    }

    @When("The user add one product to the Shopping Cart")
    public void theUserAddOneProductToTheShoppingCart() {
        addToCartBoltTshirt();
    }

    @Then("The the Shopping Cart contains {int} product")
    public void theTheShoppingCartContainsProduct(int numberBadge) {

        Assert.assertTrue(checkItemQuantity(numberBadge));

    }

    @When("The user removes {string} product from chart")
    public void theUserRemovesProductFromChart(String item) {
        BaseClass.waitFor(3);
        removeItemsFromChart(item);
    }


}
