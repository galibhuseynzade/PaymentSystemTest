package ui.tests.cardTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import ui.pages.CardsPage;
import ui.pages.HomePage;

import java.util.List;

public class DepositCardTest extends BaseTest {
    @Test
    public void depositCardTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCardsButton();

        CardsPage cardsPage = new CardsPage(driver);
        cardsPage.enterCustomerId("14");
        List<WebElement> cardList = cardsPage.getCardsByCustomerId();
        int cardCount = cardList.size();
        String cardDetails = cardList.get(cardCount - 1).getText();
        String cardId = cardDetails.substring(0, cardDetails.indexOf(" "));
        cardsPage.depositCard(cardId, 450);
    }
}
