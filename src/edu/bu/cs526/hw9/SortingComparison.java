package edu.bu.cs526.hw9;

import java.util.Random;

public class SortingComparison {

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		// loops through array and print all ints
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/**
	 * generate a list of ints
	 * 
	 * @return the list of ints
	 */
	public static int[] generateInts(int numInts, int range) {
		int[] ints = new int[numInts];

		// generate random numbers based on current time
		Random r = new Random(System.currentTimeMillis());

		// add ints to list
		for (int i = 0; i < numInts; i++) {
			ints[i] = r.nextInt(range) + 1;
		}

		return ints;
	}

	// measure three sorting algorithms and return each iteration
	// get difference in millisecs
	static long measureInsertionSort(int[] arr) {
		long startTime = System.currentTimeMillis();

		InsertionSort.insertionSort(arr);

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;

		return elapsedTime;
	}
	
	static long measureMergeSort(int[] arr) {
		long startTime = System.currentTimeMillis();

		MergeSort.mergeSort(arr);

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;

		return elapsedTime;
	}

	static long measureQuickSort(int[] arr) {
		long startTime = System.currentTimeMillis();

		QuickSort.quickSort(arr);

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;

		return elapsedTime;
	}

	static long measureHeapSort(int[] arr) {
		long startTime = System.currentTimeMillis();

		HeapSort.heapSort(arr);

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;

		return elapsedTime;
	}

	// Driver program
	public static void main(String args[]) {
		int numInts = 10000; // base of int nums
		int range = 1000000; // range of random ints
		
		for (int i = 1; i < 11; i++) {
			// get num of ints
			int num = i * numInts;
			System.out.println("\n" + num + " ints");
			// generate array of ints, each time it uses a new Random object to reduce duplicates
			int[] arr = generateInts(num, range);
			
			// measure all four sorts
			System.out.println("Insertion: " + measureInsertionSort(arr));
			System.out.println("Merge: " + measureMergeSort(arr));
			System.out.println("Quick: " + measureQuickSort(arr));
			System.out.println("Heap: " + measureHeapSort(arr));
		}
	}
}
