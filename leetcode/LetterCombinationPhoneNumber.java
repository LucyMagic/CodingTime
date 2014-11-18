import java.util.*;
public class LetterCombinationPhoneNumber {
	//********************Solution 1**********************//
    private char[] combination;
    private ArrayList<String> result;
    private static final char[][] numLetterMap = {{' '}, {}, {'a', 'b', 'c'},
    											  {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
    											  {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
    											  {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
   
    public ArrayList<String> letterCombinations(String digits) {
         result = new ArrayList<String>();
         combination = new char[digits.length()];
         getCombinations(0, digits);         
         return result;
    }
    private void getCombinations(int index, String digits){
        if(index == digits.length()){
            result.add(new String(combination));
            return;
        }        
         char c = digits.charAt(index);
         char[] letters = numLetterMap[c-'0'];
         for(int j = 0; j < letters.length; j++){
             combination[index] = letters[j];
             getCombinations(index+1, digits);
         }
    }
	
	
	//********************Solution2 **********************//
	private static final HashMap<Character, char[]> map = 
            new HashMap<Character, char[]>();
    private ArrayList<String> results;
    
    static{
            map.put('0', new char[]{' '});
            map.put('1', new char[]{});
            map.put('2', new char[]{'a', 'b', 'c'});
            map.put('3', new char[]{'d', 'e', 'f'});
            map.put('4', new char[]{'g', 'h', 'i'});
            map.put('5', new char[]{'j', 'k', 'l'});
            map.put('6', new char[]{'m', 'n', 'o'});
            map.put('7', new char[]{'p', 'q', 'r', 's'});
            map.put('8', new char[]{'t', 'u', 'v'});
            map.put('9', new char[]{'w', 'x', 'y','z'});
    }


    public ArrayList<String> letterCombinations2(String digits) {
    	results = new ArrayList<String>();
    	enumerate("", digits);
    	return results;
    }

    private void enumerate(String prefix, String rest){
    	if(rest.length() == 0){
    		results.add(prefix);
    		return;
    	}
    	
    	char num = rest.charAt(0);
    	char[] letters = map.get(num);
    	for(char c : letters){
    		enumerate(prefix+c, rest.substring(1));
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
