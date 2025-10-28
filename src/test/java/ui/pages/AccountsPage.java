package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

import java.util.List;

public class AccountsPage {
    private final WebDriver driver;
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='List All Accounts']")
    public WebElement listAllAccountsButton;

    @FindBy(xpath = "//button[text()='List Accounts by Customer']")
    public WebElement listAccountsByCustomerButton;

    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> accountList;

    @FindBy(id = "customerId")
    public WebElement enterCustomerId;

    public List<WebElement> getAllAccounts() {
        Waiter.untilClickable(listAllAccountsButton).click();
        return accountList;
    }

    public void enterCustomerId(String customerId) {
        Waiter.untilVisible(enterCustomerId).sendKeys(customerId);
    }

    public List<WebElement> getAccountsByCustomerId() {
        Waiter.untilClickable(listAccountsByCustomerButton).click();
        return accountList;
    }

    public void clickCreateAccount() {
        Waiter.untilClickable(createAccountButton).click();
    }

    public void depositAccount(String accountId, double amount) {
        WebElement amountBox = driver.findElement(By.xpath("//input[@id='amount-" + accountId + "']"));
        WebElement depositButton = driver.findElement(By.xpath("//button[@onclick=\"depositAccount('" +
                accountId +
                "')\"]"));
        Waiter.untilVisible(amountBox).sendKeys(String.valueOf(amount));
        Waiter.untilClickable(depositButton).click();
    }

    public void activateAccount(String accountId) {
        WebElement activateButton = driver.findElement(By.xpath("//button[@onclick=\"activateAccount('" +
                accountId +
                "')\"]"));
        Waiter.untilClickable(activateButton).click();
    }
}
