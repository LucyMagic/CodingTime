
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        if(A==null || A.length==0) 
            return result;
        
        result[0] = searchLowerBound(A, target);
        result[1] = searchUpperBound(A, target);
        return result; 
    }
	//predicate p is >=
    private int searchLowerBound(int[] A, int target){
        int lo = 0, hi = A.length-1;
        int bestSoFar = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(A[mid] == target){
                bestSoFar = mid;
                hi = mid-1;
            }else if(A[mid] > target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return bestSoFar;
    }
    //predicate p is <=
    private int searchUpperBound(int[] A, int target){
        int lo = 0, hi = A.length-1;
        int bestSoFar = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(A[mid] == target){
                bestSoFar = mid;
                lo = mid+1;
            }else if(A[mid] < target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return bestSoFar;    
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForARange s = new SearchForARange();
		int[] A = new int[]{1};
		int[] B = s.searchRange(A, 1);
		System.out.println(B[0]);
		System.out.println(B[1]);
	}

}
