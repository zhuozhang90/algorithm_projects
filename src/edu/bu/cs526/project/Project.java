package edu.bu.cs526.project;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		
		Scanner start = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter start node: ");

	    String startNode = start.nextLine().trim();  // Read user input
	    
	    start.close(); // close scanner
	    
		System.out.println();
	    
	    System.out.println("Algorithm one: "); // print results from algo one
		AlgoOne.run(startNode);
		
		System.out.println();
		
	    System.out.println("Algorithm two: "); // print results from algo two
		AlgoTwo.run(startNode);
	}

}
