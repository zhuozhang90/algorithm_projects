package edu.bu.cs526.hw1;

public class Hw1Progression extends Progression{
	
	protected long next;
	
	// constructor with default value
	public Hw1Progression() { this(1); }

	// constructor with specified start value
	public Hw1Progression(long start) {
		super(start);
	}
	
	// determines the next value from current
	@Override
	protected void advance() {
		if (current % 2 == 0) { next = (current * 2 - 1); }
		else if (current % 3 == 0) { next = (current * 3 - 2); }
		else { next = ++current; }
		current = next;
	}

}
