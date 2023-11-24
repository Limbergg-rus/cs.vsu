package ru.vsu.cs.aslanovrenat.oldtasks.task9;

import org.apache.commons.cli.*;
import ru.vsu.cs.aslanovrenat.oldtasks.task9.Utils.SwingUtils;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static ru.vsu.cs.aslanovrenat.oldtasks.task9.InputAndOutput.inputListArray;
import static ru.vsu.cs.aslanovrenat.oldtasks.task9.InputAndOutput.outputListArray;

public class Main {
    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | -i <in-file> [-o <out-file>])";

    public static void main(String[] args) throws FileNotFoundException {

        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("h", "help", false, "Show help");
        cmdLineOptions.addOption("w", "window", false, "Use window user interface");
        cmdLineOptions.addOption("i", "input-file", true, "Input file");
        cmdLineOptions.addOption("o", "output-file", true, "Output file");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = null;

        try {
            cmdLine = parser.parse(cmdLineOptions, args);
        } catch (Exception e) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }

        if (cmdLine.hasOption("h")) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }
        if (cmdLine.hasOption("w")) {
            winMain();
        } else {
            if (!cmdLine.hasOption("i")) {
                new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
                System.exit(1);
            }
            String inputFilename = cmdLine.getOptionValue("i");
            List<Integer> zero = new ArrayList<>();
            zero = inputListArray(inputFilename);
            Algorithms.process(zero);
            String outputFilename = cmdLine.getOptionValue("o");
            outputListArray(outputFilename, zero);

            if (zero == null) {
                System.err.printf("Can't read array from \"%s\"%n", inputFilename);
                System.exit(2);
            }

            PrintStream out = (cmdLine.hasOption("o")) ? new PrintStream(cmdLine.getOptionValue("o")) : System.out;
            out.println(zero);
            out.close();
        }
    }

    public static void winMain() {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
}
