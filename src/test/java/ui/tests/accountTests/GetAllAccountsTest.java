package ui.tests.accountTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import ui.pages.AccountsPage;
import ui.pages.HomePage;

import java.util.List;

public class GetAllAccountsTest extends BaseTest {
    @Test
    public void getAccountsListTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountsButton();

        AccountsPage accountsPage = new AccountsPage(driver);
        List<WebElement> accountList = accountsPage.getAllAccounts();
        for (WebElement account : accountList) {
            System.out.println(account.getText());
        }
    }
}
