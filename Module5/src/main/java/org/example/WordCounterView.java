package org.example;

import javax.swing.*;
import java.awt.*;

public class WordCounterView extends JFrame {
    JTextArea textArea;

    public WordCounterView() {
        this.setTitle("Word Counter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void setText(String text) {
        textArea.setText(text);
    }
}
