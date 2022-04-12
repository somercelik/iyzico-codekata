package com.somercelik.codekata.model.data;

import com.somercelik.codekata.model.Ticket;
import com.somercelik.codekata.util.Utils;

import java.text.ParseException;

/**
 * TicketDataStore
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class TicketDataStore {
    public static Ticket[] TICKETS;

    static {
        try {
            TICKETS = new Ticket[]{
                    new Ticket("Blind Bird", Utils.parseDate("01.12.2021"), Utils.parseDate("15.01.2022"), 250),
                    new Ticket("Early Bird", Utils.parseDate("16.01.2022"), Utils.parseDate("28.02.2022"), 500),
                    new Ticket("Regular", Utils.parseDate("01.03.2022"), Utils.parseDate("30.04.2022"), 750),
                    new Ticket("Laggard", Utils.parseDate("01.05.2022"), Utils.parseDate("27.05.2022"), 1000),
            };
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
