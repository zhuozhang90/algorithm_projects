package edu.bu.cs526.hw5;

public class HW5_Part1 {

	static void rearrange(int[] a) {
		// implement this method
		// you may have to write another method with additional parameters, as we discussed in the class
		rearrange(a, 0, a.length-1);
	}
	
	// helper method with more parameters
	private static void rearrange(int[] a, int left, int right) {
		// end of recursion
		if (left > right) return;
		// swap if needed to
		if (isEven(a[left]) && isOdd(a[right])) swap(a, left, right); 
		// if both even or both odd then keep one side and find the other side to swap with
		if (isEven(a[left]) && isEven(a[right])) rearrange(a, left, right-1);
		if (isOdd(a[left]) && isOdd(a[right])) rearrange(a, left+1, right);
		// proceed to the next if no need to swap
		rearrange(a, left+1, right-1);
	}
	
	//check if it's even or odd
	private static boolean isEven(int a) {
		return (a % 2) == 0;
	}
	
	private static boolean isOdd(int a) {
		return (a % 2) == 1;
	}
	
	// swap 
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
		int n = 10;
		int[] a = new int[n]; // array of size n
		
		// n random integers between 0 and 100 
		// 0 included but 100 excluded
		for (int i=0; i<n; i++) {
			a[i] = (int)(Math.random() * 100); 
		}
		
		System.out.println("Before rearrange");
		for (int i=0; i<n; i++) {
			System.out.print(a[i] + "  ");
		}
		
		rearrange(a);
		
		System.out.println("\nAfter rearrange");
		for (int i=0; i<n; i++) {
			System.out.print(a[i] + "  ");
		}
		

	}

}
