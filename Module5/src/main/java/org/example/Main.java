package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // first demo
        FindAverage average = new FindAverage("grade.csv", "Final");

        // WordCount Demo
        WordCounter wordCounter = new WordCounter();

        ClassLoader classLoader = WordCounter.class.getClassLoader();

        String resourcePath = classLoader.getResource("").getPath();
        String decodedPath = URLDecoder.decode(resourcePath, StandardCharsets.UTF_8);

        File dataDir = new File(decodedPath, "input");
        File outFile = new File(decodedPath, "output//out.txt");

        try {
            wordCounter.parseFile(dataDir);
            wordCounter.outputWordCount(5, outFile);

            // displaying the out.txt content into a JFrame
            WordCounterView view = new WordCounterView();
            view.setText(wordCounter.getOutputText(outFile));
            view.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}