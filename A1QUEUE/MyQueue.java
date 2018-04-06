public class MyQueue<T> implements IQueue<T>
{
	public  Object[] ary	=(T[])new	Object[0];
	public String toString()
	{
		StringBuffer sb = new StringBuffer("rear->");

		for(int i = ary.length-1; i > -1; i--)
		{
			if(ary.length == 1 && i != 0)
			{
				sb.append(ary[i]);
			}
			if(i == 0)
			{
				sb.append(ary[i]);
			}
			else
			{

				sb.append(ary[i] + "->");
			}
		}

		String s = sb.toString();
		return s;
	}

	public void enqueue(T item)
	{

		Object[] temp = (T[])new Object[ary.length + 1];
		for(int i = 0; i < ary.length; i++)
		{
			temp[i] = ary[i];
		}
		temp[temp.length - 1] = item;

		ary = temp;


	}

	public T dequeue()
	{
		if(ary.length > 0)
		{
			Object[] temp = (T[])new Object[ary.length - 1];
			for(int i = 1; i < ary.length; i++)
			{
				temp[i-1] = ary[i];
			}
			Object dequeued = ary[0];
			ary = temp;
			return (T)dequeued;
		}
		else
		{
			throw new IllegalStateException("Queue is already empty");
		}


	}



	public boolean isEmpty()
	{
		boolean empty;
		if(ary.length == 0)
		{
			empty = true;
		}
		else
		{
			empty = false;
		}
		return empty;
	}

	public int getSize()
	{
		return ary.length;

	}





}