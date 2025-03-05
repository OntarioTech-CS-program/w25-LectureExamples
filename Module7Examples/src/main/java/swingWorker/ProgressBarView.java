package swingWorker;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProgressBarView extends JFrame {

    private JProgressBar progressBar;
    private JButton startButton;

    public ProgressBarView() {
        setTitle("SwingWorker Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(250, 30));
        progressBar.setStringPainted(true);

        startButton = new JButton("Start");
        startButton.addActionListener(e -> startBackgroundTask());

        add(progressBar);
        add(startButton);
        setVisible(true);
    }

    private void startBackgroundTask() {
        startButton.setEnabled(false); // disable it during task processing

        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(200); // taking a while
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                for(int value: chunks){
                    progressBar.setValue(value);
                }
            }

            @Override
            protected void done() {
                startButton.setEnabled(true); // enable button again
                JOptionPane.showMessageDialog(null, "Done");
            }
        };
        worker.execute(); // start this task in background
    }
}
