package api.tests.account;

import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class DepositAccountTest extends BaseTestAPI {
    @Test
    public void depositAccountTest() {
        Boolean response = accountEndpoints.depositAccount("AZ037849376858038894", BigDecimal.valueOf(10));
        Assert.assertTrue(response);
    }
}
