package edu.bu.cs526.scratchpad;

public class Test<T> {
	  T[ ] data;
	  @SuppressWarnings("unchecked")
	public Test(int capacity) {
	    data = (T[])new Object[capacity]; }
	  public T get(int index) {return data[index];}
	  public void set(int index, T element) {data[index] = element;}

}
