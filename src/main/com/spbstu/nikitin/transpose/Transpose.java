package main.com.spbstu.nikitin.transpose;

import org.apache.commons.lang.StringUtils;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Transpose {
    public String[] transpose(String num, boolean t, boolean r, String outputFileName, String inputFileName)
            throws IOException {
        Transpose object = new Transpose();
        int quantity = object.findTheLongest(inputFileName);
        if (quantity == -1)
            throw new IOException("Invalid input name");
        String[] result;
        result = doTranspose(num, inputFileName, t, r);
        if (outputFileName != null) {
            try (FileWriter writer = new FileWriter(outputFileName, true)) {
                for (String aResult : result)
                    writer.write((aResult != null ? aResult : "") + "\n");
            }
        } else {
            for (String bResult : result)
                System.out.println(bResult != null ? bResult : "");
        }
        return result;
    }

    public int findTheLongest(String inputFileName)
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

    public String[] doTranspose(String num, String inputFileName, boolean t, boolean r)
            throws IOException {
        Transpose object = new Transpose();
        int quantity = object.findTheLongest(inputFileName);
        String[] result = new String[quantity];
        File input = new File(inputFileName);
        int number = num != null ? parseInt(num) : 10;
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String st;
            while ((st = reader.readLine()) != null) {
                String[] s = st.split(" ");
                for (int i = 0; i < s.length; i++) {
                    boolean l = s[i].length() > number;
                    if (result[i] != null) {
                        result[i] += " ";
                        result[i] += object.makeTheString(t, r, l, num, s[i], number);
                    } else {
                        result[i] = object.makeTheString(t, r, l, num, s[i], number);
                    }
                }
            }
            return result;
        }
    }

    public String makeTheString(boolean t, boolean r, boolean l, String num, String word, int number) {
        if (!t && l || !t && !r && (num == null))
            return word;
        else if (!r && !l)
            return StringUtils.rightPad(word, number);
        else if (r && !l)
            return StringUtils.leftPad(word, number);
        else
            return word.substring(0, number);
    }
}



