import Utils.SwingUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public JButton lastPressedButton;
    public JButton button11;
    public JButton button15;
    public JButton button13;
    public JButton button45;
    public JButton button55;
    public JButton button43;
    public JButton button41;
    public JButton button53;
    public JButton button51;
    public JButton button12;
    public JButton button14;
    public JButton button44;
    public JButton button54;
    public JButton button52;
    public JButton button21;
    public JButton button22;
    public JButton button23;
    public JButton button24;
    public JButton button25;
    public JButton button35;
    public JButton button34;
    public JButton button33;
    public JButton button32;
    public JButton button31;
    public JButton button42;
    JButton[] buttons = new JButton[]{
            button11, button12, button13, button14, button15,
            button21, button22, button23, button24, button25,
            button31, button32, button33, button34, button35,
            button41, button42, button43, button44, button45,
            button51, button52, button53, button54, button55};
    static boolean xTurn = true;
    public JPanel panelMain;
    public JButton returnButton;
    public JButton resetButton;
    public JLabel playerTurn;
    public int firstPressedButton = 0;


    public Window() {
        this.setTitle("TicTacToe");
        this.setContentPane(panelMain);
        setSize(560, 660);


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                firstPressedButton = 1;
                if (xTurn) {
                    button.setText("X");
                } else {
                    button.setText("O");
                }
                button.setEnabled(false);
                if (xTurn){
                    GameConditions.checkWinner("X", buttons, playerTurn);
                } else{
                    GameConditions.checkWinner("O", buttons, playerTurn);
                }
                xTurn = !xTurn;
                GameConditions.playerTurnLabel(playerTurn);
                lastPressedButton = (JButton) e.getSource();
            }
        };



        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameConditions.restartGame(buttons, playerTurn);
                xTurn = true;
                GameConditions.playerTurnLabel(playerTurn);
                firstPressedButton = 0;
            }
        });
        //Buttons Initializing
        for (int i = 0; i < 25; i++) {
            buttons[i].addActionListener(listener);
        }

        GameConditions.playerTurnLabel(playerTurn);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstPressedButton == 0){
                    SwingUtils.showInfoMessageBox("Еще не было совершенно хода");
                } else if (lastPressedButton.getText().equals(" ")) {
                    SwingUtils.showInfoMessageBox("Отменить можно только 1 последний ход");
                } else {
                lastPressedButton.setText(" ");
                lastPressedButton.setEnabled(true);
                xTurn = !xTurn;
                GameConditions.playerTurnLabel(playerTurn);
            }
            }
        });
    }
}

