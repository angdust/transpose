package com.spbstu.nikitin.transpose;

import org.apache.commons.lang.StringUtils;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Transpose {
    public static String[] transpose(String num, boolean t, boolean r, String outputFileName, String inputFileName)
            throws IOException {
        int quantity = Transpose.longest(inputFileName);
        if (quantity == -1) {
            throw new IOException("InputFile is empty");
        }
        String[] result = new String[quantity];
        String[] s;
        File input = new File(inputFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            try (FileWriter writer = new FileWriter(outputFileName, true)) {
                String st;

                while ((st = reader.readLine()) != null) {
                    s = st.split(" ");
                    if (num == null) {
                        for (int i = 0; i < s.length; i++) {
                            result[i] = result[i] + " " + s[i];
                        }
                    } else {
                        if (t) {
                            if (r) {
                                for (int i = 0; i < s.length; i++) {
                                    if (s[i].length() > parseInt(num)) {
                                        result[i] = result[i] + " " + s[i].substring(0, parseInt(num));
                                    } else {
                                        result[i] = result[i] + " " +
                                                StringUtils.leftPad(s[i], parseInt(num));
                                    }
                                }
                            } else {
                                for (int i = 0; i < s.length; i++) {
                                    if (s[i].length() > parseInt(num)) {
                                        result[i] = result[i] + " " + s[i].substring(0, parseInt(num));
                                    } else {
                                        result[i] = result[i] + " " +
                                                StringUtils.rightPad(s[i], parseInt(num));
                                    }
                                }
                            }
                        } else {
                            if (r) {
                                for (int i = 0; i < s.length; i++) {
                                    if (s[i].length() > parseInt(num)) {
                                        result[i] = result[i] + " " + s[i];
                                    } else {
                                        result[i] = result[i] + " " +
                                                StringUtils.leftPad(s[i], parseInt(num));
                                    }
                                }
                            } else {
                                for (int i = 0; i < s.length; i++) {
                                    if (s[i].length() > parseInt(num)) {
                                        result[i] = result[i] + " " + s[i];
                                    } else {
                                        result[i] = result[i] + " " +
                                                StringUtils.rightPad(s[i], parseInt(num));
                                    }
                                }
                            }
                        }
                    }
                }
                for (String aResult : result) {
                    if (aResult != null) {
                        writer.write(aResult);
                    }
                    writer.write("\n");
                }
            }
        }

        return result;
    }

    private static int longest(String inputFileName)
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
}



