
public class InterleavingString {
	//********************************************//
    /* Use two dimension DP
     * Same idea as UniquePaths where we move a robot from (0,0) to (X,Y)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int M = s1.length();
        int N = s2.length();
        if(s3.length()!=M+N) return false;
        
        boolean[][] match = new boolean[M+1][N+1];
        match[0][0] = true;
        for(int i = 1; i <= M; i++){
            if(match[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1)) 
                match[i][0] = true;
        }        
        for(int j = 1; j <= N; j++){
            if(match[0][j-1]&&s2.charAt(j-1)==s3.charAt(j-1)) 
                match[0][j] = true;
        }
        
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if((match[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1)) || 
                   (match[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1))){
                        match[i][j] = true;
                }                    
            }
        }        
        return match[M][N];
    }
    
  //********************************************//
    /* Use two dimension DP
     * Use one dimensional array to store the result
     */
    public boolean isInterleaveDPLessSpace(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3==null) return false;
        int m = s1.length();
        int n = s2.length();
        if((m + n) != s3.length()) return false;
        
        boolean[] isInterleave = new boolean[n+1];
        isInterleave[0] = true;
        for(int j = 1; j <= n; j++){
            if(isInterleave[j-1] && s2.charAt(j-1)==s3.charAt(j-1)){
                isInterleave[j] = true;
            }
        }
        for(int i = 1; i <= m; i++){
            isInterleave[0] = isInterleave[0] && s1.charAt(i-1)==s3.charAt(i-1);
            for(int j = 1; j <= n; j++){
                if(isInterleave[j]&&s1.charAt(i-1)==s3.charAt(i+j-1)
                   || isInterleave[j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1)){
                    isInterleave[j] = true;
                }else{
                	isInterleave[j] = false;
                }
            }
        }        
        return isInterleave[n];
    }
	
  //*******************Recursion *************************//
    /*
     * Match the 3 strings from start to end, and move cursor forward when there is a match
     */    
    public boolean isInterleaveRecursion(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3==null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    private boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3){
        if(i3==s3.length()) return true;
        
        if(i1<s1.length() && s3.charAt(i3)==s1.charAt(i1)){
            if(isInterleave(s1, i1+1, s2, i2, s3, i3+1)) 
            	return true;
        }
        
        if(i2<s2.length() && s3.charAt(i3)==s2.charAt(i2)){
           if(isInterleave(s1, i1, s2, i2+1, s3, i3+1)) 
        	   return true; 
        }
        return false;
    }
    
	
	//********************************************//
    /*
     * Match the 3 strings from start and end towards middle, and move cursor forward when there is a match
     */
	private String s1, s2, s3;
    public boolean isInterleaveSlow2(String s1, String s2, String s3) {
    	if(s1==null || s2==null || s3==null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        return checkInterleave(0, s1.length()-1, 0, s2.length()-1, 0, s3.length()-1);
    }    
    private boolean checkInterleave(int start1, int end1, int start2, int end2, int start3, int end3){
        if(start3>end3) return true;
        
        if(start1>end1)
            return s3.substring(start3, end3+1).equals(s2.substring(start2, end2+1));
        if(start2>end2)
            return s3.substring(start3, end3+1).equals(s1.substring(start1, end1+1));        
        if(s3.charAt(start3) == s1.charAt(start1)){
            if(s3.charAt(end3)==s1.charAt(end1) && checkInterleave(start1+1, end1-1, start2, end2, start3+1, end3-1))
                return true;
            if(s2.charAt(end2) == s3.charAt(end3) && checkInterleave(start1+1, end1, start2, end2-1, start3+1, end3-1))
                return true;
        }        
        if(s3.charAt(start3) == s2.charAt(start2)){
            if(s3.charAt(end3)==s1.charAt(end1) && checkInterleave(start1, end1-1, start2+1, end2, start3+1, end3-1))
                return true;
            if(s2.charAt(end2) == s3.charAt(end3) && checkInterleave(start1, end1, start2+1, end2-1, start3+1, end3-1))
                return true;
        }        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString is = new InterleavingString();
		System.out.println(is.isInterleaveDPLessSpace("ab", "bc", "bbac"));
	}

}
