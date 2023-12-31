import Utils.SwingUtils;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        winMain();
    }

    public static void winMain() {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
}

