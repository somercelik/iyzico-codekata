package com.somercelik.codekata.model;

import com.somercelik.codekata.model.data.BankDataStore;
import com.somercelik.codekata.util.Utils;

import java.text.ParseException;
import java.util.Arrays;

/**
 * TransactionController
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class TransactionController {

    private Transaction createTransaction(String transactionLine) throws ParseException {
        if(transactionLine == null) {
            throw new IllegalArgumentException("Line data cannot be null");
        }
        String[] values = Arrays.stream(transactionLine
                .split(","))
                .map(item -> item.trim())
                .toArray(String[]::new);
        return new Transaction(
                values[0],
                Utils.parseDate(values[1]),
                new Card(values[2],"083", BankDataStore.BANKS.get(0), Card.CardProvider.MASTER_CARD, Card.Type.CREDIT_CARD),
                values[3]
                );
    }
}
