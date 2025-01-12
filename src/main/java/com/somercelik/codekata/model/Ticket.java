package com.somercelik.codekata.model;

import com.somercelik.codekata.model.impl.Discountable;

import java.util.Date;

/**
 * Ticket
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class Ticket implements Discountable {

    private String name;
    private Date startDate;
    private Date endDate;
    private float price;

    public Ticket(String name, Date startDate, Date endDate, float price) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Ticket(Ticket source) {
        this(source.name, source.startDate, source.endDate, source.price);
    }

    @Override
    public void discount(float rate) {
        float discountAmount = this.getPrice() * rate;
        this.setPrice(this.getPrice() - discountAmount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    protected Object clone(){
        return new Ticket(this);
    }
}
