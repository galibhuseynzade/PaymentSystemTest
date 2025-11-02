package api.tests.transaction;

import api.models.response.TransactionResponse;
import base.BaseTestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllTransactionsTest extends BaseTestAPI {
    @Test
    public void getAllTransactionsTest() {
        List<TransactionResponse> transactionResponseList = transactionEndpoints.getAllTransactions();
        Assert.assertNotNull(transactionResponseList);
        for (TransactionResponse transactionResponse : transactionResponseList) {
            System.out.println(transactionResponse.getTransactionId() + " " + transactionResponse.getAmount());
        }
    }
}
