package ui.tests.cardTests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import base.BaseTestUI;
import ui.pages.CardsPage;
import ui.pages.HomePage;

import java.util.List;

public class GetCustomerCardsTest extends BaseTestUI {
    @Test
    public void getCustomerCardTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCardsButton();

        CardsPage cardsPage = new CardsPage(driver);
        cardsPage.enterCustomerId("14");
        List<WebElement> cardList = cardsPage.getCardsByCustomerId();
        for (WebElement card : cardList) {
            System.out.println(card.getText());
        }
    }
}
