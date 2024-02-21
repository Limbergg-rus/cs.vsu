import util.SwingUtils;

public class Conditions {
    public static boolean checkSizeCondition(int k, LinkedListNew newArr) {
        if (k > newArr.size) {
            SwingUtils.showInfoMessageBox("число k больше длины массива");
            return true;
        }
        return false;
    }

    public static boolean checkZeroLengthAndVariableK(LinkedListNew newArr, String k) {
        if (newArr.size == Integer.parseInt(k)){
            SwingUtils.showInfoMessageBox("Введите массив");
            return true;
        }
        return false;
    }

    public static boolean checkVariableKCondition(String k) {
        if (k.trim().isEmpty()) {
            SwingUtils.showInfoMessageBox("Введите число k");
            return true;
        }
        return false;
    }
}
