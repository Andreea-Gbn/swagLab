package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public By usernameInput = new By.ById("user-name");
    private final By passwordInput = new By.ById("password");
    private final By loginButton = new By.ById("login-button");
    private final By pageTitle = new By.ByXPath("//div[@class='login_logo']");
    private final By errorLogin = new By.ByXPath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);

    }

    public boolean userFieldIsVisible() {
        return driver.findElement(usernameInput).isDisplayed();
    }

    public boolean passwordFieldIsVisible() {
        return driver.findElement(passwordInput).isDisplayed();
    }

    public void userAndPasswordFieldsAreClickable() {
        driver.findElement(usernameInput).click();
        driver.findElement(passwordInput).click();
    }
    public void typeUser(String user) {
        driver.findElement(usernameInput).sendKeys(user);

    }
    public void typePass(String pass) {
        driver.findElement(passwordInput).sendKeys(pass);

    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean titleIsVisible() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public boolean loginButtonIsVisible() {

        return driver.findElement(loginButton).isDisplayed();
    }
    public boolean loginError(String error) {
        return driver.findElement(errorLogin).getText().contains(error);
    }
}
