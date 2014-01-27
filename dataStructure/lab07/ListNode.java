package lab07;
/* ListNode.java */

/**
 *  ListNode is a very simple headless list class, akin to cons cells in
 *  Scheme.  Each ListNode contains an item and a reference to the next node.
 **/

/**
 * @class berkeley cs61b Lab 7 Solution
 * @author Saeed Alalwan
 *
 */

class ListNode {

  public Object item;
  public ListNode next;

  /**
   *  Constructs a ListNode with item i and next node n.
   *  @param i the item to store in the ListNode.
   *  @param n the next ListNode following this ListNode.
   **/
  ListNode(Object i, ListNode n) {
    item = i;
    next = n;
  }
  
  public String toString(){
	  
	  String s = Double.toString((double) item)+" "+Double.toString((double) next.item);
	  return s;
  }

}
