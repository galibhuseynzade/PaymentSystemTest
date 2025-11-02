package api.tests.account;

import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateAccountTest extends BaseTestAPI {
    @Test
    public void activateAccountTest() {
        Boolean response = accountEndpoints.activateAccount("AZ037849376858038894");
        Assert.assertTrue(response);
    }
}
