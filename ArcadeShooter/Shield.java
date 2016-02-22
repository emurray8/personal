import java.awt.Graphics;
import java.awt.Color;

public class Shield extends Unit implements ShotListener
{
	private Shooter shooter;
	private Enemy enemy;
	private Shot shot;
	private Player player;
	private int shieldX = 0;
	private int shieldY = 0;
	private Color cyan = new Color(0, 255, 255);

	public Shield()
	{
		setSize(120, 20);
		setPosition(shieldX, 445);
	}

	public void paintShield(Graphics g)
	{
		updatePosition(false);
		g.setColor(cyan);
		g.fillRect(shieldX, 445, 120, 20);

	}


	public boolean shotMoved(ShotEvent e)
	{

		if(e.getY() > 445)
		{
			if(e.getX() > shieldX && e.getX() < shieldX+120)
			{
					e.getSource().y = 444;
					e.getSource().yVel *= -1;
					//return true;
			}
		}
		shot = e.getSource();
		return false;

	}

	public Shot getShot()
	{
		return shot;
	}

	public void setX(int x)
	{
		shieldX = x;
	}

	public int getX()
	{
		return shieldX;
	}

	public void setY(int y)
	{
		shieldY = y;

	}

	public int getY()
	{
		return shieldY;
	}


}