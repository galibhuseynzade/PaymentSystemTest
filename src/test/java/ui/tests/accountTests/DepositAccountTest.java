package ui.tests.accountTests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import base.BaseTestUI;
import ui.pages.AccountsPage;
import ui.pages.HomePage;

import java.util.List;

public class DepositAccountTest extends BaseTestUI {
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
