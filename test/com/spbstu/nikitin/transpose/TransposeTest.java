package com.spbstu.nikitin.transpose;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.spbstu.nikitin.transpose.Transpose.logic;
import static com.spbstu.nikitin.transpose.Transpose.longest;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransposeTest {

    @Test
    void longestTest() {
        int test = 0;
        try {
            test = longest("input/input1");
        } catch (IOException e) {
            assertEquals(3, test);
        }
    }

    @Test
    void logicTest() {
        String[] test1 = new String[3];
        String[] result1 = new String[3];
        result1[0] = "a c r";
        result1[1] = "b d";
        result1[2] = "e";
        try {
            test1 = logic(test1, null, "input/input1", 10, false, false);
        } catch (IOException e) {
            assertArrayEquals(test1, result1);
        }

        String[] test2 = new String[3];
        String[] result2 = new String[3];
        result2[0] = "a  c  r ";
        result2[1] = "b  d ";
        result2[2] = "e ";
        try {
            test2 = logic(test2, "2", "input/input1", 2, false, false);
        } catch (IOException e) {
            assertArrayEquals(test2, result2);
        }

        String[] test3 = new String[3];
        String[] result3 = new String[3];
        result3[0] = " a  c  r";
        result3[1] = " b  d";
        result3[2] = " e";
        try {
            test3 = logic(test3, "2", "input/input1", 2, false, true);
        } catch (IOException e) {
            assertArrayEquals(test3, result3);
        }

        String[] test4 = new String[3];
        String[] result4 = new String[3];
        result4[0] = "it' onl tes";
        result4[1] = "jus for";
        try {
            test4 = logic(test4, "3", "input/input1", 3, true, false);
        } catch (IOException e) {
            assertArrayEquals(test4, result4);
        }

        String[] test5 = new String[3];
        String[] result5 = new String[3];
        result5[0] = "i o t";
        result5[1] = "j f";
        try {
            test5 = logic(test5, "1", "input/input1", 1, true, true);
        } catch (IOException e) {
            assertArrayEquals(test5, result5);
        }

    }

}
