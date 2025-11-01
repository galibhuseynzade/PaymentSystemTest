package ui.tests.cardTests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import ui.pages.CardsPage;
import ui.pages.HomePage;

import java.util.List;

public class GetAllCardsTest extends BaseTest {
    @Test
    public void getCardsListTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCardsButton();

        CardsPage cardsPage = new CardsPage(driver);
        List<WebElement> cardList = cardsPage.getAllCards();
        for (WebElement card : cardList) {
            System.out.println(card.getText());
        }
    }
}
