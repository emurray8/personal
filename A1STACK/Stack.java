public class Stack<T> implements IStack<T>
{
	public  Object[] ary	=(T[])new	Object[0];

	public String toString()
	{
		StringBuffer sb = new StringBuffer("top->");

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

	public void push(T item)
	{

		Object[] temp = (T[])new Object[ary.length + 1];
		for(int i = 0; i < ary.length; i++)
		{
			temp[i] = ary[i];
		}
		temp[temp.length - 1] = item;

		ary = temp;


	}

	/**
	 * Removes the topmost element in the stack.
	 * @return the element that was removed from the stack.
	 * @throws IllegalStateException if the stack is empty.
	 */
	public T pop()
	{
		if(ary.length > 0)
		{
			Object[] temp = (T[])new Object[ary.length - 1];
			for(int i = 0; i < temp.length; i++)
			{
				temp[i] = ary[i];
			}
			Object popped = ary[ary.length-1];
			ary = temp;
			return (T)popped;
		}
		else
		{
			throw new IllegalStateException("Stack is already empty");
		}


	}


	/**
	 * Retrieves the topmost element in the stack.  Unlike pop,
	 * the element is not removed from the stack.
	 * @return the topmost element in the stack.
	 * @throws IllegalStateException if the stack is empty.
	 */
	public T top()
	{
		if(ary.length > 0)
		{
			Object top = ary[ary.length - 1];
			return (T)top;
		}
		else
		{
			throw new IllegalStateException("Stack is already empty");
		}

	}

	/**
	 * Determines if the stack contains any elements.
	 * @return true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		boolean empty = true;
		for(int i = 0; i < ary.length; i++)
		{
			if(ary[i] != null)
			{
				empty = false;
			}
		}
		return empty;

	}

	/**
	 * Determines the number of elements in the stack.
	 * @return the number of elements in the stack.
	 */
	public int getSize()
	{
		return ary.length;

	}



}