package textbook;

public class TreeNode {

	private String computerName;

	private int[] malwareAnalyses; // This instance variable belongs to detector work that lies outside the scope of the project.

	private TreeNode parent; 

	private TreeNode leftChild;

	private TreeNode rightChild;
	
	// Precondition: None.
	// Postcondition: A new node is created for a computer in the large enterprise network, 
	//                and its instance variables are initialized.
	//
	public TreeNode(String computerNameValue, TreeNode parentValue, TreeNode leftChildValue, TreeNode rightChildValue){
		this.computerName = computerNameValue;
		this.parent = parentValue;
		this.leftChild = leftChildValue;
		this.rightChild = rightChildValue;
	}
	
	// Precondition: currentNode is an existent node in the binary search tree.
	// Postcondition: newNode is inserted in the binary search tree.  
	//                The revised tree satisfies the binary search tree property.
	//
	public void insertNewNode(TreeNode currentNode, TreeNode newNode){
		TreeNode x = currentNode;
		TreeNode y = null;
		while (x != null){
			y = x;
			if (newNode.computerName.compareTo(x.computerName) < 0)
				x = x.leftChild;
			else
				x = x.rightChild;
		}
		newNode.parent = y;
		if (newNode.computerName.compareTo(y.computerName) < 0)
			y.leftChild = newNode;	
		else
			y.rightChild = newNode;
	}
	
	// Precondition: currentNode is an existent node in the binary search tree.
	// Postcondition: The tree is walked in order to display the keys of its nodes.  
	//                The walk starts at currentNode.
	//
	public void analyzeInOrder(TreeNode currentNode){
		hr();
		System.out.println("Walking the binary search tree in order.");
		inOrderWalk(currentNode);
		hr();
	}
	private void inOrderWalk(TreeNode currentNode){
		if (currentNode != null){
			inOrderWalk(currentNode.leftChild);
			System.out.println("Analyzing: " + currentNode.computerName);
			inOrderWalk(currentNode.rightChild);
		}
	}
	
	// Precondition: currentNode is an existent node in the binary search tree.
	// Postcondition: The tree is walked in pre-order to display the keys of its nodes.  
	//                The walk starts at currentNode.
	//               
	public void analyzeInPreOrder(TreeNode currentNode){
		hr();
		System.out.println("Walking the binary search tree in pre-order.");
		preOrderWalk(currentNode);
		hr();
	}
	public void preOrderWalk(TreeNode currentNode){
		if (currentNode != null){
			System.out.println("Analyzing: " + currentNode.computerName);
			preOrderWalk(currentNode.leftChild);
			preOrderWalk(currentNode.rightChild);
		}
	}
	
	// Precondition: currentNode is an existent node in the binary search tree.
	// Postcondition: The tree is walked in post-order to display the keys of its nodes.  
	//                The walk starts at currentNode.
	//               
	public void analyzeInPostOrder (TreeNode currentNode){
		hr();
		System.out.println("Walking the binary search tree in post-order.");
		postOrderWalk(currentNode);
		hr();
	}
	public void postOrderWalk(TreeNode currentNode){
		if (currentNode != null){
			postOrderWalk(currentNode.leftChild);
			postOrderWalk(currentNode.rightChild);
			System.out.println("Analyzing: " + currentNode.computerName);
		}
	}

	//print a horizontal line
	private void hr(){
		System.out.println("-------------------------------------------------------------");
	}
}
