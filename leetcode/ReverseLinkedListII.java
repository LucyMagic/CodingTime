
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null || m == n)
            return head;
            
        //add one dummy node
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        head = newHead;
        m++; n++;
        
        ListNode reverseStart = head;
        //find the one listnode before m
        for(int i = 1; i < m -1; i++){
            reverseStart = reverseStart.next;
        }
        
        ListNode leftEnd = reverseStart;
        reverseStart = reverseStart.next;
        
        //start reversing while travaersing to n node
        ListNode prev = reverseStart;
        ListNode current = reverseStart.next;
        for(int j = m+1; j <= n; j++){
            ListNode oldNext = current.next;
            current.next = prev;
            prev = current;
            current = oldNext;
        }
        ListNode rightEnd = current;
        ListNode reverseEnd = prev;
        
        leftEnd.next = reverseEnd;
        reverseStart.next = rightEnd;
        
        return head.next;
    }

	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
