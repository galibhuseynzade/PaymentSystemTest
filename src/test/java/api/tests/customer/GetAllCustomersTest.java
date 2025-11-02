package api.tests.customer;

import base.BaseTestAPI;
import api.models.response.CustomerResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllCustomersTest extends BaseTestAPI {
    @Test
    public void getAllCustomersTest() {
        List<CustomerResponse> customerResponseList = customerEndpoints.getAllCustomers();
        for (CustomerResponse customerData : customerResponseList) {
            System.out.println(customerData.getCustomerId() + " " + customerData.getFirstName() + " " + customerData.getLastName());
        }
        Assert.assertNotNull(customerResponseList);
    }
}
