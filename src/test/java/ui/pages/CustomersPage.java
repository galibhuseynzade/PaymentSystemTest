package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

import java.util.List;

public class CustomersPage {
    public CustomersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-bs-target='#createCustomerModal']")
    public WebElement createCustomerButton;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> customerList;

    public void clickCreateCustomer() {
        Waiter.untilClickable(createCustomerButton).click();
    }

    public List<WebElement> getCustomerList() {
        return customerList;
    }
}
