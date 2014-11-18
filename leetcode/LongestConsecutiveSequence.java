import java.util.*;
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
        if(num.length == 0) return 0;        
        int max = 0;
        Set<Integer> numbers = new HashSet<Integer>();
        for(int n : num){
            numbers.add(n);
        }        
        for(int n: num){
            max = Math.max(max, getCount(numbers, n));
        }       
        return max;
    }
    
    private int getCount(Set<Integer> numbers, int n){
        if(!numbers.contains(n)) return 0;        
        int count = 1;
        numbers.remove(n);
        int left = n-1;
        while(numbers.contains(left)){
            count++;
            numbers.remove(left);
            left--;
        }
        int right = n+1;
        while(numbers.contains(right)){
            count++;
            numbers.remove(right);
            right++;
        }
        return count;
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
