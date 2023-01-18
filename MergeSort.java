/* Christian Znidarsic
 * Lab 4
 * EN.605.202.86.SP22 Data Structures
 * 
 * The Merge Sort class.
 * 
 * 	This class has a primary method called mergeSort, which 
 * simply calls other methods in the class. It takes a ListNode
 * object as input, and it sorts the linked list of which the 
 * ListNode is the head. It is a natural merge sort. The method 
 * findRuns finds runs of already sorted data, hence the natural
 * merge. */
public class MergeSort {
	public int comparisons;
	public int swaps;

	// primary method of the class (and the only public method.)
	// sorts a linked list.
   public ListNode mergeSort(ListNode h) {
   	return sortRecursion(findRuns(h));
   }
	
	
   // this recursive method merges two nodes.
   private ListNode sortedMerge(ListNode a, ListNode b)
   {
		
		ListNode result = null;
       /* Base cases */
       if (a == null)
           return b;
       if (b == null)
           return a;

       /* Pick either a or b, and recur */
       comparisons++;
       if (a.val <= b.val) {
      	 swaps++;
           result = a;
           result.next = sortedMerge(a.next, b);
       }
       else {
           result = b;
           result.next = sortedMerge(a, b.next);
       }
       return result;
   }

   
   
   /* the findRuns method is what makes this merge sort
    * a natural merge. It eliminates some redundancy
    * by grouping together runs of integers in the unsorted
    * list that don't need to be sorted again.
   */
   private ListNode findRuns(ListNode h) {
   	 linkedList runList = new linkedList();
    	 ListNode cur = h;
       ListNode next = h.next;
       runList.push(cur);
     	 
     	 // read through entire list
	  	 while (next != null) {
	  		 comparisons++;
	  		 /* if the next value is less than the current value,
	  		  * then push the next value into the runList, because
	  		  * it represents the start of the next run.
	  		 */
	  		 if (next.val < cur.val) {
	  			 	
	  			 runList.push(next);

	  			 cur.next = null;
	  		 }
	  		 
	  		 // increment cur and next to the next nodes in the list
	  		 cur = next;
	  		 next = next.next;
	  	 }
	  	 
	  	 return runList.head;
 
   }
   
   
   /*
    * Another recursive method. You could say this is the framework
    * of the sort. It takes the linked list that is output by findRuns()
    * and recursively breaks it down into halves, and calls sortedMerge()
    * to merge nodes together.
    */
   private ListNode sortRecursion(ListNode h) {

       // Base case : if head is null
       if (h == null || h.next == null) {
           return h;
       }

       // get the middle of the list
       ListNode middle = getMiddle(h);
       ListNode nextofmiddle = middle.next;

       // set the next of middle node to null
       middle.next = null;

       // Apply mergeSort on left list
       ListNode left = sortRecursion(h);

       // Apply mergeSort on right list
       ListNode right = sortRecursion(nextofmiddle);

       // Merge the left and right lists
       ListNode sortedlist = new ListNode(sortedMerge(left.nodeVal, right.nodeVal));
       return sortedlist;
   }
   
   


   // Utility function to get the middle of the linked list
   private ListNode getMiddle(ListNode head)
   {
       if (head == null)
           return head;

       ListNode slow = head, fast = head;

       while (fast.next != null && fast.next.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }
       return slow;
   }
}
