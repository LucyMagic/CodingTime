
public class BalancedBinaryTree {
	    public boolean isBalancedBottomeUp(TreeNode root) {
	        int height = getHeightBottomUp(root);
	        return height==-1? false : true;
	    }
	    
	    private int getHeightBottomUp(TreeNode root){
	        if(root==null) return 0;
	        int leftHeight = getHeight(root.left);
	        if(leftHeight == -1) return -1;
	        
	        int rightHeight = getHeight(root.right);
	        if(rightHeight == -1) return -1;
	        
	        int diff = Math.abs(leftHeight - rightHeight);
	        if(diff>1) return -1;
	        
	        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
	    }
	
	//***************Solution 2*******************//
    public boolean isBalancedTopDown(TreeNode root) {
        if(root == null) return true;
        int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
        
        if(diff>1) return false;        
        return isBalancedTopDown(root.left) && isBalancedTopDown(root.right);
    }
    
    private int getHeight(TreeNode root){
        if(root==null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

}
