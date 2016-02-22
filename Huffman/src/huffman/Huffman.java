package huffman;



public class Huffman
{
	private Tree tree = new Tree();
	private IStack<Integer> stack = new StackLL<Integer>();
	private IStack<Integer> stack2 = new StackLL<Integer>();
	private boolean running = false;
	
        public static void main(String[] args)
	{
		new Huffman();
	}
		
	public Huffman()
	{
                java.util.Scanner keyboard = new java.util.Scanner(System.in);
		System.out.println("Pre-Order Traversal");
		preOrder(tree.root);
		System.out.println("In-Order Traversal");
		inOrderCode(tree.root);
	
		while(!running)
		{
			try
			{
				System.out.println("Enter a string of binary digits: ");
				String request = keyboard.nextLine();
				locateNode(request);
			}
			catch(Exception e)
			{
				System.out.println("Node not found");
			}
		}
	}
	

	
	public void preOrder(Node n)
	{
		if(n != null)
		{
			System.out.println(n);
			preOrder(n.leftChild);
			preOrder(n.rightChild);
		}

	}
	
	public void inOrderCode(Node n)
	{
		if(n.leftChild != null)
		{
			inOrderCode(n.leftChild);
		}
		
		if(n.name.length() == 1)
		{
			getNode(n);
			System.out.print(n);
			
			while(!stack.isEmpty()){
                            stack2.push(stack.pop());
			}
			System.out.print(stack2.toString());
			while(!stack2.isEmpty()){
                            stack2.pop();
                        }
			System.out.println();
		}
		
		if(n.rightChild != null)
		{
			inOrderCode(n.rightChild);
		}
	}
	

	
	
	public void locateNode(String s)
	{
		String[] locationCoder = s.split("(?<=.)");
		
		for(int i = locationCoder.length-1; i >= 0; i--){
                    stack.push(Integer.parseInt(locationCoder[i]));
		}
		
		Node root = tree.root;
		while(!stack.isEmpty())
		{
                    if(stack.pop() == 0){
			root = root.leftChild;
                    }
                    else{
			root = root.rightChild;
                    }	
                    if(root.leftChild == null && root.rightChild == null){
                        System.out.println(root.toString());
                        root = tree.root;
                    }
		}
		running = !running;
	}
	
        public void getNode(Node n)
	{
		Node root = tree.root;
		while(root != n){
			if(root.leftChild.name.contains(n.name)){
                            root = root.leftChild;
                            stack.push(0);
			}
			else{
                            root = root.rightChild;
                            stack.push(1);
			}
		}
	}
}
