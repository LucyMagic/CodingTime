
public class RemoveDuplicateFromSortedArrayI {	
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) return 0;
        
        int updatedIndex = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] != A[updatedIndex]){
                A[++updatedIndex] = A[i];
            }
        }
        return updatedIndex+1;
    }
	
	public static void main(String[] args) {

	}

}
