import java.util.*;
public class PopulatineNextRightPointerInEachNode {
	//*****************Solution 1 BFS *************//
	//Note the next pointer in each node is originally null. 
	//Unless we want to change it, we don't have to do anything
	public void connectBFS(TreeLinkNode root) {
        if(root == null) return;        
        ArrayDeque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeLinkNode cur = queue.poll();
            if(cur.left!=null){
                queue.offer(cur.left);
                cur.left.next = cur.right;
            }
            if(cur.right!=null){
                queue.offer(cur.right);
                if(cur.next!=null) //otherwise just leave it as null
                    cur.right.next = cur.next.left;
            }
        }
    }

    //****************Solution 2 DFS preorder traversal****************//
    /* root.next is already known by the time we are down in the tree
     * As we move down the tree, we populate the first part of the tree which has enough 
     * information for the subsequent recursion
     * 
     * Note the need to perform preorder as we need to populate the pointers for some nodes in prev level
     */
    public void connectDFS2(TreeLinkNode root) {
    	//base case
        if (root == null || root.left == null) return;
        
        //populate current nodes
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        
        //recursion
        connectDFS2(root.left);
        connectDFS2(root.right);      
    }
    
    //****************Solution 2 recursive BFS****************//
    //This is possible because we have a next pointer in each node
    //and this saves us the space for the queue. 
    public void connectRecursiveBFS(TreeLinkNode root) {
        if(root == null) return;
        if(root.left==null || root.right == null) return;
        
        for(TreeLinkNode current = root; current!=null; current=current.next){
            current.left.next = current.right;
            if(current.next!=null) 
                current.right.next = current.next.left;
        }
        
        //start the next level
        connectRecursiveBFS(root.left);
    }
    
    
    public class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
    	TreeLinkNode(int x) { val = x; }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
