package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

public class CreateTransactionPage {
    public CreateTransactionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "debit")
    public WebElement debit;

    @FindBy(id = "credit")
    public WebElement credit;

    @FindBy(id = "amount")
    public WebElement amount;

    @FindBy(xpath = "//button[text()='Transfer']")
    public WebElement createButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;

    public void createTransaction(String debit, String credit, String amount) {
        Waiter.untilVisible(this.debit).sendKeys(debit);
        Waiter.untilVisible(this.credit).sendKeys(credit);
        Waiter.untilVisible(this.amount).sendKeys(amount);
        Waiter.untilClickable(this.createButton).click();
    }

    public void cancelTransaction() {
        Waiter.untilClickable(this.cancelButton).click();
    }
}
