import Utils.SwingUtils;

import javax.swing.*;

public class GameConditions {
    public static boolean checkWinner(String xTurn, JButton[] buttons, JLabel playerTurn) {
        if (checkRow(xTurn, buttons) || checkColumn(xTurn, buttons) || checkDiagonal(xTurn, buttons)) {
            if (xTurn == "X") {
                SwingUtils.showInfoMessageBox("Выиграл первый игрок");
            } else {
                SwingUtils.showInfoMessageBox("Выиграл второй игрок");
            }
            restartGame(buttons, playerTurn);
        }
        return false;
    }
    public static void playerTurnLabel(JLabel playerTurn) {
        if (Window.xTurn) {
            playerTurn.setText("Ход первого игрока");
        } else {
            playerTurn.setText("Ход второго игрока");
        }
    }


    public static void restartGame(JButton[] buttons, JLabel playerTurn) {
        for (int i = 0; i < 25; i++) {
            buttons[i].setText(" ");
            buttons[i].setEnabled(true);
        }
        Window.xTurn = false; // Возвращаем False потому что далее по алгоритму кнопки заменится на true
    }

    public static boolean checkColumn(String ticTacToe, JButton[] buttons) {
        for (int col = 0; col < 2; col++) {
            for (int row = 0; row < 5; row++) {
                if (getColCondition(row, col, ticTacToe, buttons)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkRow(String ticTacToe, JButton[] buttons) {
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 2; row++)
                if (getRowCondition(row, col, ticTacToe, buttons)) {
                    return true;
                }
        }
        return false;
    }

    public static boolean checkDiagonal(String ticTacToe, JButton[] buttons) {
        for (int col = 0; col < 2; col++) {
            for (int row = 0; row < 2; row++) {
                if (getDiagonaCondition(row, col, ticTacToe, buttons)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getColCondition(int row, int col, String ticTacToe, JButton[] buttons) {
        return (getPosition(row, col, buttons).equals(ticTacToe) && getPosition(row, col + 1, buttons).equals(ticTacToe) &&
                getPosition(row, col + 2, buttons).equals(ticTacToe) && getPosition(row, col + 3, buttons).equals(ticTacToe));
    }

    public static boolean getRowCondition(int row, int col, String ticTacToe, JButton[] buttons) {
        return (getPosition(row, col, buttons).equals(ticTacToe)) && getPosition(row + 1, col, buttons).equals(ticTacToe)
                && getPosition(row + 2, col, buttons).equals(ticTacToe) && getPosition(row + 3, col, buttons).equals(ticTacToe);
    }

    public static boolean getDiagonaCondition(int row, int col, String ticTacToe, JButton[] buttons) {
        return (getPosition(row, col, buttons).equals(ticTacToe) && getPosition(row + 1, col + 1, buttons).equals(ticTacToe)
                && getPosition(row + 2, col + 2, buttons).equals(ticTacToe) && getPosition(row + 3, col + 3, buttons).equals(ticTacToe));
    }

    public static String getPosition(int row, int col, JButton[] buttons) {
        return (buttons[row + col * 5].getText());
    }
}
