package com.somercelik.codekata.model;

/**
 * Card
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class Card {
    private String cardNumber;
    private String cvv;
    private Bank bank;
    private CardProvider provider;
    private CardType cardType;

    public Card(String cardNumber, String cvv, Bank bank, CardProvider provider, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.bank = bank;
        this.provider = provider;
        this.cardType = cardType;
    }

    public Card(Card source) {
        this(source.cardNumber, source.cvv, source.bank, source.provider, source.cardType);
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CardProvider getProvider() {
        return provider;
    }

    public void setProvider(CardProvider provider) {
        this.provider = provider;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    enum CardProvider {
        VISA,
        MASTER_CARD
    }

    enum CardType {
        DEBIT_CARD,
        CREDIT_CARD
    }
}
