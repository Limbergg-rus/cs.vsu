import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import util.ArrayUtils;
import util.SwingUtils;

import static util.ArrayUtils.toIntArray;
import static util.ArrayUtils.writeArrayToFile;

public class Frame extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton removeButton;
    private JButton addEndButton;
    private JButton searchButton;
    private JButton uploadButton;
    private JButton saveButton;
    private JButton addFirstButton;
    private JTextField textField3;
    private JPanel panelMain;
    private JButton fillRandomButton;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public Frame() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

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
        textField1.setText(ArrayUtils.arrayToString(ArrayUtils.createRandomIntArray(10, 100)));
        textField3.setText(Integer.toString(ArrayUtils.createRandomIntArray(10, 10)[0]));
        setSize(800, 540); // Размер окна

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        textField1.setText(ArrayUtils.arrayToString(arr));
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        fillRandomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textField1.setText(ArrayUtils.arrayToString(ArrayUtils.createRandomIntArray(10, 100)));
                    textField3.setText(Integer.toString(ArrayUtils.createRandomIntArray(10, 10)[0]));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = toIntArray(textField1.getText());
                    LinkedListNew newArr = LinkedListNew.fillLinkedList(arr);
                    if (Conditions.checkVariableKCondition(textField3.getText()) || Conditions.checkSizeCondition(Integer.parseInt(textField3.getText()), newArr) || Conditions.checkZeroLengthAndVariableK(newArr, textField3.getText()))
                        return;
                    textField2.setText(Integer.toString(newArr.get(Integer.parseInt(textField3.getText()))));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = toIntArray(textField1.getText());
                    LinkedListNew newArr = LinkedListNew.fillLinkedList(arr);
                    if (Conditions.checkVariableKCondition(textField3.getText()) || Conditions.checkSizeCondition(Integer.parseInt(textField3.getText()), newArr) || Conditions.checkZeroLengthAndVariableK(newArr, textField3.getText()))
                        return;
                    newArr.remove(Integer.parseInt(textField3.getText()));
                    textField2.setText(Arrays.toString(LinkedListNew.LinkedListToIntArray(newArr)));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        addEndButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = toIntArray(textField1.getText());
                    LinkedListNew newArr = LinkedListNew.fillLinkedList(arr);
                    if (Conditions.checkVariableKCondition(textField3.getText()) || Conditions.checkSizeCondition(Integer.parseInt(textField3.getText()), newArr))
                        return;
                    newArr.addLast(Integer.parseInt(textField3.getText()));
                    textField2.setText(Arrays.toString(LinkedListNew.LinkedListToIntArray(newArr)));

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        addFirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = toIntArray(textField1.getText());
                    LinkedListNew newArr = LinkedListNew.fillLinkedList(arr);
                    if (Conditions.checkVariableKCondition(textField3.getText()) || Conditions.checkSizeCondition(Integer.parseInt(textField3.getText()), newArr))
                        return;
                    newArr.addFirst(Integer.parseInt(textField3.getText()));
                    textField2.setText(Arrays.toString(LinkedListNew.LinkedListToIntArray(newArr)));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    try {
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, toIntArray(textField3.getText()));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
    }
}
