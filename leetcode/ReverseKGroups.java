
public class ReverseKGroups {
	/*recursive solution*/	
   public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        //check length
        ListNode tail = head;
        int m = k;
        while(m>0&&tail!=null){
            tail = tail.next;
            m--;
        }
        if(m>0) return head;
        
        ListNode newHead = reverse(head, k);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }
    private ListNode reverse(ListNode head, int k){
        if(k==1){
            return head;
        }
        
        ListNode newHead = reverse(head.next, k-1);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

	/*iterative solution*/
	public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2 || head==null) return head;    
        
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        ListNode fasterP = head;
        ListNode slowerP = head;
        
        while(true){
            int m = k;
            while(m>1 && fasterP!=null){
                fasterP = fasterP.next;
                m--;
            }
            if(fasterP==null) {
                current.next = slowerP;
                break;
            }
            ListNode nextRound = fasterP.next;
            if(m==1){
                reverse(fasterP, slowerP);
            }
            current.next = fasterP;
            current = slowerP;
            fasterP = nextRound;
            slowerP = nextRound;             
        }
        return dummyHead.next;
    }
    
    private void reverse(ListNode fp, ListNode sp){
        ListNode current = sp;
        ListNode prev = null;
        ListNode end = fp.next;
        while(current!=null&&current!=end){
            ListNode oldNext = current.next;
            current.next = prev;
            prev = current;
            current = oldNext;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseKGroups rkg = new ReverseKGroups();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		rkg.reverseKGroup(head, 2);
	}

}
