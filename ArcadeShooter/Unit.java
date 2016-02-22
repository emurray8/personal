import java.awt.Graphics;

public abstract class Unit
{
	protected int x = 0;
	protected int y = 0;
	protected int xVel = 0;
	protected int yVel = 0;
	protected int speed = 0;
	protected int width = 10;
	protected int height = 10;
	protected int leftBound = 0;
	protected int rightBound = 0;
	protected int topBound = 0;
	protected int bottomBound = 0;


	public void paintUnit(Graphics g)
	{}

	public void setBounds(int l, int r, int t, int b)
	{
		leftBound = l;
		rightBound = r;
		topBound = t;
		bottomBound = b;
	}

	public void setBounds(int r, int b)
	{
		rightBound = r;
		bottomBound = b;
	}

	public void setPosition(int xPos, int yPos)
	{
		x = xPos;
		y = yPos;
	}

	public void setVelocity(int xVelocity, int yVelocity)
	{
		xVel = xVelocity;
		yVel = yVelocity;
	}

	public void setSize(int w, int h)
	{
		width = w;
		height = h;
	}

	public boolean contains(int testX, int testY)
	{
		if(testX > x - width/2 && testY > y - height/2 && testX < x + width/2 && testY < y + height/2)
		{
			return true;
		}
		return false;
	}

	protected void updatePosition(boolean bounce)
	{
		x = x + xVel;
		y = y + yVel;

		if(x - width/2 < leftBound)
		{
			x = width/2 + leftBound;
			if(bounce)
			{
				xVel = Math.abs(xVel);
			}
		}
		if(y - height/2 < topBound)
		{
			y = height/2 + topBound;
			if(bounce)
			{
				yVel = Math.abs(yVel);
			}
		}
		if(x + width/2 > rightBound)
		{
			x = rightBound - width/2;
			if(bounce)
			{
				xVel = -Math.abs(xVel);
			}
		}
		if(y + height/2 > bottomBound)
		{
			y = bottomBound - height/2;
			if(bounce)
			{
				yVel = -Math.abs(yVel);
			}
		}
	}
}

