
public class SwapNodesInPairs {

	//*****************Solution 1********************//
	/*
	 * Since there is only integer value in the nodes
	 */
    public ListNode swapPairsSwapValues(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null){
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            node = node.next.next;
        }
        return head;
    }
    
  //*****************Solution 2********************//
    public ListNode swapPairs2(ListNode head) {
    	if(head==null||head.next==null) return head;
    	
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode current = head;
        while(current!=null&&current.next!=null){
            //get the three consecutive nodes 
            ListNode first = current;
            ListNode second = current.next;
            ListNode oldNext = second.next;
            
            //rewire the pointers between nodes
            prev.next = second;
            second.next = first;
            first.next = oldNext;
            
            //forward the prev and current node pointer
            current = oldNext;
            prev = first;
        }
        return dummyHead.next;
    }
    
    //******************Solution 3 Without dummy node*****************//
    public ListNode swapPairs3(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode newHead = null;
        ListNode newTail = null;        
        while(head!=null&&head.next!=null){
            ListNode first = head;
            ListNode second = head.next;
            first.next = second.next;
            second.next = first;
            if(newHead == null){
                newHead = second;
                newTail = second;
            }else{
                newTail.next = second;
            }
            newTail = first;
            head = head.next;
        }
        newTail.next = head;        
        return newHead;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
