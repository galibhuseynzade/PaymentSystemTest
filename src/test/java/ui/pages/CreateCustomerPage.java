package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

public class CreateCustomerPage {
    public CreateCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, CreateCustomerPage.this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "birthDate")
    public WebElement birthDate;

    @FindBy(id = "finCode")
    public WebElement finCode;

    @FindBy(id = "phoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;

    public void createCustomer(
            String firstName,
            String lastName,
            String birthDate,
            String finCode,
            String phoneNumber,
            String email
    ) {
        Waiter.untilVisible(this.firstName).sendKeys(firstName);
        Waiter.untilVisible(this.lastName).sendKeys(lastName);
        Waiter.untilVisible(this.birthDate).sendKeys(birthDate);
        Waiter.untilVisible(this.finCode).sendKeys(finCode);
        Waiter.untilVisible(this.phoneNumber).sendKeys(phoneNumber);
        Waiter.untilVisible(this.email).sendKeys(email);
        Waiter.untilVisible(this.createButton).click();
    }

    public void cancel() {
        Waiter.untilClickable(this.cancelButton).click();
    }
}
