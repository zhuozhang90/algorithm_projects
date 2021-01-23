package edu.bu.cs526.scratchpad;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class Book implements Cloneable  {
  private String ISBN;
  private String title;
  private String author;
  
  public Book() { }
  public Book(String i, String t, String a) {  
    ISBN = i;
    title = t;
    author = a;
  }

  public String getISBN() { return ISBN;}               
  public String getTitle() { return title; }          
  public String getAuthor() { return author; } 
  
  public void setISBN(String i) {
	  ISBN = i;
  }
  public void setTitle(String t) {
	  title = t;
  }
  public void setAuthor(String a) {
	  author = a;
  }
  
  public boolean equals(Book other) {             
    if (!(other instanceof Book)) return false;  
    Book s = (Book) other;                    
    return ISBN.equals(s.ISBN);                         
  }
  public String toString() {                        
    return "Book(ISBN: " + ISBN + ", Title: " + title + ", Author: " + author + ")";
  }
  
  public Book clone( ) {
      Book answer;
      
      try {
         answer = (Book) super.clone( );
      }
      catch (CloneNotSupportedException e) {
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      answer.ISBN = new String(this.getISBN());
	  answer.title = new String(this.getTitle());
	  answer.author = new String(this.getAuthor());
      
      return answer;
	} // end of clone method

}
