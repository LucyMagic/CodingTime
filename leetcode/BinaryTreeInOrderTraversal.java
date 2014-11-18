import java.util.*;
public class BinaryTreeInOrderTraversal {
	//*****************Recursion*******************//
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        inorderTraversal(root, results);
        return results;
    }
    
    private void inorderTraversal(TreeNode root, ArrayList<Integer> results){
        if(root == null)
            return;
        inorderTraversal(root.left, results);
        results.add(root.val);
        inorderTraversal(root.right, results);
    }
    
    //*******Recursion***************//
    //This is not good because there will be a lot of ArrayList generated. 
    //Kind of the auxiliary array in merge sort. should be declared in the main entry method
    public ArrayList<Integer> inorderTraversalRec2(TreeNode root) {
        return inorderTraversalRec(root);
    }
    private ArrayList<Integer> inorderTraversalRec(TreeNode root){
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if(root == null) return inorder;
        
        ArrayList<Integer> left = inorderTraversalRec(root.left);        
        inorder.addAll(left);
        inorder.add(root.val);
        ArrayList<Integer> right = inorderTraversalRec(root.right);
        inorder.addAll(right);
        return inorder;
    }
    
    //*****************Iteration*******************//
    public ArrayList<Integer> inorderTraversalIteration(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        TreeNode cur = root;
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }            
            if(stack.isEmpty()) break;            
            TreeNode top = stack.pop();
            values.add(top.val);
            cur = top.right;            
        }
        return values;
    }  
    
    public ArrayList<Integer> inorderTraversalIteration2(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if(root==null) return inorder;
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            //push till left child is null
            while(node.left!=null){
                stack.push(node.left);
                node = node.left;
            }
            //process the node 
            node = stack.pop();
            inorder.add(node.val);
            //keep poping till we find one node whose right child needs to be processed
            while(!stack.isEmpty() && node.right == null){
                node = stack.pop();
                inorder.add(node.val);
            }
            if(node.right!=null) 
                stack.push(node.right);
        }
        
        return inorder;
    }
    
    
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInOrderTraversal bi = new BinaryTreeInOrderTraversal();
		TreeNode head = bi.new TreeNode(1);
		ArrayList<Integer> results =  bi.inorderTraversal(head);
		for(int i : results){
			System.out.print(i);
		}
	}

}
