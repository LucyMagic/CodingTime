
public class SearchInRotatedArrayI {
    public int searchRecursion(int[] A, int target) {
        int length = A.length;
        if(length == 0) return -1;      
        return binarySearch(A, 0, length-1, target);
    }   
    private int binarySearch(int[] A, int lo, int hi, int target){
        if(lo>hi) return -1;        
        int mid = lo + (hi-lo)/2;
        if(A[mid] == target)  return mid;                
        if(A[mid] > A[hi]){//left is sorted
            if(target < A[mid] && target >= A[lo]){
                return binarySearch(A, lo, mid-1, target);
            }else{
                return binarySearch(A, mid+1, hi, target);
            }
        }else{//right is sorted
            if(target > A[mid] && target <= A[hi]){
                return binarySearch(A, mid+1, hi, target);
            }else{
                return binarySearch(A, lo, mid-1, target);
            }
        }
    }
    
    //**************Solution 2*********//
    public static int search(int[] A, int target) {
        if(A == null || A.length == 0) return -1;
        
        int lo = 0, hi = A.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(A[mid] == target) return mid;
            if(A[mid] > A[hi]){//left half is sorted
            //if(A[mid] >= A[lo){//also work
            //if(A[mid] >= A[hi]){//also work
                if(A[mid] > target && target >= A[lo]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else{//right half is sorted
                if(A[mid] < target && target <= A[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
    
    
    public int searchIteration(int[] A, int target) {
        int N = A.length;
        int lo = 0, hi = N-1;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target){
                if(A[mid]<A[hi] || A[mid]>A[hi]&&target>=A[lo]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }else{
                if(A[mid]>A[hi] || A[mid]<A[hi]&&target<=A[hi]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }        
        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{5,1,3};
		int i = SearchInRotatedArrayI.search(a, 5);
		System.out.println(i);
	}

}
