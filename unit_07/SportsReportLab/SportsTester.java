/**This is the SportsTester file which includes main method,
 *it calls on the SportsReport file to accurately display the sport reports.
 * @author Zhuo Chen
 * Teacher Name: Garg
 * Period: 3
 * Due Date: 12-03-18
 */

public class SportsTester
{
  public static void main(String[] args)
  {
    //one test case
    SportsReport score1 = new SportsReport(
      "Dallas Cowboys beat Miami Dolphins by a score of 20 to 19");
   // 012345678901234567890123456789012345678901234567890123456
    checkReport(score1);
    
  	//More test Cases
    score1.changeScoringInfo(
      "Washington Redskins beat Seattle Seahawks by a score of 56 to 0");
    checkReport(score1);

    score1.changeScoringInfo(
      "Deadbeats beat Spoofs by a score of 130 to 74");
    checkReport(score1);


    // More scores
    SportsReport score2 = new SportsReport(
      "Dallas Mavericks beat Philadelphia 76ers by a score of 97 to 94");
    SportsReport score3 = new SportsReport(
      "Portland Trail Blazers beat New Jersey Nets by a score of 108 to 98");
    SportsReport score4 = new SportsReport(
      "Oklahoma City Thunder beat Denver Nuggets by a score of 115 to 113");
    SportsReport score5 = new SportsReport(
      "Dallas Stars beat Vancouver Canucks by a score of 2 to 1");
    SportsReport score6 = new SportsReport(
      "Washington Capitals beat St. Louis Blues by a score of 4 to 1");
    SportsReport score7 = new SportsReport(
      "Texas Rangers beat Houston Astros by a score of 10 to 3");
    SportsReport score8 = new SportsReport(
      "Baltimore Orioles beat San Francisco Giants by a score of 5 to 2");
    System.out.println("More scores:");
    System.out.println(score1.toString());
    System.out.println(score2.toString());
    System.out.println(score3.toString());
    System.out.println(score4.toString());
    System.out.println(score5.toString());
    System.out.println(score6.toString());
    System.out.println(score7.toString());
    System.out.println(score8.toString());
    System.out.println();

  }
  
  /** Check score report by displaying its various information
   *  @param report the score report to display
   */
  public static void checkReport(SportsReport report)
  {
    System.out.println("winner: " + report.getWinner());
    System.out.println("loser:  " + report.getLoser());
    System.out.println("winning score: " + report.getWinningScore());
    System.out.println("losing score:  " + report.getLosingScore());
    System.out.println(report.getWinner() + " won by "
      + report.getScoreDifference());
    System.out.println();
  }
}
