package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVWriter {
    public static void write(String csvFileOutput, int[] shortestTour) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Path.of(csvFileOutput));
        StringBuilder sb = new StringBuilder();

        // appends location numbers and semicolons to each number (unless it's the last location of the tour)
        for (int index = 0; index < shortestTour.length; index++) {
            sb.append(String.valueOf(shortestTour[index]));
            if (index != shortestTour.length - 1) {
                sb.append(";");
            }
        }
        // writes appended string to CSV
        writer.write(sb.toString());
        writer.close();
    }
}
