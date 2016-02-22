import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.applet.Applet;
import java.applet.AudioClip;

public class Player extends Unit implements KeyListener, ShotListener
{
	private Shot shot = new Shot();
	private Shot powerShot1 = new Shot();
	private Shot powerShot2 = new Shot();
	private Shot missile = new Shot();
	private ImageIcon galaxyGuy;
	private Shooter shooter;
	public boolean firing = false;
	public boolean tripleShot = false;
	public boolean shield = false;
	public boolean rapidFire = false;
	private armorPiercing armorPiercer;
	private ImageIcon fire;
	public boolean paused = false;


	public Player()
	{
		setPosition(450, 570);
		setSize(59, 59);
		speed = 20;
		setBounds(0, 900, 570, 570);
		galaxyGuy = new ImageIcon("player.gif");
		fire = new ImageIcon("fire.gif");
	}

	public void paintUnit(Graphics g)
	{
		updatePosition(false);
		//g.setColor(Color.blue);
		//g.fillOval(x - width/2, y - height/2, width, height);
		galaxyGuy.paintIcon(shooter, g, x - width/2, y-width/2);
		shot.paintUnit(g);
		powerShot1.paintUnit(g);
		powerShot2.paintUnit(g);
		if(shot.shotAnimation)
		{
			paintFire(g);
		}
	}

	public void paintFire(Graphics g)
	{
		fire.paintIcon(shooter, g,  x-13, y - 60);

	}


	public Shot getShot()
	{
		return shot;
	}

	public Shot getShot2()
	{
		return powerShot1;
	}

	public Shot getShot3()
	{
		return powerShot2;
	}


	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean getShield()
	{
		return shield;
	}

	public boolean shotMoved(ShotEvent e)
	{
		if(contains(e.getX(), e.getY()))
		{
			x = 450;
			Shooter.lives--;
			return true;
		}
		return false;
	}


	public void keyPressed(KeyEvent e)
	{

		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			xVel = -speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			xVel = speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{

			shot.fire(x, y, false);

			firing = true;
			if(rapidFire)
			{
				powerShot1.xVel = 0;
				powerShot2.xVel = 0;
				powerShot1.fire(x, y-15, false);
				powerShot2.fire(x, y-30, false);
			}
			if(tripleShot)
			{
				powerShot1.xVel = 5;
				powerShot2.xVel = -5;
				powerShot1.fire(x, y, false);
				powerShot2.fire(x, y, false);
			}

		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			Shooter.gameStart = true;

		}
		if(e.getKeyCode() == KeyEvent.VK_F)
		{
			System.exit(0);
		}

	}

	public void keyReleased(KeyEvent e)
	{
		xVel = 0;
		firing = false;
	}
	public void keyTyped(KeyEvent e)
	{}
}


