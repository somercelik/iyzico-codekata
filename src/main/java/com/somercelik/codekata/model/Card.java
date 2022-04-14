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
    private Type type;

    public Card(String cardNumber, String cvv, Bank bank, CardProvider provider, Type type) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.bank = bank;
        this.provider = provider;
        this.type = type;
    }

    public Card(Card source) {
        this(source.cardNumber, source.cvv, source.bank, source.provider, source.type);
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

    public Type getCardType() {
        return type;
    }

    public void setCardType(Type type) {
        this.type = type;
    }

    public enum CardProvider {
        VISA,
        MASTER_CARD

    }

    public enum Type {
        DEBIT_CARD,
        CREDIT_CARD
    }
}
