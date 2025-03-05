package swingWorker;

import javax.swing.*;

public class SwingWorkerDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProgressBarView());
    }
}
