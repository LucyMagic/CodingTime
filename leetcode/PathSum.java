public class PathSum {

	public class Solution {
	    public boolean hasPathSum(TreeNode root, int sum) {
	        return dfs(root, sum);
	    }
	    
	    private boolean dfs(TreeNode root, int sum){
	        if(root == null)
	            return false;
	        
	        if(root.right == null && root.left == null){
	            if(sum - root.val == 0){
	                return true;
	            }
	            return false;
	        }
	        
	        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
	    }
	}
	
    private class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
//	      TreeNode(int x) { val = x; }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
