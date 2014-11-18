public class BuildBSTFromInPreOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null) return null;
        if(preorder.length==0 || inorder.length==0) return null;
        
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        //base cases
    	if(preStart > preEnd) return null;
        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }      
        
        //recursive 
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = findRootIndex(inorder, inStart, inEnd, rootVal);
        
        int leftCount = index - inStart;
        root.left = buildTree(preorder, inorder, preStart+1, preStart+leftCount, inStart, index-1);
        root.right = buildTree(preorder, inorder, preStart+1+leftCount, preEnd, index+1, inEnd);
        
        return root;
    }
    
    //all unique values
    private int findRootIndex(int[] inorder, int lo, int hi, int target){
        for(int i = lo; i <= hi; i++){
            if(inorder[i] == target){
                return i;
            }
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
		int[] preorder = new int[]{1,2,3};
		int[] inorder = new int[]{2,3,1};
		BuildBSTFromInPreOrder btree = new BuildBSTFromInPreOrder();
		TreeNode t = btree.buildTree(preorder, inorder);
	}

}
