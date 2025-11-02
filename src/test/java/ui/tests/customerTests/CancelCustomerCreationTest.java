package ui.tests.customerTests;

import org.testng.annotations.Test;
import base.BaseTestUI;
import ui.pages.CreateCustomerPage;
import ui.pages.CustomersPage;
import ui.pages.HomePage;

public class CancelCustomerCreationTest extends BaseTestUI {
    @Test
    public void cancelCustomerCreation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCustomersButton();

        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.clickCreateCustomer();

        CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
        createCustomerPage.cancel();
    }
}
