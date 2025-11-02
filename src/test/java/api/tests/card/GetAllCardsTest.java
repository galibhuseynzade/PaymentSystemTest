package api.tests.card;

import api.models.response.CardResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllCardsTest extends BaseTestAPI {
    @Test
    public void getAllCardsTest(){
        List<CardResponse> cardResponseList = cardEndpoints.getAllCards();
        Assert.assertNotNull(cardResponseList);
        for (CardResponse cardResponse : cardResponseList) {
            System.out.println(cardResponse.getCustomerId() + " " + cardResponse.getCardNumber() + " " + cardResponse.getStatus());
        }
    }
}
