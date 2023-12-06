package ru.vsu.cs.aslanovrenat.task10;

import ru.vsu.cs.aslanovrenat.task10.Utils.ArrayUtils;
import ru.vsu.cs.aslanovrenat.task10.Utils.JTableUtils;
import ru.vsu.cs.aslanovrenat.task10.Utils.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static ru.vsu.cs.aslanovrenat.task10.Algorithms.process;
import static ru.vsu.cs.aslanovrenat.task10.InputAndOutput.*;

public class Window extends JFrame {
    public static final String[] HEADERS = new String[]{"Название", "Кол-во комнат", "Общая площадь", "Площадь кухни", "Цена"};
    private JButton buttonInputFile;
    private JButton buttonOutputFile;
    private JButton buttonSort;
    private JTable tableInput;
    private JTable tableOutput;
    private JPanel panelMain;
    private JScrollPane sctollPanelInput;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public Window() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 100, true, true, true, true, HEADERS);
        JTableUtils.initJTableForArray(tableOutput, 100, true, true, true, true, HEADERS);
        tableInput.setAutoResizeMode(1);
        tableOutput.setAutoResizeMode(1);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);
        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JTableUtils.writeArrayToJTable(tableInput, new String[]{" ", " ", " ", " ", " "});
        JTableUtils.writeArrayToJTable(tableOutput, new String[]{" ", " ", " ", " ", " "});

        setSize(700, 540); // Размер окна

        //Кнопка ввода данных из файла
        buttonInputFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    //todo здесь остановка
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[][] list = new String[countLines(fileChooserOpen.getSelectedFile().getPath())][5];
                        JTableUtils.writeArrayToJTable(tableInput, inputListArray(list, fileChooserOpen.getSelectedFile().getPath()));
                    }
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Введены некорректные данные");
                }
            }
        });

        // Кнопка выполнение вывода калькулятора
        buttonSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String text = JOptionPane.showInputDialog(null,
                            "-mxpr [maximum price]\n" + "-mnpr [minimum price]\n" +
                                    "-mxta [maximum total area]\n" + "-mnta [minimum total area]\n" +
                                    "-mxka [maximum kitchen Area]\n" + "-mnka [minimum kitchen Area]\n" +
                                    "-mxcr [maximum count Room]\n" + "-mncr [minimum price]");
                    String[][] output = JTableUtils.readStringMatrixFromJTable(tableInput);
                    DataBaseRealty[] realty;
                    realty = stringToDataBase(output);
                    process(text, realty);
                    output = dataBaseToString(realty);
                    JTableUtils.writeArrayToJTable(tableOutput, output);
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Введены некорректные данные");
                }
            }
        });


        //Кнопка вывода в файл результата
        buttonOutputFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[][] output = JTableUtils.readStringMatrixFromJTable(tableOutput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        System.out.println(output.length);
                        ArrayUtils.writeArrayToFile(file, output);
                    }
                } catch (ArrayIndexOutOfBoundsException ea) {
                    SwingUtils.showInfoMessageBox("Невозможно сохранить пустой массив ");
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}