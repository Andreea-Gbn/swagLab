package steps;


import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.TestDataGlobal;
import utils.BaseClass;

public class LoginSteps {

    WebDriver driver = BaseClass.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Given("The user access the Swag Lab page")
    public void theUserAccessTheSwagLabPage() {
        Assert.assertTrue(loginPage.titleIsVisible());
    }

    @When("The user enter user and password")
    public void theUserEnterUserAndPassword() {
        loginPage.login(TestDataGlobal.username, TestDataGlobal.password);
    }

    @And("The Swag Lab title is displayed")
    public void theSwagLabTitleIsDisplayed() {
        Assert.assertTrue(loginPage.titleIsVisible());
    }

    @When("The the user can see the username and password fields")
    public void theTheUserCanSeeTheUsernameAndPasswordFields() {
        Assert.assertTrue(loginPage.userFieldIsVisible());
        Assert.assertTrue(loginPage.passwordFieldIsVisible());
    }

    @And("User can click on input fields")
    public void userCanClickOnInputField() {
        loginPage.userAndPasswordFieldsAreClickable();
    }

    @Then("The user can see the login button")
    public void theUserCanSeeTheLoginButton() {
        Assert.assertTrue(loginPage.loginButtonIsVisible());
    }


    @When("The user enter user {string} and password {string}")
    public void theUserEnterUserAndPassword(String user, String password) {
        loginPage.typeUser(user);
        loginPage.typePass(password);
    }

    @Then("The user can see error {string}")
    public void theUserCanSeeError(String error) {
        BaseClass.waitFor(5);
        //        wait added here to check the error is displayed correct
        Assert.assertTrue(loginPage.loginError(error));

    }
}
