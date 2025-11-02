package ui.tests.cardTests;

import org.testng.annotations.Test;
import base.BaseTestUI;
import ui.pages.CardsPage;
import ui.pages.HomePage;

public class CreateCardTest extends BaseTestUI {
    @Test
    public void createCardTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCardsButton();

        CardsPage cardsPage = new CardsPage(driver);
        cardsPage.enterCustomerId("14");
        cardsPage.clickCreateCard();
    }
}
