	// lets create a node class
class TreeNode {

	// data
	private int data;
	// lets create pointers
	private TreeNode leftChild;
	private TreeNode rightChild;

	// constructor 
	TreeNode(int data) {
		this.data = data;
	}

	// getters and setters
	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getleftChild()  {
		return this.leftChild;
	}

	public void setleftChild(TreeNode leftChild)  {
		this.leftChild = leftChild;
	}

	public TreeNode getrightChild()  {
		return this.rightChild;
	}

	public void setrightChild(TreeNode rightChild)  {
		this.rightChild = rightChild;
	}

	// insert method
	public void insert(int value) {
		if (value == this.data) {
			return;
		}

		if (value < this.data) {
			if (this.leftChild == null) {
				this.leftChild = new TreeNode(value);
			} else {
				this.leftChild.insert(value);
			}
		} else 

		if (value > this.data) {
			if (rightChild == null) {
				rightChild = new TreeNode(value);
			} else {
				rightChild.insert(value);
			}
		}
	}

	// traversing method
	public void traverseInOrder() {
		if (this.leftChild != null) {
			leftChild.traverseInOrder();
		}
		System.out.print(this.data + ", ");
		if (this.rightChild != null) {
			rightChild.traverseInOrder();
		}
	}

	public void traversePreOrder() {
		System.out.print(this.data + ", ");
		if (this.leftChild != null) {
			leftChild.traversePreOrder();
		}
		if (this.rightChild != null) {
			rightChild.traversePreOrder();
		}
	}

	// get minimum value
	public int getMinValue () {		
		if (this.leftChild == null) {
			return this.data;
		} else {
			return this.leftChild.getMinValue();
		}
	}

	// get max value
	public int getMaxValue() {
		if (this.rightChild == null)
			return this.data;
		else 
			return this.rightChild.getMaxValue();
	}

	// get nodes
	public int getNodeValue (int value) {
		if (value == this.data) {
			return this.data;
		} 
		if (value < this.data) {
			if (this.leftChild != null)
				return this.leftChild.getNodeValue(value);
		} if (value > this.data){
			if (this.rightChild != null)
				return this.rightChild.getNodeValue(value);			
		} 
		return -1;
	}
}

// lets create a tree
class Tree {
	private TreeNode root;

	public void insert(int value) {
		if (root == null) {
			this.root = new TreeNode(value);
		} else {
			// call the insert of TreeNode class
			this.root.insert(value); 
		}
	}

	// inorder reversal
	public void traverseInOrder() {
		if (root != null)
			this.root.traverseInOrder();
		return;
	}

	public void traversePreOrder() {
		if (this.root != null) {
			this.root.traversePreOrder();
		}
	}

	// get minimum value 
	public int getMinValue() {
		if (root != null) {
			return this.root.getMinValue();
		}
		return Integer.MIN_VALUE;
	}

	// get max value
	public int getMaxValue() {
		if (root != null){
			return this.root.getMaxValue();
		}
		return Integer.MAX_VALUE;		
	} 

	// get value
	public int getNodeValue(int value) {
		return this.root.getNodeValue(value);
	}

	// delete node 0: leaf 1: has only left or right child
	public void delete(int value ) {
		this.root = delete(this.root, value);
		System.out.println(this.root.getData());
	}

	// create a private method for it
	private TreeNode delete(TreeNode subTreeRoot, int value) {
		if (subTreeRoot == null){
			return subTreeRoot;
		}

		if (value < subTreeRoot.getData()) {
			subTreeRoot.setleftChild(delete(subTreeRoot.getleftChild(), value));
		}  else 

		if (value > subTreeRoot.getData()) {
			subTreeRoot.setrightChild(delete(subTreeRoot.getrightChild(), value));
		} else {
			if (subTreeRoot.getleftChild() == null) {
				return subTreeRoot.getrightChild();
			} else 
			if (subTreeRoot.getrightChild() == null) {
				return subTreeRoot.getleftChild();
			}
			// for the third case in which the node has two childrens
			else {
				subTreeRoot.setData(subTreeRoot.getrightChild().getMinValue());
				// delete the node that has the smallest value in the right subtree
				subTreeRoot.setrightChild(delete(subTreeRoot.getrightChild(), subTreeRoot.getData()));
			}
		}
		return subTreeRoot;

	}
}

class TreeTest {
	public static void main(String args[]) {
		Tree intTree = new Tree();
		// lets insert values
		intTree.insert(25);
		intTree.insert(20);
		intTree.insert(15);
		intTree.insert(22);
		intTree.insert(17);
		intTree.insert(27);
		intTree.insert(26);
		intTree.insert(30);
		intTree.insert(29);
		intTree.insert(32);

		// intTree.insert(25);
		// intTree.insert(17);
		// intTree.insert(18);


		// print tree inorder
		intTree.traverseInOrder();

		// get minimum value
		System.out.println(intTree.getMinValue());

		// get max value 
		System.out.println(intTree.getMaxValue());

		// get value 
		System.out.println(intTree.getNodeValue(25));

		// delete nodes 
		intTree.delete(17);

		// print inorder again 
		intTree.traverseInOrder();

		// lets delete root node
		intTree.delete(25);

		// print inorder
		intTree.traverseInOrder();

		// lets test some preorder traversal
		System.out.println("\nPost order traversal");

		Tree intTree2 = new Tree();
		intTree2.insert(25);
		intTree2.insert(20);
		intTree2.insert(32);

		// traverse preorder
		intTree2.traversePreOrder();

		// preorder traversal
		System.out.println("\nInorder traversal");
		intTree2.traverseInOrder();
	}
}