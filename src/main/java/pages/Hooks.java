package pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseClass;

import static utils.BaseClass.driver;
import static utils.BaseClass.initializeDriver;

public class Hooks {
    BaseClass baseClass = new BaseClass();

    @Before
    public static void setup() {

        initializeDriver();
    }

    @After
    public static void quitApp() {

        driver.quit();

    }
}
