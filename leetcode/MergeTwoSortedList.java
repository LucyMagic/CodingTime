
public class MergeTwoSortedList {
	
	//******************Recursion*******************//
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode head = null;
        if(l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        }else{
            head = l1;
            l1 = l1.next;
        }        
        head.next = mergeTwoListsRecursion(l1, l2);
        return head;
    }
	
    
    //Remember to update the tail, l1, l2 pointers each iteration//
    
	//******************Iteration with dummy head*******************//
	public ListNode mergeTwoListsIteration(ListNode l1, ListNode l2) {
	        ListNode dummyHead = new ListNode(-1);
	        ListNode current = dummyHead;
	        while(l1!=null && l2!=null){
	            if(l1.val<=l2.val){
	                current.next = l1;
	                l1 = l1.next;
	            }else{
	                current.next = l2;
	                l2 = l2.next;
	            }
	            current = current.next;
	        }
	        if(l1!=null) current.next = l1;
	        if(l2!=null) current.next = l2;
	        
	        return dummyHead.next;
	    }
	

	//******************Iteration with dummy head*******************//	
	public ListNode mergeTwoListsIterationWithoutDummy(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        
        while(l1!=null || l2!=null){
            if(l1==null){
                if(head == null){
                    head = l2;
                    tail = l2;
                }else{ 
                    tail.next = l2;
                }
                break;
            }
            if(l2==null){
                if(head == null){
                    head = l1;
                    tail = l1;
                }else{ 
                    tail.next = l1;
                }
                break;
            } 
            
            if(l1.val <= l2.val){
                if(head == null){
                    head = l1; 
                    tail = l1;
                }else{ 
                    tail.next = l1;
                    tail = tail.next;
                }
                l1= l1.next;
            }else{
                if(head == null){
                    head = l2;
                    tail = l2;
                }else{
                    tail.next = l2;
                    tail = tail.next;
                }
                l2 = l2.next;
            }
        }
        return head;
    }
	
	class ListNode {
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


