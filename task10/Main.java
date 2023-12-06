package ru.vsu.cs.aslanovrenat.task10;

//В качестве параметров
//        можно задать минимальное и максимальное значение для каждой характеристики
//        квартиры (количество комнат, общая площадь, площадь кухни, стоимость).

import ru.vsu.cs.aslanovrenat.task10.Utils.SwingUtils;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.util.Locale;

import static ru.vsu.cs.aslanovrenat.task10.Algorithms.*;
import static ru.vsu.cs.aslanovrenat.task10.InputAndOutput.*;

// В базе данных недвижимости хранится информация о квартирах – район города (строка),
// количество комнат, общая площадь, площадь кухни, стоимость.
public class Main {

    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | -i <in-file> -o <out-file> |[mxp/t/k/c] [mnp/t/k/c])";

    public static void main(String[] args) throws FileNotFoundException {
        int prMin = -1, prMax = -1, taMin = -1, taMax = -1, kaMin = -1, kaMax = -1, crMin = -1, crMax = -1;
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("h", "help", false, "show help");
        cmdLineOptions.addOption("w", "window", false, "show window");
        cmdLineOptions.addOption("i", "input-file", true, "input file");
        cmdLineOptions.addOption("o", "output-file", true, "output file");
        cmdLineOptions.addOption("mxpr", "max-price", true, "maximum price");
        cmdLineOptions.addOption("mxta", "max-totalArea", true, "maximum totalArea");
        cmdLineOptions.addOption("mxka", "max-kitchenArea", true, "maximum kitchenArea");
        cmdLineOptions.addOption("mxcr", "max-countRooms", true, "maximum countRooms");
        cmdLineOptions.addOption("mnpr", "min-price", true, "minimum price");
        cmdLineOptions.addOption("mnta", "min-totalArea", true, "minimum totalArea");
        cmdLineOptions.addOption("mnka", "min-kitchenArea", true, "minimum kitchenArea");
        cmdLineOptions.addOption("mncr", "min-countRooms", true, "minimum countRooms");

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
            if (!cmdLine.hasOption("i") || !cmdLine.hasOption("o")) {
                new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
                System.exit(1);
            }
            String inputFilename = cmdLine.getOptionValue("i");
            DataBaseRealty[] realty = new DataBaseRealty[countLines(inputFilename)]; // Создание класса
            inputDataBaseArray(realty, inputFilename); // Считывание из файла
            if (cmdLine.hasOption("-mxpr")) {
                prMax = Integer.parseInt(cmdLine.getOptionValue("mxpr"));
            }
            if (cmdLine.hasOption("-mnpr")) {
                prMin = Integer.parseInt(cmdLine.getOptionValue("mnpr"));
            }
            if (cmdLine.hasOption("-mxta")) {
                taMax = Integer.parseInt(cmdLine.getOptionValue("mxta"));
            }
            if (cmdLine.hasOption("-mnta")) {
                taMin = Integer.parseInt(cmdLine.getOptionValue("mnta"));
            }
            if (cmdLine.hasOption("-mxka")) {
                kaMax = Integer.parseInt(cmdLine.getOptionValue("mxka"));
            }
            if (cmdLine.hasOption("-mnka")) {
                kaMin = Integer.parseInt(cmdLine.getOptionValue("mnka"));
            }
            if (cmdLine.hasOption("-mxcr")) {
                crMax = Integer.parseInt(cmdLine.getOptionValue("mxcr"));
            }
            if (cmdLine.hasOption("-mncr")) {
                crMin = Integer.parseInt(cmdLine.getOptionValue("mncr"));
            }
            String outputFilename = cmdLine.getOptionValue("o");
            sortingByParams(realty, prMin , prMax , taMin , taMax , kaMin , kaMax ,  crMin ,  crMax);
            outputDataBaseArray(realty, outputFilename); // Запись в файл
        }
    }


    private static void winMain() {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);

            }
        });
    }
}