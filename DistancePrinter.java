package com.company;

public class DistancePrinter {
    public static void printDistances(double[][] distances) {
        System.out.println("Imported distances:");
        for (int i = 0; i < distances[0].length; i++) {
            System.out.println("");
            for (int j = 0; j < distances[1].length; j++) {
                System.out.print(distances[i][j] + " ");
            }
        }
        System.out.println("");
    }
}
