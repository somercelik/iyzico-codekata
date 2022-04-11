package com.somercelik.codekata.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UtilsTest
 *
 * @author s84240320
 * @since 2022-04-11
 */
class UtilsTest {

    @Test
    void getFormattedDateTest() {
        String formattedDate = Utils.getFormattedDate(new Date());
        System.out.println(formattedDate);
    }

    @Test
    void padNumberTest() {
        String formattedNumber = Utils.padNumber(3, 3);
        assertEquals("003", formattedNumber);
    }

    @Test
    void addLineToFileTest() throws IOException {
        assertTrue(Utils.addLineToFile("a", "logs.txt"));
    }
}