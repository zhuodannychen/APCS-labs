/**
 *  Car.java
 *	This is the car class which contains methods and constructors for the car class.
 *	This will be called by the FuelTankTester.java.
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 03-29-2019
 */

public class Car
{
	/** Default initialization values */
	public static final int DEFAULT_YEAR = 1999;
	public static final String DEFAULT_MAKE_MODEL = "Ford Pinto";
	public static final double DEFAULT_FUEL_TANK_CAPACITY = 14.5;
	public static final int DEFAULT_FUEL_EFFICIENCY = 24;

	/** Manages unique ID numbers for all cars */
	private static int nextVIN = 1001;

	/** the car's model year */
	private int year;

	/** the make and model of the car */
	private String makeAndModel;

	/** the car's unique VIN (Vehicle Identification Number) */
	private int vin;

	/** the current mileage on the car */
	private double odometer;
	
	/** the current number of gallons of fuel in the car */
	private double currentNumGallons;
	
	/** the total capacity of the car */
	private double capacity;
	
	/** the fuel efficiency of the car*/
	private int fuelEfficiency;

	/** Constructs a Car with default settings
	 */
	public Car()
	{
		year = DEFAULT_YEAR;
		makeAndModel = DEFAULT_MAKE_MODEL;
		vin = getNextVIN();
		odometer = 0;
		currentNumGallons = 0;
		capacity = DEFAULT_FUEL_TANK_CAPACITY;
		fuelEfficiency = DEFAULT_FUEL_EFFICIENCY;
	}

	/** Create a car with the given name, year, and odometer
	 *  @param year the year the car was manufactured
	 *  @param makeAndModel the car's make and model
	 *  @param odometer the current mileage on the car
	 */
	public Car(int year, String makeAndModel, double odometer)
	{
		this.year = year;
		this.makeAndModel = makeAndModel;
		this.odometer = odometer;
		this.vin = getNextVIN();
		currentNumGallons = 0;
		capacity = DEFAULT_FUEL_TANK_CAPACITY;
		fuelEfficiency = DEFAULT_FUEL_EFFICIENCY;
	}
	
	/** Create a car with the given name, year, odometer, current number of gallons, the total capacity, and fuel efficiency
	 *  @param year the year the car was manufactured
	 *  @param makeAndModel the car's make and model
	 *  @param odometer the current mileage on the car
	 *	@param currentNumberGallons the current number of fuel in gallons on the car
	 *	@param capacity the total capacity on the car for fuel
	 *	@param fuelEfficiency the fuel efficiency of the car, which will determine how much fuel it uses.
	 */
	public Car(int year, String makeAndModel, double odometer, double currentNumGallons, double capacity, int fuelEfficiency)
	{
		this.year = year;
		this.makeAndModel = makeAndModel;
		this.odometer = odometer;
		this.vin = getNextVIN();
		this.currentNumGallons = currentNumGallons;
		this.capacity = capacity;
		this.fuelEfficiency = fuelEfficiency;
	}

	/** Change the make and model of this car
	 *  @param newMakeAndModel the new Make and Model
	 */
	public void changeMakeAndModel(String newMakeAndModel)
	{
		makeAndModel = newMakeAndModel;
	}

	/** Drives the car a given number of miles based on how much fuel
	 *  @param miles the number of miles driven
	 */
	public void drive(double miles)
	{
		double gallonsUsed = miles / fuelEfficiency;
		if(gallonsUsed > currentNumGallons)
		{
			miles = currentNumGallons * fuelEfficiency;
			odometer += miles;
			currentNumGallons = 0;
		}
		else
		{
			odometer += miles;
			currentNumGallons -= gallonsUsed;
		}
	}

	/** Drives the car a given number of miles per day
	 *  @param daysDriven the number of days of driving
	 *  @param milesPerDay the number of miles driven per day
	 */
	public void drive(int daysDriven, double milesPerDay)
	{
		double totalMiles = daysDriven * milesPerDay;
		drive(totalMiles);
	}

	/** Retrieves the current mileage on the odometer
	 *  @return the odometer setting
	 */
	public double getMileage()
	{
		return odometer;
	}

	/** Retrieves the car's VIN
	 *  @return the VIN
	 */
	public int getVIN()
	{
		return vin;
	}

	/** Provides this car's information in a string
	 *  @return car info as a string
	 */
	@Override
	public String toString()
	{
		return year + " " + makeAndModel + " " + vin + " " + String.format("%,.1f", odometer) + " " + String.format("%.4f", currentNumGallons) + " " + String.format("%.3f", capacity) + " " + fuelEfficiency;
	}

	/** Determines if 2 cars are the same based on its VIN
	 *  @param obj the car to compare to this one
	 *  @return true if this and obj have the same VIN, false otherwise
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof Car))
			return false;

		Car otherCar = (Car) obj;
		return this.vin == otherCar.vin;
	}

	/** Calculates and returns the next VIN for any car
	 *  @return unique VIN for a car
	 */
	private static int getNextVIN()
	{
		int newVIN = nextVIN;
		nextVIN++;
		return newVIN;
	}
	
	/** returns the current amount of fuel on the car, which is odometer
	 *  @return the current amount of fuel on the car
	 */
	public double getFuelLevel()
	{
		return currentNumGallons;
	}
	
	/** Adds fuel to the car until capacity is reached
	 *  @return if fuel is being added, which is always true
	 */
	public boolean addFuel()
	{
		currentNumGallons = capacity;
		return true;
	}
	
	/** Adds fuel to the car based on the given amount, if fuel added is greater than capacity, then it just adds to capacity
	 *	@param gallonsAdd which is the amount of fuel a user wants to add to their car
	 *  @return if the given amount of fuel can be added without exceeding the capacity
	 */
	public boolean addFuel(double gallonsAdd)
	{
		if(currentNumGallons + gallonsAdd <= capacity)
		{
			currentNumGallons += gallonsAdd;
			return true;
		}
		else
		{
			currentNumGallons = capacity;
			return false;
		}
	}
}
