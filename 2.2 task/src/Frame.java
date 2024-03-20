import util.ArrayUtils;
import util.SwingUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JButton executeButton;
    private JTextField textFieldInput;
    private JTextField textFieldOutput;
    private JPanel panelMain;
    private JButton ButtonUpload;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public Frame() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setSize(700, 540);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textFieldOutput.setText(String.valueOf(Algorithm.reversePolishNotationSecond(InputOutput.parrseString(textFieldInput.getText()))));
                } catch (Exception ex) {
                    SwingUtils.showInfoMessageBox("Введены некорректные данные");
                }
            }
        });


        ButtonUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        textFieldInput.setText(ArrayUtils.readLineFromFile(fileChooserOpen.getSelectedFile().getPath()));

                    }
                } catch (Exception ex) {
                    SwingUtils.showErrorMessageBox(ex);
                }
            }
        });
    }
}
