
public class Division {

    public int divideShift(int dividend, int divisor) {
        assert(divisor!=0);
        
        long dvd = (long)Math.abs((double)dividend);
        long dvs = (long)Math.abs((double)divisor);
        int result = 0;
        while(dvd>=dvs){
            long temp = dvs;
            for(int i = 0; dvd >= temp; i++){
                dvd -= temp;
                result += (1 << i);
                temp <<= 1;
            }
        }
        return ((dividend^divisor) >> 31) == 0 ? result : -result;
    }
	
    public int divideAdd(int dividend, int divisor) {
    	 if(divisor==0)
             throw new java.lang.ArithmeticException("ERROR");
    	 
         int absDividend = Math.abs(dividend);
         int absDivisor = Math.abs(divisor);              
         int quotient = 0;
         while(absDividend >= absDivisor){
         	absDividend -= absDivisor;
         	quotient++;
         }
         
         if(dividend>0&&divisor>0 || dividend<0&&divisor<0)
             return quotient;
         else
             return negate(quotient);
     }
    
    private static int negate(int a){
        int result = 0;
        int base = a > 0 ? -1 : 1;       
        while(a!=0){
            a += base;
            result+= base;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Division d = new Division();
		int a = d.divideAdd(10, 3);
		System.out.println(a);
	}

}
