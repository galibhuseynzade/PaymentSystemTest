package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.Waiter;

import java.util.List;

public class CardsPage {
    private final WebDriver driver;
    public CardsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='List All Cards']")
    public WebElement listAllCardsButton;

    @FindBy(xpath = "//button[text()='List Cards by Customer']")
    public WebElement listCardsByCustomerButton;

    @FindBy(xpath = "//button[text()='Create Card']")
    public WebElement createCardButton;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> cardList;

    @FindBy(id = "customerId")
    public WebElement enterCustomerId;

    public List<WebElement> getAllCards() {
        Waiter.untilClickable(listAllCardsButton).click();
        return cardList;
    }

    public void enterCustomerId(String customerId) {
        Waiter.untilVisible(enterCustomerId).sendKeys(customerId);
    }

    public List<WebElement> getCardsByCustomerId() {
        Waiter.untilClickable(listCardsByCustomerButton).click();
        return cardList;
    }

    public void clickCreateCard() {
        Waiter.untilClickable(createCardButton).click();
    }

    public void depositCard(String cardId, double amount) {
        WebElement amountBox = driver.findElement(By.xpath("//input[@id='amount-" + cardId + "']"));
        WebElement depositButton = driver.findElement(By.xpath("//button[@onclick=\"depositCard('" +
                cardId +
                "')\"]"));
        Waiter.untilVisible(amountBox).sendKeys(String.valueOf(amount));
        Waiter.untilClickable(depositButton).click();
    }

    public void activateCard(String cardId) {
        WebElement activateButton = driver.findElement(By.xpath("//button[@onclick=\"activateCard('" +
                cardId +
                "')\"]"));
        Waiter.untilClickable(activateButton).click();
    }
}
