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

        try {
            String[] testq;
            String[] result1 = new String[3];
            result1[0] = "a c r";
            result1[1] = "b d";
            result1[2] = "e";
            Transpose object = new Transpose("src/main/test/resources/input1");
            testq = object.doTranspose(null, "src/main/test/resources/input1", false, false );
            assertArrayEquals(result1, testq);
        } catch (IOException e) {
        }

        try {
            String[] test2;
            String[] result2 = new String[3];
            result2[0] = "a  c  r ";
            result2[1] = "b  d ";
            result2[2] = "e ";
            Transpose object = new Transpose("src/main/test/resources/input1");
            test2 = object.doTranspose("2", "src/main/test/resources/input1", false, false);
            assertArrayEquals(test2, result2);
        } catch (IOException e) {
        }

        try {
            String[] test3;
            String[] result3 = new String[3];
            result3[0] = " a  c  r";
            result3[1] = " b  d";
            result3[2] = " e";
            Transpose object = new Transpose("src/main/test/resources/input1");
            test3 = object.doTranspose("2", "src/main/test/resources/input1", false, true);
            assertArrayEquals(test3, result3);
        } catch (IOException e) {
        }

        try {
            String[] test4;
            String[] result4 = new String[2];
            result4[0] = "it' onl tes";
            result4[1] = "jus for";
            Transpose object = new Transpose("src/main/test/resources/input2");
            test4 = object.doTranspose("3", "src/main/test/resources/input2", true, false);
            assertArrayEquals(test4, result4);
        } catch (IOException e) {
        }

        try {
            String[] test5;
            String[] result5 = new String[2];
            result5[0] = "i o t";
            result5[1] = "j f";
            Transpose object = new Transpose("src/main/test/resources/input2");
            test5 = object.doTranspose("1", "src/main/test/resources/input2", true, true);
            assertArrayEquals(test5, result5);
        } catch (IOException e) {
        }
    }

}