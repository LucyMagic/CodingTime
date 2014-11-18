import java.util.*;
public class CanJumpII {
	
	//*****************Solution1 DFS***********************//
    private int[] minSteps;
    private int arayLen;
    public int jumpDFS(int[] A) {
        arayLen = A.length;
        if(arayLen < 2)
            return 0;
        
        minSteps = new int[arayLen];
        for(int i = 0; i < arayLen; i++){
            minSteps[i] = Integer.MAX_VALUE;
        }
        dfs(A, 0, 0);
        return minSteps[arayLen-1];
    }
    
    private void dfs(int[] A, int index, int stepsSoFar){
        if(index>=arayLen-1){
            if(stepsSoFar < minSteps[arayLen-1]){
                minSteps[arayLen-1] = stepsSoFar;
            }
            return;
        }
        if(stepsSoFar >= minSteps[index]){
            return;
        }       
        int choices = A[index];
        for(int i = 1; i <= choices; i++){
            dfs(A, index+i, stepsSoFar+1);
        }
    }
    
	//*****************Solution2 BFS***********************//
    HashMap<Integer, Integer> steps;
    public int jumpBFS(int[] A) {
        steps = new HashMap<Integer, Integer>();
        bfs(A, 0);
        if(steps.containsKey(A.length-1)){
            return steps.get(A.length-1);
        }
        return -1;
    }
    
    private void bfs(int[] A, int index){
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(index);
        steps.put(index, 0);
        
        while(!queue.isEmpty()){
            int curIndex = queue.poll();
            int stepsSoFar = steps.get(curIndex);
            if(curIndex >= A.length -1)
                break;
            int choices = A[curIndex];
            for(int i = 1; i <= choices; i++){
                int nextIndex = curIndex + i;
                if(!steps.containsKey(nextIndex)){
                    queue.offer(nextIndex);
                    steps.put(nextIndex, stepsSoFar+1);   
                }
            }
        }
    }
    
    
    //*****************Solution 3*****************************//
    public int jump(int[] A) {
        int count = 0;
        int max = 0;
        for(int i=0; i<A.length; i++){
            if(max>=A.length-1) return count;
            int nextMax = max;
            for(int j=i; j<=max; j++){
                nextMax = Math.max(nextMax, j+A[j]);
            }
            count++;
            max=nextMax;
        }
        return -1;
    }
    
    //*****************Solution4***********************//
    /*
     * We use "last" to keep track of the maximum distance that has been reached
     * by using the minimum steps "ret", whereas "curr" is the maximum distance
     * that can be reached by using "ret+1" steps. Thus,
     * curr = max(i+A[i]) where 0 <= i <= last.
     */
    public int jump4(int[] A) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i > last) {
            	if(last>=curr) return -1;
                last = curr;
                ++ret; 
            }
            curr = Math.max(curr, i+A[i]);
        }
        return ret;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		int[] A = {3,2,1,0,4};
		CanJumpII jump = new CanJumpII();
		int i = jump.jump4(A);
		System.out.println(i);
	}

}
