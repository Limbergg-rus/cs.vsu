import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import Utils.JTableUtils;
import Utils.SwingUtils;

import static Utils.ArrayUtils.*;

public class Window extends JFrame {
    private JButton buttonOutputFile;
    private JButton buttonInputFile;
    private JButton transform;
    private JTable tableInput;
    private JTable tableOutput;
    private JPanel panelMain;
    private JTextArea textArea1;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public Window() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        String HEADERS[] = new String[]{"eMail"};
//        JTableUtils.initJTableForArray(tableInput, 100, true, true, true, false, HEADERS);
        JTableUtils.initJTableForArray(tableOutput, 100, true, true, true, false, HEADERS);
//        tableInput.setAutoResizeMode(1);
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

        JTableUtils.writeArrayToJTable(tableInput, " ");
        JTableUtils.writeArrayToJTable(tableOutput, " ");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);


        setSize(700, 540); // Размер окна

        //Кнопка ввода данных из файла
        buttonInputFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        //fileChooserOpen.getSelectedFile().getPath()
//                        String[][] arr = readStringFile(fileChooserOpen.getSelectedFile().getPath());
                        String text = readLineFromFile(fileChooserOpen.getSelectedFile().getPath());
                        textArea1.setText(text);
//                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        // Кнопка выполнение вывода калькулятора
        transform.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                HashMap<Character, Integer> allowLetters = new HashMap<>();
                HashSet<String> newEmailList = new HashSet<>();
                Logic.checkingCondition(textArea1.getText(), allowLetters, newEmailList);
                JTableUtils.writeArrayToJTable(tableOutput, hashSetTo2DString(newEmailList));
            }
        });

        //Кнопка вывода в файл результата
        buttonOutputFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    try {
                        writeStringArrayToFile(fileChooserSave.getSelectedFile().getPath(),
                                String2DtoString(JTableUtils.readStringMatrixFromJTable(tableOutput)));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
    }
}
