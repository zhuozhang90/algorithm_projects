package edu.bu.cs526.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author zzhang
 * reads map into data structures
 */
public class Graph {
	
	// internal data structures to represent the graph
	private HashMap<String, Integer> nodeIndices;
	private HashMap<String, Integer> directDists;
	private int[][] edges;
	
	// constructor. reads two files for data
	public Graph(String graphInput, String directDist) throws FileNotFoundException {
		this.nodeIndices = getNodeIndex(graphInput);
		this.directDists = getDirectDistance(directDist);
		this.edges = getEdges(graphInput);
	}
	
	// return all nodes as a set
	public Set<String> getNodes() {
		return nodeIndices.keySet();
	}
	
	// get all adjacent nodes
	public ArrayList<String> getAdjacentNodes(String node) {
		ArrayList<String> adjNodes = new ArrayList<>();
		for (String each : this.getNodes()) {
			if (each != node && this.isConnected(node, each)) {
				adjNodes.add(each);
			}
		}
		return adjNodes;
		
	}

	/** 
	 * 
	 * @param a first node
	 * @param b second node
	 * @return distance between two nodes
	 */
	public int getDistance(String a, String b) {
		int aIndex = this.nodeIndices.get(a);
		int bIndex = this.nodeIndices.get(b);
		return this.edges[aIndex][bIndex];
	}
	/**
	 * 
	 * @param a first node
	 * @param b second node
	 * @return if two nodes are connected
	 */
	public boolean isConnected(String a, String b) {
		int aIndex = this.nodeIndices.get(a);
		int bIndex = this.nodeIndices.get(b);
		return this.edges[aIndex][bIndex] != 0;
	}
	
	/**
	 * 
	 * @param a a node
	 * @return direct distance from the node to Z
	 */
	public int getDirectDist(String a) {
		return this.directDists.get(a);
	}

	/**
	 * 
	 * @param filePath graph input
	 * @return a map containing node names and their indices in the adjacent map
	 * @throws FileNotFoundException 
	 */
	private static HashMap<String, Integer> getNodeIndex(String filePath) throws FileNotFoundException {
		File file = new File(filePath); 
		Scanner sc = new Scanner(file); 
		HashMap<String, Integer> nodeIndices = new HashMap<>();
		
		String[] nodeNames = sc.nextLine().trim().split("\\s+");
	    sc.close();
	    	    
	    for (int i = 0; i < nodeNames.length; i++) {
	    	nodeIndices.put(nodeNames[i], i);
	    }
		return nodeIndices;
		
	}
	
	/**
	 * 
	 * @param filePath
	 * @return matrix containing lengths of edges
	 * @throws FileNotFoundException 
	 */
	private static int[][] getEdges(String filePath) throws FileNotFoundException {
		int[][] edges = new int[26][26];
		File file = new File(filePath); 
		Scanner sc = new Scanner(file); 
		sc.nextLine(); // discard first line
		
		int row = 0;
		while (sc.hasNextLine()) {
			String[] dist = sc.nextLine().trim().split("\\s+");
			for (int i = 1; i < dist.length; i++) {
				int e = Integer.parseInt(dist[i]);
				if (e != 0) edges[row][i-1] = e;
			}
			row++;
		}
	    sc.close();
		return edges;
	}
	
	/**
	 * 
	 * @param filePath
	 * @return hash map containing direct distance to Z
	 * @throws FileNotFoundException 
	 */
	private static HashMap<String, Integer> getDirectDistance(String filePath) throws FileNotFoundException {
		File file = new File(filePath); 
		Scanner sc = new Scanner(file); 
		HashMap<String, Integer> directDist = new HashMap<>();
		
		while(sc.hasNextLine()) {
			String[] dist = sc.nextLine().trim().split("\\s+");
			directDist.put(dist[0], Integer.parseInt(dist[1]));
		}
	    sc.close();
		return directDist;
	}
}
