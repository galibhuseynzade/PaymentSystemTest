package base;

import api.endpoints.AccountEndpoints;
import api.endpoints.CardEndpoints;
import api.endpoints.CustomerEndpoints;
import api.endpoints.TransactionEndpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.testng.annotations.BeforeClass;
import config.ConfigReader;

import static io.restassured.RestAssured.given;

@FieldDefaults(level = AccessLevel.PROTECTED)
public class BaseTestAPI {
    RequestSpecification request;
    CustomerEndpoints customerEndpoints;
    AccountEndpoints accountEndpoints;
    CardEndpoints cardEndpoints;
    TransactionEndpoints transactionEndpoints;

    @BeforeClass
    public void setUp() {
        request = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("baseUrl"))
                .addHeader("Authorization", "Bearer " + getToken())
                .build();

        setEndpoints();
    }

    private String getToken() {
        return given().contentType("application/x-www-form-urlencoded")
                .formParam("username", "admin")
                .formParam("password", "admin")
                .when()
                .post("/api/v1/auth/login")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getString("token");
    }

    private void setEndpoints() {
        customerEndpoints = new CustomerEndpoints(request);
        accountEndpoints = new AccountEndpoints(request);
        cardEndpoints = new CardEndpoints(request);
        transactionEndpoints = new TransactionEndpoints(request);
    }
}
