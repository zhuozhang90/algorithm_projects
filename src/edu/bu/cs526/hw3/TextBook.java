package edu.bu.cs526.hw3;

public class TextBook {

	  private String course;
	  private String title;
	  private Person author;
	  private double price;
	  
	  public TextBook() { }
	  public TextBook(String c, String t, Person p, double pr) {
	    course = c;
	    title = t;
	    author = p;
	    price = pr;
	  }

	  public String getCourse() { return course;}               
	  public String getTitle() { return title; }          
	  public Person getAuthor() { return author; }     
	  public double getPrice() {return price; }
	  
	  public void setCourse(String c) {
		  course = c;
	  }
	  public void setTitle(String t) {
		  title = t;
	  }
	  public void setAuthor(Person p) {
		  author = p;
	  }
	  public void setPrice (double pr) {
		  price = pr;
	  }
	  
	  public String toString() {                        
	    return "\tCourse: " + course + 
	    		"\n\tTitle: " + title + 
	    		"\n\tAuthor: " + "Name = " + author.getName() + ", Age = " + author.getAge() +
	    		"\n\tPrice: " + price + "\n";
	  }
	
	
}
