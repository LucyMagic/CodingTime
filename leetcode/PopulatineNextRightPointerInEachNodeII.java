public class PopulatineNextRightPointerInEachNodeII {

   //*************DFS, populate right sub tree first and then left********//
   public void connect(TreeLinkNode root) {
        if(root==null) return;
        
        //left
        if(root.left!=null){
            if(root.right!=null){
                root.left.next = root.right;
            }else{
                //find next
                TreeLinkNode current = root.next;
                while(current!=null&&current.left==null&current.right==null){
                    current = current.next;
                }
                if(current!=null){
                    root.left.next = current.left==null? current.right : current.left;
                }
            }
        }
        //right
        if(root.right!=null){
            TreeLinkNode current = root.next;
            while(current!=null&&current.left==null&current.right==null){
                current = current.next;
            }
            if(current!=null){
                root.right.next = current.left==null? current.right : current.left;
            }
        }
        
        connect(root.right);
        connect(root.left);
    }

   //**********BFS, works with any binary tree**********//
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        
        ArrayDeque<TreeLinkNode> parent = new ArrayDeque<TreeLinkNode>();
        parent.addLast(root);
        ArrayDeque<TreeLinkNode> children;
        while(!parent.isEmpty()){
            children = new ArrayDeque<TreeLinkNode>();
            while(!parent.isEmpty()){
                TreeLinkNode current = parent.removeFirst();
                current.next = parent.peek();
                if(current.left!=null){ 
                    children.addLast(current.left);
                }
                if(current.right!=null){
                    children.addLast(current.right);
                }
            }
            
            parent = children;
            children = new ArrayDeque<TreeLinkNode>();
        }
    }

	//****************Jianguo solution**************//
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode nextLevelHead = null;
        TreeLinkNode preNode = null;
        for (TreeLinkNode current = root; current != null; current = current.next) {
            if (current.left != null) {
                if (nextLevelHead == null) nextLevelHead = current.left;
                if (preNode != null) preNode.next = current.left;
                preNode = current.left;
            }
            if (current.right != null) {
                if (nextLevelHead == null) nextLevelHead = current.right;
                if (preNode != null) preNode.next = current.right;
                preNode = current.right;
            }
        }
        connect(nextLevelHead);
    }
	
	
	//****************Wrong solution**************//
	/* This solution is dfs and it will miss some of the links
	 * Correct solution needs a bfs
	 */
    public void connectWrong(TreeLinkNode root) {
        if(root==null) return;
        if(root.left!=null){
            if(root.right!=null) root.left.next = root.right;
            else{
                TreeLinkNode node = root;
                while(node.next!=null&&node.next.left==null&&node.next.right==null)
                    node = node.next;
                if(node.next!=null) 
                    root.left.next = (node.next.left==null) ? node.next.right : node.next.left;
            }
        }
        if(root.right!=null){
            TreeLinkNode node = root;
            while(node.next!=null&&node.next.left==null&&node.next.right==null)
                node = node.next;
            if(node.next!=null)
                root.right.next = (node.next.left==null) ? node.next.right : node.next.left;
        }
        connect(root.left);
        connect(root.right);
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
