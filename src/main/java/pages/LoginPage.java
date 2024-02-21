package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private By usernameInput = new By.ById("user-name");
    private By passwordInput = new By.ById("password");
    private By loginButton = new By.ById("login-button");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void login(String username, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);

    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();


    }
}
