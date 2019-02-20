/** 
 * Fix the errors of the code, 10 syntax errors and 4 logical errors
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:9-12-18
 *	ComedyOfErrors Class
 *	Attempts to convert the degrees in Celsius input by the user
 *  to Fahrenheit using the formula F = 1.8 x C + 32
 */

import java.util.*;
public class ComedyOfErrors
{
	// Constants used in the formula F = 1.8 x C + 32
	public static final double MULTIPLIER = 1.8;
	public static final int ADDITIVE = 32;

	public static void main(String[] args)
	{
		// Enter degrees in Celsius
		Scanner input = new Scanner(System.in);
		System.out.print("Enter degrees in Celsius to convert: ");
		double degreesCelsius = input.nextDouble();
		
		// Convert to Fahrenheit
		double degreesFahrenheit = convertToFahrenheit(degreesCelsius);
		
		// Output converted temperature
		System.out.print(degreesCelsius + " degrees Celsius = ");
		System.out.print(degreesFahrenheit + " degrees Fahrenheit");
	}
	
	/** Calculates and returns the degrees in Celsius to Fahrenheit
	 *  @param degreesC the degrees in Celsius to be converted
	 *  @return the degreesC converted to Fahrenheit
	 */
	//method for converting celsius to fahrenheit
	public static double convertToFahrenheit(double degreesCelsius)
	{
		double degreesF = MULTIPLIER * degreesCelsius;
		degreesF += ADDITIVE; 
		return degreesF;		
	}
}
