package ui.tests.accountTests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import ui.pages.AccountsPage;
import ui.pages.HomePage;

import java.util.List;

public class GetCustomerAccountTest extends BaseTest {
    @Test
    public void getCustomerAccountTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountsButton();

        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.enterCustomerId("14");
        List<WebElement> accountList = accountsPage.getAccountsByCustomerId();
        for (WebElement account : accountList) {
            System.out.println(account.getText());
        }
    }
}
