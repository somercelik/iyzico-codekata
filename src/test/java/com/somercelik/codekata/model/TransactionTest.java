package com.somercelik.codekata.model;

import com.somercelik.codekata.model.data.BankDataStore;
import com.somercelik.codekata.model.data.TicketDataStore;
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
    static Bank bank = BankDataStore.BANKS[0];
    static Transaction[] transactions;
    static Card card;

    @BeforeAll
    public static void setup() throws ParseException {
        card = new Card(
                "asdas",
                "32",
                bank,
                Card.CardProvider.MASTER_CARD,
                Card.CardType.CREDIT_CARD);


        transactions = new Transaction[]{
                new Transaction(
                        "001",
                        Utils.parseDate("02.12.2021"),
                        card,
                        null
                ),
                new Transaction(
                        "002",
                        Utils.parseDate("02.12.2021"),
                        card,
                        null
                ),
                new Transaction(
                        "003",
                        Utils.parseDate("03.03.2022"),
                        card,
                        null
                ),
                new Transaction(
                        "004",
                        Utils.parseDate("13.03.2022"),
                        card,
                        "GAMMA"
                ),
                new Transaction(
                        "005",
                        Utils.parseDate("13.03.2022"),
                        card,
                        "FOWLER"
                )
        };
    }

    @Test
    void testTransaction1() {
        assertEquals(250, transactions[0].getTicket().getPrice());
    }

    @Test
    void testTransaction2() {
        assertEquals(250, transactions[1].getTicket().getPrice());
    }

    @Test
    void testTransaction3() {
        assertEquals(750, transactions[2].getTicket().getPrice());
    }

    @Test
    void testTransaction4() {
        assertEquals(675, transactions[3].getTicket().getPrice());
    }

    @Test
    void testTransaction5() {
        assertEquals(750, transactions[4].getTicket().getPrice());
    }
}