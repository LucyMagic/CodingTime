import java.util.*;
public class SymmetricTree {

	//*****************Recursion**************//
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        
        if(p.val != q.val)
            return false;
            
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
    
    private class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
//	      TreeNode(int x) { val = x; }
    }
    
    //**********Iteration**************//
    public boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;
        return isMirror2(root.left, root.right);
    }
    
    private boolean isMirror2(TreeNode p, TreeNode q){
        if(p == null && q == null) 
                return true;
        if(p == null || q == null)
                return false;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(p);
        queue.offer(q);
        
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if(first.val != second.val)
                return false;
            
            if(first.left == null || second.right == null){
                if(first.left != second.right)
                    return false;
            }else{
                queue.offer(first.left);
                queue.offer(second.right);
            }
            
            if(first.right == null || second.left == null){
                if(first.right != second.left)
                    return false;
            }else{
                queue.offer(first.right);
                queue.offer(second.left);
            }
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
