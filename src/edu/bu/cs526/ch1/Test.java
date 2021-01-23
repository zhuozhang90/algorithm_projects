package edu.bu.cs526.ch1;

public class Test {

	public static void main(String[] args) {
		Integer a = new Integer(12);
		increment(a);
		System.out.println(a);
		
	}
	
	public static void increment (Integer a) {
		a = a + 1;
	}

}
