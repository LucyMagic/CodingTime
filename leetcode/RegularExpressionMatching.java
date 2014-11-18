import java.util.*;
public class RegularExpressionMatching {
	//***************Solution 1 one dimensional DP*************//
	public boolean isMatch1DDP(String s, String p) {
        if(s==null||p==null) return false;
        int n = s.length(), m = p.length();
        if(m==0) return n==0;
        
        boolean[] isMatch = new boolean[n+1];
        isMatch[0] = true;
        for(int i = 0; i < m; i++){
            if(i+1<m && p.charAt(i+1)=='*'){
            	for(int j = 1; j <= n; j++){
                    if(isMatch[j-1] && (p.charAt(i)=='.' || p.charAt(i)==s.charAt(j-1)))
                		isMatch[j] = true;
                }
                i++;
            }else{
                for(int j = n; j > 0; j--){
                    if(isMatch[j-1] && (p.charAt(i)=='.'||p.charAt(i)==s.charAt(j-1))){
                        isMatch[j] = true;
                    }else{
                        isMatch[j] = false;
                    }
                }
                isMatch[0] =false;
            }
        }        
        return isMatch[n];
    }
	
	
	//*************Solution 2 recursion******************//
    public boolean isMatchRecSol2(String s, String p) {
        if(s==null||p==null) return false;
        return isMatchRecSol2(s, 0, p, 0);
    }    
    private boolean isMatchRecSol2(String s, int ss, String p, int pp){
        if(pp==p.length()) return ss==s.length();
        
        if(pp+1<p.length() && p.charAt(pp+1)=='*'){
            //match 0 chars
            if(isMatchRecSol2(s, ss, p, pp+2)) 
                return true;
            
            //match more
            while (p.charAt(pp) == '.' || (ss<s.length()&&s.charAt(ss) == p.charAt(pp))) {
                if (ss == s.length()) return isMatchRecSol2(s, ss, p, pp + 2);
                if (isMatchRecSol2(s, ++ss, p, pp+2)) return true;                
            }           
        }
        
        if(ss<s.length() && (p.charAt(pp) == '.' || p.charAt(pp)==s.charAt(ss))){
            return isMatchRecSol2(s, ss+1, p, pp+1);
        }
        
        return false;
    }
	
	//*************Solution 3 Automata******************//
	public boolean isMatchRecursion(String s, String p) {
        return recognize(s, 0, p, 0);
    }
    private boolean recognize(String s, int sp, String p, int pp){
        if(sp == s.length() && pp == p.length()) return true;
        if(sp != s.length() && pp == p.length()) return false;
        if(sp == s.length() && pp != p.length()){
            while(pp <= p.length()-2 && p.charAt(pp+1)=='*') pp+=2;
            if(pp == p.length()) return true;
            return false;
        }
        
        if(pp+1<p.length() && p.charAt(pp+1) == '*'){
            if(p.charAt(pp) != '.' && p.charAt(pp) != s.charAt(sp))
                return recognize(s, sp, p, pp+2);
            return recognize(s, sp+1, p, pp) || recognize(s, sp, p, pp+2);
        }else if(p.charAt(pp) == '.' || p.charAt(pp)==s.charAt(sp)){
            return recognize(s, sp+1, p, pp+1);
        } 
        
        return false;
    }
	
	
	public boolean isMatchIteration(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        if(s.length() != 0 && p.length() == 0) return false;
        
        return recognize(s, p);
    }
    
    private boolean recognize(String s, String p){
        Set<Integer> states = getAllReachableStates(0, p);
        
        //match each char in string s
        Set<Integer> newStates;
        for(int i = 0; i < s.length(); i++){
            newStates = new HashSet<Integer>();
            
            for(int state : states){
                if(state == p.length()) continue;
                if(p.charAt(state)=='.' || s.charAt(i)==p.charAt(state))
                    newStates.add(state+1);
            }
            
            states = new HashSet<Integer>();
            for(int state : newStates){
                if(!states.contains(state))
                    states.addAll(getAllReachableStates(state, p));   
            }
        }
        
        for(Integer statenum : states){
            if(statenum == p.length()) return true;
        }
        return false;
    }
    
    private Set<Integer> getAllReachableStates(int start, String p){
        Set<Integer> states = new HashSet<Integer>();
        states.add(start);
        if(p.length() == 1) return states; 
    
        while(start < p.length() - 1){
            if(p.charAt(start)!='*' && p.charAt(start+1)!='*') break;
            if(p.charAt(start)=='*'){
                if(start-1 >= 0) states.add(start-1);
                if(start+1 <= p.length()) states.add(start+1);
            }
        	start++;
        }

        if(start == p.length()-1 && p.charAt(start) == '*'){
            states.add(start-1); states.add(start+1);
        } 
        return states;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching rem = new RegularExpressionMatching();
		boolean b = rem.isMatch1DDP("aaca", "ab*a*c*a");
		System.out.println(b);
	}

}
