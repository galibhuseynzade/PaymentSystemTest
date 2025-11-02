package ui.tests.transactionTests;

import org.testng.annotations.Test;
import base.BaseTestUI;
import ui.pages.CreateTransactionPage;
import ui.pages.HomePage;
import ui.pages.TransactionsPage;

public class CreateTransactionTest extends BaseTestUI {
    @Test
    public void createTransactionTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTransactionsButton();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        transactionsPage.createTransaction();

        CreateTransactionPage createTransactionPage = new CreateTransactionPage(driver);
        createTransactionPage.createTransaction("AZ166300850804942644", "AZ396686048473648732", "10");
    }
}
