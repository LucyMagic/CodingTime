import java.util.*;
public class BinaryTreeLevelOrderTraversal {
	//*************************BFS 1 with 2 counts**************************//
	public ArrayList<ArrayList<Integer>> levelOrderBFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        if(root == null) return levels;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int parentCount = 1;
        int childrenCount = 0;
        ArrayList<Integer> oneLevel = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            oneLevel.add(node.val);
            parentCount--;
            
            if(node.left!=null){
                queue.offer(node.left);
                childrenCount++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                childrenCount++;
            }
            
            if(parentCount==0){
                levels.add(oneLevel);
                oneLevel = new ArrayList<Integer>();
                parentCount = childrenCount;
                childrenCount = 0;
            }
        }
        return levels;
    }

	//*************************BFS2 with 2 queues**************************//
	public ArrayList<ArrayList<Integer>> levelOrder2Queues(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        if(root == null) return levels;
        
        ArrayDeque<TreeNode> parentQueue = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> childQueue = new ArrayDeque<TreeNode>(); 
        parentQueue.offer(root);
        ArrayList<Integer> oneLevel = new ArrayList<Integer>();
        
        while(!parentQueue.isEmpty()){
            TreeNode node = parentQueue.poll();
            oneLevel.add(node.val);
            
            if(node.left!=null){
                childQueue.offer(node.left);
            }
            if(node.right!=null){
                childQueue.offer(node.right);
            }
            
            if(parentQueue.isEmpty()){
                levels.add(oneLevel);
                oneLevel = new ArrayList<Integer>();
                parentQueue = childQueue;
                childQueue = new ArrayDeque<TreeNode>();
            }
        }
        return levels;
    }
    
    //*************************DFS**************************//
	public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        if(root == null) return levels;
        
        levelOrderDFS(root, 1, levels);
        return levels;
    }
    private void levelOrderDFS(TreeNode root, int level, ArrayList<ArrayList<Integer>> levels){
        if(root == null) return;
        
        if(levels.size()<level){
            ArrayList<Integer> oneLevel = new ArrayList<Integer>();
            oneLevel.add(root.val);
            levels.add(oneLevel);
        }else{
            levels.get(level-1).add(root.val);
        }
        
        levelOrderDFS(root.left, level+1, levels);
        levelOrderDFS(root.right, level+1, levels);
    }
  //*************************End of DFS**************************//
    
    //*****************Print binary tree by level order****************//
    public void printLevelOrder(TreeNode root){
    	int height = maxHeight(root);
    	for(int i = 1; i <= height; i++){
    		printOneLevelDFS(root, i);
    		System.out.println();
    	}
    }
    private void printOneLevelDFS(TreeNode root, int level){
    	if(root==null) return;
    	if(level==1){
    		System.out.print(root.val + " ");
    		return;
    	}
    	printOneLevelDFS(root.left, level-1);
    	printOneLevelDFS(root.right, level-1);
    }
    private int maxHeight(TreeNode root){
    	if(root==null) return 0;
    	return Math.max(maxHeight(root.left), maxHeight(root.right))+1;
    }
    
    public class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLevelOrderTraversal bt = new BinaryTreeLevelOrderTraversal();
		TreeNode root = bt.new TreeNode(1);
		bt.levelOrderDFS(root);
		
	}

}
