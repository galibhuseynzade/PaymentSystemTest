package api.tests.customer;

import base.BaseTestAPI;
import api.models.request.CustomerRequest;
import api.models.response.CustomerResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateCustomerTest extends BaseTestAPI {
    @Test
    public void createCustomerTest() {
        CustomerRequest customerRequest = CustomerRequest.builder()
                .firstName("James")
                .lastName("Bond")
                .birthDate(LocalDate.of(2000, 1, 1))
                .finCode("AA00007")
                .phoneNumber("+994557418526")
                .email("jamesbond@gmail.com")
                .build();

        CustomerResponse response = customerEndpoints.createCustomer(customerRequest);

        Assert.assertNotNull(response);
        System.out.println(response);
    }
}
