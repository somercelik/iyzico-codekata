package com.somercelik.codekata.model;

import java.util.Date;

/**
 * DiscountCode
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class YearlyDiscount {
    private String code;
    private Date startDate;
    private Date endDate;
    private float rate;

    public YearlyDiscount(String code, Date startDate, Date endDate, float rate) {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
