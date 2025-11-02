package ui.tests.customerTests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import base.BaseTestUI;
import ui.pages.CustomersPage;
import ui.pages.HomePage;

import java.util.List;

public class GetCustomersTest extends BaseTestUI {
    @Test
    public void getAllCustomers() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCustomersButton();

        CustomersPage customersPage = new CustomersPage(driver);
        List<WebElement> customerList = customersPage.getCustomerList();
        for (WebElement customer : customerList) {
            System.out.println(customer.getText());
        }
    }
}
