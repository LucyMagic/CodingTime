import java.util.*;
public class BinaryTreeLevelOrderTraversalBottom {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return results;
        
        ArrayDeque<TreeNode> parents = new ArrayDeque<TreeNode>();
        parents.offer(root);       
        ArrayDeque<TreeNode> children = new ArrayDeque<TreeNode>();
        
        while(!parents.isEmpty()){
            ArrayList<Integer> result = new ArrayList<Integer>();
            children = new ArrayDeque<TreeNode>();
            while(!parents.isEmpty()){
                TreeNode node = parents.poll();
                result.add(node.val);
                if(node.left!=null)
                    children.offer(node.left);
                if(node.right!=null)
                children.offer(node.right);            
            }
            results.add(result);
            parents = children;
        }
        reverse(results);
        return results;
    }
    
    private void reverse(ArrayList<ArrayList<Integer>> results){
        int start = 0, end = results.size() - 1;
        while(start < end){
            ArrayList<Integer> temp = results.get(start);
            results.set(start, results.get(end));
            results.set(end, temp);
            start++; end--;
        }
    }
    
  //*************************DFS**************************//
    //ArrayDeque will be a better choice since no shifting is needed
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
        result = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if(root == null)	return;
            
        ArrayList<Integer> levelList;
        if(result.size() == level){
            levelList = new ArrayList<Integer>();
            result.add(0, levelList);
        }        
        levelList = result.get(result.size() - 1 - level);
        levelList.add(root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
  //*************************End of DFS**************************//
    
    public class TreeNode {
   	 int val;
   	 TreeNode left;
   	 TreeNode right;
   	 TreeNode(int x) { val = x; }
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLevelOrderTraversalBottom bt = new BinaryTreeLevelOrderTraversalBottom();
		TreeNode root = bt.new TreeNode(1);
		bt.levelOrderBottom(root);
		
	}


}
