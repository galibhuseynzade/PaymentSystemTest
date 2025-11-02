package ui.tests.customerTests;

import org.testng.annotations.Test;
import base.BaseTestUI;
import ui.pages.CreateCustomerPage;
import ui.pages.CustomersPage;
import ui.pages.HomePage;

public class CreateCustomerTest extends BaseTestUI {
    @Test
    public void createCustomer() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCustomersButton();

        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.clickCreateCustomer();

        CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
        createCustomerPage.createCustomer(
                "galib",
                "huseyn",
                "03Apr1998",
                "ABC0001",
                "+994773212121",
                "galib@gmail.com"
        );
    }
}
