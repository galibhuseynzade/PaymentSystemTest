package ui.tests.accountTests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base.BaseTestUI;
import ui.pages.AccountsPage;
import ui.pages.HomePage;

import java.util.List;

public class ActivateAccountTest extends BaseTestUI {
    @Test
    public void activateAccountTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountsButton();

        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.enterCustomerId("14");
        List<WebElement> accountList = accountsPage.getAccountsByCustomerId();
        int accountCount = accountList.size();
        String accountDetails = accountList.get(accountCount - 1).getText();
        String accountId = accountDetails.substring(0, accountDetails.indexOf(" "));
        accountsPage.activateAccount(accountId);
    }
}
