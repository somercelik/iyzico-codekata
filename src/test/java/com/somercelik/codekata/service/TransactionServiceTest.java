package com.somercelik.codekata.service;

import com.somercelik.codekata.model.Transaction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TransactionServiceTest
 *
 * @author s84240320
 * @since 2022-04-14
 */
class TransactionServiceTest {
    @Test
    public void readTransactionsTest() throws IOException {
        TransactionService service = new TransactionService();
        ArrayList<Transaction> transactions = service.readTransactions();
        assertNotEquals(0, transactions.size());
    }
}