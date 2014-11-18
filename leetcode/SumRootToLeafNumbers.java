import java.util.*;
public class SumRootToLeafNumbers {
	//****************Solution 1: DFS only record sum*******************//
    private int totalSum;
	public int sumNumbers1(TreeNode root){
        totalSum = 0;
		dfs1(root, 0);
		return totalSum;
	}	
	private void dfs1(TreeNode root, int curSum){
		if(root == null) return;
		if(root.left == null && root.right== null){
			curSum = curSum*10 + root.val;
			totalSum += curSum;
		}		
        curSum = curSum*10 + root.val;
		dfs1(root.left, curSum);
		dfs1(root.right, curSum);
	}
	
	//************Solution 2 DFS with sum passed in as method arg*****************//
    public int sumNumbers2(TreeNode root) {
        return sumNumbers2(root, 0);
    }
    private int sumNumbers2(TreeNode root, int prevSum){
        if(root == null) return 0;
        
        int curSum = prevSum*10 + root.val;
        if(root.left == null && root.right == null) return curSum; 
        return sumNumbers2(root.left, curSum) + sumNumbers2(root.right, curSum);        
    }
	
	//**************Solution 2 BFS**************************//
	    public int sumNumbersBFS(TreeNode root) {
	    	if(root == null) return 0;
	        int totalSum = 0;
	        
	        ArrayDeque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
	        ArrayDeque<Integer> sumQueue = new ArrayDeque<Integer>();
	        nodeQueue.offer(root);
	        sumQueue.offer(root.val);
	        
	        while(!nodeQueue.isEmpty()){
	            TreeNode curNode = nodeQueue.poll();
	            int curSum = sumQueue.poll();
	            
	            if(curNode.left==null&&curNode.right==null){
	                 totalSum += curSum;
	                 continue;
	            }
	            
	            if(curNode.left!=null){
	                nodeQueue.offer(curNode.left);
	                sumQueue.offer(curSum*10+curNode.left.val);
	            }
	            
	            if(curNode.right!=null){
	                nodeQueue.offer(curNode.right);
	                sumQueue.offer(curSum*10+curNode.right.val);
	            }
	            
	        }	        
	        return totalSum;
	    }
	
	//*************Solution2 DFS record all paths*********************//
	private ArrayList<Integer> path;
    private int sum;
    public int sumNumbers(TreeNode root) {
        path = new ArrayList<Integer>();
        sum = 0;
        dfs(root, path);
        return sum;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> path){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            //this is a leaf node
            path.add(root.val);
            process(path);
            path.remove(path.size()-1);
            return;
        }        
        path.add(root.val);
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size()-1);
    }
    
    private void process(ArrayList<Integer> path){
        int number = 0;
        int numberOfDigits = path.size() - 1;
        for(int i = 0; i < path.size(); i++){        	
            number += path.get(i) * Math.pow(10, numberOfDigits - i);
        }        
        sum += number;
    }
    
    public class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		TreeNode n = s.new TreeNode(0);
		n.left = s.new TreeNode(1);
		n.right = s.new TreeNode(3);
		s.sumNumbers(n);
	}

}
