public class SportsReport
{
	private String winner;
	private String loser;
	private int winningScore;
	private int losingScore;

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

	public String getWinner()
	{

		return winner;
		
	}

	public String getLoser()
	{
		return loser;
	}

	public int getWinningScore()
	{
		return winningScore;
	}

	public int getLosingScore()
	{
		return losingScore;
	}

	public int getScoreDifference()
	{
		return winningScore - losingScore;
	}

	@Override
	public String toString()
	{
    String finall = String.format("%-25s%4d, %-25s%4d", winner, winningScore, loser, losingScore);
		return finall;
	}
	

	private void extractInformation(String score)
	{
		int indexOfBeat = -1;
		int indexOfBy = -1;
    int indexOfOff = -1;
    int indexOfTo = -1;

		for(int i = 0; i < score.length() - 1; i++)
		{
			if(score.substring(i, i + 6).equals(" beat "))
			{
				indexOfBeat = i;
        winner = score.substring(0, i + 1).trim();
				break;
			}
		}
		
		for(int j = indexOfBeat; j < score.length() - 1; j++)
		{
			
			if(score.substring(j, j + 4).equals(" by "))
			{
				indexOfBy = j;
        loser = score.substring(indexOfBeat + 6, indexOfBy);
        break;
			}			
		}

    for(int i = indexOfBy; i < score.length() - 1; i++)
		{
			
			if(score.substring(i, i + 4).equals(" of "))
			{
				indexOfOff = i;
        break;
			}			
		}

    for(int j = indexOfOff; j < score.length() - 1; j++)
		{
			
			if(score.substring(j, j + 4).equals(" to "))
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
