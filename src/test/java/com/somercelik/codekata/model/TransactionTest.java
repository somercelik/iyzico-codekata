package com.somercelik.codekata.model;

import com.somercelik.codekata.model.data.BankDataStore;
import com.somercelik.codekata.util.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TransactionTest
 *
 * @author s84240320
 * @since 2022-04-11
 */

class TransactionTest {
    static Card card;
    @BeforeAll
    public static void setup() throws ParseException {
        Bank bank = BankDataStore.BANKS.get(0);
        card = new Card(
                "asdas",
                bank,
                Card.CardProvider.MASTER_CARD,
                Card.Type.CREDIT_CARD);
    }

    @Test
    void testTransaction1() throws Exception {
        Transaction transaction = new Transaction(
                "001",
                Utils.parseDate("02.12.2021"),
                card,
                null
        );
        assertEquals(250, transaction.getTicket().getPrice());
    }

    @Test
    void testTransaction2() throws Exception {
        Transaction transaction = new Transaction(
                "002",
                Utils.parseDate("02.12.2021"),
                card,
                null
        );
        assertEquals(250, transaction.getTicket().getPrice());
    }

    @Test
    void testTransaction3() throws Exception {
        Transaction transaction = new Transaction(
                "003",
                Utils.parseDate("03.03.2022"),
                card,
                null
        );
        assertEquals(750, transaction.getTicket().getPrice());
    }

    @Test
    void testTransaction4() throws Exception {
        Transaction transaction = new Transaction(
                "004",
                Utils.parseDate("13.03.2022"),
                card,
                "GAMMA"
        );
        assertEquals(675, transaction.getTicket().getPrice());
    }

    @Test
    void testTransaction5() throws Exception {
        Transaction transaction = new Transaction(
                "005",
                Utils.parseDate("13.03.2022"),
                card,
                "FOWLER"
        );
        assertEquals(750, transaction.getTicket().getPrice());
    }
}