import java.util.Random;
import java.awt.*;
import javax.swing.ImageIcon;

public class PowerUp
{
	private Shooter shooter;
	private Player player;
	private Enemy enemy;
	private Random rand = new Random();
	public int x = 300;
	public int y = 530;
	public int powerUpSelection = -1;
	public boolean powerUpActive = false;
	private ImageIcon multiShot;
	private ImageIcon shield;
	private ImageIcon rapidFire;
	public int select = 0;


	public PowerUp()
	{
		multiShot = new ImageIcon("tripleshot.png");
		shield = new ImageIcon("shield.png");
		rapidFire = new ImageIcon("rapidfire.png");
	}

	public void powerUpSelect()
	{
		select = rand.nextInt(3) + 1;
	}


	public void paintPowerUp(Graphics g)
	{

		if(select == 1)
		{
			//player.tripleShot = true;
			multiShot.paintIcon(shooter, g, x, y);
		}

		if(select == 2)
		{
			shield.paintIcon(shooter, g, x, y);
		}

		if(select == 3)
		{
			rapidFire.paintIcon(shooter, g, x, y);
		}
	}


	public void setX()
	{
		x = rand.nextInt(800) + 150;

	}

	public void checkCollision()
	{


	}


}