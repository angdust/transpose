package com.spbstu.nikitin.transpose;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TransposeTest {

    boolean fileEquals(String outputFileName, String answerFileName)
            throws IOException {
        File output = new File(outputFileName);
        File answer = new File(answerFileName);
        try (BufferedReader readerA = new BufferedReader(new FileReader(output));
             BufferedReader readerB = new BufferedReader(new FileReader(answer))) {
            String sa;
            String sb = null;
            while (((sa = readerA.readLine()) != null) || ((sb = readerB.readLine()) != null)) {
                if (!sa.equals(sb)) return false;
            }
        }
        return true;
    }

    @Test
    void everything() {
        Transpose.transpose(null, false, false, "test\input\input.txt", )
    }
}
