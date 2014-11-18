
public class SearchInRotatedSortedArrayIII {

	/** search pivot position
	 */
	public int searchPivotPosNoDup(int[] A){
		if(A == null || A.length == 0) return -1;
		
		int lo = 0, hi = A.length-1;
		while(A[lo] > A[hi]){
			int mid = lo + (hi-lo)/2;
			if(A[mid] > A[hi]){//pivot in right half
				lo = mid+1;
			}else{//pivot in left half
				
			}
		}
		return lo;
	}
	
	public int searchPivotPosWithDup(int[] A){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
