package com.somercelik.codekata.io;

import com.somercelik.codekata.model.Card;
import com.somercelik.codekata.model.Transaction;
import com.somercelik.codekata.model.data.BankDataStore;
import com.somercelik.codekata.util.Utils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FileLoggerTest
 *
 * @author s84240320
 * @since 2022-04-11
 */
class FileWriterTest {
    @Test
    public void logTransactionTest() throws IOException {
        int oldLineCount = Utils.getTextFileLineCount("logs.txt");
        Transaction transaction = new Transaction("001", new Date(), new Card("123123123", "001", BankDataStore.BANKS.get(0), Card.CardProvider.MASTER_CARD, Card.Type.CREDIT_CARD), "123");
        FileWriter.getInstance().logTransaction(transaction, new Date());

        int newLineCount = Utils.getTextFileLineCount("logs.txt");
        assertEquals(newLineCount, oldLineCount + 1);
    }

    @Test
    public void outputTransactionTest() throws IOException {
        int oldLineCount = Utils.getTextFileLineCount("output.txt");

        Transaction transaction = new Transaction("001", new Date(), new Card("123123123", "001", BankDataStore.BANKS.get(0), Card.CardProvider.MASTER_CARD, Card.Type.CREDIT_CARD), "123");
        transaction.executeTransaction();
        FileWriter.getInstance().outputTransaction(transaction);

        int newLineCount = Utils.getTextFileLineCount("output.txt");

        assertEquals(newLineCount, oldLineCount + 1);
    }
}