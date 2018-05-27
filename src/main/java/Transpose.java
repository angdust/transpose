import org.apache.commons.lang.StringUtils;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Transpose extends MatrixForTranspose {
    private String[] result;
    private int length;
    private boolean t;
    private boolean r;
    private String num;
    private String outputFileName;
    private String inputFileName;

    public Transpose() {
    }

    public Transpose(String num0, boolean t0, boolean r0, String outputFileName0, String inputFileName0) throws IOException {

        inputFileName = inputFileName0;
        length = findTheLongest();
        result = new String[length];
        t = t0;
        r = r0;
        num = num0;
        outputFileName = outputFileName0;

    }

    @Override
    public int findTheLongest() throws IOException {
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

    @Override
    public String[] writeTheResult()
            throws IOException {
        result = doTranspose();
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

    @Override
    public String[] doTranspose()
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
                        result[i] += makeTheString(l, num, s[i], number);
                    } else {
                        result[i] = makeTheString(l, num, s[i], number);
                    }
                }
            }
            return result;
        }
    }

    private String makeTheString(boolean l, String num, String word, int number) {
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



