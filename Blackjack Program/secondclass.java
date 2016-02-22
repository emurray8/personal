public class deck
{
	card[] cards = new card[52];

	public void Shuffle(int[] a)
	{
		for(int i = 0; i < cards.length; i++)
		{
			cards[i] = cards[rand.nextInt(51)];

		}


	}

	public int GetCard()
	{
		int drawn = cards[0];
		return drawn;

	}




}