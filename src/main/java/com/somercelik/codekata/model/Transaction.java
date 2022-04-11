package com.somercelik.codekata.model;

import java.util.Date;

/**
 * Transaction
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class Transaction {
    private String id;
    private Date date;
    private String discountCode;
    private Status status;
    private enum Status {
        PENDING,
        FAIL,
        SUCCESS
    }

    public boolean executeTransaction() {
        //TODO: Execute implementation needed
        return true;
    }

    public Transaction(String id, Date date, String discountCode) {
        this.id = id;
        this.date = date;
        this.discountCode = discountCode;
        this.status = Status.PENDING;
    }

    public Transaction(Transaction source) {
        this.id = source.id;
        this.date = source.date;
        this.discountCode = source.discountCode;
        this.status = source.status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
