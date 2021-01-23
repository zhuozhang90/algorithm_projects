package edu.bu.cs526.hw1;

import java.util.Arrays;

public class Hw1_part1 {
	
	// problem 1
	// takes int n and returns sum of squares of odd ints smaller or equal
	public static int sumOfSquaresOfOdds(int n) {
		// if n < 1 just return 0
		if (n < 1) return 0;
		// else calculate sum
		int sum = 0;
		for (int i = 1; i <= n; i += 2) {
			sum += (i * i);
		}
		return sum;
	}
	
	// problem 2
	public static void shuffle(int[] intArray) {
		int step;
		int arrayLength = intArray.length;
		
		// only difference in handling odd or even array is the step size
		// even arrays
		if (arrayLength % 2 == 0) { step = arrayLength / 2; }
		// odd arrays
		else { step = arrayLength / 2 + 1; }
		
		// shuffle array by swapping elements
		for (int i = 0; i < arrayLength / 2; i++) {
			swap(intArray, i, step);
		}
	}
	
	// helper method to swap ints in array
	// swaps item with the one step size down
	private static void swap(int[] intArray, int index, int step) {
		int tmp;
		int swapIndex = index + step;
		
		// swap elements
		tmp = intArray[index];
		intArray[index] = intArray[swapIndex];
		intArray[swapIndex] = tmp;
	}
	
	// problem 3
	public static double[] statistics(double[] nums) {
		double[] result = new double[3]; // result array to return
		
		int size = nums.length;
		double max = nums[0];
		double min = nums[0];
		double sum = 0.0;
		double avg;
		
		// get min, max and sum in one loop
		for (int i = 0; i < size; i++) {
			if (nums[i] > max) { max = nums[i]; }
			if (nums[i] < min) { min = nums[i]; }
			sum += nums[i];
		}
		
		// get avg
		avg = sum / size;
		
		// construct array to return
		result[0] = max;
		result[1] = min;
		result[2] = avg;
 		
		return result;
	}

	public static void main(String[] args) {
		// question 1
		int sum1 = sumOfSquaresOfOdds(10);
		System.out.print("sum of squares of odds with n as 10: ");
		System.out.println(sum1);
		System.out.print("sum of squares of odds with n as 20: ");
		int sum2 = sumOfSquaresOfOdds(20);
		System.out.println(sum2);
		
		// question 2
		// initial arrays
		int[] evenArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14, 15,16, 17, 18, 19};
		int[] oddArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14, 15,16, 17, 18, 19, 20};
		
		// even array
		System.out.println("even array: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14, 15,16, 17, 18, 19]");
		shuffle(evenArray);
		System.out.print("even array after shuffle: ");
		System.out.println(Arrays.toString(evenArray));
		
		// odd array
		System.out.println("odd array: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14, 15,16, 17, 18, 19, 20]");
		shuffle(oddArray);
		System.out.print("odd array after shuffle: ");
		System.out.println(Arrays.toString(oddArray));
		
		// question 3
		double[] test1 = {8, 9.0, 2.5, 5.77, 2.51, 8.99999, 777, 0.98, 664.123, 0};
		double[] test2 = {1.02, -0,99, 3.62, 18.259, 9.016, 7.07, -6.9, 4.20, 53.62, 77.13};
		
		// first test
		double[] result1 = statistics(test1);
		System.out.println("Max of array test1 is: " + result1[0]);
		System.out.println("Min of array test1 is: " + result1[1]);
		System.out.println("Avg of array test1 is: " + result1[2]);
		
		// second test
		double[] result2 = statistics(test2);
		System.out.println("Max of array test2 is: " + result2[0]);
		System.out.println("Min of array test2 is: " + result2[1]);
		System.out.println("Avg of array test2 is: " + result2[2]);


	}
}
