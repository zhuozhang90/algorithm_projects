/*
 * @Zhuo Zhang
 * zzhang90@bu.edu
 * cs526 hw3
 */

package edu.bu.cs526.hw3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

public class TextbookManagement {
	
	// path for input file
	static final String FILE_PATH = "textbook_info.txt";
	
	// read file into string list, taken from hw2
	private static ArrayList<String> readFile(String filePath) throws IOException {
		
		ArrayList<String> content = new ArrayList<>();
	    
		// reading files requires a try block to catch exceptions
	    try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))){ 
	        stream.forEach(s -> content.add(s)); // add each line to the arraylist
	    } catch (IOException e){
	        e.printStackTrace();
	    }
	    
	    return content; // return arraylist that holds all the lines
	}
	
	// wrapper for Person and TextBook constructors
	public static TextBook makeTextBook(String course, String title, String name, int age, double price) {
		
		Person author = new Person(name, age);
		TextBook textBook = new TextBook(course, title, author, price);
		
		return textBook;
	}
	
	public static TextBook getCheapest(LinkedList<TextBook> textBooks) {
		
		TextBook cheapest = textBooks.getFirst();
		
		// loop through all boks
		for (TextBook each : textBooks) {
			if (each.getPrice() < cheapest.getPrice()) cheapest = each;
		}
		
		return cheapest;
	}
	
	public static TextBook getMostExpensive(LinkedList<TextBook> textBooks) {
		
		TextBook mostExpensive = textBooks.getFirst();
		
		for (TextBook each : textBooks) {
			if (each.getPrice() > mostExpensive.getPrice()) mostExpensive = each;
		}
		
		return mostExpensive;
	}
	
	public static double getAveragePrice(LinkedList<TextBook> textBooks) {
		
		double avgPrice = textBooks.stream() // convert to stream
							.mapToDouble(TextBook::getPrice) // convert to array of prices
							.average().orElse(0.0); // get average or 0 if failure
		
		return avgPrice;
		
	}
	
	public static TextBook getBookByYoungestAuthor(LinkedList<TextBook> textBooks) {
		
		TextBook bookWithYoungestAuthor = textBooks.getFirst();
		
		for (TextBook each : textBooks) {
			// get age from the Person object within TextBook
			if (each.getAuthor().getAge() < bookWithYoungestAuthor.getAuthor().getAge()) {
				bookWithYoungestAuthor = each;
			}
		}
		
		return bookWithYoungestAuthor;
	}
	
	public static void main(String[] args) throws IOException {
		
		// use linkedlist to keep track of books
		LinkedList<TextBook> textBooks = new LinkedList<>();
		
		ArrayList<String> textBookContent = readFile(FILE_PATH);
		
		for (String each : textBookContent) {
			
			String[] content = each.split(",");
			
			String course = content[0].trim();
			String title = content[1].trim();
			String name = content[2].trim();
			int age = Integer.parseInt(content[3].trim());
			double price = Float.parseFloat(content[4].trim());
			
			TextBook tb = makeTextBook(course, title, name, age, price);
			
			textBooks.add(tb); // add all books to linkedlist
		}	
		
		// output results
		System.out.println("all books: ");
		textBooks.forEach(System.out::println);
		
		System.out.println("cheapest book: ");
		System.out.println(getCheapest(textBooks));
		
		System.out.println("most expensive book: ");
		System.out.println(getMostExpensive(textBooks));
		
		System.out.print("average price: ");
		System.out.println(getAveragePrice(textBooks) + "\n");
		
		System.out.println("book by youngest author: ");
		System.out.println(getBookByYoungestAuthor(textBooks));
	}

}
