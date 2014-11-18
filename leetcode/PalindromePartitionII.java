import java.util.*;

public class PalindromePartitionII {

	//***************Solution 1******************//
	/* Refer to PalindromePartitioningI.java
	 * We could first compute all possible partitions, and then compare the size of them to return the smallest.
	 */
	
	//*********Using 2 DP ********************//
    public int minCut2DP(String s) {
        int n = s.length();
        int[] minCuts = new int[n+1];
        boolean[][] isPalin = new boolean[n][n];
        
        for(int i = 0; i < n+1; i++){
            minCuts[i] = n - i;
        }
        
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2||isPalin[i+1][j-1])){
                    isPalin[i][j] = true;
                    minCuts[i] = Math.min(minCuts[i], minCuts[j+1]+1); 
                }
            }
        }
        return minCuts[0]-1;
    }
	
	//*****************Solution 2 BFS alike********************//
	Map<Integer, Integer> cache;
    public int minCut(String s) {
        cache = new HashMap<Integer, Integer>();
    	return findMinCut(s);
    }
    
    private int findMinCut(String s){
        int count = 0; 
        ArrayList<Integer> startIndices = new ArrayList<Integer>();
        startIndices.addAll(findNextIndices(0, s, count));
        ArrayList<Integer> nextLevelIndices;
        
        while(!startIndices.isEmpty()){
            nextLevelIndices = new ArrayList<Integer>();
            while(!startIndices.isEmpty()){
                int index = startIndices.remove(startIndices.size()-1);
                if(index > s.length()-1) return count;
                nextLevelIndices.addAll(findNextIndices(index, s, count));
            }
            count++;
            startIndices = nextLevelIndices;
        }
        return count+1;
    }
    
    private ArrayList<Integer> findNextIndices(int index, String s, int count){
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                if(cache.containsKey(i) && cache.get(i)<count) continue;
                cache.put(i,count);
                indices.add(i);
            } 
        }
        return indices;
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
	
	
	//****************Solution 3 DFS alike*********************//
	/* Only record the partition which has the minimum number of cut 	 */
    public int minCutDFS(String s) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        findPartitions(0, s, 0, cache);
        return cache.get(s.length())-1;
    }
    
    private void findPartitions(int index, String s, int count, Map<Integer, Integer> cache){
        if(index == s.length()){
            return;
        }       
        for(String str : findPalindromesDFS(index, s)){
            int nextIndex = index+str.length();
            if(cache.containsKey(nextIndex) && cache.get(nextIndex) < count+1){
                continue;
            }
            cache.put(nextIndex, count+1);
            findPartitions(nextIndex, s, count+1, cache);
        }
    }
    
    private ArrayList<String> findPalindromesDFS(int index, String s){
        ArrayList<String> palindromes = new ArrayList<String>();
        for(int i = index; i < s.length(); i++){
            if(isPalindromeDFS(s, index, i)) 
                palindromes.add(s.substring(index, i+1));
        }
        return palindromes;
    }
    
    private boolean isPalindromeDFS(String s, int start, int end){
        while(start < end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitionII p = new PalindromePartitionII();
		int i = p.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(i);
	}

}
