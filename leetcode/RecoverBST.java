public class RecoverBST {

	private TreeNode preNode, targetNode1, targetNode2;
    public void recoverTree(TreeNode root) {        
        preNode = null; targetNode1 = null; targetNode2 = null;
        findNodes(root);
        swapNodes(targetNode1, targetNode2);
    }
    
    private void findNodes(TreeNode root){
        if(root == null)    return;
        if(root.left == null && preNode == null){
            preNode = root;
        }
        
        findNodes(root.left);
        if(root.val < preNode.val && targetNode2 == null){
            targetNode1 = preNode;
            targetNode2 = root;
            preNode = root;
        }else if(root.val < preNode.val && targetNode2 != null){
            targetNode2 = root;
            preNode = root;
        }else{
            preNode = root;
        }
        findNodes(root.right);
    }
    
    private void swapNodes(TreeNode targetNode1, TreeNode targetNode2){
        int tempVal = targetNode1.val;
        targetNode1.val = targetNode2.val;
        targetNode2.val = tempVal;
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

    //*****do not need to put the varaibles in class as fields**********//
    public void recoverTreeNoFields(TreeNode root) {
        if(root==null) return;
        
        TreeNode[] swappedNodes = new TreeNode[2];
        recoverTreePreorder(root, null, swappedNodes);
        swapNodes(swappedNodes[0], swappedNodes[1]);
    }
    private TreeNode recoverTreePreorder(TreeNode root, TreeNode prev, TreeNode[] swappedNodes){
        if(root==null) return prev;
        
        prev = recoverTreePreorder(root.left, prev, swappedNodes);
        if(prev!=null&&root.val<prev.val){
            if(swappedNodes[0]==null){
                swappedNodes[0] = prev;
                swappedNodes[1] = root;
            }else{
                swappedNodes[1] = root;
            }
        }
        prev = root;
        return recoverTreePreorder(root.right, prev, swappedNodes);
    }
}
