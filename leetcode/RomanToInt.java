import java.util.*;
public class RomanToInt {
	private static final Map<Character, Integer> romanMap;
    static{
    	romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }  
    
    public int romanToIntPrev(String s){
    	int number = 0;
    	int prev = 10000;
        for(int i = 0; i < s.length(); i++){
            int current = romanMap.get(s.charAt(i));
            number += current;
            if(current > prev) number -= 2*prev;
            prev = current;
        }    	
    	return number;
    }
    
    public int romanToInt(String s) {
         int number = 0;        
         for(int i=0; i<s.length(); i++){
             int first = romanMap.get(s.charAt(i));
             int second = getNext(s, i);
             if(first<second){
                 number -= first;
             }else{
                 number += first;
             }
         }
         return number;
    }    
    private int getNext(String s, int index){
        if(index+1>s.length()-1)  return 0;
        return romanMap.get(s.charAt(index+1));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
