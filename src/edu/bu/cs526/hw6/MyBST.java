package edu.bu.cs526.hw6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


// must have these packages in the same project
import edu.bu.cs526.net.datastructures.DefaultComparator;
import edu.bu.cs526.net.datastructures.LinkedBinaryTree;
import edu.bu.cs526.net.datastructures.Position;


// generic binary search tree
public class MyBST<E> extends LinkedBinaryTree<E> {

	private Comparator<E> comp;
	private int size = 0;
	
	public MyBST(Comparator<E> c) {comp = c;};
	public MyBST(){ this(new DefaultComparator<E>()); }
	
	public int size() { return size; }
	public boolean isEmpty() { return size() == 0; }
	
	/**
	 * adds element e to a tree with root p,
	 * insert so that the tree keeps sorted.
	 * 
	 * @param p position of root node in tree
	 * @param e element to add
	 * @return
	 */
	public Position<E> add(Position<E> p, E e){
//		this.inorderPrint(p);
//		System.out.println();
		Position<E> result = null;
		// use x and y to keep track of locations in tree
		Position<E> x = p;
		Position<E> y = x;
		// if p is null, tree is empty, then e will become root
		if (p == null) {
			this.addRoot(e);
			this.size++;
			return this.root();
		} else {
			// when tree is not empty
			while (x != null) {
				if (comp.compare(x.getElement(), e) == 0) {
					return result;
				}
				// if x > e go right, else go left
				else if (comp.compare(x.getElement(), e) > 0) {
					y = x;
					x = left(x);
				} else {
					y = x;
					x = right(x);
				}
			} 
		}
		// now y is parent of final x position
		// if parent element > e then add e to left child
		if (comp.compare(y.getElement(), e) > 0) {
			result = addLeft(y, e);
			this.size++;
		} else {
			result = addRight(y, e);
			this.size++;
		}
		return result;
	}
		

	// print a binary tree horizontally using indentation
	public void print(Position<E> p, int depth){
		
		  Node<E> n = validate(p); 
	      int i;
	   
	      for (i = 1; i <= depth; i++)
	         System.out.print("    ");
	      System.out.println(n.getElement());

	      if (n.getLeft() != null)
	         print(n.getLeft(), depth+1);
	      else if (n.getRight() != null)
	      {
	         for (i = 1; i <= depth+1; i++)
	            System.out.print("    ");
	         System.out.println("--");
	      }

	      if (n.getRight() != null)
	         print(n.getRight(), depth+1);
	      else if (n.getLeft() != null)
	      {
	         for (i = 1; i <= depth+1; i++)
	            System.out.print("    ");
	         System.out.println("--");
	      }
	   }

	// print a binary tree using inorder tree traversal
	public void inorderPrint(Position<E> p){
		if (p == null) return;
		Node<E> n = validate(p);
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}
	
	// get 1000 distinct ints
	public static Set<Integer> getRandInts() {
		// use set to make sure there are no duplicates
		Set<Integer> ints = new HashSet<>();
		// generate random nums
		int e; 
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		// stop when size is reached
		while (ints.size() < 1000) {
			e = r.nextInt(1000000);
			ints.add(e);
		}
		return ints;
	}
	
	public static void main(String[] args) {
		
		// binary search tree stroing integers
		MyBST<Integer> t = new MyBST<>();

		// test add method
		t.add(t.root, 100);
		t.add(t.root, 50);
		t.add(t.root, 150);
		t.add(t.root, 70);
		t.add(t.root, 30);
		t.add(t.root, 130);
		t.add(t.root, 140);
		t.add(t.root, 120);
		t.add(t.root, 100);
		t.add(t.root, 30);

		System.out.println("Number of nodes is: " + t.size);
		
		System.out.println("Print tree horizontally using indentation: ");
		t.print(t.root, 0);
		System.out.println("\n");
		
		System.out.println("Print tree by inorder traversal: ");
		t.inorderPrint(t.root);

		System.out.println("\n");
				
		// create 100 trees and get height and size
		
		// array list to hold all heights
		int heightTotal = 0;
		for (int i = 0; i < 100; i++) {
			MyBST<Integer> ht = new MyBST<>();
			for (int j : getRandInts()) {
				ht.add(ht.root, j);
			}
			// add height to array
			int height = ht.height(ht.root);
			heightTotal = heightTotal + height;

			System.out.println("Height = " + height + " " + "Size = " + ht.size);
		}
		
		double avgHeight = (double) heightTotal / 100;
		System.out.println("Average height = " + avgHeight);

	}

}
