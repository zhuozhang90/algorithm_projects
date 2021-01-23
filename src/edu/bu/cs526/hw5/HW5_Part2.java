package edu.bu.cs526.hw5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.stream.Stream;

public class HW5_Part2 {
	// path for input file
	static final String FILE_PATH = "infix_expressions.txt";	
	
	public static int parseExpression(String expression) {
		// stacks to hold operators and operands
		LinkedStack<String> operator = new LinkedStack<>();
		LinkedStack<Integer> operand = new LinkedStack<>();
		
		// a queue to hold the expression
		ArrayDeque<String> expr = new ArrayDeque<>();
		String[] exprTokens = expression.trim().split(" ");
		for (String each : exprTokens) expr.add(each.trim());
		 // while expr is not empty keep poping and pushing
		while (expr.size() > 0) {
			// get next from expression
			String s = expr.pop();
			// ignore (
			if (s.equals("(")) continue;
			// operands 
            else if (s.equals("+")) operator.push(s);
            else if (s.equals("-")) operator.push(s);
            else if (s.equals("*")) operator.push(s);
            else if (s.equals("/")) operator.push(s);
			// if ) then start calculating results
            else if (s.equals(")")) {
            	// get 2 numbers and an operand
                String op = operator.pop();
                int num = operand.pop();
                int num2 = operand.pop();
                // calculate then push result in
                if (op.equals("+")) num = num2 + num;
                else if (op.equals("-")) num = num2 - num;
                else if (op.equals("*")) num = num2 * num;
                else if (op.equals("/")) num = num2 / num;
                operand.push(num);
            }
			// if not above then push in the int
            else operand.push(Integer.parseInt(s));
        }
		// result is what's left
		return operand.pop();
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
		
		ArrayList<String> expressions = readFile(FILE_PATH);
		for (String s : expressions) {
			System.out.println(s + " = " + parseExpression(s));
		}
	}

}
