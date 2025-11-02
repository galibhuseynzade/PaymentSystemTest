package api.tests.account;

import api.models.response.AccountResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllActiveAccountsTest extends BaseTestAPI {
    @Test
    public void getAllActiveAccountsTest() {
        List<AccountResponse> accountResponseList = accountEndpoints.getAllActiveAccounts();
        Assert.assertNotNull(accountResponseList);
        for (AccountResponse accountResponse : accountResponseList) {
            System.out.println(accountResponse.getAccountNumber());
        }
    }
}
