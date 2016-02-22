import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.applet.AudioClip;
import java.applet.Applet;
import javax.swing.Timer;

public class Ball
{
	public int x = 450;
	public int y = 0;
	public int xVel = 10;
	public int yVel = 10;
	private Paddle paddle;
	public int hits = 0;
	public int lives = 3;
	private Pong parentPanel;
	private ImageIcon waffle;

	public Ball(Pong pg)
	{
		parentPanel = pg;
		waffle = new ImageIcon("waffle.png");
	}



	public void paintBall(Graphics g)
	{
		moveBall();
		waffle.paintIcon(parentPanel, g, x, y);
	}

	public void addPaddle(Paddle p)
	{
		paddle = p;

	}

	public void moveBall()
	{

		x = x + xVel;
		y = y + yVel;

		if(x < -12)
		{
			xVel = Math.abs(xVel);
			x = -12;
		}

		if(y < 5)
		{
			yVel = Math.abs(yVel);
			y = 5;
		}

		if(x > 809)
		{
			xVel = -Math.abs(xVel);
			x = 809;

		}

		if(y > 470)
		{
			if(paddle.getPadX()-100  < x && paddle.getPadX()+150 > x )
			{
				yVel = -Math.abs(yVel);
				y = 470;
				if(parentPanel.doublePoints)
				{
					hits = hits + 2;
				}
				else
				{
					hits++;
				}
			}
			else
			{
				x =450;
				y =20;
				lives--;
			}
		}
	}

	public int getHits()
	{
		return hits;

	}

	public int getLives()
	{
		return lives;
	}

	public void changeVelocity()
	{
		if(xVel > 0 && yVel > 0)
		{
			xVel = 5;
			yVel = 5;
		}
		if(xVel < 0 && yVel < 0)
		{
			xVel = -5;
			yVel = -5;
		}
		if(xVel > 0 && yVel < 0)
		{
			xVel = 5;
			yVel = -5;
		}
		if(xVel < 0 && yVel > 0)
		{
			xVel = -5;
			yVel = 5;
		}
	}

	public void resetVelocity()
	{
		if(xVel > 0 && yVel > 0)
		{
			xVel = 10;
			yVel = 10;
		}
		if(xVel < 0 && yVel < 0)
		{
			xVel = -10;
			yVel = -10;
		}
		if(xVel > 0 && yVel < 0)
		{
			xVel = 10;
			yVel = -10;
		}
		if(xVel < 0 && yVel > 0)
		{
			xVel = -10;
			yVel = 10;
		}
	}




}