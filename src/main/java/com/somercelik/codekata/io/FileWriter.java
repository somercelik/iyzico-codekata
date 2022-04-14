package com.somercelik.codekata.io;

import com.somercelik.codekata.model.Transaction;
import com.somercelik.codekata.util.Utils;

import java.io.IOException;
import java.util.Date;

/**
 * FileLogger
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class FileWriter {
    private static FileWriter INSTANCE;
    private static final String LOG_FILE_PATH = "logs.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";

    private FileWriter() {
    }

    public static FileWriter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileWriter();
            return INSTANCE;
        }
        return INSTANCE;
    }

    private void logToFile(String message, String path) throws IOException {
        Utils.addLineToFile(message, path);
    }



    public void logTransaction(Transaction transaction, Date apiCallTime) {
        String logDatePart = Utils.getFormattedDate(apiCallTime);
        String logMessage = String.format("%s , %s , %s", logDatePart, transaction.getId(), transaction.getCard().getCardNumber());
        try {
            logToFile(logMessage, LOG_FILE_PATH);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void outputTransaction(Transaction transaction) {
        if(transaction.getStatus() == Transaction.Status.PENDING){
            throw new IllegalArgumentException("Transaction has not processed yet.");
        }
        String logMessage = String.format("%s , %s , %s", transaction.getId(), transaction.getStatus(), transaction.getCard().getCardNumber());
        try {
            logToFile(logMessage, OUTPUT_FILE_PATH);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
