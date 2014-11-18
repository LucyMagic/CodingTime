import java.util.*;
public class GrayCode {
	//*******************Solution 1**********************//
	//By formula, from http://en.wikipedia.org/wiki/Gray_code
    public ArrayList<Integer> grayCode1(int n) {
        int count = 1 << n;
        ArrayList<Integer> result = new ArrayList<Integer>(count);        
        for(int i = 0; i < count; i++){
            result.add(i^(i>>1));
        }
        return result;
    }
	
    //*******************Solution 1**********************//
    //to compute the Gray Code for n=k, we can reverse the gray code for n=k-1 and add '1' to the beginning
    
    public ArrayList<Integer> grayCode2(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for(int i = 0; i < n; i++){
            for(int j = result.size()-1; j >= 0 ; j--){
                result.add((1<<i) | result.get(j));
            }
        }
        return result;
    }
	
	//******************Solution 3***********************//
    //By enumerating all 2^n numbers for gray code and covert each one to number
    public ArrayList<Integer> grayCode3(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n == 0){
            result.add(0);
            return result;
        }
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = 0;
        }    
        enumerate(a, 0, result);
        return result;
    }
    
    private void enumerate(int[] a, int k, ArrayList<Integer> result){
        int n = a.length;
        if(k == n){
            process(a, result); return;
        }
        enumerate(a, k+1, result);
        a[k] = 1 - a[k];
        enumerate(a, k+1, result);
    }
    
    private void process(int[] a, ArrayList<Integer> result){
        int num = 0;
        String binaryString = "";
        for(int i = 0; i < a.length; i++){
            binaryString += a[i];
        }
        num = Integer.parseInt(binaryString, 2);
        result.add(num);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode gc = new GrayCode();
		ArrayList<Integer> result = gc.grayCode1(2);
		for(int i : result){
			System.out.print(i);
		}
	}

}
