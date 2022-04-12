package com.somercelik.codekata.model.data;

import com.somercelik.codekata.model.Bank;
import com.somercelik.codekata.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BankDataStore
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class BankDataStore {
    public static final List<Bank> BANKS = new ArrayList<>();

    static {
        ArrayList<Card.Type> allTypes = new ArrayList<>();
        allTypes.add(Card.Type.CREDIT_CARD);
        allTypes.add(Card.Type.DEBIT_CARD);

        ArrayList<Card.Type> onlyCredit = new ArrayList<>();
        onlyCredit.add(Card.Type.CREDIT_CARD);

        BANKS.add(new Bank("Garanti Bankası", onlyCredit));
        BANKS.add(new Bank("İş Bankası", onlyCredit));
        BANKS.add(new Bank("Akbank", onlyCredit));
        BANKS.add(new Bank("Finansbank", allTypes));

    }
}
