package main.test;

import main.java.Transpose;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransposeTest {

    @Test
    void longestTest() {
        int test = 0;
        try {
            Transpose object = new Transpose();
            test = object.findTheLongest("src/main/test/resources/input1");
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
            Transpose object = new Transpose();
            test1 = object.doTranspose(null, "src/main/test/resources/input1", false, false);
        } catch (IOException e) {
            assertArrayEquals(test1, result1);
        }

        String[] test2 = new String[3];
        String[] result2 = new String[3];
        result2[0] = "a  c  r ";
        result2[1] = "b  d ";
        result2[2] = "e ";
        try {
            Transpose object = new Transpose();
            test2 = object.doTranspose("2", "src/main/test/resources/input1", false, false);
        } catch (IOException e) {
            assertArrayEquals(test2, result2);
        }

        String[] test3 = new String[3];
        String[] result3 = new String[3];
        result3[0] = " a  c  r";
        result3[1] = " b  d";
        result3[2] = " e";
        try {
            Transpose object = new Transpose();
            test3 = object.doTranspose("2", "src/main/test/resources/input1", false, true);
        } catch (IOException e) {
            assertArrayEquals(test3, result3);
        }

        String[] test4 = new String[3];
        String[] result4 = new String[3];
        result4[0] = "it' onl tes";
        result4[1] = "jus for";
        try {
            Transpose object = new Transpose();
            test4 = object.doTranspose("3", "src/main/test/resources/input2", true, false);
        } catch (IOException e) {
            assertArrayEquals(test4, result4);
        }

        String[] test5 = new String[3];
        String[] result5 = new String[3];
        result5[0] = "i o t";
        result5[1] = "j f";
        try {
            Transpose object = new Transpose();
            test5 = object.doTranspose("1", "src/main/test/resources/input2", true, true);
        } catch (IOException e) {
            assertArrayEquals(test5, result5);
        }

    }

}