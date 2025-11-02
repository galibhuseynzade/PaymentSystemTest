package api.tests.account;

import base.BaseTestAPI;
import api.models.response.AccountResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllAccountsTest extends BaseTestAPI {
    @Test
    public void getAllAccountsTest() {
        List<AccountResponse> accountResponseList = accountEndpoints.getAllAccounts();
        for (AccountResponse accountData : accountResponseList) {
            System.out.println(accountData.toString());
        }

        Assert.assertNotNull(accountResponseList);
    }
}
