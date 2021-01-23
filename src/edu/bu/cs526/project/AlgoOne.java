package edu.bu.cs526.project;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

/**
 * 
 * @author zzhang
 * Algorithm one: gets shortest path from direct distance only
 *
 */
public class AlgoOne {
	
	/** 
	 * 
	 * @param g graph
	 * @param currNode 
	 * @return node with smallest dd
	 */
	public static String getNextNode(Graph g, String currNode, ArrayList<String> visits) {
		String nextNode = "";
		int dd = 99999;
		
		// get adjacent nodes
		ArrayList<String> adj = g.getAdjacentNodes(currNode);
//		
//		for (String each : adj) {
//			System.out.println(each + " " + g.getDirectDist(each));
//		}

		// check for the shortest DD
		for (String each : adj) {
			// if currnode already in visits then just find candidate that's not visited
			if (visits.contains(currNode)) {
				if(g.getDirectDist(each) < dd) {
					if (!visits.contains(each)) nextNode = each;
					dd = g.getDirectDist(each);
				}
			}
			// otherwise get best candidate
			else if(g.getDirectDist(each) < dd) {
				nextNode = each;
				dd = g.getDirectDist(each);
			}
		}
		return nextNode;
	}
	
	/**
	 * 
	 * @param visits array of all visited nodes
	 * @return path with loops removed, shortest path
	 */
	public static ArrayList<String> getPath(ArrayList<String> visits) {
		ArrayList<String> path = new ArrayList<>();
		// get rid of loops
		for (int i = 0; i < visits.size(); i++) {
			String visit = visits.get(i);
			path.add(visit);
			// if in rest of the path then just skip till the same node appears
			if (visits.subList(i+1, visits.size()).contains(visit)) {
				i++;
				while(!visits.get(i).contentEquals(visit)) {
					i++;
				}
			}
		}
		return path;
	}
	
	/**
	 * 
	 * @param g graph
	 * @param path list of nodes
	 * @return length between start and end
	 */
	public static int getPathLength(Graph g, ArrayList<String> path) {
		int pathLength = 0;
		String last, curr;
		// connect two nodes and add the edge length to pathLength
		for (int i = 0; i < path.size()-1; i++) {
			last = path.get(i);
			curr = path.get(i+1);
			// add edge length to sum
			pathLength += g.getDistance(last, curr);
		}
		
		return pathLength;
	}
	
	public static void run(String startNode) throws FileNotFoundException, InterruptedException {
		// read files into graph
		Graph g = new Graph("graph_input.txt", "direct_distance.txt");
		
		// array to hold all visited nodes
		ArrayList<String> visits = new ArrayList<>(); // all visited nodes
		
		// get all adjacent nodes
		String nextNode = startNode;
		String currNode = startNode;
		
		// while next is not end, keep getting next
		while (!nextNode.contentEquals("Z")) {
			currNode = nextNode;
			nextNode = getNextNode(g, currNode, visits);
			visits.add(currNode);
		}
		
		// add end to arraylist
		visits.add("Z");
		
		// get shortest path
		ArrayList<String> path = getPath(visits);
		
		// print results
		System.out.print("sequence of all nodes: ");
		for (String each : visits) {
			System.out.print(each + " ");
		}
		
		System.out.println();
		
		System.out.print("shortest path: ");
		for (String each : path) {
			System.out.print(each + " ");
		}
		
		System.out.println();
		
		System.out.println("path length: " + getPathLength(g, path));
		
		
	}
}











