import java.util.Scanner;
public class Maze
{
	private static Stack<String> redo = new Stack<String>();
	private static Stack<String> undo = new Stack<String>();
	private Scanner key = new Scanner(System.in);
	private int x = 2;
	private int y = 1;
	private boolean quit = false;


	private String[][] map = {{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"},
							{"-","-","-","-","-","-","-","-","-","-"}};

	public static void main(String[] args)
	{
		Maze tester = new Maze();
		tester.test(redo, undo);
	}

	public void test(Stack<String> redo, Stack<String> undo)
	{
		String action = "";

		while(!quit)
		{
			userLocation(x, y);
			System.out.println(undo.toString());
			System.out.println(redo.toString());
			printMap();
			printInstructions();
			action = key.nextLine();
			takeAction(action);
		}

	}

	public void printMap()
	{
		for(int i = 0; i < 10; i++)
		{

			System.out.println("");


			for(int j = 0; j <10; j++)
			{

				System.out.print(map[j][i]);

			}
		}
	}

	public void clearStack(Stack s)
	{
		while(s.ary.length != 0)
		{
			s.pop();
		}
	}

	public void userLocation(int x, int y)
	{
		map[x][y] = "*";
	}

	public String takeAction(String s)
	{
		if(s.equalsIgnoreCase("N"))
		{
			if(y - 1 == -1)
			{
				System.out.println("Out of bounds");
			}
			else
			{
				map[x][y] = "-";
				y = y - 1;
				undo.push(s+"_r");
				clearStack(redo);
			}

		}
		if(s.equalsIgnoreCase("E"))
		{
			if(x + 1 == 10)
			{
				System.out.println("Out of bounds");
			}
			else
			{
				map[x][y] = "-";
				x = x + 1;
				undo.push(s+"_r");
				clearStack(redo);
			}
		}
		if(s.equalsIgnoreCase("W"))
		{
			if(x - 1 == -1)
			{
				System.out.println("Out of bounds");
			}
			else
			{
				map[x][y] = "-";
				x = x - 1;
				undo.push(s+"_r");
				clearStack(redo);
			}
		}
		if(s.equalsIgnoreCase("S"))
		{
			if(y + 1 == 10)
			{
				System.out.println("Out of bounds");
			}
			else
			{
				map[x][y] = "-";
				y = y + 1;
				undo.push(s+"_r");
				clearStack(redo);
			}
		}
		if(s.equalsIgnoreCase("G"))
		{
			System.out.println("Gulp!");
			undo.push(s+"_r");
			clearStack(redo);
		}
		if(s.equalsIgnoreCase("U"))
		{
			if(!undo.isEmpty())
			{
				reverseAction(undo.pop());
			}
			else
			{
				System.out.println("Nothing to undo");
			}
		}
		if(s.equalsIgnoreCase("R"))
		{
			if(!redo.isEmpty())
			{
				redoAction(redo.pop());
			}
			else
			{
				System.out.println("Nothing to redo");
			}
		}
		if(s.equalsIgnoreCase("Q"))
		{
			quit = true;
		}
		return s;
	}

	public void reverseAction(String s)
	{
		if(s.equalsIgnoreCase("N"+"_r"))
		{
			/*if(y - 1 == -1)
			{
				System.out.println("Out of bounds");
			}
			else*/
			//{
				map[x][y] = "-";
				y = y + 1;
				redo.push("n_u");
			//}

		}
		if(s.equalsIgnoreCase("E"+"_r"))
		{
			/*if(x + 1 == 10)
			{
				System.out.println("Out of bounds");
			}
			else
			{*/
				map[x][y] = "-";
				x = x - 1;
				redo.push("e_u");

			//}
		}
		if(s.equalsIgnoreCase("W"+"_r"))
		{
		/*	if(x - 1 == -1)
			{
				System.out.println("Out of bounds");
			}
			else
			{*/
				map[x][y] = "-";
				x = x + 1;
				redo.push("w_u");

			//}
		}
		if(s.equalsIgnoreCase("S"+"_r"))
		{
			/*if(y + 1 == 10)
			{
				System.out.println("Out of bounds");
			}
			else
			{*/
				map[x][y] = "-";
				y = y - 1;
				redo.push("s_u");

			//}
		}
		if(s.equalsIgnoreCase("G"+"_r"))
		{
			System.out.println("Blah!");
			redo.push("g_u");

		}
	}
public void redoAction(String s)
	{
		if(s.equalsIgnoreCase("N"+"_u"))
		{
			if(y - 1 == -1)
			{
				System.out.println("Out of bounds");
			}
			else
			{
				map[x][y] = "-";
				y = y - 1;
				undo.push("n_r");
			}

		}
		if(s.equalsIgnoreCase("E"+"_u"))
		{
			if(x + 1 == 10)
			{
				System.out.println("Out of bounds");
			}
			else
			{
				map[x][y] = "-";
				x = x + 1;
				undo.push("e_r");

			}
		}
		if(s.equalsIgnoreCase("W"+"_u"))
		{
			if(x - 1 == -1)
			{
				System.out.println("Out of bounds");
			}
			else
			{
				map[x][y] = "-";
				x = x - 1;
				undo.push("w_r");

			}
		}
		if(s.equalsIgnoreCase("S"+"_u"))
		{
			if(y + 1 == 10)
			{
				System.out.println("Out of bounds");
			}
			else
			{
				map[x][y] = "-";
				y = y + 1;
				undo.push("s_r");

			}
		}
		if(s.equalsIgnoreCase("G"+"_u"))
		{
			System.out.println("Gulp!");
			undo.push("g_r");

		}
	}

	public void printInstructions()
	{
		System.out.println("What have you mage?");
		System.out.println("N: North");
		System.out.println("S: South");
		System.out.println("E: East");
		System.out.println("W: West");
		System.out.println("G: Grog");
		System.out.println("U: Undo");
		System.out.println("R: Redo");
		System.out.println("Q: Quit");
	}

}