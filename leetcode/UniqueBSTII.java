import java.util.*;
public class UniqueBSTII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTreesRec(1, n);
    }
	
	private ArrayList<TreeNode> generateTreesRec(int start, int end){
		ArrayList<TreeNode> bsts = new ArrayList<TreeNode>();
		
		if(start > end){
    	    bsts.add(null);
            return bsts;
		}		
		for(int i = start; i <= end; i++){
			ArrayList<TreeNode> leftSubtrees = generateTreesRec(start, i-1);
			ArrayList<TreeNode> rightSubtrees = generateTreesRec(i+1, end);
			for(TreeNode leftsub : leftSubtrees){
				for(TreeNode rightsub : rightSubtrees){
					TreeNode root = new TreeNode(i);
					root.left = leftsub;
					root.right = rightsub;
					bsts.add(root);
				}
			}
		}		
		return bsts;
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
