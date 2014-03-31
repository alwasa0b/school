
/* BinaryTreeNode.java */


/**
 * BinaryTreeNode represents a node in a binary tree.
 * 
 * DO NOT CHANGE THIS FILE.
 **/
class BinaryTreeNode {

	/**
	 * entry is the key/value pair stored in this node. parent is the parent of
	 * this node. leftChild and rightChild are the children of this node.
	 **/
	Entry entry;
	BinaryTreeNode parent;
	BinaryTreeNode leftChild, rightChild;

	/**
	 * Simple constructor that sets the entry. The rest of the fields are set to
	 * null.
	 */
	BinaryTreeNode(Entry entry) {
		this(entry, null, null, null);
	}
	
	public void delNode(){
		
		if (this.parent.leftChild==this) 
			if(this.leftChild!=null) {this.parent.leftChild=this.leftChild;}
			else if (this.rightChild!=null){this.parent.rightChild=this.leftChild;}
			else{this.parent.leftChild=null;}
			
		else if(this.parent.rightChild==this)
			if(this.leftChild!=null) {this.parent.rightChild=this.leftChild;}
			else if (this.rightChild!=null){this.parent.rightChild=this.rightChild;}
			else{this.parent.rightChild=null;}
		else{
			System.out.println("uncought");
		}
	}

	/**
	 * Simple constructor that sets the entry and parent. The rest of the fields
	 * are set to null.
	 */
	BinaryTreeNode(Entry entry, BinaryTreeNode parent) {
		this(entry, parent, null, null);
	}

	/** Simple constructor that sets all of the node's fields. */
	BinaryTreeNode(Entry entry, BinaryTreeNode parent, BinaryTreeNode left,
			BinaryTreeNode right) {
		this.entry = entry;
		this.parent = parent;
		leftChild = left;
		rightChild = right;
	}

	public String toString() {
		String s = "";

		if (leftChild != null) {
			s = "(" + leftChild.toString() + ")";
		}
		s = s + entry.key().toString() + entry.value();
		if (rightChild != null) {
			s = s + "(" + rightChild.toString() + ")";
		}
		return s;
	}

}
