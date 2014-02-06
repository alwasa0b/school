package lab06;
public class Stack<D>{     
	private class Node{
		private D data;
		private Node next;

		public Node (D value, Node link){
			this.data=value;
			this.next=link;
		}
	}


	private Node top;

	public Stack() {
		top = null;
	}
	public void push(D value) {
		
		Node newNode=new Node(value,top);
		top=newNode;
	}
	
	public D pop () throws StackException { 
		Node poped = top;
		top= top.next;
		return poped.data;
	}
	
	public D look() throws StackException { 
		if(!isEmpty()) return top.data;
		else throw new StackException();
	}
	
	public boolean isEmpty() { 
		return top==null;
	}
	
	public String toString() { 
		String s=null;
		Node nextNode=top.next;
		while(nextNode != null){
			s+=nextNode.toString();
			nextNode=nextNode.next;
		}
		return s;
		
	}  // Print all items in the stack
}