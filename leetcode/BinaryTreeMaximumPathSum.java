public class BinaryTreeMaximumPathSum {

	private int maxPathSum;
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        findMaximumSum(root);
        return maxPathSum;
    }
    
    private int findMaximumSum(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        int leftPathSum = root.val, rightPathSum = root.val;
        int leftMax = findMaximumSum(root.left);
        if(leftMax > 0){
            leftPathSum += leftMax;
        } 
        int rightMax = findMaximumSum(root.right);
        if(rightMax > 0){
            rightPathSum += rightMax;
        }
           
        int sum = leftPathSum + rightPathSum - root.val;
        if(sum > maxPathSum)
            maxPathSum = sum;
            
        return leftPathSum > rightPathSum ? leftPathSum : rightPathSum;
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
