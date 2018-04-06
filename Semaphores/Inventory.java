import java.util.*;
import java.util.concurrent.*;

public class Inventory
{
	private final Semaphore m_items = new Semaphore(0, true);
	private final Semaphore mutex = new Semaphore(1, true);
	private class Widget {};
	private List<Widget> widgets = new ArrayList<Widget>();

	public void produce(int i)
	{
		try
		{
			m_items.release(i);

			mutex.acquire();
			for (int j = 0; j < i; j++)
				widgets.add(new Widget());
				System.out.printf("%s produced, %s/%s items avaiable...%n",
					i, m_items.availablePermits(), widgets.size());
			mutex.release();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void consume(int i)
	{
		try
		{
			m_items.acquire(i);

			mutex.acquire();
			for (int j = 0; j < i; j++)
				widgets.remove(0);
			System.out.printf("%s consumed, %s/%s items avaiable...%n",
				i, m_items.availablePermits(), widgets.size());
			mutex.release();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
