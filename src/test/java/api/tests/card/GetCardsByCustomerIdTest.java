package api.tests.card;

import api.models.response.CardResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetCardsByCustomerIdTest extends BaseTestAPI {
    @Test
    public void getCardsByCustomerId() {
        List<CardResponse> cardResponseList = cardEndpoints.getCardsByCustomerId(3);
        Assert.assertNotNull(cardResponseList);
        for (CardResponse cardResponse : cardResponseList) {
            System.out.println(cardResponse.getCardNumber());
        }
    }
}
