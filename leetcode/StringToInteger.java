public class StringToInteger {
	//**********************Solution 1*****************//
	/*Use long to store number and check its range*/
    public int atoi1(String str) {
        if(str==null || str.length()==0) return 0;
        
        int start = 0;
        while(str.charAt(start)==' ') start++;
        
        int sign = 1;
        if(str.charAt(start)=='-') sign = -1;
        if(str.charAt(start)=='-' || str.charAt(start)=='+') start++;
        
        long number = 0;
        while(start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9'){
        	//Note that the order of statements matters a lot!!!
            number = number * 10 + (str.charAt(start) - '0');
            if((sign==-1) && -number <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if((sign==1) && number >= Integer.MAX_VALUE) return Integer.MAX_VALUE;            
            start++;
        }
        return sign * (int)number;         
    }
	
	//*****Solution 2********//
    //Use an integer to store the result and check for overflow when the integer is 9 digits long
	public int atoi2(String str) {
        if(str==null || str.length()==0) return 0;
        
        int start = 0;
        while(str.charAt(start)==' ') start++;
        
        boolean negative = false;
        if(str.charAt(start) == '-'){
            negative = true;
            start++;
        }else if(str.charAt(start) == '+'){
            start++;
        }
        
        int number = 0;
        while(start < str.length() && isDigit(str.charAt(start))){
            int digit = str.charAt(start) - '0';
            number = number * 10 + digit;
            //check for overflow possibility
            if(start+1<str.length() && isDigit(str.charAt(start+1))){
                if(number > 214748364){
                    if(negative) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
                if(number == 214748364){
                    if(negative && str.charAt(start+1) >= '8') 
                        return Integer.MIN_VALUE;
                    if(!negative && str.charAt(start+1) >= '7')
                        return Integer.MAX_VALUE;
                }
            } 
            
            start++;
        }
        if(negative) return -number;
        return number;
    }
    
    private boolean isDigit(char c){
        if(c >= '0' && c <= '9') return true;
        return false;
    }
    
    //**************Solution 3***************//
	
	public int atoi3(String str) {
        String number = findLegalNumber(str);
        if(number.length()==0) return 0;
        if(!isWithinRange(number)){
            if(number.charAt(0) == '-') return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }        
        return convertNumber(number);        
    }
    
    private int convertNumber(String str){
        char first = str.charAt(0);
        if(isSign(first)) str = str.substring(1);
        
        int number = 0;
        int div = 1;
        for(int i = str.length()-1; i >= 0; i--){
            int digit = str.charAt(i) - '0';
            number += digit*div;
            div *= 10;
        }
        if(first=='-') return -number;
        return number;
    }
    
    private boolean isWithinRange(String number){
        char first = number.charAt(0);
        if(isSign(first)) number = number.substring(1);
        int length = number.length();
        if(length>10) return false;
        if(length<10) return true;
        
        String bound;
        if(first == '-') bound = "2147483648";
        else bound = "2147483647";
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) > bound.charAt(i)) 
                return false;
            if(number.charAt(i) < bound.charAt(i)) 
                return true;
        }        
        return true;
    }
    
    private String findLegalNumber(String str){
        int i = 0;
        while(i<str.length() && str.charAt(i) == ' '){
            i++;
        }
        if(i==str.length() || !isSign(str.charAt(i)) && !isNumber(str.charAt(i))) 
        	return ""; 
        
        int j = i+1;
        while(j<str.length() && isNumber(str.charAt(j))){
            j++;
        }            
        if(j==i+1 && !isNumber(str.charAt(i))){
            return "";
        }
        return str.substring(i, j);
    }
        
    private boolean isNumber(char c){
        if(c >= '0' && c <= '9')
            return true;
        return false;
    }
    
    private boolean isSign(char c){
        if(c == '+' || c == '-')
            return true;
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger atoi = new StringToInteger();
//		atoi.atoi("1");
	}

}
