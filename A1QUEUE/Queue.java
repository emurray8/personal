public class Queue<T> implements IQueue<T>
{
	public Object[] ary =(T[])new Object[0];

	/**
	 * Adds an element to the rear of the queue.
	 * @param item - the element to be added to the end of the queue.
	 */

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
		Object[] temp =(T[])new Object[ary.length + 1];
		for(int i = 0; i < ary.length; i++)
		{
			temp[i] = ary[i];
		}
		temp[temp.length - 1] = item;

		ary = temp;

	}

	/**
	 * Removes the element at the front of the queue (fifo).
	 * @return the element that was removed from the queue.
	 * @throws IllegalStateException if the queue is empty.
	 */
	public T dequeue()
	{
		if(ary.length > 0)
		{
			Object[] temp =(T[])new Object[ary.length - 1];
			for(int i = 1; i < ary.length; i++)
			{
				temp[i-1] = ary[i ];
			}
			Object removed = ary[0];
			ary = temp;
			return (T)removed;
		}
		else
		{
			throw new IllegalStateException("Queue is already empty");

		}
	}


	/**
	 * Determines if the queue contains any elements.
	 * @return true if the queue is empty, false otherwise.
	 */
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

	/**
	 * Determines the number of elements in the queue.
	 * @return the number of elements in the queue.
	 */
	public int getSize()
	{
		return ary.length;
	}
	public Iterator<T> iterator()
	{
		return new QIterator();
	}
private class QIterator implements Iterator<T>
	{
		private int m_loc = getSize();

		public boolean hasNext()
		{
			return (m_loc > 0);
		}

		public T next()
		{
			if (m_loc == 0)
				throw new NoSuchElementException();

			Node cur = m_endOfQueue;
			for (int i = 0; i < m_loc; i++)
				cur = cur.m_next;
			m_loc--;
			return cur.m_data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

}
}