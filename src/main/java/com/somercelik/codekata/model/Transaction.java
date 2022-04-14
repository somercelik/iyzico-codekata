package com.somercelik.codekata.model;

import com.somercelik.codekata.io.FileWriter;
import com.somercelik.codekata.model.data.DiscountCodesDataStore;
import com.somercelik.codekata.model.data.TicketDataStore;
import com.somercelik.codekata.service.IyzicoTransactionValidationService;
import com.somercelik.codekata.util.Utils;

import java.util.Date;

/**
 * Transaction
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class Transaction {
    private static final FileWriter LOG = FileWriter.getInstance();
    private String id;
    private Date date;
    private Status status;
    private Ticket ticket;
    private Card card;
    private YearlyDiscount yearlyDiscount;
    private String validationMessage = "";

    public enum Status {
        PENDING,
        FAIL,
        SUCCESS
    }

    public boolean executeTransaction() {
        boolean isValidated = new IyzicoTransactionValidationService().validateTransaction(this);
        if(!isValidated) {
            return false;
        }

        boolean isCardDetailsValid = isCardDetailsValid(this.getCard());
        if(!isCardDetailsValid) {
            return false;
        }
        this.setStatus(Status.SUCCESS);
        FileWriter.getInstance().outputTransaction(this);
        FileWriter.getInstance().logTransaction(this, new Date());

        return true;
    }

    private boolean isCardDetailsValid(Card card) {
        if(!card.getBank().getAllowedCardTypes().contains(card.getCardType())){
            validationMessage += String.format("The bank %s does not allow type %s", card.getBank().getName(), card.getCardType());
            return false;
        }
        return true;
    }

    public Transaction(String id, Date date, Card card, String discountCode) {
        this.id = id;
        this.date = date;
        this.ticket = this.getTicketFromDate(date);
        this.card = card;
        this.status = Status.PENDING;
        if (discountCode != null) {
            this.yearlyDiscount = DiscountCodesDataStore.DISCOUNTS.get(discountCode);
        }

        if (ticket == null) {
            throw new IllegalArgumentException("No Ticket found for given date, " + Utils.getFormattedDate(date));
        }
        discountIfApplicable();
    }

    private void discountIfApplicable() {
        if(this.yearlyDiscount == null) {
            return;
        }

        boolean isDiscountApplicable = this.yearlyDiscount.getStartDate().getTime() <= this.date.getTime()
                        && this.yearlyDiscount.getEndDate().getTime() >= this.date.getTime();
        if (isDiscountApplicable) {
            this.ticket.discount(this.yearlyDiscount.getRate());
        }
    }

    private Ticket getTicketFromDate(Date date) {
        return (Ticket) TicketDataStore.TICKETS.stream()
                .filter(
                        t -> {
                            return date.after(t.getStartDate()) && date.before(t.getEndDate());
                        })
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .clone();
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

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setYearlyDiscount(YearlyDiscount yearlyDiscount) {
        this.yearlyDiscount = yearlyDiscount;
    }
}
