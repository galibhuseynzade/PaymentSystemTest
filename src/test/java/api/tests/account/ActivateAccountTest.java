package api.tests.account;

import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateAccountTest extends BaseTestAPI {
    @Test
    public void activateAccountTest() {
        Boolean response = accountEndpoints.activateAccount("AZ415454784938147621");
        Assert.assertTrue(response);
    }
}
