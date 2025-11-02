package api.tests.card;

import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class DepositCardTest extends BaseTestAPI {
    @Test
    public void depositCardTest() {
        Boolean response = cardEndpoints.depositCard("4809102660970296", BigDecimal.valueOf(10));
        Assert.assertTrue(response);
    }
}
