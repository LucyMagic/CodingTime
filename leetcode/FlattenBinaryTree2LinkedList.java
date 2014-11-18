public class FlattenBinaryTree2LinkedList {

    public void flatten(TreeNode root) {
        preOrder(root);
    }
    
    private TreeNode preOrder(TreeNode root){
        if(root == null)    return null;
        
        if(root.left == null && root.right == null){
            return root;
        }else if(root.left == null){ 
            return preOrder(root.right);
        }else if(root.right == null){
            root.right = root.left;
            root.left = null;
            return preOrder(root.right);
        }else{
            //both left and right are not null
            TreeNode oldRight = root.right;
            TreeNode oldLeft = root.left;
            root.right = oldLeft; 
            root.left = null;
            TreeNode leftEnd = preOrder(oldLeft);
            leftEnd.right = oldRight;
            return preOrder(oldRight);
        }       
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
