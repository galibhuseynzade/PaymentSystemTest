package api.tests.card;

import api.models.response.CardResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllActiveCardsTest extends BaseTestAPI {
    @Test
    public void getAllActiveCardsTest(){
        List<CardResponse> cardResponseList = cardEndpoints.getAllActiveCards();
        Assert.assertNotNull(cardResponseList);
        for (CardResponse cardResponse : cardResponseList) {
            System.out.println(cardResponse.getCustomerId() + " " + cardResponse.getCardNumber());
        }
    }
}
