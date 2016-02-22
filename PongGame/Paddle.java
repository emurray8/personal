import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.applet.AudioClip;
import java.applet.Applet;

public class Paddle implements KeyListener
{
	public int padx = 450;
	private int pady = 500;
	private int xVelo = 0;
	private Pong parentPanel;
	private ImageIcon bacon;
	private PowerUp power;


	public Paddle(Pong p)
	{
		parentPanel = p;
		bacon = new ImageIcon("bacon.png");
	}


	public void paintPad(Graphics g)
	{
		checkBounds();
		g.setColor(Color.black);
		//g.drawLine(padx, pady, padx, pady+50);
		//g.drawLine(padx+200, pady, padx+200, pady+50);
		bacon.paintIcon(parentPanel, g, padx, pady);

	}


	public void checkBounds()
	{
		padx = padx + xVelo;

		if(padx < 10)
		{
			padx = 10;
		}

		if(padx > 685)
		{
			padx = 685;
		}
	}


	public int getPadX()
	{
		return padx;
	}


	public void keyTyped(KeyEvent e)
	{


	}

	public void keyPressed(KeyEvent e)
	{

		if(e.getKeyCode() == KeyEvent.VK_LEFT && parentPanel.fastPaddleActive)
		{
			xVelo = -25;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			xVelo = -10;
		}




		if(e.getKeyCode() == KeyEvent.VK_RIGHT && parentPanel.fastPaddleActive)
		{
			xVelo = 25;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			xVelo = 10;
		}

	}

	public void keyReleased(KeyEvent e)
	{
		xVelo = 0;

	}

}