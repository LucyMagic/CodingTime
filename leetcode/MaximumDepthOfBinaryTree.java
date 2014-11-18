public class MaximumDepthOfBinaryTree {

	//*********Solution 1***************//
	private int maxDepth;
    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        findMaxDepth(root, 0);
        return maxDepth;
    }    
    private void findMaxDepth(TreeNode root, int curDepth){
        if(root == null){
            if(curDepth > maxDepth) maxDepth = curDepth;
            return;
        }        
        findMaxDepth(root.left, curDepth + 1);
        findMaxDepth(root.right, curDepth + 1);
    }
    
    //*************Solution2 *****************//
    //Without using a field
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
    
    private class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
  }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
