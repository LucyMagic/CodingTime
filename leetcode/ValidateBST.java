
public class ValidateBST {

	//*********************Solution 1**************************//
	/* (1) This solution is only good when we know the value range of the TreeNode, for example integer value.
	 * 	   However, if we store objects in the TreeNode and do not know the biggest range we can have, this is not good
	 * (2) What happens when duplicates are allowed in the tree? How should the values be adjusted?
	 * 	   If node with equal values goes to left subtree, we allow the left subtree to "<=" hi.
	 * 	   if(root.val <= lo || root.val > hi) to return false
	 */
    public boolean isValidBST1(TreeNode root) {
        return isInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);    
    }
    
    private boolean isInRange(TreeNode root, int lo, int hi){
        if(root == null)    return true;
        if(root.val <= lo || root.val >= hi)    return false;
        return isInRange(root.left, lo, root.val) && isInRange(root.right, root.val, hi);
    }
	
	//*********************Solution 2**************************//
    //Update reference to previous reference recursive calls by setting its value
    public boolean isValidBST2(TreeNode root) {
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        return isValidBST(root, prev);       
    }   
    private boolean isValidBST(TreeNode root, TreeNode prev){
        if(root == null) return true;
        boolean leftValid = isValidBST(root.left, prev);
        if(!leftValid || root.val<=prev.val) return false;
        prev.val = root.val;
        return isValidBST(root.right, prev);
    }
    
    //********************Solution 3***************//
    //With a field to update the reference for any previous recursive calls
    TreeNode prev;
    public boolean isValidBST3(TreeNode root) {
        prev = null;
        return inOrderTraversal(root);
    }
    private boolean inOrderTraversal(TreeNode root){
        if(root == null) return true;
        boolean leftValid = inOrderTraversal(root.left);
        if(!leftValid) return false;
        
        if(prev==null || root.val > prev.val){
            prev = root;
        }else if(root.val <= prev.val){
             return false;
        }
        
        boolean rightValid = inOrderTraversal(root.right);
        return rightValid;
    }
    
   //********************Wrong solution***************//
    //Setting the reference of prev to root does not change the reference in any other recursive calls except for within this sole method
    public boolean isValidBSTWrong(TreeNode root) {
    	TreeNode prev = null;
        return inOrderTraversalWrong(root, prev);
    }
    private boolean inOrderTraversalWrong(TreeNode root, TreeNode prev){
        if(root == null) return true;
        boolean leftValid = inOrderTraversalWrong(root.left, prev);
        if(!leftValid) return false;
        
        if(prev==null || root.val > prev.val){
            prev = root;//this can not be propagated to other methods
        }else if(root.val <= prev.val){
             return false;
        }        
        boolean rightValid = inOrderTraversalWrong(root.right, prev);
        return rightValid;
    }
    
    public class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }

	public static void main(String[] args) {
		
		
	}

}
