import java.util.*;
public class DistinctSubsequences {
	//*******************Solution 2****************************//
	public int numDistinct(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();        
        if(sLen==0 || tLen==0) return 0;
        
        int[] distinctCount = new int[tLen];
        Map<Character, ArrayList<Integer>> tCharIndexMap= constructCharMap(T);
        
        for(int i = sLen-1; i>=0; i--){
            char c = S.charAt(i);
            if(tCharIndexMap.containsKey(c)){
                for(int j: tCharIndexMap.get(c)){
                    if(j==0){
                        distinctCount[j]++;                    
                    }else{
                        distinctCount[j] += distinctCount[j-1];
                    }
                }
            }
        }
        
        return distinctCount[tLen-1];
    }
    
    private Map<Character, ArrayList<Integer>> constructCharMap(String T){
        Map<Character, ArrayList<Integer>> charIndexMap = new HashMap<Character, ArrayList<Integer>>();
        for(int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            if(!charIndexMap.containsKey(c)){
                ArrayList<Integer> index = new ArrayList<Integer>();
                charIndexMap.put(c, index);
            }
            charIndexMap.get(c).add(T.length()-i-1);
        }
        return charIndexMap;
    }
	
	//*******************Solution 1****************************//
    public int numDistinct2(String S, String T) {
        if(S.length()==0 || T.length()==0) return 0;
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return findOccurance(S, 0, T, 0, cache);
    }
    
    private int findOccurance(String S, int index, String T, int d, Map<Integer, Integer> cache){
        int count = 0;
        int cacheKey = d*S.length()+index;
        if(cache.containsKey(cacheKey)){
            return cache.get(cacheKey);
        } 
        if(d==T.length()){
            return 1;
        } 
        
        for(int i=index; i<S.length(); i++){
            while(i<S.length() && S.charAt(i)!=T.charAt(d)){
                i++;
            }
            if(i!=S.length()){
                count += findOccurance(S, i+1, T, d+1, cache);
            }
        }   
        cache.put(cacheKey, count);
        return count;
    }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
