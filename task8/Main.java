package ru.vsu.cs.aslanovrenat.oldtasks.task8;

import ru.vsu.cs.aslanovrenat.task8.Utils.SwingUtils;

import java.io.PrintStream;
import java.util.Locale;

import static ru.vsu.cs.aslanovrenat.task8.Algoritmes.calendarPrinter;
import static ru.vsu.cs.aslanovrenat.task8.InputAndOutput.inputArray;
import static ru.vsu.cs.aslanovrenat.task8.InputAndOutput.outputArray;


public class Main {
    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    //Парсинг аргументов
    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();

        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }
            params.inputFile = args[1];
            if (args.length > 2) {
                params.outputFile = args[2];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }
        if (params.window) {
            winMain();
        } else {
            String input = args[0];
            String output = args[1];
            if (input.isEmpty() || output.isEmpty()) {
                System.err.printf("Can't read file from \"%s\"%n", params.inputFile);
                System.exit(2);
            }
            outputArray(output, calendarPrinter(inputArray(input)));
        }
    }

    //Открытие окна
    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
}
