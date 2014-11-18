
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n];
        
        for(int i = m-1; i >= 0; i--){
            int d1 = num1.charAt(i) - '0';
            int carrier = 0;
            for(int j = n - 1; j >= 0; j--){
                int d2 = num2.charAt(j) - '0';
                int res = d1*d2 + result[i+j+1];
                carrier = res/10;
                result[i+j+1] = res%10;
                if(carrier > 0) result[i+j] += carrier;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i: result){
            if(i==0 && sb.length()==0) continue;
            sb.append(i);
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = MultiplyStrings.multiply("123", "456");
	}

}
