package com.company;

interface TSPSolver {
    void runAlgorithm();
    int[] getTour();
    double getTourDistance();
}

public class MinDistanceFinder {
    public int shortestTour[];
    public double shortestDistance;
    int secondsToRun;
    TSPSolver solver;


    public MinDistanceFinder(TSPSolver solver, int secondsToRun) {
        this.secondsToRun = secondsToRun;
        this.solver = solver;
    }
    public void findOptimalTour(){
        long t = System.currentTimeMillis();
        long end = t + secondsToRun*1000;
        shortestDistance = Double.MAX_VALUE;

        while(System.currentTimeMillis() < end) {
            solver.runAlgorithm();
            double currentDistance = solver.getTourDistance();
            if(currentDistance < shortestDistance){
                shortestTour = solver.getTour();
                // to let city location ids start at 1
                for (int i = 0; i < shortestTour.length; i++) {
                    shortestTour[i]++;
                }
                shortestDistance = currentDistance;
            }
        }
    }
    /**
     * This function returns a string with the current tour and its distance
     * @return String with the representation of the tour
     */
    public String toString() {
        String str = "[" + shortestDistance + "] : ";
        boolean add = false;
        for(int location : shortestTour) {
            if(add) {
                str += " => " + location;
            } else {
                str += location;
                add = true;
            }
        }
        return str;
    }
}
