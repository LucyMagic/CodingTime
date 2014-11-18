import java.util.*;

public class BinaryTreePreOrderTraversal {

	//**************Solution1 recursion********************//
	public ArrayList<Integer> preorderRec(TreeNode root){
		ArrayList<Integer> values = new ArrayList<Integer>();
		preorderRec(root, values);
		return values;
	}
	private void preorderRec(TreeNode root, ArrayList<Integer> values){
		if(root == null) return;
		values.add(root.val);
		preorderRec(root.left, values);
		preorderRec(root.right, values);
	}
	
	//**************Solution2 iteration********************//
	public ArrayList<Integer> preorderIteration(TreeNode root){
		if(root == null) return null;
		ArrayList<Integer> values = new ArrayList<Integer>();
		ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode current = root;
		while(true){
			values.add(current.val);
			if(current.right!=null) stack.push(current.right);
			if(current.left!=null) stack.push(current.left);
			
			if(stack.isEmpty()) break;
			current = stack.pop();
		}
		//a differnt way to write the code
//		stack.push(root);
//		while(!stack.isEmpty()){
//			TreeNode node = stack.pop();
//			values.add(node.val);
//			if(node.right!=null) stack.push(node.right);
//			if(node.left!=null) stack.push(node.left);
//		}
		return values;
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
