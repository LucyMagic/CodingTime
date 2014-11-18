import java.util.*;
public class Pow {
	//***************Solution 3****************//
    public double pow3(double x, int n) {
        if (n == 0) return 1.0;
 
        double half = pow3(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else if (n > 0)
            return half * half * x;
        else
            return half * half / x;
    }
	
  //****************Wrong solution***********************//
    /*used -n which will incur overflow when n is Integer.MIN_VALUE*/
    public double pow1(double x, int n) {
        if(n<0){ 
            x = 1/x;
        	n = -n;
        }    
        ArrayDeque<Integer> path = new ArrayDeque<Integer>();
        path.push(n);
        while(n>1){
            n/=2;
            path.push(n);            
        }        
        double result = 1.0;
        while(!path.isEmpty()){
            int power = path.pop();
            result = result*result;
            if(power%2!=0){
                result *= x;
            }
        }
        return result;
    }
    
    //****************Wrong solution***********************//
    public double pow2(double x, int n) {
    	//Wrong solution when n is -2147483648
        if(n<0)   return 1/pow2(x, -n);

        if(n==0) return 1;
        
        double half = pow2(x, n/2);
        if(n%2==0)
            return half * half;
        else
            return half * half * x;        
    }	
	//*************naive solution************//
    public double pow(double x, int n) {
        if(x==0&&n==0) return 1;
        if(x==0) return 0;
        if(n==0) return 1;                
        if(n<0){ 
        	x = 1/x;
        	n = -n;
        }        
        Map<Integer, Double> cache = new HashMap<Integer, Double>();
        return pow(x, n, cache);
    }
    
    private double pow(double x, int n, Map<Integer, Double> cache){
    	if(cache.containsKey(n)) return cache.get(n);
    	double result;
    	if(n%2==0){
            result = pow(x,n/2)*pow(x,n/2);
        }else{
            result = x*pow(x,n/2)*pow(x,n/2);
        }
    	cache.put(n, result);
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow p = new Pow();
		double d = p.pow2(1.0, -2147483648);
		System.out.println(d);
	}

}
