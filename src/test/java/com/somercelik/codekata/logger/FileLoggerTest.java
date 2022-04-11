package com.somercelik.codekata.logger;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FileLoggerTest
 *
 * @author s84240320
 * @since 2022-04-11
 */
class FileLoggerTest {

    @Test
    void log() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("logs.txt");
        Scanner scanner = new Scanner(fileInputStream);
        int oldLineCount = 0;
        int newLineCount = 0;
        while (scanner.hasNextLine()){
            scanner.nextLine();
            oldLineCount++;
        }
        scanner.close();
        fileInputStream.close();
        fileInputStream = new FileInputStream("logs.txt");
        scanner = new Scanner(fileInputStream);
        FileLogger.getInstance().log("4543590000000006");
        while (scanner.hasNextLine()){
            scanner.nextLine();
            newLineCount++;
        }
        assertEquals(newLineCount, oldLineCount + 1);
        scanner.close();
        fileInputStream.close();
    }
}