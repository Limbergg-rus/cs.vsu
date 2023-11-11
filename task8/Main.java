package ru.vsu.cs.aslanovrenat.task8;

import ru.vsu.cs.aslanovrenat.task8.Utils.SwingUtils;

import java.io.PrintStream;
import java.util.Locale;

import static ru.vsu.cs.aslanovrenat.task8.Algoritmes.calendarPrinter;
import static ru.vsu.cs.aslanovrenat.task8.CmdParams.parseArgs;
import static ru.vsu.cs.aslanovrenat.task8.InputAndOutput.inputArray;
import static ru.vsu.cs.aslanovrenat.task8.InputAndOutput.outputArray;


public class Main {
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
