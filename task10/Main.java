package ru.vsu.cs.aslanovrenat.oldtasks.task10;

//В качестве параметров
//        можно задать минимальное и максимальное значение для каждой характеристики
//        квартиры (количество комнат, общая площадь, площадь кухни, стоимость).

import org.apache.commons.cli.*;
import ru.vsu.cs.aslanovrenat.task10.Utils.SwingUtils;

import java.io.FileNotFoundException;
import java.util.Locale;

import static ru.vsu.cs.aslanovrenat.task10.Algorithms.*;
import static ru.vsu.cs.aslanovrenat.task10.InputAndOutput.*;

// В базе данных недвижимости хранится информация о квартирах – район города (строка),
// количество комнат, общая площадь, площадь кухни, стоимость.
public class Main {

    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | -i <in-file> -o <out-file> |[mx-/p/t/k/c] [mn-p/t/k/c])";

    public static void main(String[] args) throws FileNotFoundException {
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
                priceCondition(Integer.parseInt(cmdLine.getOptionValue("mxpr")), -1, realty);
            }
            if (cmdLine.hasOption("-mnpr")) {
                priceCondition(-1, Integer.parseInt(cmdLine.getOptionValue("mnpr")), realty);
            }
            if (cmdLine.hasOption("-mxta")) {
                totalAreaCondition(Integer.parseInt(cmdLine.getOptionValue("mxta")), -1, realty);
            }
            if (cmdLine.hasOption("-mnta")) {
                totalAreaCondition(-1, Integer.parseInt(cmdLine.getOptionValue("mnta")), realty);
            }
            if (cmdLine.hasOption("-mxka")) {
                kitchenAreaCondition(Integer.parseInt(cmdLine.getOptionValue("mxka")), -1, realty);
            }
            if (cmdLine.hasOption("-mnka")) {
                kitchenAreaCondition(-1, Integer.parseInt(cmdLine.getOptionValue("mnka")), realty);
            }
            if (cmdLine.hasOption("-mxcr")) {
                countRoomCondition(Integer.parseInt(cmdLine.getOptionValue("mxcr")), -1, realty);
            }
            if (cmdLine.hasOption("-mncr")) {
                countRoomCondition(-1, Integer.parseInt(cmdLine.getOptionValue("mncr")), realty);
            }
            String outputFilename = cmdLine.getOptionValue("o");
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