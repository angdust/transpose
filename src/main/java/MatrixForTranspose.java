import java.io.IOException;

public abstract class MatrixForTranspose {
    private String[] result;
    private int length;
    private boolean t;
    private boolean r;
    private String num;

    public abstract int findTheLongest () throws IOException;

    public abstract String[] writeTheResult() throws IOException;

    public abstract String[] doTranspose() throws IOException;
}
