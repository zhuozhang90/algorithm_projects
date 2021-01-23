/*
 * Zhuo Zhang
 * zzhang90@bu.edu
 */

package edu.bu.cs526.hw2;

import java.util.Comparator;

public class Car {
	
	// private fields
	private String make;
	private int year;
	private int price;
	
	// constructors
	public Car() { }
	public Car(String make, int year, int price) {
		this.make = make;
		this.year = year;
		this.price = price;
	}
	
	// getters and setters
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// override toString for printing
	@Override
	public String toString()
	{
		String s = "Make = " + make + "\t Year = " + year
				+ "\t Price = " + price;
		return s;
	}
	
	// Comparator for sorting by year
	static class SortByYear implements Comparator<Car> {

		@Override
		public int compare(Car car1, Car car2) {
			return car1.year - car2.year;
		}
		
	}

}
