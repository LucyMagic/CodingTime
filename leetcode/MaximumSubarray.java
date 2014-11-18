
public class MaximumSubarray {
	//*************Solution 1***************//
	//linear probing
    public int maxSubArray(int[] A) {
        int maxSum = Integer.MIN_VALUE;        
        int sum = 0;
        for(int i = 0; i <A.length; i++){
            sum += A[i];
            if(sum > maxSum) maxSum = sum;
            if(sum < 0) sum = 0;
        }       
        return maxSum;
    }
    
    //*************Solution 2*********************//
    //Divide and Conquer
    public int maxSubArrayDivideConquer(int[] A) {
        if(A==null||A.length==0) return 0;        
        return maxSubArray(A, 0, A.length-1);
    }
    private int maxSubArray(int[] A, int lo, int hi){
        if(lo==hi) //one element
            return A[lo];
//        if(hi-lo==1) //two elements
//            return max(A[lo], A[hi], A[lo]+A[hi]);
        
        int mid = lo + (hi - lo)/2;
        return max(maxSubArray(A, lo, mid), 
                   maxSubArray(A, mid+1, hi), 
                   maxSubArrayCrossMid(A, lo, mid, hi));
    }
    private int maxSubArrayCrossMid(int[] A, int lo, int mid, int hi){
        int sum = 0;
        int leftSum = 0;
        for(int i = mid-1; i >= lo; i--){
            sum += A[i];
            leftSum = Math.max(sum, leftSum);
        }
        
        sum = 0;
        int rightSum = 0;
        for(int i = mid+1; i <= hi; i++){
            sum += A[i];
            rightSum = Math.max(sum, rightSum);
        }
        
        return leftSum + rightSum + A[mid];
    }
    private int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
