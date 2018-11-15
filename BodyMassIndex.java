/** 
 * This is a BMI calculator that calculates your BMI based on 
 *your weight and height. The user first enters their height in
 *CM and weight in Kg, then they enter height in Inches and weight
 *in pounds so the experience is user friendly.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:9-19-18
 */

import java.util.*;

public class BodyMassIndex 
{
	// constants for unit conversions
	public static final double METERS = 100.0;
	public static final double KILOGRAM = 0.453592;
	public static final double CENTIMETER = 2.54;
	
	
	public static void main(String[] args) 
	{
		// calculates BMI based on Metric input

		calculateMetricBMI();
		System.out.println();
		
		// calculates BMI based on imperial units
		System.out.println();
		System.out.println();
		calculateImperialBMI();
		System.out.println();
	}
	
	/** 
	 *Inputs the user data in metric units, and calls getBMI method
	 */
	public static void calculateMetricBMI()
	{
		//Scans in user input in metric units
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your weight in kilograms: ");
		int weightKG = scanner.nextInt();
		System.out.println();
		System.out.print("Enter your height in centimeters: ");
		int heightCM = scanner.nextInt();
		System.out.println();
		//Calls getBMI method
		double get1 = getBMI(weightKG, heightCM);
		System.out.println("A body mass index of 20 - 25 is considered \"normal\"");
		System.out.printf("Your BMI is %.2f", get1);
	} 
		
	
	/**
	 *Calculates the BMI with metric unit and prints out the value.
	 *@param weightKG gets the weight the user inputs in KG.
	 *@param heightCM gets the height the user inputs in CM.
	 *@return the bmi number
	 */ 
	public static double getBMI(int weightKG, int heightCM)
	{
		// getBMI calculation does formula
		double bmi = weightKG / (Math.pow(heightCM / METERS, 2));
		return bmi;
	}
	
	/** 
	 *Scans the user input in inches and pounds.
	 *calls convertInchesToCM and convertPoundsToKG and getBMI
	 */
	public static void calculateImperialBMI()
	{
		// Scans for user input in pounds and inches
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your weight in pounds: ");
		int numPounds = scanner.nextInt();
		System.out.println();
		System.out.print("Enter your height in inches: ");
		int numInches = scanner.nextInt();
		System.out.println();
		//Converts inches and pounds to metric
		int inches = convertInchesToCM(numInches);
		int pounds = convertPoundsToKG(numPounds);
		//Calls get, but with variable pounds and inches
		double get2 = getBMI(pounds,inches);
		System.out.println("A body mass index of 20 - 25 is considered \"normal\"");
		System.out.printf("Your BMI is %.2f", get2);
		
	}
	
	/** 
	 *Uses the constant KILOGRAM and converts pounds to KG
	 *@param numPounds the user input of how much they weight in pounds
	 *@return the number of pounds in KG
	 */
	public static int convertPoundsToKG(int numPounds)
	{
		//uses the constant KILOGRAM, this prevents magic number
		numPounds = (int) Math.round(numPounds * KILOGRAM);
		return numPounds;
	}
	
	/** 
	 *Uses the constant CENTIMETER and converts Inches to CM
	 *@param numInches the user input of how tall they are in Inches
	 *@return the number of inches in CM
	 */
	public static int convertInchesToCM(int numInches)
	{
		//uses the constant CENTIMETER, this prevents magic number
		numInches = (int) Math.round(numInches * CENTIMETER);
		return numInches;
	}
}
