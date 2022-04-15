package com.somercelik.codekata.service;

import com.somercelik.codekata.model.Card;
import com.somercelik.codekata.model.Transaction;
import com.somercelik.codekata.util.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * TransactionService
 *
 * @author s84240320
 * @since 2022-04-14
 */
public class TransactionService {
    private static final String TRANSACTION_INPUT_FILE_LOCATION = "inputs.txt";

    public ArrayList<Transaction> readTransactions() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String inputContent = Utils.readTextFile(TRANSACTION_INPUT_FILE_LOCATION);
        String[] lines = inputContent.split("\n");
        Arrays.stream(lines)
                .filter(Objects::nonNull)
                .forEach(line -> {
                        try {
                            transactions.add(createTransaction(line));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        return transactions;
    }


    private Transaction createTransaction(String transactionLine) throws Exception {
        if (transactionLine == null) {
            throw new IllegalArgumentException("Line data cannot be null");
        }

        IyzicoTransactionValidationService transactionValidationService = new IyzicoTransactionValidationService();

        String[] values = Arrays.stream(transactionLine.split(",")).toArray(String[]::new);

        String transactionId;
        String cardNumber;
        String discountCode = null;
        Date date;
        transactionId = values[0].trim();
        date = Utils.parseDate(values[1].trim());
        cardNumber = values[2].trim();
        try {
            discountCode = values[3].trim();
        } catch (ArrayIndexOutOfBoundsException ex) {

        }

        Card card = transactionValidationService.getCreditCardDetailsFromIyzico(cardNumber);

        return new Transaction(transactionId, date, card, discountCode);
    }
}
