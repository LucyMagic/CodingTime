
public class PartitionList {

	//Note to clean up after traversing the list to unwire any pointers not needed
	//at line 24
    public ListNode partition(ListNode head, int x) {
        ListNode ltHead = new ListNode(-1);
        ListNode ltTail = ltHead;
        ListNode geHead = new ListNode(x);
        ListNode geTail = geHead;
        
        ListNode current = head;
        while(current!=null){
            if(current.val < x){
                ltTail.next = current;
                ltTail = ltTail.next;
            }else{
                geTail.next = current;
                geTail = geTail.next;
            }
            current = current.next;
        }
        ltTail.next = geHead.next;
        geTail.next = null;//This is very necessary
        return ltHead.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		PartitionList pl = new PartitionList();
		ListNode node = pl.partition(head, 2);
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}

}
