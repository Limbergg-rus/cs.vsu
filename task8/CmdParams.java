package ru.vsu.cs.aslanovrenat.task8;

public class CmdParams {
    public String inputFile;
    public String outputFile;
    public boolean error;
    public boolean help;
    public boolean window;
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
}
