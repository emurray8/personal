import java.util.Random;
import java.awt.*;

public class PowerUp
{
	private Pong pong;
	private Ball ball;
	private Paddle paddle;
	private Random rand = new Random();
	public int powerUpXVal = 0;
	private int y = 520;
	public int powerUpSelection = -1;
	public boolean powerUpActive = false;

	public void paintPowerSlow(Graphics g)
	{
		//activatePowerUp();
		g.setColor(Color.black);
		g.drawOval(powerUpXVal, y, 20, 20);
		g.setColor(Color.white);
		g.fillOval(powerUpXVal, y, 20, 20);

	}
	public void paintPowerDoublePoints(Graphics g)
	{
		//activatePowerUp();
		g.setColor(Color.black);
		g.drawOval(powerUpXVal, y, 20, 20);
		g.setColor(Color.red);
		g.fillOval(powerUpXVal, y, 20, 20);

	}
	public void paintPowerFastPaddle(Graphics g)
	{
		//activatePowerUp();
		g.setColor(Color.black);
		g.drawOval(powerUpXVal, y, 20, 20);
		g.setColor(Color.blue);
		g.fillOval(powerUpXVal, y, 20, 20);

	}

	public int powerUpSelection()
	{
		powerUpSelection = 2;//rand.nextInt(3)+1;

		return powerUpSelection;
	}


}