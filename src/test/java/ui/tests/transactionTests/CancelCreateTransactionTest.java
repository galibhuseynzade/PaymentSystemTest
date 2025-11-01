package ui.tests.transactionTests;

import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.CreateTransactionPage;
import ui.pages.HomePage;
import ui.pages.TransactionsPage;

public class CancelCreateTransactionTest extends BaseTest {
    @Test
    public void cancelCreateTransaction() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTransactionsButton();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        transactionsPage.createTransaction();

        CreateTransactionPage createTransactionPage = new CreateTransactionPage(driver);
        createTransactionPage.cancelTransaction();
    }
}
