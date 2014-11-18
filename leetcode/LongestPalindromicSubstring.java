import java.util.*;
public class LongestPalindromicSubstring {

	//****************O(N2)time O(1) space***********************//
    public String longestPalindrome1(String s) {
        int length = s.length();
        if(length == 0) return "";        
        int maxIndex = 0;
        int maxLen = 1;
        
        for(int i=0; i<length-1; i++){
            int curMax1 = findPalinStr(s, i, i);
            if(curMax1 > maxLen){
                maxLen = curMax1;
                maxIndex = i-curMax1/2;
            }
            int curMax2 = findPalinStr(s, i, i+1);
            if(curMax2>maxLen){
                maxLen = curMax2;
                maxIndex = i-curMax2/2+1;
            }
        }       
        return s.substring(maxIndex, maxIndex+maxLen);
    }
    
    private int findPalinStr(String s, int c1, int c2){
        int len = 0;
        if(c1 == c2)  len=-1;
        while(c1>=0 && c2<=s.length()-1 && s.charAt(c1)==s.charAt(c2)){
            c1--; c2++;
            len+=2;
        }
        return len;
    }
    
    //****************O(N2)time O(2N) space***********************//
    public String longestPalindrome2(String s) {
        int length = s.length();
        if(length == 0) return "";        
        int maxIndex = 0;
        int maxLen = 1;
        Map<Integer, Boolean> isPalin = new HashMap<Integer, Boolean>();
        
        for(int i=0; i<length; i++){
            isPalin.put(i*length+i, true);
        }
        for(int i=0; i<length-1; i++){
            int j = i+1;
            if(s.charAt(i)==s.charAt(j)){
                isPalin.put(i*length+j, true);
                maxLen = 2;
                maxIndex = i;
            }else{
                isPalin.put(i*length+j, false);
            }
        }
                       
        for(int len=3; len<=length; len++){
            for(int i=0; i<=length-len; i++){
                int j = i+len-1;
                int key = (i+1)*length+(j-1);
                if(isPalin.remove(key) && s.charAt(i)==s.charAt(j)){
                    isPalin.put(i*length+j, true);
                    maxLen = len;
                    maxIndex = i;
                }else{
                    isPalin.put(i*length+j, false);
                }
            }
        } 
        return s.substring(maxIndex, maxIndex+maxLen);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String sub = lps.longestPalindrome1("banana");
		System.out.println(sub);
	}

}
