package com.spbstu.nikitin.transpose;

import org.apache.commons.lang.StringUtils;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Transpose {
    public static String[] transpose(String num, boolean t, boolean r, String outputFileName, String inputFileName)
            throws IOException {

        int quantity = Transpose.longest(inputFileName);
        if (quantity == -1)
            throw new IOException("InputFile is empty");


        int number = num != null ? parseInt(num) : 10;
        String[] result = new String[quantity];
        File input = new File(inputFileName);
        try (FileWriter writer = new FileWriter(outputFileName, true)) {

            result = logic(result, num, inputFileName, number, t, r);


            for (String aResult : result)
                writer.write((aResult != null ? aResult : "") + "\n");
        }

        return result;
    }

    public static int longest(String inputFileName)
            throws IOException {
        File input = new File(inputFileName);
        int max = -1;
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String st;
            while ((st = reader.readLine()) != null) {
                int s = st.split(" ").length;
                if (s > max) {
                    max = s;
                }
            }
            reader.close();
        }
        return max;
    }

    public static String[] logic(String[] result, String num, String inputFileName, int number, boolean t, boolean r)
            throws IOException {
        File input = new File(inputFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String st;
            while ((st = reader.readLine()) != null) {
                String[] s = st.split(" ");

                for (int i = 0; i < s.length; i++) {
                    boolean l = s[i].length() > number;
                    if (result[i] != null) {
                        result[i] += " ";
                        if (!t && l || !t && !r && (num == null))
                            result[i] += s[i];
                        else if (!r && !l)
                            result[i] += StringUtils.rightPad(s[i], number);
                        else if (r && !l)
                            result[i] += StringUtils.leftPad(s[i], number);
                        else
                            result[i] += s[i].substring(0, number);
                    } else {
                        if (!t && l || !t && !r && (num == null))
                            result[i] = s[i];
                        else if (!r && !l)
                            result[i] = StringUtils.rightPad(s[i], number);
                        else if (r && !l)
                            result[i] = StringUtils.leftPad(s[i], number);
                        else
                            result[i] = s[i].substring(0, number);
                    }
                }
            }
            return result;
        }

    }
}



