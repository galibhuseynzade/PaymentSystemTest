package ui.tests.transactionTests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import base.BaseTestUI;
import ui.pages.HomePage;
import ui.pages.TransactionsPage;

import java.util.List;

public class GetAllTransactionsTest extends BaseTestUI {
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
