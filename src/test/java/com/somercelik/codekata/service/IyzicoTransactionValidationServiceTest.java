package com.somercelik.codekata.service;

import com.somercelik.codekata.model.Card;
import com.somercelik.codekata.model.Transaction;
import com.somercelik.codekata.model.data.BankDataStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * IyzicoTransactionValidationServiceTest
 *
 * @author s84240320
 * @since 2022-04-12
 */
class IyzicoTransactionValidationServiceTest {
    static IyzicoTransactionValidationService service;
    @BeforeAll
    public static void setup() {
        service = new IyzicoTransactionValidationService();
    }

    @Test
    void getCreditCardDetailsFromIyzico() throws Exception {
        Transaction transaction = new Transaction(
                "001",
                new Date(),
                new Card("5890040000000016", BankDataStore.BANKS.get(2), Card.CardProvider.MASTER_CARD, Card.Type.CREDIT_CARD),
                "123"
        );
        Card testCard = service.getCreditCardDetailsFromIyzico(transaction.getCard().getCardNumber());
        assertEquals(Card.Type.DEBIT_CARD, testCard.getCardType());
        assertEquals(Card.CardProvider.MASTER_CARD, testCard.getProvider());
        assertEquals("Akbank", testCard.getBank().getName());
    }
}