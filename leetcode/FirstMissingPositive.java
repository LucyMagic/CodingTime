
public class FirstMissingPositive {

	public int firstMissingPositive1(int[] A) {
        int length = A.length;
        if(length == 0) return 1;
        
        for(int i = 0; i < length; i++){
            if(A[i] <= 0 || A[i] > length || A[i] == i+1 || A[A[i]-1] == A[i]) continue;
            //need to swap
            int temp = A[A[i]-1];
            A[A[i]-1] = A[i];
            A[i] = temp;
            i--;
        }
        
        for(int i = 0; i < length; i++){
            if(A[i]!=i+1) return i+1;
        }
        return length+1;
    }
	
    public int firstMissingPositive2(int[] A) {
        int length = A.length;
        if(length == 0) return 1;
        
        for(int i = 0; i < length; i++){
            int cur = A[i];
            if(cur<=0|| cur>length || cur==i+1) continue;
            
            int temp = A[cur-1];
            A[cur-1] = cur;
            A[i] = -1;
            if(temp<=0||temp>length||A[temp-1]==temp) continue;
            
            while(A[temp-1] > 0 && A[temp-1] < length && A[temp-1]!=temp){
                int val = A[temp-1];
                A[temp-1] = temp;
                temp = val;
            }
            A[temp-1] = temp;
        }
        
        for(int i = 0; i < length; i++){
            if(A[i]!=i+1) return i+1;
        }
        return length+1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
