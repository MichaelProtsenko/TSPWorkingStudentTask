# TSPWorkingStudentTask
A solver for the Traveling Salesman Problem using the Lin-Kernighan algorithm.

### Usage:

- Open the Main.java class and paste the path to your input and output files (examples are included in the repository)
- Choose the allowed runtime by adjusting the secondsToRun variable (for the example file with 29 locations >10 seconds are enough to come up with an optimal solution) 
- Run the project 

---

This program was written as part of a working student task for a company specializing in online food ordering and home delivery.
It takes a CSV file with distances between two locations in form of a CSV file as input and writes the optimal path to another CSV file. 

Since finding an exact solution for 29 locations would take way too much time (complexity of O(n^2*2^n)), I decided to use a heuristical approach. After analyzing several heuristic algorithms, I decided to settle for the Lin-Kernighan algorithm, as I found some good resources to learn more about it and a [great implementation on GitHub](https://github.com/RodolfoPichardo/LinKernighanTSP/).
After analyzing the task, I decided I’m going to use an interface to solve the TSP with a method than takes distances as input and returns an array with the optimal tour. For parsing the distances and writing the optimal tour to a CSV I wrote two classes – DistanceParser and CSVWriter. 	

The classes “LinKernighan” (containing the actual algorithm) and “Edge” (representing a path between two locations) were taken from the already existing implementation
and slightly edited to fit the formatting of the parsed CSV file. The implementation is heavily based on the paper 
“An Effective Heuristic Algorithm for the Traveling-Salesman Problem" by Shen Lin and Brian Kernighan. To make it short, the program starts by creating a random tour using the 
“drunken sailor algorithm”, which then gets more and more improved by the “improve” methods in the LinKernighan class. 	

What I didn’t expect is how fast a single run of the algorithm finds a solution – one run of the Lin-Kernighan implementation needs about 60-70ms on my machine to come up with a tour. The whole process gets repeated until the allowed time to run (specified in main’s secondsToRun variable) is up. The tour with the shortest total distance gets saved and written to the CSV file by the CSVWriter class once the program is done.

According to my tests it seems like a total distance of 1610 is the shortest the algorithm can find. After doing some research on the internet I found out that this specific dataset (usually referred to as bayg29) is often used for TSP problems. According to [this document](https://www.or.uni-bonn.de/lectures/ws17/co_exercises/programming/tsp/tsp95.pdf) by Gerhard Reinelt from the University of Heidelberg, 1610 indeed seems to be the shortest possible distance. With only one second of allowed runtime the algorithm comes up with a tour that has a distance between 1610 and 1650 - anything longer than 10 seconds pretty much always results in the optimal solution of 1610.

For reference, here is the machine the program was written on and tested with:

- Intel NUC8i5BEK 
- Intel(R) Core(TM) i5-8259U CPU @ 2.30 GHz, 2304 MHz, 4 Core(s), 8 Logical Processor(s) 
- 32GB RAM
