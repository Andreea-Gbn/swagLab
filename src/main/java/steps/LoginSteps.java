package steps;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.BaseClass;

public class LoginSteps {

    WebDriver driver = BaseClass.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Given("The user access the Swag Lab page")
    public void theUserAccessTheSwagLabPage() {

    }

    @When("The user enter user and password")
    public void theUserEnterUserAndPassword() {
        loginPage.

                login("standard_user", "secret_sauce");
    }

    @And("The user click on Login button")
    public void theUserClickOnLoginButton() {
        loginPage.clickLoginButton();
    }
}
