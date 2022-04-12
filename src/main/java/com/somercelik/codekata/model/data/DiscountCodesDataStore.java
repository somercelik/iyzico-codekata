package com.somercelik.codekata.model.data;

import com.somercelik.codekata.model.YearlyDiscount;
import com.somercelik.codekata.util.Utils;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * DiscountCodes
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class DiscountCodesDataStore {
    public static final Map<String, YearlyDiscount> DISCOUNTS = new HashMap<>();

    static {
        try {
            DISCOUNTS.put("GAMMA", new YearlyDiscount("GAMMA", Utils.parseDate("13.03.2022"), Utils.parseDate("13.03.2022"), 0.1f));
            DISCOUNTS.put("BECK", new YearlyDiscount("BECK", Utils.parseDate("31.03.2022"), Utils.parseDate("31.03.2022"), 0.15f));
            DISCOUNTS.put("CUNNINGHAM", new YearlyDiscount("CUNNINGHAM", Utils.parseDate("26.05.2022"), Utils.parseDate("26.05.2022"), 0.05f));
            DISCOUNTS.put("AGILE", new YearlyDiscount("AGILE", Utils.parseDate("11.02.2022"), Utils.parseDate("13.02.2022"), 0.2f));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
