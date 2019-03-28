/**
 *  FuelTankTester.java
 *  This creates 3 objects of cars each with different values based on the constructor.
 *  It uses methods in the car class.
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 03-29-2019
 */

public class FuelTankTester
{
    public static void main(String[] args)
    {
    	// Create a Car object using the default constructor
    	// Create a Car object using the 3-parameter constructor
		// Display both cars using toString
		
		Car car1 = new Car();
		Car car2 = new Car(2002, "Porsche 911", 1700);
		System.out.println("Car 1: " + car1.toString());
		System.out.println("Car 2: " + car2.toString());
		System.out.println();

    	// Drive both cars. Display each car's fuel tank level and odometer 
    	// using accessor methods (not toString)
		//car1.drive(750);
		//car2.drive(5280);
		
		System.out.println("Car 1's odometer: " + car1.getMileage());
		System.out.println("Car 1's fuel level: " + car1.getFuelLevel());
		System.out.println();
		System.out.println("Car 2's odometer: " + car2.getMileage());
		System.out.println("Car 2's fuel level: " + car2.getFuelLevel());
		
    	// 100-pt Version:
    	
    	// Create a Car object using your 6-parameter constructor
    	// Display the car using toString
    	
		Car car3 = new Car(1951, "Hudson Hornet", 87293.8, 10, 18.5, 16);
		System.out.println();
		System.out.println("Car 3: " + car3.toString());
		System.out.println();
		car3.drive(100);
		System.out.println("After 100 miles: " + car3.toString());
		car3.drive(75);
		System.out.println("After 75 miles: " + car3.toString());

    	// Drive your car and add fuel, displaying the results
    	// as directed on your lab sheet
    	
		car3.addFuel();
		System.out.println("After filling tank: " + car3.getFuelLevel());
		System.out.println();
		car3.drive(500);
		System.out.println("After 500 miles: " + car3.toString());
		System.out.println();

		System.out.println("Able to add 6.8 gal? " + car3.addFuel(6.8));
		System.out.println("Current fuel level: " + car3.getFuelLevel());
		System.out.println("Able to add 11.7 gal? " + car3.addFuel(11.7));
		System.out.println("Current fuel level: " + car3.getFuelLevel());
		System.out.println("Able to add 5.25 gal? " + car3.addFuel(5.25));
		System.out.println("Current fuel level: " + car3.getFuelLevel());
		System.out.println("Car 3: " + car3.toString());
    }
}
