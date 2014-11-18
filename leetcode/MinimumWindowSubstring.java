import java.util.*;
public class MinimumWindowSubstring {

	public String minWindow(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        
        if(sLen==0 || tLen==0) return "";
        Map<Character, Integer> expectedCount = new HashMap<Character, Integer>();
        for(int i=0; i<tLen; i++){
            char c = T.charAt(i);
            if(!expectedCount.containsKey(c)){
                expectedCount.put(c, 1);
            }else{
                expectedCount.put(c, expectedCount.get(c)+1);
            }
        }
        
        int matchCount = 0;
        int minWindowSz = Integer.MAX_VALUE;
        int windBegin = -1, windEnd = -1;
        Map<Character, Integer> actualCount = new HashMap<Character, Integer>();
        for(char c : expectedCount.keySet()){
            actualCount.put(c,0);
        }
        
        for(int begin=0, end=0; end<sLen; end++){
            char c = S.charAt(end);
            if(!expectedCount.containsKey(c)) continue;
            actualCount.put(c, actualCount.get(c)+1);
            if(actualCount.get(c)<=expectedCount.get(c)){
                matchCount++;
            }
            //found a window
            if(matchCount==tLen){
                //advance begin index
                char b = S.charAt(begin);
                while(!expectedCount.containsKey(b) || actualCount.get(b)>expectedCount.get(b)){
                   if(expectedCount.containsKey(b) && actualCount.get(b)>expectedCount.get(b)){
                        actualCount.put(b,actualCount.get(b)-1);
                    } 
                    begin++;
                    b = S.charAt(begin);
                }
                //update window
                int window = end-begin+1;
                if(window<minWindowSz){
                    minWindowSz=window;
                    windBegin = begin; windEnd = end;
                }
            }
        }
        if(matchCount==tLen) 
            return S.substring(windBegin, windEnd+1);
        else
            return "";
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		mws.minWindow("ab", "b");
	}

}
