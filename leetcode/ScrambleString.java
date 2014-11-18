import java.util.*;
public class ScrambleString {
	
	
	
	//*****************Solution 2********************//
	//cleaner code but a little more stack space
	public boolean isScramble2(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(!isAnagram(s1, s2)) return false;
        
        int len1 = s1.length();
        int len2 = s2.length();
	//notice that we can't have the full string s1 as a choice
	//will result in stack overflow
        for(int i = 1; i < len1; i++){
            String s1left = s1.substring(0, i);
            String s1right = s1.substring(i);                        
            //no swap
            String s2left = s2.substring(0, i), s2right = s2.substring(i);
            if(isScramble2(s1left, s2left) && isScramble2(s1right, s2right))  
                    return true;
            //swap 
            s2left = s2.substring(0, len2-i); s2right = s2.substring(len2-i);
            if(isScramble2(s1left, s2right) && isScramble2(s1right, s2left))
                    return true;
        }
        return false;
    }
	
	//This one uses less stack space because we check for anagrams before recursion
    public boolean isScramble3(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1!=len2) return false;
        if(s1.equals(s2)) return true;
        
        for(int i = 1; i < len1; i++){
            String s1left = s1.substring(0, i);
            String s1right = s1.substring(i);
                        
            //no swap
            String s2left = s2.substring(0, i), s2right = s2.substring(i);
            if(isAnagram(s1left, s2left) && isAnagram(s1right, s2right)){
                if(isScramble3(s1left, s2left) && isScramble3(s1right, s2right))  
                    return true;
            }
            //swap 
            s2left = s2.substring(0, len2-i); s2right = s2.substring(len2-i);
            if(isAnagram(s1left, s2right) && isAnagram(s1right, s2left)){
                if(isScramble3(s1left, s2right) && isScramble3(s1right, s2left))
                    return true;
            }               
        }
        return false;
    }    
    private boolean isAnagram(String s1, String s2){
    	if(s1.length()!=s2.length()) return false;
    	if(s1.equals(s2)) return true;
    	
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        s1 = new String(chars1);
        s2 = new String(chars2);
        if(s1.equals(s2)) return true;
        return false;
    }
    //Counting sort to check for anagrams
    private boolean isAnagram1(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        
        int[] count = new int[26];
        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i)-'a']++;
        }
        for(int i = 0; i < s2.length(); i++){
            count[s2.charAt(i)-'a']--;
            if(count[s2.charAt(i)-'a']<0) return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
