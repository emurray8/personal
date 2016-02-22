import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.applet.Applet;
import java.applet.AudioClip;

public class Shooter extends JPanel implements ActionListener
{
	public static int score = 0;
	public static int lives = 3;
	public static boolean gameStart = false;
	public static int level = 2;

	private Player player = new Player();
	private Enemy[] enemy = new Enemy[10];
	private int counter = 0;
	private int deathDelay = 0;
	private ImageIcon boom;
	private boolean dead = false;
	public Timer timer = new Timer(50, this);
	private PowerUp power = new PowerUp();
	private boolean spawnPower = false;
	private AudioClip atari = Applet.newAudioClip(getClass().getResource("boom.wav"));
	private Shield shield = new Shield();
	private Font font1 = new Font("algerian", Font.BOLD, 32);
	private Shot shot;
	private AudioClip intro = Applet.newAudioClip(getClass().getResource("intro.mid"));
	private AudioClip theme = Applet.newAudioClip(getClass().getResource("theme.mid"));
	private AudioClip sad = Applet.newAudioClip(getClass().getResource("sadsong.wav"));
	private ImageIcon titleScreen;
	private ImageIcon deathScreen;


	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Extra-terrestrial Marauders");
		frame.setSize(906, 633);
		frame.setResizable(false);
		frame.add(new Shooter());
		frame.setVisible(true);
	}

	public Shooter()
	{
		setFocusable(true);
		addKeyListener(player);
		for(int i = 0; i < enemy.length; i++)
		{
			enemy[i] = new Enemy();
			player.getShot().addShotListener(enemy[i]);
			player.getShot2().addShotListener(enemy[i]);
			player.getShot3().addShotListener(enemy[i]);
			enemy[i].getShot().addShotListener(player);
			enemy[i].getReflect().addShotListener(shield);
			enemy[i].getReflect().addShotListener(enemy[i]);

		}
		boom = new ImageIcon("explosion.gif");
		titleScreen = new ImageIcon("titlescreen.png");
		deathScreen = new ImageIcon("deathscreen.png");
		theme.loop();
		timer.start();


	}

	public void paintComponent(Graphics g)
	{
		if(!gameStart)
		{
			titleScreen.paintIcon(this, g, 0, 0);
		}
		else
		{

		g.setColor(Color.black);
		g.fillRect(0, 0, 900, 620);
		player.paintUnit(g);

		for(int i = 0; i < enemy.length; i++)
		{
			enemy[i].paintUnit(g);
		}
		g.setColor(Color.green);
		g.drawString("Score: " + Shooter.score, 50, 580);
		g.drawString("Lives: " + Shooter.lives, 800, 580);

		if(spawnPower)
		{
			power.paintPowerUp(g);
			if(player.x  < power.x+30 && player.x+64 > power.x)
			{
				spawnPower = false;
				if(power.select == 1)
				{
					player.tripleShot = true;
				}
				if(power.select == 2)
				{
					player.shield = true;
				}
				if(power.select == 3)
				{
					player.rapidFire = true;
				}
			}
		}

		if(allDead())
		{
			level = level + 2;
			respawn();
		}

		if(player.shield)
		{
			shield.setX(player.x-50);
			shield.paintShield(g);

		}
		else
		{
			shield.setX(-1000);

		}
		if(Shooter.lives <= 0)
		{
			dead = true;
			boom.paintIcon(this, g, player.x-20, player.y-25);
			if(deathDelay < 1)
			{
				atari.play();
				sad.play();

			}
		}

		if(deathDelay > 40)
		{

			deathScreen.paintIcon(this, g, 0, 0);
			theme.stop();
			dead = false;
		}
		}

	}


	public boolean allDead()
	{
		boolean allDead = false;
		int killed = 0;
		for(int i = 0; i < enemy.length; i++)
		{
			if(enemy[i].destroyed)
			{
				killed++;
			}
		}

		if(killed == enemy.length)
		{
			allDead = true;
		}
		return allDead;
	}

	public void respawn()
	{
		for(int i = 0; i < enemy.length; i++)
		{
			enemy[i].destroyed = false;
			enemy[i].setPosition(450, 50);
		}
	}


	public void actionPerformed(ActionEvent e)
	{
		repaint();
		counter++;
		if(counter % 300 == 0)
		{
			power.setX();
			power.powerUpSelect();
			spawnPower = true;
		}
		if(counter % 600 == 0)
		{
			spawnPower = false;
			player.tripleShot = false;
			player.shield = false;
			player.rapidFire = false;
		}
		if(dead)
		{
			deathDelay++;
		}
	}
}

