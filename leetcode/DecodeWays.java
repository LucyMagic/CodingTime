import java.util.*;
public class DecodeWays {
	//****************Solution 1 DP with iteration******************//
	//Note that this question is similar to "Fibonacci numbers", only need to save previous 2 values
    public int numDecodingsIteration(String s) {
        if(s == null || s.isEmpty()) return 0;
        if(s.charAt(0)=='0') return 0;
        
        int prev1 = 1, prev2 = 1;        
        for(int i = 2; i <= s.length(); i++){
            char c1 = s.charAt(i-2);
            char c2 = s.charAt(i-1);
            
            int count = 0;
            if(c2>'0')    count += prev2; 
            if(isValidTwoDigit(c1, c2))  count += prev1;
            
            if(count==0) return 0;
            prev1=prev2; prev2=count;
        }
        return prev2;
    }
    
    private boolean isValidTwoDigit(char c1, char c2){
        if(c1=='1') return true;
        if(c1=='2' &&  c2<='6') return true;
        return false;
    }
	
	//****************Solution 1 DP with recursion******************//
    private Map<Integer, Integer> cache;
    public int numDecodingsBetter(String s) {
        if(s == null || s.length() == 0) return 0;
        cache = new HashMap<Integer, Integer>();
        return countWays(s, 0);
    }    
    private int countWays(String s, int index){
        if(index == s.length()) return 1;
        if(index > s.length() || s.charAt(index) == '0') return 0;
        if(cache.containsKey(index)) return cache.get(index);
        
        int count = 0;
        count += countWays(s, index+1);
        if(isValidTwoDigitNum(s, index)) count += countWays(s, index+2);
        cache.put(index, count);
        return count;
    }    
    private boolean isValidTwoDigitNum(String s, int index){
        if(index+1>=s.length()) return false;
        if(s.charAt(index) == '1') return true;
        if(s.charAt(index) == '2' && s.charAt(index+1) <= '6') return true;
        return false;
   }
	
    //****************Solution 2 Not as good******************//
	private HashMap<String, Integer> cacheNotGood;
    public int numDecodingsNotGood(String s) {
    	cacheNotGood = new HashMap<String, Integer>();
        if(s.length() == 0)
            return 0;
        
        return dfs(s, 0);
    }
    
    private int dfs(String s, int count){
        if(cacheNotGood.containsKey(s)){
            return cacheNotGood.get(s);
        }
        
        int length = s.length();
        if(length == 0){
            return 1;
        }
        
        if(s.charAt(0)!='0'){
            count += dfs(s.substring(1), count);
        }
        if(length>1 && isValid(s.substring(0,2))){
            count += dfs(s.substring(2), count);
        }
        cacheNotGood.put(s, count);
        return count;
    }
    
    private boolean isValid(String s){
        if(s.startsWith("0"))
            return false;
        int num = Integer.parseInt(s);
        if(1 <= num && num <= 26)
            return true;
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays dw = new DecodeWays();
		int i = dw.numDecodingsIteration("10");
		System.out.println(i);
	}

}
