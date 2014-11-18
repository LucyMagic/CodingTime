import java.util.*;

public class BinaryTreePostOrderTraversal {
	
	public ArrayList<Integer> postorderRec(TreeNode root){
		ArrayList<Integer> postorder = new ArrayList<Integer>();
		if(root == null) return null;
		postorderRec(root, postorder);
		return postorder;
	}
	private void postorderRec(TreeNode root, ArrayList<Integer> postorder){
		if(root == null) return;
		
		postorderRec(root.left, postorder);
		postorderRec(root.right, postorder);
		postorder.add(root.val);
	}

	//*************Use 2 stacks**************//
	public ArrayList<Integer> postorderIteration(TreeNode root){
		ArrayList<Integer> values = new ArrayList<Integer>();
		ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
		ArrayDeque<Integer> output = new ArrayDeque<Integer>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			output.push(node.val);
			if(node.left!=null) stack.push(node.left);
			if(node.right!=null) stack.push(node.right);
		}
		
		while(!output.isEmpty()){
			values.add(output.pop());
		}
		return values;
	}
	
	//****************Keep previous node*********************//
	/* Use previous node to */
	
	
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
