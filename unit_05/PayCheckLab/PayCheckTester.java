/** 
 *This is the paychecktester program which tests the paycheck program,
 *it calls to methods in paycheck and prints them out in the main method.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:10-29-18
 */

import java.util.Scanner;

public class PayCheckTester
{
  public static void main(String[] args)
  {
    boolean position = false;
    // Input name and type of worker
    Scanner scan = new Scanner(System.in);
    
    System.out.print("Enter employee's name: ");
    String name = scan.nextLine();
    
    System.out.print("Enter M (Manager) or S (Sales Clerk): ");
    String type = scan.next();
    System.out.println();

    if(type.equalsIgnoreCase("M"))
    {
      position = true;
    }
  
    // new object
    PayCheck employee = new PayCheck(name, position);
    
    // Set the hours and sales. Display the expected wage
    changeHoursAndSales(scan, employee);
    displayWages(employee);
    
    // Change the hours and sales. Display the expected wage
    changeHoursAndSales(scan, employee);
    displayWages(employee);
  }
  
  /** Updates worker's weekly hours and sales with information
   *  input by the user
   *  @param scan the Scanner to use to get input from user
   *  @param worker the Paycheck to update
   */
  public static void changeHoursAndSales(Scanner scan, PayCheck worker)
  {
    System.out.print("Enter total number of hours worked: ");
    double hours = scan.nextDouble();   
    
    //double totalWage = worker.calcWages();
    System.out.print("Enter total sales generated: ");
    double sales = scan.nextDouble();
    System.out.println();
    
    // Update PayCheck object's hours and sales
    worker.setHours(hours);
    worker.setSales(sales);   
  }
  /**
   *displays the name of the employee, number of hours they worked,
   *and number of sales they generated, all based on inputs. This is
   *later called in the main method.
   *@param worker the paycheck to update
   */
  public static void displayWages(PayCheck worker)
  {
    String name = worker.getName();
    double hours = worker.getHours();
    double sales = worker.getSales();
    double totalWage = worker.calcWages();
    boolean position = worker.isManager();
    String positionS;
    
    if(position == true)
    {
      positionS = "Manager";
    }
    else
    {
      positionS = "Sales Clerk";
    }
    
    System.out.printf("%s %s: %.1f hours, $%.2f in sales", positionS,name, hours, sales);
    System.out.println();
    System.out.printf("Total wages: $%.2f", totalWage);
    System.out.println();
    System.out.println();
  }
}
