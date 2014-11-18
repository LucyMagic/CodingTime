public class ReverseInteger {  
    public int reverse(int x) {
        long reversed = 0;
        while(x!=0){
            reversed = reversed*10+x%10;
            x /= 10;
        }             
        return (int)reversed;
    }
    
    //java actually helps to do the check when converting long to int
//  if(reversed >= Integer.MAX_VALUE)
//      return Integer.MAX_VALUE;
//  if(reversed <= Integer.MIN_VALUE)
//      return Integer.MIN_VALUE;  
	
    public int reverse2(int x) {
        long result = 0;
        int sign = 1;
        if(x < 0){
            if(x==Integer.MIN_VALUE) return x;
            sign = -1;
            x = -x;
        }
        
        while(x > 0){
            result = result*10 + x%10;
            x = x/10;
        }
        
        if(result > Integer.MAX_VALUE)
            return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        return sign*(int)result;
    }

    //first find all the digits, and then compute the reversed number
    public int reverse3(int x) {
        if(x==0){
            return 0;
        }
        
        //-123
        boolean negative = x>0 ? false : true;
        List<Integer> digits = new ArrayList<Integer>(10);
        while(x!=0){
            int digit = x%10;
            if(negative){
                digit = -digit;
            }
            digits.add(digit);
            x=x/10;
        }
        
        int number = 0;
        for(int digit : digits){
            //check overflow
            if(number>=214748364){
                if(negative&&digit>=8){
                    return Integer.MIN_VALUE;
                }
                if(!negative&&digit>=7){
                    return Integer.MAX_VALUE;
                }
            }
            number = number*10+digit;
        }
        
        return negative? -number : number;
    }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(Integer.MIN_VALUE));
	}

}
