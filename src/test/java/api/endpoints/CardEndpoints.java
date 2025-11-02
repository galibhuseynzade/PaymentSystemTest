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
        CardResponse[] cardResponseArray = given()
                .spec(request)
                .pathParam("customerId", customerId)
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
        return given()
                .spec(request)
                .pathParam("customerId", customerId)
                .when()
                .post(ConfigReader.get("cardEndpoint") + "/{customerId}")
                .then()
                .statusCode(200)
                .extract().as(CardResponse.class);
    }

    public Boolean activateCard(String cardNumber) {
        return given()
                .spec(request)
                .pathParam("cardNumber", cardNumber)
                .when()
                .put(ConfigReader.get("cardEndpoint") + "/activateCard/{cardNumber}")
                .then()
                .extract().as(Boolean.class);
    }

    public Boolean depositCard(String cardNumber, BigDecimal amount) {
        return given()
                .spec(request)
                .pathParam("cardNumber", cardNumber)
                .queryParam("amount", amount)
                .when()
                .put(ConfigReader.get("cardEndpoint") + "/depositCard/{cardNumber}")
                .then()
                .extract().as(Boolean.class);
    }
}
