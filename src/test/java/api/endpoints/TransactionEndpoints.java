package api.endpoints;

import api.models.response.TransactionResponse;
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
public class TransactionEndpoints {
    RequestSpecification request;

    public List<TransactionResponse> getAllTransactions() {
        TransactionResponse[] transactionResponseArray = given()
                .spec(request)
                .when()
                .get(ConfigReader.get("transactionEndpoint"))
                .then()
                .statusCode(200)
                .extract().as(TransactionResponse[].class);

        return Arrays.asList(transactionResponseArray);
    }

    public List<TransactionResponse> getTransactionsByCustomerId(Integer customerId) {
        TransactionResponse[] transactionResponseArray = given()
                .spec(request)
                .pathParam("customerId", customerId)
                .when()
                .get(ConfigReader.get("transactionEndpoint") + "/transactionsByCustomerId/{customerId}")
                .then()
                .statusCode(200)
                .extract().as(TransactionResponse[].class);

        return Arrays.asList(transactionResponseArray);
    }

    public TransactionResponse createTransaction(String debit, String credit, BigDecimal amount) {
        return given()
                .spec(request)
                .queryParam("debit", debit)
                .queryParam("credit", credit)
                .queryParam("amount", amount)
                .when()
                .post(ConfigReader.get("transactionEndpoint") + "/transfer")
                .then()
                .statusCode(200)
                .extract().as(TransactionResponse.class);
    }
}
