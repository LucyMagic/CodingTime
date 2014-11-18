
public class TrappingRainWater {

    public int trap(int[] A) {
        int n = A.length;
        if(n==0) return 0;
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int max = A[0];
        leftMax[0] = A[0];
        for(int i = 1; i < n; i++){
            max = Math.max(max, A[i]);
            leftMax[i] = max;
        } 
        
        max = A[n-1];
        rightMax[n-1] = A[n-1];
        for(int i = n-2; i>=0; i--){
            max = Math.max(max, A[i]);
            rightMax[i] = max;
        }
        
        int units = 0;
        for(int i = 1; i<n-1; i++){
            int height = Math.min(rightMax[i], leftMax[i]);
            if(height<=A[i]) continue;
            units += height-A[i];
        }        
        return units;        
    }
	
	
	
	public int trapBad(int[] A) {
        int length = 0;
        if(length==0) return 0;
        
        int units = 0;
        for(int i = 1; i < length-1; i++){
            if(A[i-1] <= A[i] || A[i] >= A[i+1]) continue;
            int leftRange = i-1;
            int rightRange = i+1;
            while(leftRange >0 && A[leftRange-1] > A[leftRange]) leftRange--;
            while(rightRange <length && A[rightRange+1] > A[rightRange]) rightRange++;
            units += computeUnits(A, leftRange, rightRange);           
            i = rightRange;
        }
        return units;
    }
    
    private int computeUnits(int[] A, int left, int right){
        int area = Math.min(A[left], A[right]) * (right-left-1);
        for(int i = left+1; i < right; i++){
            area -= A[i];
        }
        return area;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater tr = new TrappingRainWater();
		int[] A = new int[]{2,0,2};
		tr.trap(A);
	}

}
