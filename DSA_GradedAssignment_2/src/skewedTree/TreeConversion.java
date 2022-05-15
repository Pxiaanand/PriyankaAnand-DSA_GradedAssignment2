package skewedTree;
class Node
{
    int val;
    Node left, right;
    
    //Function to Create a Node with Left and Right elements
    Node(int item)
    {
        val = item;
        left = right = null;
    }
}
class TreeConversion
{
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
   
    //Function to convert BST to One sided Skewed Tree
    static void BSTtoSkewed(Node root)
    {
       
        // Base Case
        if(root == null)
        {
            return;
        }
       
        
        BSTtoSkewed(root.left);
        
        Node rightNode = root.right;
        Node leftNode = root.left;
       
        // Condition to check if the root Node
        // of the skewed tree is not defined
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        
        BSTtoSkewed(rightNode);
        
    }
   
    // Function to traverse the right Skewed Tree recursively
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);       
    }
   
    // Main Function
    public static void main (String[] args)
    {
       
    	TreeConversion tree = new TreeConversion();
        
    	tree.node = new Node(50);
    	tree.node.left = new Node(30);
    	tree.node.right = new Node(60);
    	tree.node.left.left = new Node(10);
    	tree.node.right.left= new Node(55);
       
       
        
        BSTtoSkewed(node);
        traverseRightSkewed(headNode);
    }
}
