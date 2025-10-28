package ui.tests.accountTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import ui.pages.AccountsPage;
import ui.pages.HomePage;

import java.util.List;

public class DepositAccountTest extends BaseTest {
    @Test
    public void depositAccountTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountsButton();

        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.enterCustomerId("14");
        List<WebElement> accountList = accountsPage.getAccountsByCustomerId();
        int accountCount = accountList.size();
        String accountDetails = accountList.get(accountCount - 1).getText();
        String accountId = accountDetails.substring(0, accountDetails.indexOf(" "));
        accountsPage.depositAccount(accountId, 450);
    }
}
