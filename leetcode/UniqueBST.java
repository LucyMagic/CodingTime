import java.util.*;
public class UniqueBST {
    public int numTrees(int n) {
        if(n == 0)  return 0;            
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return numTreesDP(n, cache);
    }
    
    private int numTreesDP(int n, HashMap<Integer, Integer> cache){
        int count = 0;
        if(cache.containsKey(n)) return cache.get(n);
        if(n == 1 || n == 0) return 1;       
        for(int i = 0; i < n/2; i++){
            count += numTreesDP(i, cache) * numTreesDP(n-i-1, cache) * 2;
        }        
        if(n%2!=0){
            count += numTreesDP(n/2, cache) * numTreesDP(n/2, cache);
        }
        cache.put(n, count);
        return count;
    }
    
    //****************iteration*********************//   
    public int numTreesIteration(int n) {
        int[] numOfTrees = new int[n+1];
        numOfTrees[0] = 1;
    	numOfTrees[1] = 1;    
    	for(int i=2; i<=n; i++){
    		int count = 0;
    		for(int j=i-1; j>=0; j--){
    			count += numOfTrees[j] * numOfTrees[i-1-j];
    		}  		
    		numOfTrees[i] = count;
    	}    	
    	return numOfTrees[n];
    }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBST u = new UniqueBST();
		int num = u.numTrees(2);
		System.out.println(num);
	}

}
