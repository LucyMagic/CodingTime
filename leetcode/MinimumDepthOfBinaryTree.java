import java.util.*;
public class MinimumDepthOfBinaryTree {

	//****************DFS*******************//
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return minDepthHelper(root);
    }
    private int minDepthHelper(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return Math.min(minDepthHelper(root.right), minDepthHelper(root.left))+1;
    }
    
    //*****************BFS with 2 counters********************//
    public int minDepthBFSW2Counters(TreeNode root) {
        if(root==null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int height = 1;
        int curCnt = 1;
        int nextCnt = 0;
        
        while(curCnt!=0){
            TreeNode node = queue.poll();
            curCnt--;
            if(node.left==null&&node.right==null) break;
            if(node.left!=null){
                queue.offer(node.left);
                nextCnt++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextCnt++;
            }
            if(curCnt==0){
                height++;
                curCnt = nextCnt;
                nextCnt = 0;
            }
        }
        return height;
    }
    
    //*****************BFS with 2 queues********************//
    public int minDepthBFS2Queues(TreeNode root) {
        if(root == null) return 0;
        
        int height = 1;
        ArrayDeque<TreeNode> parents = new ArrayDeque<TreeNode>();
        parents.offer(root);
        ArrayDeque<TreeNode> children = new ArrayDeque<TreeNode>();
        
        while(!parents.isEmpty()){
            TreeNode node = parents.poll();
            if(node.left==null&&node.right==null) break;
            if(node.left!=null) children.offer(node.left);
            if(node.right!=null) children.offer(node.right);
            
            if(parents.isEmpty()){
                height++;
                parents = children;
                children = new ArrayDeque<TreeNode>();
            }
        }
        return height;
    }
    
    private class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
