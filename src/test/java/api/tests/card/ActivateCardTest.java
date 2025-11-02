package api.tests.card;

import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateCardTest extends BaseTestAPI {
    @Test
    public void activateCardTest(){
        Boolean response = cardEndpoints.activateCard("4061996278394535");
        Assert.assertTrue(response);
    }
}
