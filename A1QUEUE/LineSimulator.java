import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
public class LineSimulator
{
	private MyQueue<Customer> line = new MyQueue<Customer>();
	private ArrayList<Customer> dataList = new ArrayList<Customer>();
	private int time = 240;
	private Random rand = new Random();

	public static void main(String[] args)
	{
		System.out.print("Sim one: ");
		LineSimulator a = new LineSimulator(25, 33);
		System.out.print("Sim two: ");
		LineSimulator b = new LineSimulator(33, 25);
	}

	public LineSimulator(int cp, int sp)
	{
		Customer temp = null;
		boolean customerProb = false;
		boolean serviceProb = false;
		int x = rand.nextInt(100)+1;
		int y = rand.nextInt(100)+1;

		while(time > 0)
		{

			if(x <= cp && x > 0)//determines if customer enters bank
			{
				Customer c = new Customer();
				c.setTimeEntered(time); //customer enters line (if the teller is free, the customer will leave the line instantly)
				line.enqueue(c);
				customerProb =true;
			}

			if(y <= sp && y > 0)//determines if teller finishes service
			{
				serviceProb = true;
			}

			if(temp == null && !line.isEmpty())// customer leaves line if teller is not busy (will still work if customer just entered)
			{
				temp = line.dequeue();
				temp.setTimeExited(time);
			}

			if(serviceProb && temp != null)//if teller is busy and finishes service with a customer (next customer will step up next turn)
			{
				temp.setTimeServiced(time);
				dataList.add(temp);
				temp = null;
			}


	/*		System.out.println("time: " + time + " cP: "+ customerProb + " sP: " + serviceProb + " " + " teller: " + temp);
			System.out.println("line: " + line.toString());*/
			time--;


			customerProb = false;
			serviceProb = false;
			x = rand.nextInt(100)+1;
			y = rand.nextInt(100)+1;


		}
	/*	for(int i = 0; i < dataList.size();i++)
		{
			System.out.println(dataList.get(i).toString());
		}
		System.out.println(dataList.size());*/
		System.out.println("Max Wait: " + calcMaxWait() + " Average Wait: " + calcAveWait() + " Max Teller Time: " + calcMaxTeller() + " Average Teller Time " + calcAveTeller());


	}

	public int calcMaxWait()
	{
		int x = dataList.get(0).getTimeEntered()-dataList.get(0).getTimeExited();
		for(int i = 0; i < dataList.size();i++)
		{
			if(dataList.get(i).getTimeEntered()-dataList.get(i).getTimeExited() > x)
			{
				x = dataList.get(i).getTimeEntered()-dataList.get(i).getTimeExited();
			}
		}
		return x;
	}
	public int calcAveWait()
	{
		int x = 0;
		int sum = 0;
		int ave = 0;
		for(int i = 0; i < dataList.size();i++)
		{
			x = dataList.get(i).getTimeEntered()-dataList.get(i).getTimeExited();
			sum = sum + x;
		}
		ave = sum/dataList.size();
		return ave;
	}
	public int calcMaxTeller()
	{
		int x = dataList.get(0).getTimeExited()-dataList.get(0).getTimeServiced();
		for(int i = 0; i < dataList.size();i++)
		{
			if(dataList.get(i).getTimeExited()-dataList.get(i).getTimeServiced() > x)
			{
				x = dataList.get(i).getTimeExited()-dataList.get(i).getTimeServiced();
			}
		}
		return x;
	}
	public int calcAveTeller()
	{
		int x = 0;
		int sum = 0;
		int ave = 0;
		for(int i = 0; i < dataList.size();i++)
		{
			x = dataList.get(i).getTimeExited()-dataList.get(i).getTimeServiced();
			sum = sum + x;
		}
		ave = sum/dataList.size();
		return ave;
	}

	private class Customer
	{
		private int timeEntered;
		private int timeExited;
		private int timeServiced;
		public Customer()
		{
		}
		public void setTimeEntered(int t)
		{
			timeEntered = t;
		}
		public void setTimeExited(int t)
		{
			timeExited = t;
		}
		public void setTimeServiced(int t)
		{
			timeServiced = t;
		}
		public int getTimeEntered()
		{
			return timeEntered;
		}
		public int getTimeExited()
		{
			return timeExited;
		}
		public int getTimeServiced()
		{
			return timeServiced;
		}
		public String  toString()
		{
			String s = timeEntered + ", " + timeExited + ", " + timeServiced;
			return s;
		}
	}


}