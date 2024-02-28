package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseClass;

import static pages.InventoryPage.priceIsDisplayed;
import static pages.LoginPage.clickLoginButton;
import static utils.BaseClass.driver;

public class CheckoutPage {

    private static final By checkoutButton = new By.ById("checkout");
    private static final By titlePage = new By.ByClassName("title");
    private static final By firstNameInput = new By.ById("first-name");
    private static final By lastNameInput = new By.ById("last-name");
    private static final By postalCodeInput = new By.ById("postal-code");
    private static final By continueButton = new By.ById("continue");
    private static final By cancelButton = new By.ById("cancel");
    private static final By finishButton = new By.ById("finish");
    private static final By backHomeButton = new By.ById("back-to-products");
    private static final By errorCheckoutPage = new By.ByXPath("//h3[@data-test='error']");
    private static final By cartList = new By.ByClassName("cart_list");
    private static final By summaryInformation = new By.ByClassName("summary_info_label");
//    private static final By paymentInformation = new By.ByClassName("summary_info_label");

    public static boolean checkoutButtonIsDisplayed() {
        return driver.findElement(checkoutButton).isDisplayed();
    }

    public static void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public static boolean checkoutTitlePageIsDisplayed() {
        return driver.findElement(titlePage).isDisplayed();
    }

    public static Object checkoutTitlePageText() {
        return driver.findElement(titlePage).getText();

    }

    public static boolean finishButtonIsDisplayed() {
        return driver.findElement(finishButton).isDisplayed();
    }

    public static void clickBckHomeButton() {
        driver.findElement(backHomeButton).click();
    }
    public static boolean backHomeButtonIsDisplayed() {
        return driver.findElement(backHomeButton).isDisplayed();
    }

    public static void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
    public static boolean firstNameInputIsDisplayed() {
        return driver.findElement(firstNameInput).isDisplayed();
    }

    public static boolean lastNameInputInputIsDisplayed() {
        return driver.findElement(lastNameInput).isDisplayed();
    }

    public static boolean postalCodeInputInputIsDisplayed() {
        return driver.findElement(postalCodeInput).isDisplayed();
    }

    public static void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public static void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public static void addInputToFirstNameField(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public static void addInputToLastNameField(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public static void addInputToPostalCodeField(String code) {
        driver.findElement(postalCodeInput).sendKeys(code);
    }

    public static void clearInputToFirstNameField() {
        driver.findElement(firstNameInput).clear();
    }

    public static void clearInputToLastNameField() {
        driver.findElement(lastNameInput).clear();
    }

    public static void clearInputToPostalCodeField() {
        driver.findElement(postalCodeInput).clear();
    }

    public static boolean errorCheckoutPage(String error) {
        return driver.findElement(errorCheckoutPage).getText().contains(error);
    }

    public static boolean cartListInfo(String text) {
        return driver.findElement(cartList).getText().contains(text);
    }

    public static boolean summaryInformation(String text) {
        return driver.findElement(summaryInformation).getText().contains(text);
    }

    public static void clearCheckoutForm() {
        clearInputToFirstNameField();
        clearInputToLastNameField();
        clearInputToPostalCodeField();
    }

    public static void leaveFieldsEmpty(String fields) {
        clearCheckoutForm();
        switch (fields) {
            case "all":
                break;
            case "First Name":
                addInputToLastNameField("Pop");
                addInputToPostalCodeField("747412");
                break;
            case "Last Name":
                addInputToFirstNameField("Ana");
                addInputToPostalCodeField("747412");
                break;
            case "Zip/Postal Code":
                addInputToFirstNameField("Ana");
                addInputToLastNameField("Pop");
                break;
            default:
                Assert.fail("field not found!!!");

        }
        BaseClass.waitFor(5);
    }

    public static void userClickOnButton(String button) {
        switch (button) {
            case "Login":
                clickLoginButton();
                break;
            case "Continue":
                clickContinueButton();
                break;
            case "Checkout":
                clickCheckoutButton();
                break;
            case "Cancel":
                clickCancelButton();
                break;
            case "Finish":
                clickFinishButton();
                break;
            case "Back Home":
                clickBckHomeButton();
                break;
            default:
                Assert.fail("button not found!!!");
        }
    }

    public static void overviewPageInformationAreDisplayed() {
        cartListInfo("QTY");
        cartListInfo("Description");
        Assert.assertTrue(priceIsDisplayed());
        summaryInformation("Payment Information");
        summaryInformation("Shipping Information");
        summaryInformation("Price Total");
        finishButtonIsDisplayed();
    }
}
