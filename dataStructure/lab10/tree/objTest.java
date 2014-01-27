package lab10.tree;

public class objTest extends TreeNode{
	SibTreeNode parent;
	SibTreeNode firstChild;
	SibTreeNode nextSibling;
	
	public objTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */


	@Override
	public int children() {
		// TODO Auto-generated method stub
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

	@Override
	public TreeNode parent() throws InvalidNodeException {
		// TODO Auto-generated method stub
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
	}

	@Override
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

	@Override
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

	@Override
	public void insertChild(Object item, int c) throws InvalidNodeException {
	    if (!isValidNode()) {
	    		this.setItem(item);
		      } else {
		        throw new InvalidNodeException();
		      }
		
	}

	@Override
	public void removeLeaf() throws InvalidNodeException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		objTest t = new objTest();
		try {
			t.setItem(3);
		} catch (InvalidNodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
