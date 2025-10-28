package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//button[@aria-label='Settings']")
    public WebElement settingsButton;

    @FindBy(xpath = "//div[text()='Customers']")
    public WebElement customersButton;

    @FindBy(xpath = "//div[text()='Accounts']")
    public WebElement accountsButton;

    @FindBy(xpath = "//div[text()='Cards']")
    public WebElement cardsButton;

    @FindBy(xpath = "//div[text()='Transactions']")
    public WebElement transactionsButton;

    @FindBy(xpath = "//div[text()='Users']")
    public WebElement usersButton;

    @FindBy(xpath = "//div/a[text()='PaymentSystem']")
    public WebElement dashboardButton;

    public void clickLogoutButton() {
        Waiter.untilClickable(logoutButton).click();
    }
    public void clickSettingsButton() {
        Waiter.untilVisible(settingsButton).click();
    }
    public void clickCustomersButton() {
        Waiter.untilClickable(customersButton).click();
    }
    public void clickAccountsButton() {
        Waiter.untilClickable(accountsButton).click();
    }
    public void clickCardsButton() {
        Waiter.untilClickable(cardsButton).click();
    }
    public void clickTransactionsButton() {
        Waiter.untilClickable(transactionsButton).click();
    }
    public void clickUsersButton() {
        Waiter.untilClickable(usersButton).click();
    }
    public void clickDashboardButton() {
        Waiter.untilClickable(dashboardButton).click();
    }
}
