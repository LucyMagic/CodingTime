import java.util.*;

public class ClimbStairs {
	
	//**********Recursion + DP memorization****************//
    public int climbStairs(int n) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return climbStairsDP(n, cache);
    }    
    private int climbStairsDP(int n, HashMap<Integer, Integer> cache){
        if(cache.containsKey(n)) return cache.get(n);
        if(n==0 || n==1) return 1;
        
        int count = climbStairsDP(n-1, cache) + climbStairsDP(n-2, cache);
        cache.put(n, count);
        return count;
    }
    
    //*************Solution2 bottom up DP*********************//
    public int climbStairs2(int n){
    	if(n==0 || n == 1) return 1;
    	
    	int p1 = 1, p2 = 1;
    	for(int i = 2; i < n; i++){
    		p2 = p1 + p2;
    		p1 = p2 - p1;
    	}
    	return p2;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
