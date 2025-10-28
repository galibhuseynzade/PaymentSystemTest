package ui.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import ui.config.ConfigReader;
import ui.pages.LoginPage;
import ui.util.DriverManager;

public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.get("baseUrl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(ConfigReader.get("adminUser"));
        loginPage.enterPassword(ConfigReader.get("adminUser"));
        loginPage.clickLoginButton();
    }

//    @AfterAll
//    public static void tearDown() {
//        DriverManager.quitDriver();
//    }
}
