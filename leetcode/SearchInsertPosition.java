
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        if(A==null || A.length==0) return -1;
        
        int bestSoFar = -1;
        int lo = 0, hi = A.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (A[mid] == target){
            	return mid;
            } else if(A[mid] > target){
                bestSoFar = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }        
        if(bestSoFar==-1) return A.length;
        return bestSoFar;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition s = new SearchInsertPosition();
		int[] A = new int[]{1,3};
		int target = 0;
		s.searchInsert(A, target);
	}

}
