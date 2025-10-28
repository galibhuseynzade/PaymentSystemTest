package ui.tests.cardTests;

import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.pages.CardsPage;
import ui.pages.HomePage;

public class CreateCardTest extends BaseTest {
    @Test
    public void createCardTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCardsButton();

        CardsPage cardsPage = new CardsPage(driver);
        cardsPage.enterCustomerId("14");
        cardsPage.clickCreateCard();
    }
}
