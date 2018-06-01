import java.io.*;

public class Transpose {
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

    public String[] doTranspose()
            throws IOException {
        File input = new File(inputFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String st;
            while ((st = reader.readLine()) != null) {
                String[] s = st.split(" ");
                for (int i = 0; i < s.length; i++) {
                    Processor object = new Processor(t, r, num, s[i].length(), s[i]);
                    if (result[i] != null) {
                        result[i] += " ";
                        result[i] += object.doTheCorrectWord();
                    } else {
                        result[i] = object.doTheCorrectWord();
                    }
                }
            }
            return result;
        }
    }

}



