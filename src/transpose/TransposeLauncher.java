package transpose;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class TransposeLauncher {
    @Option(name = "-a", required = true, metaVar = "Number", usage = "Number of symbols for writing")
    private String num;

    @Option(name = "-t", metaVar = "Cutter", usage = "Cut the length to num")
    private boolean t;

    @Option(name = "-r", metaVar = "Align", usage = "Align right")
    private boolean r;

    @Option(name = "-o", metaVar = "OutputName", usage = "Output file name")
    private String outputFileName;

    @Argument(required = true, metaVar = "InputName", usage = "Input file name")
    private String inputFileName;

    public static void main(String[] args) {
        new TransposeLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Expected arguments: [-a num][-t][-r][-o OutputName] InputName");
            parser.printUsage(System.err);
            return;
        }

        try {
            String[] result = Transpose.transpose(num, t, r, outputFileName, inputFileName);
            //

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
