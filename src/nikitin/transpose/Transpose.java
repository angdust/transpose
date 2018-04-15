package nikitin.transpose;

import org.apache.commons.lang.StringUtils;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Transpose {
    public static String[] transpose(String num, boolean t, boolean r, String outputFileName, String inputFileName)
            throws IOException {
        String[] result = new String[0];
        String[] s;
        File input = new File(inputFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            try (FileWriter writer = new FileWriter(outputFileName, true)) {


                while (reader.readLine() != null) {
                    s = reader.readLine().split(" ");
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
                                                org.apache.commons.lang.StringUtils.leftPad(s[i], parseInt(num));
                                    }
                                }
                            } else {
                                for (int i = 0; i < s.length; i++) {
                                    if (s[i].length() > parseInt(num)) {
                                        result[i] = result[i] + " " + s[i].substring(0, parseInt(num));
                                    } else {
                                        result[i] = result[i] + " " +
                                                org.apache.commons.lang.StringUtils.rightPad(s[i], parseInt(num));
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
                                                org.apache.commons.lang.StringUtils.leftPad(s[i], parseInt(num));
                                    }
                                }
                            } else {
                                for (int i = 0; i < s.length; i++) {
                                    if (s[i].length() > parseInt(num)) {
                                        result[i] = result[i] + " " + s[i];
                                    } else {
                                        result[i] = result[i] + " " +
                                                org.apache.commons.lang.StringUtils.rightPad(s[i], parseInt(num));
                                    }
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < result.length; i++) {
                    writer.write(result[i]);
                }
            }
        }

        return result;
    }


}
