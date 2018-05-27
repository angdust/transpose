import org.apache.commons.lang.StringUtils;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Transpose {
    public static int length;
    public static String[] result;

    public Transpose(String num, boolean t, boolean r, String outputFileName, String inputFileName) throws IOException {
        length = findTheLongest(inputFileName);
        result = new String[length];
        result = doTranspose(num, inputFileName, t, r);
        result = writeTheResult(outputFileName);
    }

    public int findTheLongest(String inputFileName)
            throws IOException {
        File input = new File(inputFileName);
        int max = -1;
        if (input.length() != 0) {
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
        } else {
            return 1;
        }
    }

    public String[] writeTheResult(String outputFileName)
            throws IOException {
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

    public String[] doTranspose(String num, String inputFileName, boolean t, boolean r)
            throws IOException {
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
                        result[i] += makeTheString(t, r, l, num, s[i], number);
                    } else {
                        result[i] = makeTheString(t, r, l, num, s[i], number);
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



