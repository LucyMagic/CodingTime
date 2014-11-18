
public class RemoveElement {	
    public int removeElement(int[] A, int elem) {
        if(A == null) return 0;       
        int newLength = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != elem && A[i] != A[newLength]){
                A[newLength++] = A[i];
            }
        }
        return newLength;
    }
    
    public int removeElementRemove(int[] A, int elem) {
        if(A==null) return 0;
        int start = 0;
        int end = A.length - 1;
        while(true){
            while(start<=end && A[start] != elem) start++;
            while(start<=end && A[end]==elem) end--;
            if(start>end) break;
            exch(A, start, end);
            start++; end--;
        }
        return start;
    }    
    private void exch(int[] A, int s, int e){
        int tmp = A[s];
        A[s] = A[e];
        A[e] = tmp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
