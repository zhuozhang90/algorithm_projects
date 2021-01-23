package edu.bu.cs526.scratchpad;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		// integer array list
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(10);
		intList.add(30);
		System.out.println("Initial integer list: ");
		System.out.println(intList);
		
		intList.add(2, 100);
		intList.add(0, 200);
		System.out.println("After adding two integers: ");
		System.out.println(intList);
		
		intList.remove(4);
		System.out.println("After removing the 5th element: ");
		System.out.println(intList);
		
		intList.set(1, 500);
		System.out.println("After changing the second element: ");
		System.out.println(intList);
		
		System.out.println("\nBook list\n");
		ArrayList<Book> bookList = new ArrayList<>();
		
		// create two books and add them to array list
		Book b1, b2;
		b1 = new Book();
		b1.setAuthor("John Smith");
		b1.setISBN("ABC123");
		b1.setTitle("Deep forest");
		bookList.add(b1);
		b2 = new Book();
		b2.setAuthor("Susan Smith");
		b2.setISBN("DEF456");
		b2.setTitle("Deep sea");
		bookList.add(b2);
		
		// print books in bookList
		// we can use iterator but here we use indexes
		
		for (int i=0; i<bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
		
	}

}
