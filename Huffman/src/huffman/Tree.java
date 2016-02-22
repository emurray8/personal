package huffman;

public class Tree
{
    private IStack<Node> stack = new StackLL<Node>();
    private IStack<Node> stack2 = new StackLL<Node>();
    public Node root;
    private int count = 0;
    
    
    public Tree()
    {
        addNode("M", 3);
        addNode("N", 6);
        addNode("K", 2);
        addNode("G", 2);
        addNode("I", 4);
        addNode("E", 15);
        addNode("C", 3);
        addNode("D", 4);
        addNode("R", 7);
        addNode("U", 5);
        addNode("T", 12);
        addNode("O", 8);
        addNode("A", 10);
        addNode("S", 5);
        buildTree();
    }
     public void buildTree()
    {
        Node node1 = getMin();
        Node node2 = getMin();
            
        Node newNode = new Node(node1.name + node2.name, node1.key + node2.key, node1, node2, null);
        stack.push(newNode);
        node1.parent = newNode;
        node2.parent = newNode;
        if(newNode.key == count){
            root = newNode;
        }
        else{
            buildTree();
        }
    }   
    
    public void addNode(String s, int n)
    {
        Node newNode = new Node(s, n, null, null, null);
        count += newNode.key;
        stack.push(newNode);
    }
    
    public Node getMin()
    {
        Node n = null;
        Node temp;
        
        n = stack.pop();
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp.key < n.key){
                stack2.push(n);
                n = temp;
            }
            else{
                stack2.push(temp);
            }
        }
        
        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }
        return n;
    }
}

class Node
{
    Node leftChild;
    Node rightChild;
    Node parent;
    int key;
    String name;
    int level;
    
    Node(String name, int key, Node leftChild, Node rightChild, Node parent){
        this.parent = parent;
        this.name = name;
        this.key = key;  
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public String toString(){
        if(name.length() > 1){
            return "*" + " (" + key + ")";
        }
        else{
            return name + " (" + key + ")";
        }
    }
}