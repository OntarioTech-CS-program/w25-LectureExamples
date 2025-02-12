package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SimpleTextEditor extends JFrame {
    private JTextArea textArea;
    private File currentFile; // Stores the currently opened file
    private JMenuBar menuBar;

    public SimpleTextEditor() {
        // Set up the frame
        this.setTitle("Simple Text Editor");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Create UI components
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create menu bar
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");

        //TODO: Add menu items
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

        // Add components to frame
        this.add(scrollPane, BorderLayout.CENTER);

        // Add action listeners using lambda notation (Java 8+ supported)
        openItem.addActionListener(this::openFile);
        saveItem.addActionListener(this::saveFile);
        saveAsItem.addActionListener(this::saveFileAs);
    }

    private void openFile(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);

        // TODO: If APPROVE_OPTION, read and display the file content
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try {
                FileReader fileReader = new FileReader(currentFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                textArea.read(bufferedReader, null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void saveFile(ActionEvent e) {
        if (currentFile == null) {
            saveFileAs(e);
        } else {
            writeFile(currentFile);
        }
    }

    private void saveFileAs(ActionEvent e) {
        // TODO: Get path and name from JFileChooser and use writeFile
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            writeFile(currentFile);
        }
    }

    private void writeFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            textArea.write(writer);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SimpleTextEditor editorView =  new SimpleTextEditor();
        editorView.setVisible(true);
    }
}