import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

public class FilesLab
{
  static String fileName = "";
  public static void main(String[] args)
  {
    try
    {
      // run 70-point version
      processIntegers("test1.txt", "output1.txt");
      System.out.println();
      
      // run 85-point version
      testLines("test2a.txt", "output2a.txt");
      
      // run 85-point version
      testLines("test2b.txt", "output2b.txt");
      System.out.println();
      
      // run 100-point version - good data
      extractSubstrings("test3a.txt", "output3a.txt");    
      
      // run 100-point version - bad data
      extractSubstrings("test3b.txt", "output3b.txt");    
      System.out.println();
    }
    catch (Exception exc)
    {
      System.out.println("Error opening file: " + exc.getMessage());
    }
  }
  
  public static void processIntegers(String inFile, String outFile) throws IOException
  {
    Scanner sc = new Scanner(new File(inFile));
    PrintWriter pw = new PrintWriter(new File(outFile));
    int cases = sc.nextInt();
    for(int i = 0; i < cases; i++)
    {
      int one = sc.nextInt();
      int two = sc.nextInt();
      int three = sc.nextInt();
      int min = Math.min(Math.min(one, two), three);
      int max = Math.max(Math.max(one, two), three);
      pw.print(min + " " + max);
      pw.println();
    }
    
    System.out.println("Smallest and largest integers from " + inFile
      + " written to " + outFile);
    pw.close();
  }
  
  public static void testLines(String inFile, String outFile) throws IOException
  {
    System.out.println("Lines from " + inFile + " written to " + outFile);
    
    Scanner sc = new Scanner(new File(inFile));
    PrintWriter pw = new PrintWriter(new File(outFile));
    String target = sc.next();
    char alter = Character.toUpperCase(target.charAt(0));
    String target2 = alter + target.substring(1);
    
    while(sc.hasNextLine())
    {
      String c = sc.nextLine();
      if(c.indexOf(target) != -1)
      {
        pw.println(c);
      }
      else if(c.indexOf(target2) != -1)
      {
        pw.println(c);
      }
    }
    pw.close();
  }
  
  public static void extractSubstrings(String inFile, String outFile) throws IOException
  {
   Scanner sc = new Scanner(new File(inFile));
   PrintWriter pw = new PrintWriter(new File(outFile));
   fileName = outFile;

   while(sc.hasNextLine())
   {
     int index1 = sc.nextInt();
     int index2 = sc.nextInt();
     String result = sc.nextLine().trim();
     
     result = getSubstring(index1, index2, result);
     pw.println(result);
   }

   pw.close();
   System.out.println("Requested substrings from " + inFile + " written to " + outFile);
  }
  
  private static String getSubstring(int index1, int index2, String text)
  {
   	 
     //System.out.println(fileName);
     String result = "";
     
     try
     {
      result = text.substring(index1, index2);
      result = ":" + result + ":";

     }
     catch(Exception e)
     {
      result = "Error in file " + fileName + " Invalid indexes [" + index1 + ", " + index2 + ") for " + text;
     }
     return result;
     
  }
}
