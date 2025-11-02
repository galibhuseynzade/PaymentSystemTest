package api.tests.card;

import api.models.response.CardResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCardTest extends BaseTestAPI {
    @Test
    public void createCardTest(){
        CardResponse cardResponse = cardEndpoints.createCard(30);
        Assert.assertNotNull(cardResponse);
        System.out.println(cardResponse.getCardNumber());
    }
}
