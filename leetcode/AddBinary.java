
public class AddBinary {
	//More clean code
    public String addBinary(String a, String b) {
        if(a==null || b==null) return null;
        int aLen = a.length();
        int bLen = b.length();
        
        char[] result = new char[Math.max(aLen, bLen)];
        int i = aLen-1, j = bLen-1;
        int carrier = 0;
        
        for(int k = result.length-1; k >= 0; k--){        	
            int val1 = (i<0) ? 0 : a.charAt(i--)-'0';
            int val2 = (j<0) ? 0 : b.charAt(j--)-'0';
            
            int sum = val1+val2+carrier;
            carrier = sum/2;
            result[k] = (sum%2==0) ? '0' : '1';
        }
        
        String str = new String(result);
        return (carrier==0) ? str : '1'+str;
    }
	
	//*************Solution 1: like merge sort******************//
    public String addBinary1(String a, String b) {
        if(a==null||b==null) return null;
        int length = Math.max(a.length(), b.length());
        char[] result = new char[length];
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carrier = 0;
        for(int k = length - 1; k >= 0; k--){
            int sum = 0;
            if(i < 0) sum = (b.charAt(j--) - '0') + carrier;
            else if( j < 0) sum = (a.charAt(i--) - '0') + carrier;
            else sum = (b.charAt(j--) - '0') + (a.charAt(i--) - '0') + carrier;
            
            if(sum >= 2){
                carrier = 1; sum -= 2;
            }else{
                carrier = 0; 
            }
            
            if(sum == 0) result[k] = '0';
            else result[k] = '1';
        }
     
        return (carrier==1) ? "1"+new String(result) : new String(result);
    }
	
	
	//*************Solution 2******************//
	public String addBinary2(String a, String b) {
        if(a==null||b==null) return null;
        int aLen = a.length();
        int bLen = b.length();
        char[] result = new char[aLen>bLen?aLen:bLen];
        
        int i = aLen-1, j = bLen-1, k = result.length-1, carrier = 0;
        while(i>=0&&j>=0){
            int sum = (a.charAt(i)-'0') + (b.charAt(j)-'0') + carrier;
            if(sum>=2){
                carrier = 1;
                result[k--] = (char)(sum-2+'0');
            }else{
                carrier = 0;
                result[k--] = (char)(sum+'0');
            }            
            i--; j--;
        }
        if(i<0){
            a = b; i = j;
        }
        while(i>=0){
            int sum = (a.charAt(i)-'0') + carrier;
            if(sum>=2){
                carrier = 1;
                result[k--] = (char)(sum-2+'0');
            }else{
                carrier = 0;
                result[k--] = (char)(sum+'0');
            }            
            i--;
        }
        return (carrier==1)? "1"+new String(result) : new String(result);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
