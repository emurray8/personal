public class ShotEvent
{
	private int x;
	private int y;
	private Shot source;

	public ShotEvent(int xVal, int yVal, Shot shot)
	{
		x = xVal;
		y = yVal;
		source = shot;
	}

	public Shot getSource()
	{
		return source;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
}