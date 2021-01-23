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
package edu.bu.cs526.hw9;

public class InsertionSort {

	/** Insertion-sort of an array of characters into nondecreasing order */
	public static void insertionSort(int[] data) {
		int n = data.length;
		for (int k = 1; k < n; k++) { // begin with second character
			int cur = data[k]; // time to insert cur=data[k]
			int j = k; // find correct index j for cur
			while (j > 0 && data[j - 1] > cur) { // thus, data[j-1] must go after cur
				data[j] = data[j - 1]; // slide data[j-1] rightward
				j--; // and consider previous j for cur
			}
			data[j] = cur; // this is the proper place for cur
		}
	}
}
