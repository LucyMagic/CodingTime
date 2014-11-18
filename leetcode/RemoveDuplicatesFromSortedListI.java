
public class RemoveDuplicatesFromSortedListI {
	
	public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next ==null) return head;
        
        ListNode prev = head;
        ListNode current = head.next;
        while(current != null){
            while(current!=null && current.val==prev.val)
                current = current.next;
            if(current == null) break;
            prev.next = current;
            prev = prev.next;
            current = current.next;
        }
        prev.next = null;
        return head;
    }
	
    //****************Solution 2*******************//
    /* reconstruct the list and do not include any node with duplicate values
     */	
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
        ListNode pre = head;
        for(ListNode current = head.next; current!=null; current = current.next){
            if(current.val != pre.val){
                pre.next = current;
                pre = current;
            }
        }
        pre.next = null;
        return head;
    }
    
    
    //****************Solution 2*******************//
    /*  Leave out any node with duplicate values from the original list
     */
    public ListNode deleteDuplicates2(ListNode head) {
    	if(head == null) return null;
    	
    	ListNode pre = head;
    	for(ListNode current = head.next; current!=null; current = current.next){
    		if(current.val == pre.val){
    			pre.next = current.next;
    		}else{
    			pre = current;
    		}
    	}
    	return head;
    }
    
	public static void main(String[] args) {

	}

}
