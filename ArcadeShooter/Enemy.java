import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;

public class Enemy extends Unit implements ShotListener
{
	public boolean destroyed = false;
	private Shot shot = new Shot();
	private Random random = new Random();
	private String[] enemyList = {"enemy1.png", "enemy2.png", "enemy3.png", "enemy4.png", "enemy5.png", "enemy6.png", "enemy7.png"};
	private ImageIcon enemySprites;
	private Shooter shooter;
	private ImageIcon hitMarker;
	public Shot reflect = shot;

	public Enemy()
	{
		setPosition(450, 50);
		setVelocity(random.nextInt(21) - 10, -(random.nextInt(6) + 3));
		setSize(50, 30);
		setBounds(900, 440);
		enemySprites = new ImageIcon(enemyList[random.nextInt(6)]);
		hitMarker = new ImageIcon("hitmarker.png");
	}

	public void paintUnit(Graphics g)
	{
		if(!destroyed)
		{
			updatePosition(true);
			//g.setColor(Color.red);
			//g.fillRoundRect(x-width/2, y-height/2, width, height, 25, 15);
			enemySprites.paintIcon(shooter, g, x-width/2, y-width/2);
			if(random.nextInt(100) < shooter.level)
			{
				shot.fire(x, y, true);
			}
			shot.paintUnit(g);
		}
	}

	public Shot getShot()
	{
		return shot;
	}

	public Shot getReflect()
	{
		return reflect;
	}

	public boolean shotMoved(ShotEvent e)
	{
		if(contains(e.getX(), e.getY()) && !destroyed)
		{
			destroyed = true;
			Shooter.score++;
			return true;
		}
		return false;
	}


}

