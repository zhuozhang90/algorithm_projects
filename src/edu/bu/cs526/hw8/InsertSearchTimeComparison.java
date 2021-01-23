package edu.bu.cs526.hw8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class InsertSearchTimeComparison {
	
	/**
	 * generate a list of ints
	 * @return the list of ints
	 */
	public static int[] generateInts(int numInts, int range) {
		int[] ints = new int[numInts];
		
		// generate random numbers based on current time
		Random r = new Random(System.currentTimeMillis());

		// add ints to list
		for(int i = 0; i < numInts; i++) {
			ints[i] = r.nextInt(range) + 1;
		}
		
		return ints;
	}
	
	/**
	 * get avg time of a list of times
	 * @param times
	 * @return avg of ten ints in list
	 */
	public static double getAvgTime(long[] times) {
		int size = times.length;
		double sum = 0;
		for (long each : times) {
			sum += each;
		}
		double avg = sum / size;
		return avg;
	}
	
	/**
	 * measure insertion time for hashmap
	 * @param map to populate
	 * @param ints to insert
	 * @return time to insert all ints
	 */
	public static long measureHashMap(HashMap<Integer, ?> map, int[] ints) {
		// get current time
		long startTime = System.currentTimeMillis();
		
		// insert each int
		for (int each : ints) {
			map.put(each, null);
		}		
		
		// get elapsed time
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		
		return elapsedTime;
		
	}
	
	/**
	 * 
	 * @param map
	 * @param ints
	 * @return time to search all ints in map
	 */
	public static long searchHashMap(HashMap<Integer, ?> map, int[] ints) {
		long startTime = System.currentTimeMillis();
		
		// just searching no returning to reduce overhead
		for (int each : ints) {
			map.containsKey(each);
		}		
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		
		return elapsedTime;
	}
	
	/**
	 * measure insertion time for arrayList
	 * @param list
	 * @param ints
	 * @return
	 */
	public static long measureArrayList(ArrayList<Integer> list, int[] ints) {
		long startTime = System.currentTimeMillis();
		
		for (int each : ints) {
			list.add(each);
		}		
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		
		return elapsedTime;
		
	}
	
	/**
	 * 
	 * @param list
	 * @param ints
	 * @return time it takes to search all ints in arraylist
	 */
	public static long searchArrayList(ArrayList<Integer> list, int[] ints) {
		long startTime = System.currentTimeMillis();
		
		for (int each : ints) {
			list.contains(each);
		}		
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		
		return elapsedTime;
	}
	
	/**
	 * measure insertion time for linked list
	 * @param list
	 * @param ints
	 * @return
	 */
	public static long measureLinkedList(LinkedList<Integer> list, int[] ints) {
		long startTime = System.currentTimeMillis();
		
		for (int each : ints) {
			list.add(each);
		}		
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		
		return elapsedTime;
		
	}
	
	/**
	 * 
	 * @param list
	 * @param ints
	 * @return time it takes to search all ints in linked list
	 */
	public static long searchLinkedList(LinkedList<Integer> list, int[] ints) {
		long startTime = System.currentTimeMillis();
		
		for (int each : ints) {
			list.contains(each);
		}		
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		
		return elapsedTime;
		
	}
	
	public static void main(String[] args) {
		final int numInts = 100000;

		// insertion
		
		// get ints
		int range = 1000000;

		// list of times and DS to populate
		long[] mapTime = new long[10];
		long[] arrayListTime = new long[10];
		long[] linkedListTime = new long[10];
		HashMap<Integer, ?> myMap = new HashMap<>();
		ArrayList<Integer> myArrayList = new ArrayList<>();
		LinkedList<Integer> myLinkedList = new LinkedList<>();
		
		// each iteration gets random ints and inserts
		for (int i = 0; i < 10; i++) {
			int[] ints = generateInts(numInts, range);

			long res0 = measureHashMap(myMap, ints);
			mapTime[i] = res0;
			
			long res1 = measureArrayList(myArrayList, ints);
			arrayListTime[i] = res1;

			long res2 = measureLinkedList(myLinkedList, ints);
			linkedListTime[i] = res2;
		}
		
		System.out.println("Number of keys = " + numInts + "\n");
		System.out.println("HashMap average total insert time = " + getAvgTime(mapTime));
		System.out.println("ArrayList average total insert time = " + getAvgTime(arrayListTime));
		System.out.println("LinkedList average total insert time = " + getAvgTime(linkedListTime));

		// searching 
		
		// get ints
		int rangeSearch = 2000000;
		int[] intsSearch = generateInts(numInts, rangeSearch);

		// lists to save results
		long[] mapSearchTime = new long[10];
		long[] arrayListSearchTime = new long[10];
		long[] linkedListSearchTime = new long[10];
		
		// measured individually because searching arraylist and linkedlist takes way longer
		for (int i = 0; i < 10; i++) {
			long res = searchHashMap(myMap, intsSearch);
			mapSearchTime[i] = res;
		}
		System.out.println("HashMap average total search time = " + getAvgTime(mapSearchTime));
		
		for (int i = 0; i < 10; i++) {
			long res = searchArrayList(myArrayList, intsSearch);
			arrayListSearchTime[i] = res;
		}
		System.out.println("ArrayList average total search time = " + getAvgTime(arrayListSearchTime));
		
		for (int i = 0; i < 10; i++) {
			long res = searchLinkedList(myLinkedList, intsSearch);
			linkedListSearchTime[i] = res;
		}
		System.out.println("LinkedList average total search time = " + getAvgTime(linkedListSearchTime));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
