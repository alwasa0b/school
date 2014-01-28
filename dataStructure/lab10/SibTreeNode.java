/* SibTreeNode.java */


/**
 *  A SibTreeNode object is a node in a SibTree (sibling-based general tree).
 *  @author Jonathan Shewchuk
 */

class SibTreeNode extends TreeNode {

  /**
   *  (inherited)  item references the item stored in this node.
   *  (inherited)  valid is true if and only if this is a valid node in some
   *               Tree.
   *  myTree references the Tree that contains this node.
   *  parent references this node's parent node.
   *  firstChild references this node's first (leftmost) child.
   *  nextSibling references this node's next sibling.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  /**
   *  ADT implementation invariants:
   *  1) if valid == true, myTree != null.
   *  2) if valid == true, then this is a descendent of myTree.root.
   *  3) if valid == true, myTree satisfies all the invariants of a
   *     SibTree (listed in SibTree.java).
   */

  protected SibTree myTree;
  protected testObj myTree2;
  protected SibTreeNode parent;
  protected SibTreeNode firstChild;
  protected SibTreeNode nextSibling;

  /**
   * Construct a valid SibTreeNode referring to a given item.
   */
  SibTreeNode(SibTree tree, Object item) {
    this.item = item;
    valid = true;
    myTree = tree;
    parent = null;
    firstChild = null;
    nextSibling = null;
  }

  /**
   * Construct an invalid SibTreeNode.
   */
  SibTreeNode() {
    valid = false;
  }

  public SibTreeNode(testObj tree, Object item) {
	    this.item = item;
	    valid = true;
	    myTree2 = tree;
	    parent = null;
	    firstChild = null;
	    nextSibling = null;
}

/**
   *  children() returns the number of children of the node at this position.
   *  WARNING:  Does not run in constant time.  Actually counts the kids.
   */
  public int children() {
    if (isValidNode()) {
      int count = 0;
      SibTreeNode countNode = firstChild;
      while (countNode != null) {
        count++;
        countNode = countNode.nextSibling;
      }
      return count;
    } else {
      return 0;
    }
  }

  /**
   *  
   *  parent() returns the parent TreeNode of this TreeNode.
   *  
   *  Throws an exception if `this' is not a valid node.  
   *  
   *  Returns an invalid TreeNode if this node is the root.
   */
  public TreeNode parent() throws InvalidNodeException {
    // REPLACE THE FOLLOWING LINE WITH YOUR SOLUTION TO PART I.
	    if (this.isValidNode()) {
	    	
	    	if(this.parent==null){
	    		return new SibTreeNode();
	    	}
	    	
	    	else{
	    		return this.parent;
	    	}
	        
	      } else {
	        throw new InvalidNodeException();
	      }
	    
	 // Returns an invalid TreeNode if this node is the root.
	
	 }
  

  /**
   *  child() returns the cth child of this TreeNode.  Throws an exception if
   *  `this' is not a valid node.  Returns an invalid TreeNode if there is no
   *  cth child.
   */
  public TreeNode child(int c) throws InvalidNodeException {
    if (isValidNode()) {
      if (c < 1) {
        return new SibTreeNode();
      }
      SibTreeNode kid = firstChild;
      while ((kid != null) && (c > 1)) {
        kid = kid.nextSibling;
        c--;
      }
      if (kid == null) {
        return new SibTreeNode();
      } else {
        return kid;
      }
    } else {
      throw new InvalidNodeException();
    }
  }

  /**
   *  nextSibling() returns the next sibling TreeNode to the right from this
   *  TreeNode.  Throws an exception if `this' is not a valid node.  Returns
   *  an invalid TreeNode if there is no sibling to the right of this node.
   */
  public TreeNode nextSibling() throws InvalidNodeException {
    if (isValidNode()) {
      if (nextSibling == null) {
        return new SibTreeNode();
      } else {
        return nextSibling;
      }
    } else {
      throw new InvalidNodeException();
    }
  }
  public void makeRoom(SibTreeNode t, SibTreeNode n,int c){
	  SibTreeNode tempNode = new SibTreeNode();
	  SibTreeNode tree = new SibTreeNode();
	  tree =t;
	  tempNode= n;
	  tree.firstChild=t.firstChild;
	  n.nextSibling=t.firstChild.nextSibling;
	  tree.firstChild.nextSibling=n;
	
  }
  
  public SibTreeNode lastChild(SibTreeNode n,int c){
	  
	  while(n.nextSibling.isValidNode() && c>2){
		  n= n.nextSibling;
		  c--;
	  }
	  return n.nextSibling;
  }
  public void setChid(SibTreeNode n, Object o){
	  n.nextSibling=(SibTreeNode) o;
	  n.nextSibling.valid=true;
	  myTree.size++;
  }
  
  /**
   *  insertChild() inserts an item as the cth child of this node.  
   *  
   *  Existing children numbered c or higher are shifted one place to the right to accommodate.  
   *  
   *  If the current node has fewer than c children, the new item is inserted as the last child.  
   *  If c < 1, act as if c is 1.
   */

  
  public void insertChild(Object item, int c) throws InvalidNodeException {
    // FILL IN YOUR SOLUTION TO PART II HERE.
	  SibTreeNode newNode = new SibTreeNode();
	  SibTreeNode tempTree = new SibTreeNode();
	  SibTreeNode tempTree2 = new SibTreeNode();
	  newNode.valid=true;
	  newNode.setItem(item);
	  
	  
	  int i=0;
	  if (isValidNode()) {
		  System.out.println(this.child(1).item);
		  System.out.println(this.myTree.root.item);
		  if(c==0){
			  
			  SibTreeNode kid = this.firstChild;
			  this.firstChild=newNode;
			  this.firstChild.nextSibling=kid;
			  this.myTree.size++;
			  this.firstChild.parent.setItem(this.myTree.root);
			 
		      
		  }
		  
		  if(this.children()-1<c){
			  setChid((SibTreeNode) this.child(this.children()),newNode);
			  this.child(this.children()).parent().setItem(this.myTree.root);
			  
		  }
		  
		  if(this.children()-1==c){
			  setChid((SibTreeNode) this.child(this.children()-1),newNode);
			  this.child(this.children()-1).parent().setItem(this.myTree.root);
		  }
		 		  
		  
		  
		  
		  if(this.children()-1>c){
			 
			 tempTree = (SibTreeNode) this.child(c-1);
			 
			 tempTree2 = (SibTreeNode) this.child(this.children()-1);
			 
			 tempTree.nextSibling=newNode;
			 tempTree.nextSibling.nextSibling=tempTree2;
			 this.firstChild=tempTree;
			 this.myTree.size++;
		
		
		   
		    
		  }
		 
		  
		  
	
	  
	  }
	  else {
		 // this.myTree.size++;
		  throw new InvalidNodeException();
	    //  this.firstChild=newNode;
	      
	    }
	    
	
  }

  /**
   *  removeLeaf() removes the node at the current position from the tree if
   *  it is a leaf.  Does nothing if `this' has one or more children.  Throws
   *  an exception if `this' is not a valid node.  If 'this' has siblings to
   *  its right, those siblings are all shifted left by one.
   */
  public void removeLeaf() throws InvalidNodeException {
    // FILL IN YOUR SOLUTION TO PART III HERE.
  }

}
