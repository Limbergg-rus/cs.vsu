package ru.vsu.cs.aslanovrenat.oldtasks.task8.Utils.task8;

import ru.vsu.cs.aslanovrenat.task8.Utils.task8.Utils.ArrayUtils;
import ru.vsu.cs.aslanovrenat.task8.Utils.task8.Utils.JTableUtils;
import ru.vsu.cs.aslanovrenat.task8.Utils.task8.Utils.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Window extends JFrame {
    private JButton buttonLoadInputFromFile;
    private JButton buttonSaveInputInfoFile;
    private JButton outputFileButton;
    private JTable tableInput;
    private JTable tableOutput;
    private JPanel panelMain;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;

    public Window() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 80, true, true, true, true);
        JTableUtils.initJTableForArray(tableOutput, 40, true, true, true, true);
        //tableOutput.setEnabled(false);
        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);

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

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);


        JTableUtils.writeArrayToJTable(tableInput, new int[][]{
                {11, 2023}
        });
        this.pack();
        setSize(700, 540); // Размер окна

        //Кнопка ввода данных из файла
        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        // Кнопка выполнение вывода калькулятора
        outputFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] matrix = JTableUtils.readIntArrayFromJTable(tableInput);
                    if (matrix[0] < 1 || matrix[0] > 12 || matrix[1] < 0) {
                        JOptionPane.showMessageDialog(null, "Введены некорректные данные");
                    } else {
                        JTableUtils.writeArrayToJTable(tableOutput, Algoritmes.calendarPrinter(matrix));
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });


        //Кнопка вывода в файл результата
        buttonSaveInputInfoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] matrix = JTableUtils.readIntMatrixFromJTable(tableOutput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, matrix);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

}
