package ui.tests.accountTests;

import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.pages.AccountsPage;
import ui.pages.HomePage;

public class CreateAccountTest extends BaseTest {
    @Test
    public void createAccountTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountsButton();

        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.enterCustomerId("14");
        accountsPage.clickCreateAccount();
    }
}
