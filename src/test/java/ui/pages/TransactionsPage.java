package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

import java.util.List;

public class TransactionsPage {
    public TransactionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='List All Transactions']")
    public WebElement listAllTransactionsButton;

    @FindBy(xpath = "//button[text()='List Transactions by Customer']")
    public WebElement listTransactionsByCustomerButton;

    @FindBy(xpath = "//button[@data-bs-target='#transferModal']")
    public WebElement createTransactionsButton;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> transactionList;

    @FindBy(id = "customerId")
    public WebElement enterCustomerId;

    public List<WebElement> getAllTransactions() {
        Waiter.untilClickable(listAllTransactionsButton).click();
        return transactionList;
    }

    public void enterCustomerId(String customerId) {
        Waiter.untilClickable(enterCustomerId).sendKeys(customerId);
    }

    public List<WebElement> getTransactionsByCustomerId() {
        Waiter.untilClickable(listTransactionsByCustomerButton).click();
        return transactionList;
    }

    public void createTransaction() {
        Waiter.untilClickable(createTransactionsButton).click();
    }
}
