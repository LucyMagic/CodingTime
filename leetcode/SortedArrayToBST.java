
public class SortedArrayToBST {
	//************************Recursion************************************//
    public TreeNode sortedArrayToBSTRecursion(int[] num) {
        return balancedBST(num, 0, num.length-1);
    }
    
    private TreeNode balancedBST(int[] num, int lo, int hi){
        if(lo > hi) return null;	        
        int mid = lo + (hi-lo)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = balancedBST(num, lo, mid-1);
        root.right = balancedBST(num, mid+1, hi);
        return root;
    }
	//*************************Iteration***********************************//

    
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }	  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
