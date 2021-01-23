package edu.bu.cs526.ch1;

public class PrimitiveReference {

	public static void main(String[] args) {
		int i ;
		int intArray[] = new int[10];
		
		for (i=0; i<intArray.length; i++) {
			intArray[i] = i * 10;
		}
		
		System.out.println("Integer array  ");
		for (i=0; i<intArray.length; i++) {
			System.out.print(intArray[i] + "  ");
		}
		
		Car c1, c2, c3;
		Car carArray[] = new Car[3];
		
		c1 = new Car();
		c1.setVIN("1234");
		c1.setMake("GM");
		carArray[0] = c1;
		
		c2 = new Car();
		c2.setVIN("2345");
		c2.setMake("Ford");
		carArray[1] = c2;
		
		c3 = new Car();
		c3.setVIN("3456");
		c3.setMake("Chevy");
		carArray[2] = c3;
		
		System.out.println("\n\nCar array  ");
		for (i=0; i<carArray.length; i++) {
			System.out.println(carArray[i] + "\n");
		}
		
		c3.setVIN("4567");
		c3.setMake("Buick");
		
		System.out.println("\nCar c3 after update  ");
		System.out.println(c3);

	}

}
