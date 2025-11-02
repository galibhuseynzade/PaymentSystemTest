package api.tests.account;

import base.BaseTestAPI;
import api.models.response.AccountResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAccountsByCustomerIdTest extends BaseTestAPI {
    @Test
    public void getAccountsByCustomerIdTest() {
        List<AccountResponse> accountResponseList = accountEndpoints.getAccountsByCustomerId(14);
        Assert.assertNotNull(accountResponseList);
        for (AccountResponse accountResponse : accountResponseList) {
            System.out.println(accountResponse.getAccountNumber());
        }
    }
}
