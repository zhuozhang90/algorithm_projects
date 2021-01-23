/*
 * Zhuo Zhang
 * zzhang90@bu.edu
 */

package edu.bu.cs526.hw3;

import java.util.Comparator;

public class Person {
	
	// private fields
	private String name;
	private int age;

	// constructors
	public Person() { }
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// override toString for printing
	@Override
	public String toString() {
		String s = "Name = " + name + "\tAge = " + age;
		return s;
	}
	
	// Comparator for sorting by age
	static class SortByAge implements Comparator<Person> {

		@Override
		public int compare(Person person1, Person person2) {
			return person1.age - person2.age;
		}
		
	}
}
