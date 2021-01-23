package edu.bu.cs526.hw7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import edu.bu.cs526.net.datastructures.HeapPriorityQueue;

public class ProcessScheduling {
	
	protected static class Process {
		private int id;
		private int pr; // priority 
		private int arrivalTime;
		private int duration;
		
		public Process(int id, int pr, int arrivalTime, int duration) {
			this.id = id;
			this.pr = pr;
			this.arrivalTime = arrivalTime;
			this.duration = duration;
		}
		
		// public getters
		public int getId() {
			return id;
		}
		public int getPr() {
			return pr;
		}
		public int getArrivalTime() {
			return arrivalTime;
		}
		public int getDuration() {
			return duration;
		}
		
		public String toString() {
			String s = new String();
			s += "id = " + id + "; "; 
			s += "priority = " + pr + "; ";
			s += "duration = " + duration + "; ";
			s += "arrival time = " + arrivalTime;

			return s;
		}
		
	}
	
	// read file into string list, taken from hw2
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

		final String FILE_PATH = "process_scheduling_in.txt";
		final String OUT_FILE_PATH = "process_scheduling_out.txt";
		StringBuffer output = new StringBuffer();

		int currentTime = 0;
		int currDoneTime = 0;
		float totalWait = 0;
		boolean running = false;
		int numProcess = 0;
		
		ArrayList<String> processes = readFile(FILE_PATH);
		ArrayList<Process> processList = new ArrayList<>();
		HeapPriorityQueue<Integer, Process> pq = new HeapPriorityQueue<>();
		Process curr = null;
		
		// read file into objects
		for (String each : processes) {
			String[] line = each.split(" ");
			int id = Integer.parseInt(line[0].trim());
			int pr = Integer.parseInt(line[1].trim());
			int duration = Integer.parseInt(line[2].trim());
			int arrivalTime = Integer.parseInt(line[3].trim());
			Process process = new Process(id, pr, arrivalTime, duration);
			processList.add(process);
//			System.out.println(process);
			output.append(process).append("\n");
		}
		
		System.out.println();
		
		numProcess = processes.size();

		while (processList.size() > 0) {
			Process p = processList.get(0); // get first item
			// get earliest arrival and add to pq
			if (p.getArrivalTime() <= currentTime) {  
				processList.remove(0);
				pq.insert(p.getPr(), p);
				
			}
			// if pq not empty and not running, then run
			if (pq.size() > 0 && !running) {
				curr = pq.removeMin().getValue();
				int waitTime = currentTime - curr.getArrivalTime();
				totalWait += waitTime;
				String s = "Process removed from Queue is: " + curr.getId() + ", at time " + currentTime +
						", wait time " + waitTime + ", total wait " + totalWait;
				
//				System.out.println("\t" + curr);
				output.append(s).append("\n\t").append(curr).append("\n");
				currDoneTime = currentTime + curr.getDuration();
				running = true;
			}
			currentTime++;
			// check if curr done
			if (running && (currentTime == (currDoneTime))) {
				String s = "Process " + curr.getId() + " finished at time " + currentTime + "\n";
				output.append(s).append("\n");
				running = false;
			}
		} // while
		
		String tmp = "\nprocess list is empty at time " + currentTime + "\n";
		output.append(tmp);
		
		// at this point all in pq
		while (pq.size() > 0) {
			if (!running) {
				curr = pq.removeMin().getValue();
				int waitTime = currentTime - curr.getArrivalTime();
				totalWait += waitTime;
				String s = "Process removed from Queue is: " + curr.getId() + ", at time " + currentTime +
						", wait time " + waitTime + ", total wait " + totalWait;
				output.append(s).append("\n\t").append(curr).append("\n");
//				System.out.println("\t" + curr);
				currDoneTime = currentTime + curr.getDuration();
				running = true;
			}
			currentTime++;

			// check if curr is done
			if (running && (currentTime == (currDoneTime))) {
				String s = "Process " + curr.getId() + " finished at time " + currentTime + "\n";
				output.append(s).append("\n");
				running = false;
			}
		} // while
		
		// take care of last running process
		while (running) {
			currentTime++;

			// check if curr is done
			if (running && (currentTime == (currDoneTime))) {
				String s = "Process " + curr.getId() + " finished at time " + currentTime + "\n";
				output.append(s).append("\n");
				running = false;
			}
		} // while
		
		// get total and avg wait time
		output.append("Total wait ").append(totalWait).append("\n");
		output.append("Average wait ").append(totalWait / numProcess);
		
		System.out.println(output);
		
		FileWriter fileWriter = new FileWriter(OUT_FILE_PATH);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print(output.toString());
	    printWriter.close();
	}
}





























