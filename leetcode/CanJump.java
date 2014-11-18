import java.util.*;
public class CanJump {
	//******************Solution 1*****************//
	//Keep track of a range, especially the upper bound to see if the end is reached
    public boolean canJumpRange(int[] A) {
        int max = 0;
        int N = A.length;
        for(int i=0; i<=max; i++){
            max = Math.max(max, A[i]+i);
            if(max>=N-1) return true;
        }
        return false;
    }
	
	//******************Solution 2*****************//
	//Scan from end to start for zeros and see if any index can reach or get over the zero
	public boolean canJumpFindZeros(int[] A) {
        if(A.length<2) return true;
        
        int index = A.length-1;
        while(true){
            int zeroIndex = getNextZero(A, index);
            if(zeroIndex<0) return true;
            if(zeroIndex==A.length-1){
                index = reachIndex(A, zeroIndex);
            }else{
                index = overIndex(A, zeroIndex);
            }
            if(index<0) return false;
        }
    }
    private int reachIndex(int[] A, int index){
        int start = index-1;
        while(start>=0 && A[start]<(index-start))
            start--;
        return start;
    }
    private int overIndex(int[] A, int index){
        int start = index-1;
        while(start>=0 && A[start]<=(index-start))
            start--;
        return start;
    }
    private int getNextZero(int[] A, int index){
        while(index>=0&&A[index]!=0){
            index--;
        }
        return index;
    }
	
	
	
	//******************Solution 3*****************//
	//Simple DFS
    Set<Integer> cannotJump;
    public boolean canJumpDFS(int[] A) {
        cannotJump = new HashSet<Integer>();
        return canJump(A, 0);
    }
    private boolean canJump(int[] A, int index){
        if(index >= A.length-1) return true;
        if(A[index]==0||cannotJump.contains(index)) return false;
        
        for(int i=A[index]; i>=1; i--){
            if(canJump(A, index+i))
                return true;
        }
        cannotJump.add(index);
        return false;
    }
	
	/*This approach takes the maximum number of jumps at each step
	* It does not work for the following case {1, 2, 3, 0, 1}
	*/   
    public boolean canJumpWrong(int[] A) {     
        int i = 0;
        while(i<A.length-1){
            int jump = A[i];          
            if(jump == 0){
                return false;
            }
            i += jump;
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CanJump cj = new CanJump();
		int[] A = {2,0};
		boolean b = cj.canJumpRange(A);
		System.out.println(b);
	}

}
