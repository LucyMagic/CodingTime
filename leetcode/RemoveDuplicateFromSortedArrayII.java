
public class RemoveDuplicateFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        
        int count = 1;
        int prev = A[0];
        int uniqueCount = 1;

        for(int i = 1; i < A.length; i++){
            if(A[i]!=prev){
                count = 1;
                prev = A[i];
                A[uniqueCount++] = A[i];
            }else if(count < 2){
                count++;
                A[uniqueCount++] = A[i];
            }
        }
        return uniqueCount;
    }
	
	public static void main(String[] args) {

	}

}
