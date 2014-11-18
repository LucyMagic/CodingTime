import java.util.*;
public class BinaryTreeZigZagOrderTraversal {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;
        
        ArrayDeque<TreeNode> currentLevel = new ArrayDeque<TreeNode>();
        currentLevel.push(root);
        ArrayDeque<TreeNode> nextLevel;
        boolean leftToRight = true;        
        ArrayList<Integer> oneLevelResult;
        
        while(!currentLevel.isEmpty()){
            oneLevelResult = new ArrayList<Integer>();
            nextLevel = new ArrayDeque<TreeNode>();
            while(!currentLevel.isEmpty()){
                TreeNode curNode = currentLevel.pop();
                oneLevelResult.add(curNode.val);
                TreeNode firstChild, secondChild;
                if(leftToRight){
                    firstChild = curNode.left;
                    secondChild = curNode.right;
                }else{
                    firstChild = curNode.right;
                    secondChild = curNode.left;
                }
                if(firstChild!=null)
                    nextLevel.push(firstChild);
                if(secondChild!=null)
                    nextLevel.push(secondChild);
            }
            
            leftToRight = leftToRight ? false : true;
            result.add(oneLevelResult);
            currentLevel = nextLevel;
        }
        
        return result;
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
