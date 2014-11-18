import java.util.*;

public class WildcardMatching {
	//******************Solution1 DP Using O(m) space********************//
    public boolean isMatchDPLessSpace(String s, String p) {
        if(s==null||p==null) return false;
        int m = p.length();
        int n = s.length();
        if(m==0) return n==0;
        
        int nonStarCount = 0;
        for(int i = 0; i < m; i++){
            if(p.charAt(i) != '*') 
                nonStarCount++;
        }
        if(nonStarCount > n) return false;
        
        
        boolean[] isMatch = new boolean[n+1];
        isMatch[0] = true;
        for(int i = 0; i < m; i++){
            char ch = p.charAt(i);
            if(ch == '*'){
                int k = 0;
                while(k<=n && isMatch[k]==false) k++;
                while(k<=n) isMatch[k++] = true;
            }else{
                for(int j = n; j > 0; j--){
                   if(isMatch[j-1] && (ch=='?' || ch==s.charAt(j-1))){
                        isMatch[j] = true;
                    }else{
                        isMatch[j] = false;
                    }                    
                }
                isMatch[0] = false;
            }
        }
        return isMatch[n];
    }
    
	
	//******************Solution1 DP Using O(M x N) space********************//
    //memory limit exceeded for leetcode
    public boolean isMatchDPMoreSpace(String s, String p) {
    	if(s==null||p==null) return false;
        int m = p.length();
        int n = s.length();
        if(m==0) return n==0;
        
        boolean[][] isMatch = new boolean[m+1][n+1];
        isMatch[0][0] = true;
        for(int i = 1; i <= m; i++){
            char ch = p.charAt(i-1);
            if(ch == '*'){
                int k = 0;
                while(k<=n && isMatch[i-1][k]==false) k++;
                while(k<=n) isMatch[i][k++] = true;
            }else{
                for(int j = 1; j <= n; j++){
                   if(isMatch[i-1][j-1] && (ch=='?' || ch==s.charAt(j-1))){
                        isMatch[i][j] = true;
                    }
                }
            }
        }
        return isMatch[m][n];
    }
		
  //******************Solution2 Greedy********************//
    public boolean isMatchGreedy(String s, String p) {
        if(s==null || p==null) return false;    
        
        int M = s.length(), N = p.length();
        int i = 0, j = 0;
        int pStarPos = -1;
        int sStarMatchPos = -1;
        while(i<M){
        	//update star position
            while(j<N && p.charAt(j)=='*'){ 
                pStarPos = j++;//position of star in p
                sStarMatchPos = i;//match 0 chars
            }            
            //needs backtracking
            if(j == N || (p.charAt(j)!='?'&&s.charAt(i)!=p.charAt(j))){
                if(pStarPos<0) return false;//can not backtrack without star
                j = pStarPos+1;
                i = ++sStarMatchPos;
            }else{//match one char
                i++; j++;
            }            
        }        
        while(j<N && p.charAt(j)=='*') j++;
        return j==N;
    }

    //******************Solution3 ********************//
	//Plain recursion with backtracking. Special handling for *, it can match 0-? number of characters
	public boolean isMatchRecursion(String s, String p) {
        if(s==null||p==null) return false;
        return isMatch(s, p, 0, 0);
    }
    private boolean isMatch(String s, String p, int sIndex, int pIndex){
        if(pIndex == p.length()) return sIndex == s.length();
        if(sIndex == s.length()){
            while(pIndex<p.length() && p.charAt(pIndex)=='*') pIndex++;
            return pIndex == p.length();
        }
        
        if(p.charAt(pIndex) == '*'){
            while(pIndex<p.length() && p.charAt(pIndex)=='*') pIndex++;
            for(int i = sIndex; i <= s.length(); i++){
                if(isMatch(s, p, i, pIndex)) return true;
            }
        }
        if(p.charAt(pIndex) == '?' || p.charAt(pIndex)==s.charAt(sIndex)){
            return isMatch(s, p, sIndex+1, pIndex+1);
        }        
        return false;
    }
    
    //**********Only recursion**************//
    //Recursion based on string instead of string index
    public boolean isMatch(String s, String p) {
        if(p.length()==0) return s.length()==0;
        if(s.length()==0) return isAllStar(p);
        
        if(p.charAt(0) == '*'){
            for(int j = 0; j <= s.length(); j++){
                if(isMatch(s.substring(j), p.substring(1)))
                    return true;
            }
        }        
        if(p.charAt(0) == '?' || p.charAt(0)==s.charAt(0))
            return isMatch(s.substring(1), p.substring(1));        
        return false;
    }
    private boolean isAllStar(String p){
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i)!='*') return false;
        }
        return true;
    }
   
    
    //******************Solution3 Recursion with memorization********************//
    public boolean isMatchMemorization(String s, String p) {
        if(s==null||p==null) return false;
        Map<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
        return isMatchMemorization(s, p, 0, 0, cache);
    }
    private boolean isMatchMemorization(String s, String p, int sIndex, int pIndex, Map<Integer, Boolean> cache){
        int key = sIndex*p.length()+pIndex*s.length();
        if(cache.containsKey(key))  return cache.get(key);
        if(pIndex==p.length())      return sIndex==s.length();
        if(sIndex==s.length()){
            while(pIndex<p.length()&&p.charAt(pIndex)=='*') pIndex++;
            return pIndex==p.length();
        }
        
        boolean match = false;
        char pChar = p.charAt(pIndex);
        if(pChar=='*'){
            while(pIndex<p.length() && p.charAt(pIndex)=='*') pIndex++;
            for(int i = 0; i <= s.length()-sIndex; i++){
                if(isMatchMemorization(s, p, sIndex+i, pIndex, cache)) {
                    match = true; break;
                }
            }
        }else{
            if(pChar=='?' || pChar == s.charAt(sIndex))
                match = isMatchMemorization(s, p, sIndex+1, pIndex+1, cache);
        }        
        cache.put(key, match);
        return match;
    }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching wm = new WildcardMatching();
//		boolean b = wm.isMatchDP("bbababababbababaaababbbaaababaaababbbbabaaaaabaabbaaababbbbabbabbbaaababbabbbbbbabbabababbbbabaabaabbaaaabbaaabaaabbaabababaababbaabbbbbabbbbabbbaabbabaaaaababbbaaabbbbabaababaaaababaaaabbbaaaaaababbaaba", "*ba**aa*aa*aa*bbba*baaba*ab*b*b*abb*b*bb*b*****a*bba**aa*b***b***aba**baa****b***a*b**ba*ba****a*aaa");
		boolean b = wm.isMatchDPLessSpace("aab","c*a*b");
		wm.isMatch("aa", "*");
		System.out.println(b);
		
	}

}
