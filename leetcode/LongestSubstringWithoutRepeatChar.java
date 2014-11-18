import java.util.*;
public class LongestSubstringWithoutRepeatChar {

    //**********more concise solution****//
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        
        Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
        int max = 0, startIndex=-1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(indexMap.containsKey(ch)&&indexMap.get(ch)>startIndex){
                startIndex = indexMap.get(ch);
            }
            indexMap.put(ch, i);
            max = Math.max(max, i-startIndex);
        }
        return max;
    }

	//*********old solution***********//
	public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<Character, Integer>();
        int longestLen = 0;
        
        int start = 0, curLen = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!chars.containsKey(c)){
            	curLen++;
            }else{
                int prevIndex = chars.get(c);
                updateMap(s, start, prevIndex, chars);
                start = prevIndex+1;
                if(curLen > longestLen){
                    longestLen = curLen;                    
                }
                curLen=i-prevIndex;
            }
            chars.put(c, i);
        }
        if(longestLen < curLen){
        	longestLen = curLen;
        }
        return longestLen;
    }
    
    private void updateMap(String s, int start, int end, Map<Character, Integer> chars){
        for(int i=start; i<=end; i++){
            chars.remove(s.charAt(i));
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatChar l = new LongestSubstringWithoutRepeatChar();
		int i = l.lengthOfLongestSubstring("abcabcbb");
		System.out.println(i);
	}

}
