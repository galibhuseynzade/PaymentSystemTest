package api.tests.transaction;

import api.models.response.TransactionResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CreateTransactionTest extends BaseTestAPI {
    @Test
    public void createTransactionTest() {
        TransactionResponse transactionResponse = transactionEndpoints.createTransaction(
                "AZ756367192807556146",
                "AZ037849376858038894",
                BigDecimal.valueOf(10)
        );
        Assert.assertNotNull(transactionResponse);
        System.out.println(transactionResponse.getTransactionId() + " " + transactionResponse.getStatus());
    }
}
