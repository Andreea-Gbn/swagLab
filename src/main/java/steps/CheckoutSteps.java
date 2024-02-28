package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.BaseClass;

import static pages.CheckoutPage.*;

public class CheckoutSteps {

    @When("The user click on {string} button")
    public void theUserClickOnButton(String button) {
        userClickOnButton(button);
    }

    @And("The user can see specific page fields like firsName input, lastName input and Postal Code")
    public void theUserCanSeeSpecificPageFieldsLikeFirsNameInputLastNameInputAndPostalCode() {
        Assert.assertTrue(firstNameInputIsDisplayed());
        Assert.assertTrue(lastNameInputInputIsDisplayed());
        Assert.assertTrue(postalCodeInputInputIsDisplayed());
    }

    @And("The user add input for First Name, Last Name and Postal Code")
    public void theUserAddInputForFirstNameLastNameAndPostalCode() {
        addInputToFirstNameField("Ana");
        addInputToLastNameField("Pop");
        addInputToPostalCodeField("1234");
    }

    @And("The user click on {string} button to submit the form")
    public void theUserClickOnButtonToSubmitTheForm(String button) {
        userClickOnButton(button);
    }

    @Then("The user can see the {string} page")
    public void theUserCanSeeThePage(String page) {
        Assert.assertTrue(checkoutTitlePageIsDisplayed());
        Assert.assertEquals(checkoutTitlePageText(), page);
    }


    @And("The user leave fields {string} empty")
    public void theUserLeaveFieldsEmpty(String fields) {
        leaveFieldsEmpty(fields);
    }

    @Then("The user check if specific error {string} is displayed")
    public void theUserCheckIfSpecificErrorIsDisplayed(String error) {
        BaseClass.waitFor(5);
        //  wait added here to check the error is displayed correct
        Assert.assertTrue(errorCheckoutPage(error));
    }


    @And("The user can see specific order details")
    public void theUserCanSeeSpecificOrderDetails() {
        overviewPageInformationAreDisplayed();

    }

    @And("The user can see that Back Home button is displayed")
    public void theUserCanSeeThatBackHomeButtonIsDisplayed() {
        backHomeButtonIsDisplayed();
    }
}
