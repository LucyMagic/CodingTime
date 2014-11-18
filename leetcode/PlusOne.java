
public class PlusOne {

	public int[] plusOne(int[] digits) {
        int length = digits.length;
        int carrier = 1;
        
        for(int i = length - 1; i>=0; i--){
            int sum = digits[i] + carrier;
            digits[i] = sum%10;
            carrier = sum/10;
            if(carrier==0) break;
        }
        
        if(carrier == 1){
            int[] result = new int[length+1];
            result[0] = 1;
            for(int i = 0; i < length; i++){
                result[i+1] = digits[i];
            }
            return result;
        }
        
        return digits;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
