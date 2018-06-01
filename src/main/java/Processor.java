import org.apache.commons.lang.StringUtils;

import static java.lang.Integer.parseInt;

public class Processor {
    private boolean a1;
    private boolean t1;
    private boolean r1;
    private boolean l1;
    private String word1;
    private String num1;
    private int number;

    public Processor (boolean t, boolean r, String num, int length, String word) {
        t1 = t;
        r1 = r;
        number = num != null ? parseInt(num) : 10;
        l1 = length > number;
        word1 = word;
        num1 = num;
    }

    public String doTheCorrectWord() {
        if (!t1 && l1 || !t1 && !r1 && (num1 == null))
            return word1;
        else if (!r1 && !l1)
            return StringUtils.rightPad(word1, number);
        else if (r1 && !l1)
            return StringUtils.leftPad(word1, number);
        else
            return word1.substring(0, Math.min(word1.length(), number));
    }
}
