
public class RotateListRight {

	public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null || n == 0)
            return head;
        
        ListNode fasterP = head;
        ListNode slowerP = head;
        int counter = n;

        while(fasterP != null && counter > 0){
            fasterP = fasterP.next;
            counter--;
        }
        
        if(counter > 0){
            int listLength = n - counter;
            return rotateRight(head, n%listLength);
        }
        if(counter == 0 && fasterP == null)
            return head;
        
        while(fasterP.next != null){
            fasterP = fasterP.next;
            slowerP = slowerP.next;
        }
        
        ListNode nHead = slowerP.next;
        slowerP.next = null;
        fasterP.next = head;
        
        return nHead;
    }

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
         public void print(ListNode head){
        	 while(head!=null){
        		 System.out.print(head.val + " ");
        		 head = head.next;
        	 }
         }
    }
    
//    private ListNode reverse(ListNode head){
//        if(head == null || head.next == null)
//            return head;
//
//        ListNode newHead = reverse(head.next);
//        ListNode newTail = head.next;
//        newTail.next = head;
//        head.next = null;
//        return newHead;
//    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateListRight rlr = new RotateListRight();
		ListNode head = rlr.new ListNode(1);
		head.next = rlr.new ListNode(2);
		head.print(head);
		rlr.rotateRight(head, 2);
	}

}
