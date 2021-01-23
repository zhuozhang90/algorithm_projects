/*
 * Zhuo Zhang
 * zzhang90@bu.edu
 */


package edu.bu.cs526.hw2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Hw2 {
	
	// read files into arraylists
	private static ArrayList<String> readFile(String filePath) throws IOException {
		
		ArrayList<String> content = new ArrayList<>();
	    
		// reading files requires a try block to catch exceptions
	    try (Stream<String> stream = Files.lines(Paths.get(filePath))){ 
	        stream.forEach(s -> content.add(s)); // add each line to the arraylist
	    } catch (IOException e){
	        e.printStackTrace();
	    }
	    
	    return content; // return arraylist that holds all the lines
	}

	public static void main(String[] args) throws IOException {

		// read two files into arraylists
		ArrayList<String> carContent = 
				readFile("/home/zzhang/Projects/bu/eclipse-workspace/bu/src/edu/bu/cs526/hw2/car_info.txt");
		ArrayList<String> personContent = 
				readFile("/home/zzhang/Projects/bu/eclipse-workspace/bu/src/edu/bu/cs526/hw2/person_info.txt");
				
		// declare arraylists for Objects
		ArrayList<Car> carList = new ArrayList<>();
		ArrayList<Person> personList = new ArrayList<>();
		
		// add all Car objects to arraylist
		for (String s : carContent) {
			String make = s.split(" ")[0];
			int year = Integer.parseInt(s.split(" ")[1]);
			int price = Integer.parseInt(s.split(" ")[2]);
			carList.add(new Car(make, year, price));
		}
		
		// add all Person objects to arraylist
		for (String s : personContent) {
			String name = s.split(" ")[0];
			int age = Integer.parseInt(s.split(" ")[1]);
			personList.add(new Person(name, age));
		}
			
		// print all cars and persons
		System.out.println("all cars: ");
		carList.forEach(System.out::println);
		
		System.out.println("\nall persons: ");
		personList.forEach(System.out::println);
		
		// sort both lists to get min and max
		carList.sort(new Car.SortByYear());
		personList.sort(new Person.SortByAge());
		
		// get oldest and newest car
		System.out.println("\noldest car:");
		System.out.println(carList.get(0));
		System.out.println("\nnewest car:");
		System.out.println(carList.get(carList.size()-1));	
		
		// get oldest and youngest person
		System.out.println("\nyoungest person:");
		System.out.println(personList.get(0));
		System.out.println("\noldest person:");
		System.out.println(personList.get(personList.size()-1));
		
		// get avg of car prices
		double carSum = (double) carList.stream().map(car -> car.getPrice())
				.mapToInt(Integer::intValue).sum();
		double carAvg = carSum / carList.size();
		
		System.out.println("\naverage car price: " + carAvg);
		
		// get avg of person ages
		double personSum = (double) personList.stream().map(person -> person.getAge())
				.mapToInt(Integer::intValue).sum();
		double personAvg = personSum / personList.size();
		
		System.out.println("\naverage person age: " + personAvg);
		
	}

}
