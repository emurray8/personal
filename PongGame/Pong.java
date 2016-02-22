import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;
import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import java.util.Random;

public class Pong extends JPanel implements ActionListener, KeyListener
{
	private int xPos = 30;
	private int yPos = 30;
	private int i = 0;
	private Ball ball = new Ball(this);
	private Paddle paddle = new Paddle(this);
	private ImageIcon back;
	private Font font1 = new Font("algerian", Font.BOLD, 32);
	private ImageIcon background;
	private ImageIcon loser;
	private AudioClip shrek = Applet.newAudioClip(getClass().getResource("shrek.mid"));
	private boolean gameStart = false;
	public int timeCounter = 0;
	private Color backColor = new Color(144, 121, 89);
	public Timer speed = new Timer(50, this);
	private PowerUp power = new PowerUp();
	private boolean gameOver = false;
	private Random rand = new Random();
	public boolean powerUpSpawn = false;
	private boolean powerUpActive = false;
	public boolean fastPaddleActive = false;
	public boolean doublePoints = false;
	private ImageIcon pointPowerUp;
	private ImageIcon paddlePowerUp;
	private ImageIcon ballPowerUp;
	private boolean slowBall = false;


	public static void main(String[] args)
	{
		JFrame frame = new JFrame("International House of Pong");
		frame.setSize(900, 600);
		frame.setResizable(false);
		frame.add(new Pong());
		frame.setVisible(true);



	}

	public Pong()
	{
		setFocusable(true);
		addKeyListener(paddle);
		addKeyListener(this);
		ball.addPaddle(paddle);
		back = new ImageIcon("ihop.png");
		loser = new ImageIcon("sadpepe.jpg");
		pointPowerUp = new ImageIcon("doublepoints.gif");
		paddlePowerUp = new ImageIcon("fastpaddle.gif");
		ballPowerUp = new ImageIcon("slowball.gif");
		shrek.loop();


	}


	public void paintComponent(Graphics g)
	{
		if(gameStart == false)
		{
			g.setColor(Color.black);
			g.fillRect(0,0,900,600);
			g.setColor(Color.white);
			g.setFont(font1);
			g.drawString("Welcome to the International House of Pong!", 10, 300);
			g.drawString("Press left arrow to move left,", 10, 330);
			g.drawString("press right arrow to move right", 10, 360);
			g.drawString("Press enter to start.", 10, 390);
		}
		else
		{
			back.paintIcon(this, g, 0, 0);
			g.setColor(backColor);
			g.fillRect(0, 0, 10, 600);
			g.fillRect(885, 0, 10, 600);
			g.fillRect(0, 0, 900, 10);
			//g.fillRect(0, 565, 900, 10);
			ball.paintBall(g);
			paddle.paintPad(g);
			if(doublePoints)
			{
				pointPowerUp.paintIcon(this, g, 250, 100);
			}
		/*	if(slowBall)
			{
				ballPowerUp.paintIcon(this, g, 350, 100);
			}
			if(fastPaddleActive)
			{
				paddlePowerUp.paintIcon(this, g, 350, 100);

			}*/
		/*	if(power.powerUpSelection == 1 && powerUpSpawn)
			{
				power.paintPowerSlow(g);
				if(paddle.getPadX()  < power.powerUpXVal && paddle.getPadX()+150 > power.powerUpXVal)
				{
					power.powerUpXVal = 1000;
					powerUpActive = true;
					if (powerUpActive)
					{
						ball.changeVelocity();
						slowBall = true;

					}
				}
			}*/
			if(power.powerUpSelection == 2 && powerUpSpawn)
			{
				power.paintPowerDoublePoints(g);
				if(paddle.getPadX()  < power.powerUpXVal && paddle.getPadX()+150 > power.powerUpXVal)
				{
					power.powerUpXVal = 1000;
					powerUpActive = true;
					if(powerUpActive = true)
					{
						doublePoints = true;

					}
				}
			}
	/*		if(power.powerUpSelection == 3 && powerUpSpawn)
			{
				power.paintPowerFastPaddle(g);
				if(paddle.getPadX()  < power.powerUpXVal && paddle.getPadX()+150 > power.powerUpXVal)
				{
					power.powerUpXVal = 1000;
					powerUpActive = true;
					if(powerUpActive)
					{
						fastPaddleActive = true;

					}
				}
			}*/
			g.setColor(Color.red);
			g.setFont(font1);
			g.drawString("Points: " + Integer.toString(ball.getHits()), 100, 565);
			g.drawString("Lives: " + Integer.toString(ball.getLives()), 600, 565);
		}
		if(ball.getLives() == 0)
		{
			shrek.stop();
			loser.paintIcon(this, g, 0, 0);
			g.setColor(Color.red);
			g.drawString("Too bad! You lost. Press enter to try again.", 10, 480);
			gameOver = true;
			doublePoints = false;
			powerUpActive = false;
			speed.stop();

		}

	}


	public void actionPerformed(ActionEvent e)
	{
		repaint();
		timeCounter++;
		if(timeCounter % 900 == 0)
		{
			powerUpSpawn = true;
			power.powerUpXVal = rand.nextInt(600)+30;
			power.powerUpSelection();
		}
		if(timeCounter % 1200 == 0)
		{
			powerUpActive = false;
			/*ball.resetVelocity();
			fastPaddleActive = false;*/
			doublePoints = false;
		//	slowBall = false;
		}

	}


	public void keyTyped(KeyEvent f)
	{


	}

	public void keyPressed(KeyEvent f)
	{
		if(f.getKeyCode() == KeyEvent.VK_ENTER && gameStart == false)
		{
			speed.start();
			gameStart = true;
		}

		if(f.getKeyCode() == KeyEvent.VK_ENTER && gameOver)
		{
			speed.start();
			shrek.loop();
			ball.lives = 3;
			ball.hits = 0;
			powerUpActive = false;
			ball.x = 450;
			ball.y = 0;
			paddle.padx = 450;
			//fastPaddleActive = false;
			doublePoints = false;
			//slowBall = false;
		}

	}

	public void keyReleased(KeyEvent f)
	{

	}

}