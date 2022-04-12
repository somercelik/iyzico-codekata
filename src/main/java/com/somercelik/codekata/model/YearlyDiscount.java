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
    private int month;
    private int day;
    private double rate;

    public YearlyDiscount(String code, int month, int day, double rate) {
        this.code = code;
        this.month = month;
        this.day = day;
        this.rate = rate;
    }

    public YearlyDiscount(YearlyDiscount source) {
        if(source == null) {
            return;
        }
        this.code = source.code;
        this.month = source.month;
        this.day = source.day;
        this.rate = source.rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
