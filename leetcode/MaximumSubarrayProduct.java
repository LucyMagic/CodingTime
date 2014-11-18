
public class MaximumSubarrayProduct {

	/**
	 * return the maximum product of any subarray in A
	 */
	public int maxProduct(int[] A){
		if(A==null || A.length==0) return 0;
		int maxProduct = Integer.MIN_VALUE;    
	    int maxCurrent = 1;    
	    int minCurrent = 1;    
	    
	    for(int i=0; i< A.length; i++){ 
	    	int num = A[i];
	    	if(num==0){
	    		maxCurrent = 1; minCurrent =1; continue;
	    	}
	        maxCurrent *= num; minCurrent *= num; 
	        maxProduct = Math.max(maxProduct, Math.max(minCurrent, maxCurrent));        
	        if(minCurrent > maxCurrent){
	        	int temp = minCurrent;
	        	minCurrent = maxCurrent;
	        	maxCurrent = temp;
	        }
	        minCurrent = Math.min(1, minCurrent);
	        maxCurrent = Math.max(1, maxCurrent);
	    }    
	    return maxProduct; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
