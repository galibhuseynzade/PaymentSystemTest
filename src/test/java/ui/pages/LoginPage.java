package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void enterUsername(String username) {
        Waiter.untilVisible(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        Waiter.untilVisible(this.password).sendKeys(password);
    }

    public void clickLoginButton() {
        Waiter.untilClickable(this.loginButton).click();
    }
}
