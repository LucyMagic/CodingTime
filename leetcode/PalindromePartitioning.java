import java.util.*;
public class PalindromePartitioning {
	//**********All recursive calls use one ArrayList to store partitions, do clean up***********
	ArrayList<ArrayList<String>> partitions;
    ArrayList<String> onePartition;
    public ArrayList<ArrayList<String>> partition1(String s) {
        partitions = new ArrayList<ArrayList<String>>();
        if(s==null || s.isEmpty()) return partitions;
        onePartition = new ArrayList<String>();        
        partition(s, 0);
        return partitions;
    }
    private void partition(String s, int index){
        if(index==s.length()){
            ArrayList<String> result = new ArrayList<String>(onePartition);
            partitions.add(result);
            return;
        }
        
        for(int i = 1; i <= s.length()-index; i++){
            String substr = s.substring(index, index+i);
            if(isPalin(substr)){
                onePartition.add(substr);
                partition(s, index+i);
                onePartition.remove(onePartition.size()-1);//clean up
            }
        }
    }   
    private boolean isPalin(String s){
        int start = 0, end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) 
                return false;
            start++; end--;
        }
        return true;
    }
    
    //***************Solution 2 Recursion + DP memorization + DP palindrome calculation*******************//
    private Map<Integer, ArrayList<ArrayList<String>>> cache;
    public ArrayList<ArrayList<String>> partition2(String s) {
        cache = new HashMap<Integer, ArrayList<ArrayList<String>>>();
        return partition(s, 0, computePalins(s));
    }    
    private ArrayList<ArrayList<String>> partition(String s, int index, boolean[][] isPalin) {
        if(cache.containsKey(index)) return cache.get(index);
        ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>();
        if(index>=s.length()){
        	//Note that we need to add an empty ArrayList so that the previous recursive call can add result
            partitions.add(new ArrayList<String>());
            return partitions;
        }        
        for(int i = 0; i+index < s.length(); i++){
            if(isPalin[index][i+index]){
                for(ArrayList<String> list : partition(s, index+i+1, isPalin)){
                	//Note that we need to construct a new ArrayList, otherwise they all update the same references
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add(s.substring(index, index+i+1));
                    temp.addAll(list);
                    partitions.add(temp);
                }
            }
        }        
        cache.put(index, partitions);
        return partitions;
    }    
    private boolean[][] computePalins(String s){
        int length = s.length();
        boolean[][] isPalin = new boolean[length][length];
        //one char palindrome
        for(int i = 0; i < length; i++){
            isPalin[i][i] = true;
        }        
        //more chars
        for(int i = 1; i < length; i++){
            //even number of chars
            int left = i-1, right = i;
            while(left>=0&&right<length && s.charAt(left)==s.charAt(right)){
                isPalin[left][right] = true;
                left--; right++;
            }
            //odd number of chars
            left = i-1; right = i+1;
            while(left>=0&&right<length && s.charAt(left)==s.charAt(right)){
                isPalin[left][right] = true;
                left--; right++;
            }
        }
        return isPalin;
    }
    
   //***************Solution 2 Iteration for DP + DP palindrome calculation*******************//
    public ArrayList<ArrayList<String>> partition(String s) {        
        Map<Integer, ArrayList<ArrayList<String>>> cache 
                = new HashMap<Integer, ArrayList<ArrayList<String>>>();
                
        ArrayList<ArrayList<String>> lastPartition = new ArrayList<ArrayList<String>>();
        lastPartition.add(new ArrayList<String>());
        cache.put(s.length(), lastPartition);
        
        boolean[][] isPalin = computePalins(s);
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for(int i = s.length()-1; i >= 0; i--){
            result = new ArrayList<ArrayList<String>>();
            for(int j = i; j < s.length(); j++){
                if(isPalin[i][j]){
                    for(ArrayList<String> list : cache.get(j+1)){
                        ArrayList<String> partition = new ArrayList<String>();
                        partition.add(s.substring(i, j+1));
                        partition.addAll(list);
                        result.add(partition);
                    }   
                }
            }
            cache.put(i, result);
        }        
        return result;
    }
    

	//**************By passing in a new object to each recursive call with no cleaning up****************//
	ArrayList<ArrayList<String>> result1;
    public ArrayList<ArrayList<String>> partition4(String s) {
        result1 = new ArrayList<ArrayList<String>>();
        findPartitions1(0, s, new ArrayList<String>());
        return result1;
    }    
    private void findPartitions1(int index, String s, ArrayList<String> partition){
        if(index == s.length()){
            result1.add(partition);
            return;
        }       
        for(String str : findPalindromes1(index, s)){
            ArrayList<String> newPartition = new ArrayList<String>();
            newPartition.addAll(partition);
            newPartition.add(str);
            findPartitions1(index+str.length(), s, newPartition);
        }
    }   
    private ArrayList<String> findPalindromes1(int index, String s){
        ArrayList<String> palindromes = new ArrayList<String>();
        for(int i = index; i < s.length(); i++){
            if(isPalindrome1(s, index, i)) 
                palindromes.add(s.substring(index, i+1));
        }
        return palindromes;
    }    
    private boolean isPalindrome1(String s, int start, int end){
        while(start < end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning pp = new PalindromePartitioning();
		pp.partition1("a");
	}

}
