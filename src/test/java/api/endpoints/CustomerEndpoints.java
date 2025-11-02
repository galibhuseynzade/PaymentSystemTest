package api.endpoints;

import api.models.request.CustomerRequest;
import api.models.response.CustomerResponse;
import config.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerEndpoints {
    RequestSpecification request;

    public CustomerResponse createCustomer(CustomerRequest body) {
        return given()
                .spec(request)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(ConfigReader.get("customerEndpoint"))
                .then()
                .statusCode(200)
                .extract().as(CustomerResponse.class);
    }

    public List<CustomerResponse> getAllCustomers() {
        CustomerResponse[] customerResponseArray = given()
                .spec(request)
                .when()
                .get(ConfigReader.get("customerEndpoint"))
                .then()
                .statusCode(200)
                .extract().as(CustomerResponse[].class);

        return Arrays.asList(customerResponseArray);
    }
}
