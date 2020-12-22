package com.company;

import java.io.*;

public class Main {

    // specify files to read from and to write to and time allowed for calculation
    // by changing printRunDetails you can choose whether you want more information about the run printed to the console
    static final String csvFileInput = "C:\\tsp\\tsp_distancematrix.csv";
    static final String csvFileOutput = "C:\\tsp\\shortestTour.csv";
    static final int secondsToRun = 10;
    static final boolean printRunDetails = true;

    public static void main(String[] args) throws IOException {

        var distances = DistanceParser.parseDistances(csvFileInput);
        if(printRunDetails){
            DistancePrinter.printDistances(distances);
            System.out.println("Waiting for optimal tour...");
        }
        var solver = new LinKernighan(distances);
        MinDistanceFinder finder = new MinDistanceFinder(solver, secondsToRun);

        // Time keeping
        long startTime = System.currentTimeMillis();

        finder.findOptimalTour();
        if(printRunDetails) {
            System.out.printf("Calculated for: %dms\n", System.currentTimeMillis() - startTime);
            System.out.println("The solution is: ");
            System.out.println(finder.toString());
        }

        // write shortest found tour to CSV file
        CSVWriter.write(csvFileOutput, finder.shortestTour);
    }

}
