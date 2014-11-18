
public class AddTwoNumbers {

	//***********************Without dummy node***********************************//
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		ListNode head = null, current = null;
		int carrier = 0;
		while(l1!=null || l2!=null){
			int sum = carrier;
			if(l1!=null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2!=null){
				sum += l2.val;
				l2 = l2.next;
			}
			if(current!=null){
				current.next = new ListNode(sum%10);
				current = current.next;
			}else{
				head = new ListNode(sum%10);
				current = head;
			}
			carrier = sum/10;
		}
		if(carrier!=0) current.next = new ListNode(carrier);
		return head;
	}

	//*****************Less code, more work*********************//
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummyHead = new ListNode(0);
        ListNode last = dummyHead;
        int carrier = 0;
        while(l1!=null || l2!=null){
        	//get values
            int val1 = 0, val2 = 0;
            if(l1!=null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }
            
            //compute the sum
            int sum = val1+val2+carrier;
            carrier = sum/10;
            ListNode current = new ListNode(sum%10);
            last.next = current;
            last = last.next;
        }
        if(carrier!=0) 
        	last.next = new ListNode(carrier);
        
        return dummyHead.next;
    }
    
    //**************More code, more efficient**************//
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        
        ListNode dummySumHead = new ListNode(-1);
        ListNode current = dummySumHead;
        int carrier = 0;
        
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carrier;
            carrier = sum>10 ? 1 : 0;//or sum/10
            current.next = new ListNode(sum%10);
            current = current.next;
            l1 = l1.next; l2 = l2.next;
        }
        
        if(l1 == null)
            l1 = l2;
       
        while(l1 != null){
            int sum = l1.val + carrier;
            carrier = sum>10 ? 1 : 0;
            current.next = new ListNode(sum%10);
            current = current.next;
            l1 = l1.next;
        }       
        if(carrier == 1)
            current.next = new ListNode(1);
        
        return dummySumHead.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
