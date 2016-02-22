import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.applet.Applet;
import java.applet.AudioClip;

public class Shot extends Unit
{
	public boolean fired = false;
	private ShotListener[] listener = new ShotListener[10];
	private int listeners = 0;
	private Player player;
	private Shooter shooter;
	private Shield shield;
	private AudioClip pew = Applet.newAudioClip(getClass().getResource("laser.wav"));
	public boolean shotAnimation = false;





	public Shot()
	{
		setBounds(900, 600);
		setSize(3, 5);
		speed = 15;

	}

	public void fire(int launchX, int launchY, boolean down)
	{
		if(!fired)
		{
			fired = true;
			setPosition(launchX, launchY);
			if(down)
			{
				yVel = speed;
			}
			else
			{
				yVel = -speed;
				pew.play();
				shotAnimation = true;
			}

		}
	}



	public void addShotListener(ShotListener l)
	{
		listener[listeners] = l;
		listeners++;
	}

	public void paintUnit(Graphics g)
	{
		if(fired)
		{
			updatePosition(false);
			g.setColor(Color.yellow);
			g.drawLine(x, y-2, x, y+2);
			checkForEdge();
			callListeners();

		}

	}



	private void checkForEdge()
	{
		if(y + 5 >= bottomBound || y - 5 <= topBound)
		{
			fired = false;
		}

		if(y - 500 <= topBound)
		{
			shotAnimation = false;
		}
	}

	private void callListeners()
	{
		for(int i = 0; i < listeners; i++)
		{
			if(listener[i].shotMoved(new ShotEvent(x, y, this)))
			{
					fired = false;

			}
		}
	}


}