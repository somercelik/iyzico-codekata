package com.somercelik.codekata.model.data;

import com.somercelik.codekata.model.Ticket;
import com.somercelik.codekata.util.Utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * TicketDataStore
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class TicketDataStore {
    public static List<Ticket> TICKETS = new ArrayList<>();

    static {
        try {
            TICKETS.add(new Ticket("Blind Bird", Utils.parseDate("01.12.2021"), Utils.parseDate("15.01.2022"), 250));
            TICKETS.add(new Ticket("Early Bird", Utils.parseDate("16.01.2022"), Utils.parseDate("28.02.2022"), 500));
            TICKETS.add(new Ticket("Regular", Utils.parseDate("01.03.2022"), Utils.parseDate("30.04.2022"), 750));
            TICKETS.add(new Ticket("Laggard", Utils.parseDate("01.05.2022"), Utils.parseDate("27.05.2022"), 1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
