package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

public class SettingsPage {
    public SettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-bs-target='#changePasswordModal']")
    public WebElement changePasswordButton;

    public void clickChangePasswordButton() {
        Waiter.untilClickable(changePasswordButton).click();
    }
}
