import java.util.*;
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> strAnagramMap = 
            new HashMap<String, ArrayList<String>>();
            
        for(String str: strs){
            String sorted = sortString(str);
            if(strAnagramMap.containsKey(sorted)){
            	strAnagramMap.get(sorted).add(str);
            }else{
            	strAnagramMap.put(sorted, new ArrayList<String>(Arrays.asList(str)));
            }
        }
        
        ArrayList<String> result = new ArrayList<String>();   
        for(ArrayList<String> strings : strAnagramMap.values()){
            if(strings.size()>1){
                result.addAll(strings);
            }
        }
        return result;
    }
    
    private String sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    private String getLabel(String str){
    	int[] counts = new int[26];
    	for(char c : str.toCharArray()){
    		counts[c-'a']++;
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int index = 0; index < counts.length; index++){
    		if(counts[index]==0) continue;
    		sb.append('a' + index);
    		sb.append(counts[index]);
    	}
    	return sb.toString();
    }
    
    //**********Solution 2***************//
    //does not work with leetcode constraints
    public ArrayList<String> anagrams2(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if(strs==null || strs.length==0) return result;
        
        Comparator<String> byAnagram = new Comparator<String>(){
            public int compare(String s1, String s2){
                char[] chars1 = s1.toCharArray();
                char[] chars2 = s2.toCharArray();
                Arrays.sort(chars1);
                Arrays.sort(chars2);
                String a1 = new String(chars1);
                String a2 = new String(chars2);
                return a1.compareTo(a2);
            }  
        };
        
        Arrays.sort(strs, byAnagram);
        for(String s : strs){
            if(!s.equals(""))  result.add(s);
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
