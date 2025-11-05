package api.endpoints;

import api.models.response.AccountResponse;
import api.models.response.CardResponse;
import config.ConfigReader;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CardEndpoints {
    RequestSpecification request;

    public List<CardResponse> getAllCards() {
        CardResponse[] cardResponseArray = given()
                .spec(request)
                .when()
                .get(ConfigReader.get("cardEndpoint"))
                .then()
                .statusCode(200)
                .extract().as(CardResponse[].class);

        return Arrays.asList(cardResponseArray);
    }

    public List<CardResponse> getCardsByCustomerId(Integer customerId) {
        request.queryParam("customerId", customerId);
        CardResponse[] cardResponseArray = given()
                .spec(request)
                .when()
                .get(ConfigReader.get("cardEndpoint") + "/cardsByCustomerId/{customerId}")
                .then()
                .statusCode(200)
                .extract().as(CardResponse[].class);

        return Arrays.asList(cardResponseArray);
    }

    public List<CardResponse> getAllActiveCards() {
        CardResponse[] cardResponseArray = given()
                .spec(request)
                .when()
                .get(ConfigReader.get("cardEndpoint"))
                .then()
                .statusCode(200)
                .extract().as(CardResponse[].class);

        return Arrays.asList(cardResponseArray);
    }

    public CardResponse createCard(Integer customerId) {
        request.pathParam("customerId", customerId);
        return given()
                .spec(request)
                .when()
                .post(ConfigReader.get("cardEndpoint") + "/{customerId}")
                .then()
                .statusCode(200)
                .extract().as(CardResponse.class);
    }

    public Boolean activateCard(String cardNumber) {
        request.pathParam("cardNumber", cardNumber);
        return given()
                .spec(request)
                .when()
                .put(ConfigReader.get("cardEndpoint") + "/activateCard/{cardNumber}")
                .then()
                .extract().as(Boolean.class);
    }

    public Boolean depositCard(String cardNumber, BigDecimal amount) {
        request.pathParam("cardNumber", cardNumber);
        request.pathParam("amount", amount);
        return given()
                .spec(request)
                .when()
                .put(ConfigReader.get("cardEndpoint") + "/depositCard/{cardNumber}")
                .then()
                .extract().as(Boolean.class);
    }
}
