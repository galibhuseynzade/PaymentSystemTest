package api.tests.transaction;

import api.models.response.TransactionResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetTransactionsByCustomerIdTest extends BaseTestAPI {
    @Test
    public void getTransactionsByCustomerIdTest() {
        List<TransactionResponse> transactionResponseList = transactionEndpoints.getTransactionsByCustomerId(14);
        Assert.assertNotNull(transactionResponseList);
        for (TransactionResponse transactionResponse : transactionResponseList) {
            System.out.println(transactionResponse.getTransactionId() + " " + transactionResponse.getAmount());
        }
    }
}
