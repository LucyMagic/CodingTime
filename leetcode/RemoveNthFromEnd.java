
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        assert n>=0;
        if(n==0) return head;        
        ListNode faster = head;
        ListNode slower = head;
        
        while(n>0 && faster!=null){
            faster = faster.next;
            n--;
        }
        
        if(n==0&&faster==null) return head.next;
        if(faster==null) return head;
        
        while(faster.next!=null){
            faster = faster.next;
            slower = slower.next;
        }        
        slower.next = slower.next.next;        
        return head;
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
		RemoveNthFromEnd rnf = new RemoveNthFromEnd();
		ListNode head = rnf.new ListNode(4);
		head.next = rnf.new ListNode(5);
		ListNode newHead = rnf.removeNthFromEnd(head, 1);
		while(newHead!=null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}
