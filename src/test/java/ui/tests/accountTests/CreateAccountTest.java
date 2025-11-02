package ui.tests.accountTests;

import org.testng.annotations.Test;
import base.BaseTestUI;
import ui.pages.AccountsPage;
import ui.pages.HomePage;

public class CreateAccountTest extends BaseTestUI {
    @Test
    public void createAccountTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountsButton();

        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.enterCustomerId("14");
        accountsPage.clickCreateAccount();
    }
}
