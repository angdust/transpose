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
                    String x;
                    int number = 0;
                    if (num == null) {
                        x = "0";
                    } else {
                        x = "1";
                        number = parseInt(num);
                    }
                    if (t) {
                        x += "1";
                    } else {
                        x += "0";
                    }
                    if (r) {
                        x += "1";
                    } else {
                        x += "0";
                    }

                    switch (x) {
                        case "000":
                            for (int i = 0; i < s.length; i++) {
                                result[i] = usualAdd(result[i], s[i]);
                            }
                            break;

                        case "001":
                            for (int i = 0; i < s.length; i++) {
                                if (s[i].length() > 10) {
                                    result[i] = usualAdd(result[i], s[i]);
                                } else {
                                    result[i] = addForLong(result[i], s[i], 10, r);
                                }
                            }
                            break;

                        case "010":
                            for (int i = 0; i < s.length; i++) {
                                if (s[i].length() > number) {
                                    result[i] = addForShort(result[i], s[i], 10);
                                } else {
                                    result[i] = addForLong(result[i], s[i], 10, r);
                                }
                            }
                            break;

                        case "011":
                            for (int i = 0; i < s.length; i++) {
                                if (s[i].length() > number) {
                                    result[i] = addForShort(result[i], s[i], 10);
                                } else {
                                    result[i] = addForLong(result[i], s[i], 10, r);
                                }
                            }
                            break;

                        case "100":
                            for (int i = 0; i < s.length; i++) {
                                if (s[i].length() > number) {
                                    result[i] = usualAdd(result[i], s[i]);
                                } else {
                                    result[i] = addForLong(result[i], s[i], number, r);
                                }
                            }
                            break;

                        case "101":
                            for (int i = 0; i < s.length; i++) {
                                if (s[i].length() > number) {
                                    result[i] = usualAdd(result[i], s[i]);
                                } else {
                                    result[i] = addForLong(result[i], s[i], number, r);
                                }
                            }
                            break;

                        case "110":
                            for (int i = 0; i < s.length; i++) {
                                if (s[i].length() > number) {
                                    result[i] = addForShort(result[i], s[i], number);
                                } else {
                                    result[i] = addForLong(result[i], s[i], number, r);
                                }
                            }
                            break;

                        case "111":
                            for (int i = 0; i < s.length; i++) {
                                if (s[i].length() > number) {
                                    result[i] = addForShort(result[i], s[i], number);
                                } else {
                                    result[i] = addForLong(result[i], s[i], number, r);
                                }
                            }
                            break;
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

    private static String usualAdd(String res, String val) {
        if (res != null) {
            return res + " " + val;
        } else {
            return val;
        }
    }

    private static String addForShort(String res, String val, int num) {
        if (res != null) {
            return res + " " + val.substring(0, num);
        } else {
            return val.substring(0, num);
        }
    }

    private static String addForLong(String res, String val, int num, boolean r) {
        if (r) {
            if (res != null) {
                return res + " " + StringUtils.leftPad(val, num);
            } else {
                return StringUtils.leftPad(val, num);
            }
        } else {
            if (res != null) {
                return res + " " + StringUtils.rightPad(val, num);
            } else {
                return StringUtils.rightPad(val, num);
            }
        }
    }
}



