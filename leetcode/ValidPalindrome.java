
public class ValidPalindrome {
	//******************Solution 1***************//
	//Call String API to covert the string to lower case to start
	public boolean isPalindrome1(String s) {
        int len = s.length();
        String str = s.toLowerCase();
        int i = 0, j = len-1;
        while(i < j){
        	//note to check boundaries before retrieving the characters
            while(i<j && !isAlphanumeric(str.charAt(i)))    i++;
            while(j > i && !isAlphanumeric(str.charAt(j)))  j--;
            
            if(str.charAt(i) != str.charAt(j))  return false;           
            i++; j--;
        }
        return true;
    }    
    private boolean isAlphanumeric(char c){
        if('a' <= c && c <= 'z' || '0' <= c && c <= '9')
            return true;
        else
            return false;
    }
    
    //******************Solution 2***************//
    //convert upper case to lower case as we move along the string
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0) return true;
        
        int lo = 0, hi = s.length()-1;
        while(true){
            while(lo<hi && !isValidChar(s.charAt(lo))) lo++;
            while(lo<hi && !isValidChar(s.charAt(hi))) hi--;
            if(lo>=hi) break;
            
            if(toLowercase(s.charAt(lo)) != toLowercase(s.charAt(hi))) 
                return false;
                
            lo++; hi--;
        }
        return true;
    }
    private boolean isValidChar(char ch){
        if(ch>='A'&&ch<='Z' || ch>='a'&&ch<='z' || ch>='0'&&ch<='9')
            return true;
        return false;
    }
    
    private char toLowercase(char ch){
        if(ch >= 'A' && ch <= 'Z') ch += 32;
        return ch;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
