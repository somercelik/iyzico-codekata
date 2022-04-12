package com.somercelik.codekata.logger;

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
public class FileLogger {
    private static FileLogger INSTANCE;
    private static int logCount;
    private static final String LOG_FILE_PATH = "logs.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";

    private FileLogger() {
    }

    public static FileLogger getInstance() {
        if (INSTANCE == null) {
            logCount = 1;
            INSTANCE = new FileLogger();
            return INSTANCE;
        }
        return INSTANCE;
    }

    private void logToFile(String message, String path) throws IOException {
        Utils.addLineToFile(message, path);
    }

    public void log(Transaction transaction) {
        Date logTime = new Date();
        log(transaction, logTime);
    }


    public void log(Transaction transaction, Date logTime) {
        String logDatePart = Utils.getFormattedDate(logTime);
        String logCountPart = Utils.padNumber(logCount, 3);
        String logMessage = String.format("%s , %s , %s", logDatePart, logCountPart, transaction.getCard().getCardNumber());
        try {
            logToFile(logMessage, LOG_FILE_PATH);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void output(Transaction transaction, Date logTime) {
        String logDatePart = Utils.getFormattedDate(logTime);
        String logCountPart = Utils.padNumber(logCount, 3);
        String logMessage = String.format("%s , %s , %s", logDatePart, logCountPart, transaction.getCard().getCardNumber());
        try {
            logToFile(logMessage, OUTPUT_FILE_PATH);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
