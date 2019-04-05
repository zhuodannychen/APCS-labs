/** This class converts roman numerals into normal numbers, or they can convert normal numbers into roman numerals. It also implements the comparable and countable interfaces
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 04-05-2019
 */
public class RomanNumeral implements Comparable<RomanNumeral>, Countable
{
	/** array of possible Roman Numeral letters */
	private static final String[] ROMAN_LETTERS = 
		{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
	
	/** array of values for corresponding Roman Numeral letters */
	private static final int[] ROMAN_VALUES = 
		{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 

	/** the value as a roman numeral */
	private String romanStr;
	
	/** the roman numeral as an integer */
	private int romanInt;
	
	/** Constructs a RomanNumeral with the given roman numeral
	 *  @param romanNum a string containing a valid roman numeral
	 */
	public RomanNumeral(String romanNum)
	{
		reset(romanNum);
	}
	
	/** Constructs a roman numeral with the given decimal integer
	 *  @param num an integer from which to create a roman numeral
	 */
	public RomanNumeral(int num)
	{
		reset(num);
	}
	
	/** This method is being called by the constructor, so it insantiates a romanInt and romanStr based on the given 
	 *  number in Roman Numeral format. It converts then given number in Roman Numeral into a normal Numer.
	 *  @param newRomanNum The number in roman numeral format, which would be converted into a normal number.
	 */
	public void reset(String newRomanNum)
	{
		romanStr = newRomanNum;
		int sum = 0;
		while(newRomanNum.length() > 1)
		{
			for(int i = 0; i < ROMAN_LETTERS.length; i++)
			{
				if(newRomanNum.substring(0, 1).equals(ROMAN_LETTERS[i]))
				{
					sum += ROMAN_VALUES[i];
					newRomanNum = newRomanNum.substring(1);
					break;
				}
				else if(newRomanNum.substring(0, 2).equals(ROMAN_LETTERS[i]))
				{
					sum += ROMAN_VALUES[i];
					newRomanNum = newRomanNum.substring(2);
					break;
				}
			}
		}
		if(newRomanNum.length() == 1)
		{
			for(int i = 0; i < ROMAN_LETTERS.length; i++)
			{
				if(newRomanNum.substring(newRomanNum.length() - 1).equals(ROMAN_LETTERS[i]))
				{
					sum += ROMAN_VALUES[i];
					break;
				}
			}
		}
		romanInt = sum;
	}

	/** This method is being called by the constructor, so it insantiates a romanInt and romanStr based
	 *  on the given number in normal format. It converts then given number to a Roman Numeral.
	 *  @param newNum The number in normal format, which would be converted into Roman Numeral.
	 */
	public void reset(int newNum)
	{
		romanInt = newNum;
		romanStr = "";
		while(newNum >= 1)
		{
			for(int i = 0; i < ROMAN_VALUES.length; i++)
			{
				if(ROMAN_VALUES[i] <= newNum)
				{
					romanStr += ROMAN_LETTERS[i];
					newNum = newNum - ROMAN_VALUES[i];
					break;
				}
			}
		}
	}
	
	/** Determines whether or not 2 roman numerals are the same
	 *  @param obj the other roman numeral to compare agains
	 *  @return true if this matches obj; false otherwise
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof RomanNumeral))
			return false;
		
		RomanNumeral other = (RomanNumeral) obj;
		return this.getValue() == other.getValue();
	}
	
	/** Compare 2 RomanNumeral to determine which is "smaller"
	 *  based on its decimal integer value
	 *  @param other the other RomanNumeral to compare against
	 *  @return 0 if this.equals(other) is true
	 *          < 0 if this < other
	 *          > 0 if this > other
	 */
	@Override
	public int compareTo(RomanNumeral other)
	{
		if (this.equals(other))
			return 0;
		
		return getValue() - other.getValue();
	}		
	
	/** Provides this RomanNumeral information in a string
	 *  @return RomanNumeral info as a string
	 */
	@Override
	public String toString()
	{
		return romanStr;
	}
	
	/** This method gets the value of the number in roman Integer.
	 */
	public int getValue()
	{
		return romanInt;
	}
}
