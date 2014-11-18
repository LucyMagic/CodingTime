public class RemoeDuplicatesFromSortedListII {
	
	//******************Solution 1***************//
	public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        ListNode prev = head;
        ListNode current = head;
        while(current!=null){
            while(current.next!=null && current.val == current.next.val)
                current = current.next; 
            if(prev == current){//this is a distinct value
                tail.next = prev;
                tail = tail.next;
            }
            prev = current.next;
            current = current.next;
        }
        tail.next = null;
        return dummyHead.next;
    }
	
	//******************Solution 2***************//
    public ListNode deleteDuplicates2(ListNode head) {        
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        ListNode current = head;
        
        while(current!=null){
            if(current.next == null || current.val!=current.next.val){
                tail.next = current;
                tail = tail.next;
                current = current.next;
            }else{
                int val = current.val;
                while(current!=null && current.val == val)
                    current = current.next;                
            }            
        }
        tail.next = null;
        return dummyHead.next;
    }
		
    //******************Solution 3***************//
	public  ListNode deleteDuplicates3(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;
        
        while(head != null){
            if(head.next == null){
                tail.next = head;
                return dummy.next;
            }else if(head.val != head.next.val){
                tail.next = head;
                head = head.next;
                tail = tail.next;
                tail.next = null;
            }else if(head.val == head.next.val){
                while(head.next!=null && head.val == head.next.val){
                    head = head.next;
                }
                if(head.next == null){
                    return dummy.next;
                }else{
                    head = head.next;
                }
            }
        }
        return dummy.next;
    }

    //******************Solution 4***************//
    public ListNode deleteDuplicates4(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        //iterate for list more than one node
        boolean includeThisNode = true;
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while(head.next != null){
            if(head.val != head.next.val){
                if(includeThisNode){
                    current.next = head;
                    current = current.next;
                }else{
                    includeThisNode = true;
                }
            }else{
                includeThisNode = false;
            }
            head = head.next;
        }
        //take care of the last node
        if(includeThisNode){
            current.next = head;
            current = current.next;
        }
        //unlink the rest 
        current.next = null;
        return dummyHead.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(4);
		head.next = new ListNode(1);
		RemoeDuplicatesFromSortedListII q = new RemoeDuplicatesFromSortedListII();
		ListNode newHead = q.deleteDuplicates1(head);
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}
