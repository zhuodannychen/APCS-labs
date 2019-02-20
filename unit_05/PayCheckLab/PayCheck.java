ay/** 
 *This is the paycheck class that includes several methods to calculate
 *the paycheck value based on if the employee is a manager or not and how
 *many sales they have.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:10-29-18
 */
 
public class PayCheck
{
  //static constants
  public static final int baseHour = 40;
  public static final double payRates = 9.75;
  public static final double rate = 1.5;
  public static final int bonus = 100;
  public static final double small = 0.05;
  public static final double med = 0.08;
  public static final double large = 0.13;
   
  //instance variables
  private String employee;
  private double hoursWorked;
  private boolean isManager;
  private double weeklySales;
  
  /**
   *  Creates a PayCheck object for an employee given the name and
   *  whether or not this employee is a manager.
   *  @param name the name of the employee
   *  @param manager indicates whether or not this is a manager
   *     (true if a manager, false if a sales clerk)
   */
  public PayCheck(String name, boolean manager)
  {
    employee = name;
    isManager = manager;
    hoursWorked = 0;
    weeklySales = 0;
  }

  /**
   *Calculates the wage amount for the worker based on how many hours
   *worked, manager or just a sales clerk, and amount of sales generated.
   *@return the amount of money the employee should get.
   */
  public double calcWages()
  {
    double wage = 0.0;
    if(hoursWorked < baseHour)
      wage = payRates * hoursWorked;
    else
      wage = (payRates * baseHour) + payRates * rate * (hoursWorked - baseHour);
    if(isManager == true)
    {
      wage += bonus;
    }
    double numOfSales = calcCommission();
    wage += numOfSales;
    return wage;
   }
  /**
   *Calculates the commision based on the sale cost of the commision being sold
   *@return the price of the commision
   */
  private double calcCommission()
  {
 	 double price = 0;
     if(weeklySales < 100)
     {
       price = weeklySales * small;
     }
     else if(weeklySales < 300 && weeklySales >= 100)
     {
       price = weeklySales * med;
     }
     else
     {
       price = weeklySales * large;
     } 
     return price;   
  }
  
  /** Retrieves the employee's name
   *  @return the name of this employee
   */
  public String getName()
  {
    return employee;
  }
  
  /** Reports whether or not this employee is a manager
   *  @return true if this employee is a manager, false otherwise
   */
  public boolean isManager()
  {
    return isManager;
  }
  
  /** Retrieves the number of hours worked
   *  @return the number of hours worked this pay period
   */
  public double getHours()
  {
    return hoursWorked;
  }

  /** Resets the number of hours worked to newHours
   *  @param newHours the number of hours worked this pay period
   */
  public void setHours(double newHours)
  {
    hoursWorked = newHours;
  }

  /** Retrieves the total amount of sales generated
   *  @return the total amount of sales generated this pay period
   */
  public double getSales()
  {
    return weeklySales;
  }

  /** Resets the amount of sales generated to newSales
   *  @param newSales the total amount of sales generated this pay period
   */
  public void setSales(double newSales)
  {
    weeklySales = newSales;
  }
}
