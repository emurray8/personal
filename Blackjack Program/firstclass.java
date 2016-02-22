import java.util.Random;

public class Card
{
	Random rand = new Random();
	private int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
	36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

	public Card(int theValue, String theName)
	{
		int index = number.getNumber();
		int value = number.getValue();
		String name = number.getName();
		return name;

	}


	public String GetName(int n)
	{
		String name = "";

		if(n == 0)
		{
			name = "Ace of Hearts";
		}

		if(n >= 1 && n <= 9)
		{
			name = (n+1) + " of Hearts";
		}

		if(n == 10)
		{
			name = "Jack of Hearts";
		}

		if(n == 11)
		{
			name = "Queen of Hearts";
		}

		if(n == 12)
		{
			name = "King of Hearts";
		}

		if(n == 13)
		{
			name = "Ace of Spades";
		}

		if(n >= 14 && n <= 22)
		{
			name = (n-12) + " of Spades";
		}

		if(n == 23)
		{
			name = "Jack of Spades";
		}

		if(n == 24)
		{
			name = "Queen of Spades";
		}

		if(n == 25)
		{
			name = "King of Spades";
		}

		if(n == 26)
		{
			name = "Ace of Clubs";
		}

		if(n >= 27 && n <=35)
		{
			name = (n-25) + " of Clubs";
		}

		if(n == 36)
		{
			name = "Jack of Clubs";
		}

		if(n == 37)
		{
			name = "Queen of Clubs";
		}

		if(n == 38)
		{
			name = "King of Clubs";
		}

		if(n == 39)
		{
			name = "Ace of Diamonds";
		}

		if(n >= 40 && n <= 48)
		{
			name = (n-38) + " of Diamonds";
		}

		if(n == 49)
		{
			name = "Jack of Diamonds";
		}

		if(n == 50)
		{
			name = "Queen of Diamonds";
		}

		if(n == 51)
		{
			name = "King of Diamonds";
		}
		return name;

	}

	public int getValue()
	{

	}

	public int getNumber()
	{

	}






}