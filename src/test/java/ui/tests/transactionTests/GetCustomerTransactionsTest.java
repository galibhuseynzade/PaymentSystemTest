package ui.tests.transactionTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.TransactionsPage;

import java.util.List;

public class GetCustomerTransactionsTest extends BaseTest {
    @Test
    public void getCustomerTransactionsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTransactionsButton();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        transactionsPage.enterCustomerId("14");
        List<WebElement> transactionList = transactionsPage.getTransactionsByCustomerId();
        for (WebElement transaction : transactionList) {
            System.out.println(transaction.getText());
        }
    }
}
