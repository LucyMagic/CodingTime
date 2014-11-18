
public class MergeSortedArray {

	/*This version has better naming and concise code
	 * Note the break after the second else if. Because A already has everything in it. 
	*/
    public void mergeBetter(int A[], int m, int B[], int n) {
        assert A.length >= m+n;        
        int i = m-1, j = n-1;
        for(int k = m+n-1; k>=0; k--){
            if(i<0)             A[k] = B[j--];
            else if(j<0)        A[k] = A[i--];
            else if(A[i]>B[j])  A[k] = A[i--];
            else                A[k] = B[j--];
        }
    }
	
    public static void mergeAve(int A[], int m, int B[], int n) {
        if(A == null || B == null || A.length < m + n)
            return;
            
        int mergedLength = m + n;
        int i = m -1;
        int j = n -1;
        
        for(int ml = mergedLength - 1; ml >= 0; ml--){
            if(i<0)       A[ml] = B[j--];
            else if(j<0)  A[ml] = A[i--];
            else if(A[i] >= B[j])  A[ml] = A[i--];
            else          A[ml] = B[j--];
        }
    }

	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] A = {1};
		int[] B = {2};
	}

}
