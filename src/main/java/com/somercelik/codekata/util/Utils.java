package com.somercelik.codekata.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utils
 *
 * @author s84240320
 * @since 2022-04-11
 */
public class Utils {
    private static final String DATE_PATTERN = "dd.MM.yyyy HH:mm:ss";
    private static final String LINE_TERM = "\n";

    public static String getFormattedDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        return simpleDateFormat.format(date);
    }

    public static String padNumber(int number, int padding) {
        return String.format("%0" + padding + "d", number);
    }

    public static boolean addLineToFile(String text, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, true);
        try {
            fileWriter.write(text + LINE_TERM);
            return true;
        } catch (IOException e){
            throw new IOException(e);
        } finally {
            fileWriter.close();
        }
    }
}
