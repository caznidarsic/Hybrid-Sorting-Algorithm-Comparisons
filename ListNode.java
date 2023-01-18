/* Christian Znidarsic
 * Lab 4
 * EN.605.202.86.SP22 Data Structures
 * 
 * The ListNode class.
 * 
 * 	This class defines a node for a linked list 
 * class. This node has two fields: nodeVal and
 * next. It has two overloaded constructors
 * to accommodate linkedLists containing either 
 * integer vals, or other ListNode vals. This comes
 * in handy during the natural mergeSort. */
public class ListNode {
   int val;
   ListNode nodeVal;
   ListNode next;

   public ListNode(int val)
   {
       this.val = val;
   }
   
   public ListNode(ListNode val) {
   	
   	this.nodeVal = val;
   	
   }
}
