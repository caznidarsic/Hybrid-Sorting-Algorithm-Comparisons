/* Christian Znidarsic
 * Lab 4
 * EN.605.202.86.SP22 Data Structures
 * 
 * The linkedList class.
 * 
 * 	This class defines the methods and fields
 * of a linked list. It has a method to print
 * a linked list as well. 
 * 
 * Credit to an online source. */
 
public class linkedList {
    ListNode head = null;
    
    void push(int new_data) {
        /* allocate node */
        ListNode new_node = new ListNode(new_data);
 
        /* link the old list off the new node */
        new_node.next = head;
 
        /* move the head to point to the new node */
        head = new_node;
    }
    
    void push(ListNode new_node) {
   	 
   	 
   	 ListNode nodeNode = new ListNode(new_node);
   	 
   	 nodeNode.next = head;
   	 
   	 head = nodeNode;
   	 
    }
 
    // Utility function to print the linked list
    void printList(ListNode headref) {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }
 
}
