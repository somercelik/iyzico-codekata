package com.somercelik.codekata.model.data;

import com.somercelik.codekata.model.YearlyDiscount;

import java.util.HashMap;
import java.util.Map;

/**
 * DiscountCodes
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class DiscountCodesDataStore {
    public static final Map<String, YearlyDiscount> DISCOUNTS = new HashMap<String, YearlyDiscount>() {{
        put("GAMMA", new YearlyDiscount("GAMMA", 3, 13, 0.1));
        put("BECK", new YearlyDiscount("BECK", 3, 31, 0.15));
        put("CUNNINGHAM", new YearlyDiscount("CUNNINGHAM", 5, 26, 0.05));
        put("AGILE", new YearlyDiscount("AGILE", 2, 11, 0.2));
        put("AGILE", new YearlyDiscount("AGILE", 2, 12, 0.2));
        put("AGILE", new YearlyDiscount("AGILE", 2, 13, 0.2));
    }};

}
