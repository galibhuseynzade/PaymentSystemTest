package api.endpoints;

import api.models.response.AccountResponse;
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
public class AccountEndpoints {
    RequestSpecification request;

    public List<AccountResponse> getAllAccounts() {
        AccountResponse[] accountResponseArray = given()
                .spec(request)
                .when()
                .get(ConfigReader.get("accountEndpoint"))
                .then()
                .statusCode(200)
                .extract().as(AccountResponse[].class);

        return Arrays.asList(accountResponseArray);
    }

    public List<AccountResponse> getAccountsByCustomerId(Integer customerId) {
        AccountResponse[] accountResponseArray = given()
                .spec(request)
                .pathParam("customerId", customerId)
                .when()
                .get(ConfigReader.get("accountEndpoint") + "/accountsByCustomerId/{customerId}")
                .then()
                .statusCode(200)
                .extract().as(AccountResponse[].class);

        return Arrays.asList(accountResponseArray);
    }

    public List<AccountResponse> getAllActiveAccounts() {
        AccountResponse[] accountResponseArray = given()
                .spec(request)
                .when()
                .get(ConfigReader.get("accountEndpoint"))
                .then()
                .statusCode(200)
                .extract().as(AccountResponse[].class);

        return Arrays.asList(accountResponseArray);
    }

    public AccountResponse createAccount(Integer customerId) {
        return given()
                .spec(request)
                .pathParam("customerId", customerId)
                .when()
                .post(ConfigReader.get("accountEndpoint") + "/{customerId}")
                .then()
                .statusCode(200)
                .extract().as(AccountResponse.class);
    }

    public Boolean activateAccount(String accountNumber) {
        return given()
                .spec(request)
                .pathParam("accountNumber", accountNumber)
                .when()
                .put(ConfigReader.get("accountEndpoint") + "/activateAccount/{accountNumber}")
                .then()
                .extract().as(Boolean.class);
    }

    public Boolean depositAccount(String accountNumber, BigDecimal amount) {
        return given()
                .spec(request)
                .pathParam("accountNumber", accountNumber)
                .queryParam("amount", amount)
                .when()
                .put(ConfigReader.get("accountEndpoint") + "/depositAccount/{accountNumber}")
                .then()
                .extract().as(Boolean.class);
    }

}
