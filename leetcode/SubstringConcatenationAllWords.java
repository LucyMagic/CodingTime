import java.util.*;
public class SubstringConcatenationAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int numWords = L.length;
        if(numWords==0) return result;
        int wordLength = L[0].length();
        int concatLen = numWords*wordLength;
        if(S.length()<concatLen) return result;
               
        Map<String, Integer> wordExpectCount = constructMap(L);
        for(int i=0; i<S.length()-concatLen+1; i++){
            int j= 0;
            Map<String, Integer> wordRealCount = new HashMap<String,Integer>();
            while(j<numWords){
                String sub = S.substring(j*wordLength+i, (j+1)*wordLength+i);
                if(!wordExpectCount.containsKey(sub)) break;
                else{
                    if(!wordRealCount.containsKey(sub)){
                        wordRealCount.put(sub,1);
                    }else if(wordRealCount.containsKey(sub) && wordExpectCount.get(sub)>wordRealCount.get(sub)){
                		wordRealCount.put(sub,wordRealCount.get(sub)+1);
                	}else{
                	    break;	
                	}
                }
                j++;
            }
            if(j==numWords) result.add(i);
        }
        return result;
    }
    
    private Map<String, Integer> constructMap(String[] L){
    	 Map<String, Integer> wordMap = new HashMap<String,Integer>();
         for(String s: L){
         	if(wordMap.containsKey(s)){
         		wordMap.put(s, wordMap.get(s)+1);
         	}else
         		wordMap.put(s, 1);
         }
         return wordMap;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringConcatenationAllWords c = new SubstringConcatenationAllWords();
		String[] L = new String[]{"a","a"};
		c.findSubstring("aaa", L);
	}

}
