package ui.tests.transactionTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.TransactionsPage;

import java.util.List;

public class GetAllTransactionsTest extends BaseTest {
    @Test
    public void getAllTransactionsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTransactionsButton();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        List<WebElement> transactionList = transactionsPage.getAllTransactions();
        for (WebElement transaction : transactionList) {
            System.out.println(transaction.getText());
        }
    }
}
