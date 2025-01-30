package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.*;

public class WordCounter {
    private Map<String, Integer> wordCounts;
    public WordCounter() {
        wordCounts = new TreeMap<>();
    }
    public void parseFile(File file)  throws IOException {
        System.out.println("Parsing " + file.getName());

        if(file.isDirectory()){
            // parse each file
            File[] files = file.listFiles();
            for(File currentFile : files){
                parseFile(currentFile);
            }
        }else{
            Scanner scanner = new Scanner(file);

            // scan token by token
            while(scanner.hasNext()){
                String word = scanner.next();
                if(isValidWord(word)){
                    countToken(word);
                }
            }
        }
    }

    private void countToken(String word) {
        if(wordCounts.containsKey(word)){
            int previousCount = wordCounts.get(word);
            wordCounts.put(word, previousCount + 1);
        }else{
            wordCounts.put(word, 1); // first instance of the word
        }
    }

    private boolean isValidWord(String word){
//        String allLetters = "^[a-zA-Z]*$]";
        String allLetters = "^[a-zA-Z]+$";
        return word.matches(allLetters);

    }

    public String getOutputText(File outputFile){
        if(outputFile == null || !outputFile.exists() || !outputFile.isFile()){
            throw new IllegalArgumentException("Invalid output file");
        }
        try {
            return Files.readString(outputFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void outputWordCount(int minCount, File outputFile) throws IOException {
        System.out.println("Total words:" + wordCounts.keySet().size());

        if(!outputFile.exists()){
            outputFile.createNewFile();
            if(outputFile.canWrite()){
                System.out.println("Writing output file " + outputFile.getName());
                PrintWriter fileOutput = new PrintWriter(outputFile);

                Set<String> keySet = wordCounts.keySet();
                Iterator<String> keySetIterator = keySet.iterator();
                while(keySetIterator.hasNext()){
                    String word = keySetIterator.next();
                    int count = wordCounts.get(word);
                    if(count >= minCount){
                        fileOutput.println(word+": "+count);
                    }
                }
                fileOutput.close();

            }
        }else{
            System.out.println("Output file already exists" + outputFile.getAbsolutePath());
        }
    }
}
