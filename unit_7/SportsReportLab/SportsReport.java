/**This is another file which contains the methods that the SportsTester calls on,
 *extractInformation extracts all the useful information from a string, and it's
 *a private method.
 * @author Zhuo Chen
 * Teacher Name: Garg
 * Period: 3
 * Due Date: 12-03-18
 */
 
public class SportsReport
{
	private String winner;
	private String loser;
	private int winningScore;
    private int losingScore;
  	public static final String BEAT = " beat ";
  	public static final String BY = " by ";
  	public static final String OF = " of ";
  	public static final String TO = " to ";

  	/** Constructs a SportsReport using the information in score
   	*  @param score contains winner, loser, and scores in the format:
   	*  <winner> beat <loser> by a score of <winning score> to <losing score>
   	*/
	public SportsReport(String score)
  	{
    	extractInformation(score);
  	}

  	/** Changes the sports scoring information
   	*  @param score contains winner, loser, and scores in the format:
   	*  <winner> beat <loser> by a score of <winning score> to <losing score>
   	*/
  	public void changeScoringInfo(String score)
  	{
    	extractInformation(score);
  	}

  	//Accessor methods
  	
  	/**Gets the winniner's name
  	*@return the winner
  	*/
  	public String getWinner()
  	{
		return winner;
  	}
  	/**Gets the loser's name
   	*@return the loser team
   	*/
  	public String getLoser()
  	{
    	return loser;
  	}
  	/**Gets the winningScore
   	*@return the winning score
   	*/
  	public int getWinningScore()
  	{
    	return winningScore;
  	}
  	/**Gets the losingScore
   	*@return the losing score
   	*/
  	public int getLosingScore()
  	{
    	return losingScore;
  	}

  	/**Gets the score difference for the winning and losing scores
   	*@return the score difference
   	*/
  	public int getScoreDifference()
  	{
    	return winningScore - losingScore;
  	}

  	@Override
  	public String toString()
  	{
  		//formats the string
  		String finall = String.format("%-25s%4d, %-25s%4d", winner, winningScore, loser, losingScore);
    	return finall;
  	}
  
  	/**This private method takes all the important information from a string called scores,
   	*it should update winer, loser, winningScore, and losingScore.
   	*@param score contains winner, loser, and scores in the format:
   	*<winner> beat <loser> by a score of <winning score> to <losing score>
   	*/
  	private void extractInformation(String score)
  	{
    	int indexOfBeat = -1;
    	int indexOfBy = -1;
  		int indexOfOff = -1;
   		int indexOfTo = -1;

    	for(int i = 0; i < score.length() - 1; i++)
    	{
      		if(score.substring(i, i + 6).equals(BEAT))
      		{
        		indexOfBeat = i;
      			winner = score.substring(0, i + 1).trim();
        		break;
      		}
    	}
    
    	for(int j = indexOfBeat; j < score.length() - 1; j++)
    	{
      		if(score.substring(j, j + 4).equals(BY))
      		{
       			indexOfBy = j;
       			loser = score.substring(indexOfBeat + 6, indexOfBy);
       			break;
      		}     
   		}

   		for(int i = indexOfBy; i < score.length() - 1; i++)
   		{
      		if(score.substring(i, i + 4).equals(OF))
      		{
        		indexOfOff = i;
       			break;
      		}     
   		}

   		for(int j = indexOfOff; j < score.length() - 1; j++)
   		{
      		if(score.substring(j, j + 4).equals(TO))
      		{
      			indexOfTo = j;
       			String stringWinScore = score.substring(indexOfOff + 3, indexOfTo).trim();
       			winningScore = Integer.parseInt(stringWinScore);
       			break;
      		}     
   		}   
  
   		String stringloseScore = score.substring(indexOfTo + 3, score.length()).trim();
   		losingScore = Integer.parseInt(stringloseScore);
  }
}
