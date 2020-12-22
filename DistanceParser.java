package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DistanceParser {
    public static double[][] parseDistances(String csvFile) {
        // declare character to split by, initializing size of matrix (subtracting 1 to get weights and skip numbering)
        String line = "";
        String cvsSplitBy = ";";
        var dimensions = getDimensions(csvFile);
        int lines = dimensions[0];
        int columns = dimensions[1];
        var distances = new double[lines-1][columns-1];

        // read file, fill matrix with values from file and skip the first line & first number of every line
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int lineIndex = 0;
            while ((line = br.readLine()) != null) {
                String[] splitString = line.split(cvsSplitBy);
                // skip first line to get rid of numbering from CSV file
                if(lineIndex != 0) {
                    // numberIndex starts at 1 to get rid of numbering in first column from CSV file
                    for (int numberIndex = 1; numberIndex < splitString.length; numberIndex++) {
                        distances[lineIndex - 1][numberIndex - 1] = Double.parseDouble(splitString[numberIndex]);
                    }
                }
                lineIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return distances;
    }

    // counts amount of columns and lines
    // Not needed for this exact task but makes program more flexible if different sized matrix is ever used
    public static int[] getDimensions(String csvFile) {
        int[] dimensions = new int[2];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = "";
            String cvsSplitBy = ";";
            int lineCounter = 0, numberCounter = 0;

            while ((line = br.readLine()) != null) {
                lineCounter++;
                String[] splitString = line.split(cvsSplitBy);
                numberCounter = splitString.length;
            }
            dimensions[0] = lineCounter;
            dimensions[1] = numberCounter;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return dimensions;
    }
}
