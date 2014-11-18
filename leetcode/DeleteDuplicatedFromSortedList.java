
public class DeleteDuplicatedFromSortedList {

	/* Note the order of instructions in line 18 -21
	 */
	
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
            return head;
        
        ListNode uniqueListHead = head;
        ListNode uniqueListTail = uniqueListHead;
        ListNode current = head.next;
        int value = head.val;
        while(current!=null){
            if(current.val != value){
                uniqueListTail.next = current;
                value = current.val;
                current = current.next;
                uniqueListTail = uniqueListTail.next;
            }else{
                current = current.next;
            }
        }
        uniqueListTail.next = null;
        return uniqueListHead;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		deleteDuplicates(head);
//		head.print();
	}

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    void print(){
    	ListNode node = this;
    	while(node != null){
    		System.out.println(this.val);
    		node = node.next;
    	}
    }
}
