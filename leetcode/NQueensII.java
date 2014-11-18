
public class NQueensII {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] queensLoc = new int[n];
        for(int i = 0; i < n; i++){
            queensLoc[i] = i;
        }
        return nQueens(0, n, queensLoc);
    }
    
    private int nQueens(int k, int n, int[] queensLoc){
        int count = 0;
    	if(k==n){
            return 1;
        }      
        for(int i = k; i < n; i++){
            exch(queensLoc, k, i);
            if(!backtrack(k, queensLoc)) 
            	count += nQueens(k+1, n, queensLoc);
            exch(queensLoc, i, k);
        }
        return count;
    }
    
    private void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private boolean backtrack(int k, int[] a){
        for(int i = 0; i < k; i++){
            if((a[i] - a[k]) == (k - i)){
            	return true;
            }
            if((a[k] - a[i]) == (k - i)) {
            	return true;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensII temp = new NQueensII();
		int count = temp.totalNQueens(8);
		System.out.println(count);
	}

}
