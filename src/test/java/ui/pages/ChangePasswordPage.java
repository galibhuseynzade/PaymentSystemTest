package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

public class ChangePasswordPage {
    public ChangePasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "oldPassword")
    public WebElement oldPassword;

    @FindBy(id = "newPassword")
    public WebElement newPassword;

    @FindBy(xpath = "//button[@type='submit' and text()='Change Password']")
    public WebElement submitChangePasswordButton;

    @FindBy(xpath = "//button[@type='button' and text()='Close']")
    public WebElement closeButton;

    @FindBy(xpath = "//div[text()='Password changed successfully']")
    public WebElement passwordChangedSuccessfully;

    public void setNewPassword(String oldPassword, String newPassword) {
        Waiter.untilVisible(this.oldPassword).sendKeys(oldPassword);
        Waiter.untilVisible(this.newPassword).sendKeys(newPassword);
        Waiter.untilClickable(submitChangePasswordButton).click();
    }

    public void closeChangePasswordWindow() {
        Waiter.untilClickable(closeButton).click();
    }

    public boolean isPasswordChangedSuccessfully() {
        return Waiter.untilVisible(passwordChangedSuccessfully).isDisplayed();
    }
}
