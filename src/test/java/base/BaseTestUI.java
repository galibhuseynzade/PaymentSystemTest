package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import config.ConfigReader;
import ui.pages.LoginPage;
import ui.util.DriverManager;

public class BaseTestUI {
    protected static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.get("baseUrl") + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(ConfigReader.get("adminUser"));
        loginPage.enterPassword(ConfigReader.get("adminUser"));
        loginPage.clickLoginButton();
    }

    @AfterClass
    public static void tearDown() {
        DriverManager.quitDriver();
    }
}
