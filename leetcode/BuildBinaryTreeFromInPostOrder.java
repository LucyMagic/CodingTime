public class BuildBinaryTreeFromInPostOrder {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        if(inorder.length==0 || postorder.length == 0) return null;
        
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart == inEnd){
            return new TreeNode(inorder[inStart]);
        }
        if(inStart > inEnd) return null;
        
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = findRootIndex(inorder, inStart, inEnd, rootVal);
        int leftCount = index - inStart;
        
        root.left = buildTree(inorder, postorder, inStart, index-1, postStart, postStart+leftCount-1);
        root.right = buildTree(inorder, postorder, index+1, inEnd, postStart+leftCount, postEnd-1);
        
        return root;
    }
    
    private int findRootIndex(int[] inorder, int start, int end, int target){
        for(int i = start; i <= end; i++){
            if(inorder[i] == target) return i;
        }
        return -1;
    }
    
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
