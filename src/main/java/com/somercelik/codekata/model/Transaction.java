package com.somercelik.codekata.model;

import com.somercelik.codekata.logger.FileLogger;
import com.somercelik.codekata.model.data.DiscountCodesDataStore;
import com.somercelik.codekata.model.data.TicketDataStore;
import com.somercelik.codekata.util.Utils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Transaction
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class Transaction {
    private static final FileLogger LOG = FileLogger.getInstance();
    private String id;
    private Date date;
    private Status status;
    private Ticket ticket;
    private Card card;
    private YearlyDiscount yearlyDiscount;
    enum Status {
        PENDING,
        FAIL,
        SUCCESS
    }


    public boolean executeTransaction() {
        if (!this.status.equals(Status.PENDING)){
            return false;
        }
        LOG.log(this, new Date());
        this.status = Status.SUCCESS;
        return true;
    }

    public Transaction(String id, Date date, Card card, String discountCode) {
        this.id = id;
        this.date = date;
        this.ticket = this.getTicketFromDate(date);
        this.card = card;
        this.status = Status.PENDING;
        if(discountCode != null){
            this.yearlyDiscount = DiscountCodesDataStore.DISCOUNTS.get(discountCode);
        }

        if(ticket == null) {
            throw new IllegalArgumentException("No Ticket found for given date, " + Utils.getFormattedDate(date));
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int transactionMonth = cal.get(Calendar.MONTH) + 1;
        int transactionDay = cal.get(Calendar.DAY_OF_MONTH);
        if (yearlyDiscount != null
                && transactionMonth == yearlyDiscount.getMonth()
                && transactionDay == yearlyDiscount.getDay()) {
            ticket.discount(yearlyDiscount.getRate());
        }
    }

    private Ticket getTicketFromDate(Date date) {
        return Arrays.stream(TicketDataStore.TICKETS)
                .filter(ticket -> date.after(ticket.getStartDate()) && date.before(ticket.getEndDate()))
                .findFirst()
                .orElse(null);
    }

    public Transaction(Transaction source) {
        this(source.id, source.date, source.card, source.getYearlyDiscount().getCode());
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


    public Status getStatus() {
        return status;
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public YearlyDiscount getYearlyDiscount() {
        return yearlyDiscount;
    }

    public void setYearlyDiscount(YearlyDiscount yearlyDiscount) {
        this.yearlyDiscount = yearlyDiscount;
    }
}
