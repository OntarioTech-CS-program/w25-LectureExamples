package org.example;

import java.io.*;
import java.net.URLDecoder;

public class FindAverage {
    String colName, fileName;

    FindAverage(String fileName, String colName){
        this.colName = colName;
        this.fileName = fileName;

        // read file using the classloader
        ClassLoader classLoader = getClass().getClassLoader();

        String resourcePath = classLoader.getResource(fileName).getPath();
        String decodedPath = URLDecoder.decode(resourcePath);

        File inputFile = new File(decodedPath);

        //        parse the file
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader input = new BufferedReader(fileReader);

            // read first line with names of cols
            String header = input.readLine();
            String[] colNames = header.split(",");
            int colIndex = -1;
            // iterate over all los to find colName
            for (int i = 0; i < colNames.length; i++) {
                if (colNames[i].equals(colName)) {
                    colIndex = i;
                    break;
                }
            }

            if (colIndex == -1) {
                System.err.println("Couldn't find column " + colName);
                System.exit(1);
            }

            //        calculate the average of given colName
            float sum = 0f;
            int count = 0;
            String line;
            while ((line = input.readLine()) != null) {
                String[] data = line.split(",");
                float value = Float.parseFloat(data[colIndex]);
                sum += value;
                count++;
            }

            System.out.println("Average of " + colName + " is " + sum / count);
            input.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
