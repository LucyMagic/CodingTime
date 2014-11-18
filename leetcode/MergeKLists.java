import java.util.*;
public class MergeKLists {

	//*******************Solution 1********************
	//Use a priority queue to store the minimum k nodes
	public ListNode mergeKLists1(ArrayList<ListNode> lists) {
        if(lists == null) return null;
        int k = lists.size();
        if(k==0) return null;
        
        Comparator<ListNode> BY_VALUE = new Comparator<ListNode>(){
              public int compare(ListNode l1, ListNode l2){
                int cmp = l1.val - l2.val;
                if(cmp > 0) return 1;
                else if(cmp < 0) return -1;
                else            return 0;
              } 
        };
        
        PriorityQueue<ListNode> topK = new PriorityQueue<ListNode>(k, BY_VALUE);
        for(ListNode node : lists){
            if(node!=null) topK.offer(node);
        }        
        
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while(!topK.isEmpty()){
            ListNode node = topK.poll();
            current.next = node;
            current = current.next;
            if(node.next!=null) topK.offer(node.next);
        }
        
        return dummyHead.next;
    }
	
	//*******************Solution 1********************
	//bottom up merge, merge 2 lists each time, iterate till there is only 1 left
	public ListNode mergeKLists2(ArrayList<ListNode> lists) {
		if(lists==null||lists.size()==0) return null;        
        while(lists.size() > 1){
            int lo = 0, hi = lists.size()-1;
            while(lo < hi){
                lists.set(lo, mergeTwoSortedLists(lists.get(lo), lists.get(hi)));
                lists.remove(hi);
                lo++; hi--;
            }
        }
        return lists.get(0);
    }    
    private ListNode mergeTwoSortedLists(ListNode list1, ListNode list2){        
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while(list1!=null&&list2!=null){
            int cmp = list1.val - list2.val;
            if(cmp<=0) {
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1==null) current.next = list2;
        if(list2==null) current.next = list1;
        
        return dummyHead.next;
    }
    
    //*****************Solution 3*********************//
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null||lists.size()==0) return null;        
        return mergeKLists(lists, 0, lists.size()-1);
    }
    private ListNode mergeKLists(ArrayList<ListNode> lists, int lo, int hi){
    	//check base case
    	if(hi>lo) return null;
        if(lo==hi) return lists.get(lo); 
        
        //divide
        int mid = lo + (hi-lo)/2;
        ListNode l1 = mergeKLists(lists, lo, mid);
        ListNode l2 = mergeKLists(lists, mid+1, hi);
        //conquer
        return mergeTwoSortedLists(l1, l2);
    }
    
	    
	//Explicit usage of comparator
	public static final Comparator<ListNode> BY_VALUE = new ByValue();
    private static class ByValue implements Comparator<ListNode>{
        public int compare(ListNode l1, ListNode l2){
            int cmp = l1.val - l2.val;
            if(cmp > 0) return 1;
            else if(cmp < 0) return -1;
            else            return 0;
        }
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

	}

}
