
public class SearchInRotatedArrayII {
	//*****************Solution 1*****************//
	//eliminate half of the array when possible, otherwise search entire array  
	public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) return false;
        return search(A, 0, A.length-1, target);
    }
    private boolean search(int[] A, int lo, int hi, int target){
        if(lo > hi) return false;        
        int mid = lo + (hi-lo)/2;
        if(A[mid] == target) return true;
        
        if(A[mid] < A[hi]){//right is sorted
            if(A[mid] < target && target <= A[hi]){
                return search(A, mid+1, hi, target);
            }else{
                return search(A, lo, mid-1, target);
            }
        }else if(A[mid] > A[hi]){//left is sorted
            if(A[mid]>target && target >= A[lo]){
                return search(A, lo, mid-1, target);
            }else{
                return search(A, mid+1, hi, target);
            }
        }else if(A[mid] != A[lo]){//A[mid]==A[hi]&&A[mid]!=A[lo]
            return search(A, lo, mid-1, target);
        }else{//A[mid]==A[hi]&&A[mid]==A[lo]
            return search(A, lo, mid-1, target) || search(A, mid+1, hi, target);
        }
    }
    
    //******************Solution 2**********************//
    //remove the duplicates first before search, and this reduces the problem to I when there are no dups
    public boolean searchDeDup(int[] A, int target) {
        if(A == null || A.length == 0) return false;
        int lo = 0, hi = A.length-1;
        while(lo <= hi){
            while(lo<hi && A[lo]==A[hi]){
                if(A[lo] == target) return true;
                lo++; hi--;
            }
            
            int mid = lo + (hi-lo)/2;
            if(A[mid] == target) return true;
            if(A[mid] > A[hi]){//left is sorted
                if(A[mid] > target && target >= A[lo]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }else{//right is sorted
                //A[mid]<A[hi], since A[mid] can not be equal to A[hi]
                if(A[mid] < target && target <= A[hi]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
