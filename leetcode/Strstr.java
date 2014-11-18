
public class Strstr {

	//*****************Solution 1 brute force*****************************//
    public String strStr1(String haystack, String needle) {
        if(haystack == null) return null;
        if(needle.isEmpty()) return haystack;
        
        int M = haystack.length(), N = needle.length();
        for(int i = 0; i <= M-N; i++){
            for(int j = 0; j < N; j++){
                char chNeedle = needle.charAt(j);
                char chHay = haystack.charAt(i+j);
                if(chNeedle!=chHay) break;
                if(j==N-1) return haystack.substring(i);                
            }
        }
        return null;
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
