
public class ConvertSortedListTpBST {	
	public TreeNode sortedListToBST(ListNode head) {
        ListNode n = head;
        int size = 0;
        while (n != null) {
        	size++;
    		n = n.next;
    	}
    	int[] num = new int[size];
    	n = head;
    	int i = 0;
    	while (n != null) {
    		num[i++] = n.val;
    		n = n.next;
    	}
    	return sortedArrayToBST(num, 0, size-1);
    }       
	public TreeNode sortedArrayToBST(int[] num, int lo, int hi) {
		if(lo > hi) return null;
		int mid = lo + (hi-lo)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, lo, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, hi);
		return root;
	}
	
	
	//*****************Top down recursion******************//
    public TreeNode sortedListToBSTTopDown(ListNode head) {
        if(head == null) return null;
        int size = getSize(head);
        return buildTree(head, 0, size-1);
    }    
    private TreeNode buildTree(ListNode head, int lo, int hi){
        if(lo > hi) return null;
        int mid = lo + (hi -lo)/2;
        TreeNode root = new TreeNode(getNthNode(head, mid).val);
        root.left = buildTree(head, lo, mid-1);
        root.right = buildTree(head, mid+1, hi);
        return root;
    }    
    private ListNode getNthNode(ListNode head, int n){
        while(n>0&&head!=null){
            n--; head = head.next;
        }
        return head;
    }    
    private int getSize(ListNode head){
        int size = 0;
        while(head!=null){
            size++; head = head.next;
        }
        return size;
    }

	
	//*****************Bottom up which does not work in java******************//
	public TreeNode sortedListToBSTWrong(ListNode head) {
        if(head == null) return null;       
        int length = findLength(head);
        return constructTree(head, 0, length-1);
    }
    
    private TreeNode constructTree(ListNode head, int lo, int hi){
        if(lo>hi) return null;
        int mid = lo + (hi-lo)/2;
        TreeNode leftChild = constructTree(head, lo, mid-1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = leftChild;
        root.right = constructTree(head, mid+1, hi);
        return root;
    } 
    
    //*****************bottom up workaround in java by passing an object******************//
    class Wrapper{
        ListNode node;
        Wrapper(ListNode n){
        	node = n;
        }
    }     
    public TreeNode sortedListToBSTBottomUp(ListNode head) {
        int len = findLength(head); 
        Wrapper w = new Wrapper(head);
        return sortedListToBST(w, 0, len-1);
    }
     
    public TreeNode sortedListToBST(Wrapper w, int start, int end) {
        if(start>end)
            return null;
         
        int mid = start+(end-start)/2;         
        TreeNode left = sortedListToBST(w, start, mid-1);
        TreeNode root = new TreeNode(w.node.val);
        w.node = w.node.next;         
        TreeNode right = sortedListToBST(w, mid+1, end);
         
        root.left = left;
        root.right = right;
        return root;
    }
    //************************************************************************************//
    
    private int findLength(ListNode head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    public class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedListTpBST toBST = new ConvertSortedListTpBST();
		ListNode head = toBST.new ListNode(0);
		toBST.sortedListToBST(head);
	}

}
