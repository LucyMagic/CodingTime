
public class AddTwoNumbersNaturalOrder {

	//*****************Solution 1 Iteration***********************//
	//l1 and l2 have the same length
	//pad the lists first if they are of different lengths
	public ListNode addTwoNumbersIteration(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		ListNode dummyHead = new ListNode(0);
		ListNode lastLessThanNine = dummyHead;
		ListNode current = dummyHead;		
		while(l1!=null&&l2!=null){
			int sum = l1.val + l2.val;
			int value = sum%10;
			int carrier = sum/10;
			current.next = new ListNode(value);
			current = current.next;
			if(carrier > 0){//have carrier
				lastLessThanNine.val++;
				ListNode zeros = lastLessThanNine.next;
				while(zeros!=current){
					zeros.val = 0;
					zeros = zeros.next;
				}
			}
			if(current.val < 9){//update last position
				lastLessThanNine = current;
			}
			l1 = l1.next; l2 = l2.next;
		}
		
		return (dummyHead.val==0) ? dummyHead.next : dummyHead;
	}	
	
	//*****************Solution 1 Recursion***********************//
	public ListNode addTwoNumbersRecursion(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		int length1 = getLength(l1);
		int length2 = getLength(l2);
		if(length1 > length2){
			l2 = padList(l2, length1-length2);
		}else if(length1 < length2){
			l1 = padList(l1, length2 - length1);
		}
		
		Sum sum = addNumbers(l1, l2);
		ListNode head = null;
		if(sum.carrier>0) {
			head = new ListNode(sum.carrier);
			head.next = sum.node;
		}else{
			head = sum.node;
		}		
		return head;
	}
	private Sum addNumbers(ListNode l1, ListNode l2){
		if(l1==null || l2==null) return null;
		
		Sum nextSum = addNumbers(l1.next, l2.next);
		int carrier = 0;
		ListNode nextNode = null;
		if(nextSum!=null){
			carrier = nextSum.carrier;
			nextNode = nextSum.node;
		}
		
		int currentVal = l1.val + l2.val + carrier;
		ListNode current = new ListNode(currentVal%10);
		current.next = nextNode;
		carrier = currentVal/10;
		return new Sum(carrier, current);
	}	
	private class Sum{
		private int carrier;
		private ListNode node;
		public Sum(int c, ListNode n){
			carrier = c;
			node = n;
		}
	}
	
	private int getLength(ListNode node){
		int length = 0;
		while(node!=null){
			length++;
			node = node.next;
		}
		return length;
	}	
	private ListNode padList(ListNode node, int numOfZeros){
		ListNode head = new ListNode(0);
		ListNode current = head;
		for(int i = 1; i < numOfZeros; i++){
			current.next = new ListNode(0);
			current = current.next;
		}
		current.next = node;
		return head;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbersNaturalOrder add = new AddTwoNumbersNaturalOrder();
		ListNode l1 = new ListNode(8);
		l1.next = new ListNode(8);
		l1.next.next = new ListNode(1);
		l1.next.next.next = new ListNode(8);
		l1.next.next.next.next = new ListNode(9);
		ListNode l2 = new ListNode(8);
		l2.next = new ListNode(1);
		l2.next.next = new ListNode(8);
		l2.next.next.next = new ListNode(1);
//		l2.next.next.next.next = new ListNode(9);
		
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(5);
		
		
		ListNode l3 = add.addTwoNumbersIteration(l5, l6);
		ListNode l4 = add.addTwoNumbersRecursion(l5, l6);
		while(l3!=null){
			System.out.print(l3.val + "  ");
			l3 = l3.next;
		}
		System.out.println();
		while(l4!=null){
			System.out.print(l4.val + "  ");
			l4 = l4.next;
		}
	}

}
