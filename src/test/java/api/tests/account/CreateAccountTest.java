package api.tests.account;

import api.models.response.AccountResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTestAPI {
    @Test
    public void createAccountTest() {
        AccountResponse accountResponse = accountEndpoints.createAccount(29);
        Assert.assertNotNull(accountResponse);
        System.out.println(accountResponse.getAccountNumber());
    }
}
