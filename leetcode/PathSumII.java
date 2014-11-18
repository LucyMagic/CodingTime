import java.util.*;
public class PathSumII {

	private ArrayList<ArrayList<Integer>> paths;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> pathTo = new ArrayList<Integer>();
        dfs(root, pathTo, sum);
        return paths;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> pathTo, int sum){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            if(sum - root.val == 0){
                pathTo.add(root.val);
                process(pathTo);
                pathTo.remove(pathTo.size()-1);
            }
            return;
        }
        
        pathTo.add(root.val);
        dfs(root.left, pathTo, sum - root.val);
        dfs(root.right, pathTo, sum - root.val);
        pathTo.remove(pathTo.size()-1);
    }
    
    private void process(ArrayList<Integer> pathTo){
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.addAll(pathTo);
        paths.add(path);
    }
    
    private class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
//	      TreeNode(int x) { val = x; }
}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
