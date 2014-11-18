import java.util.*;

public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
        int[] queensLoc = new int[n];
        for(int i = 0; i < n; i++){
            queensLoc[i] = i;
        }
        ArrayList<String[]> results = new ArrayList<String[]>();
        nQueens(0, n, queensLoc, results);
        return results;
    }
    
    private void nQueens(int k, int n, int[] queensLoc, ArrayList<String[]> results){
        if(k==n){
            process(queensLoc, results);
            return;
        }      
        for(int i = k; i < n; i++){
            exch(queensLoc, k, i);
            if(!backtrack(k, queensLoc)) 
                nQueens(k+1, n, queensLoc, results);
            exch(queensLoc, i, k);
        }
    }
    
    private void process(int[] queensLoc, ArrayList<String[]> results){
        int len = queensLoc.length;
        String[] result = new String[len];
        for(int i = 0; i < len; i++){
            int loc = queensLoc[i];
            String str = "";
            for(int j = 0; j < len; j++){
                if(j == loc)
                    str += "Q";
                else
                    str += ".";
            }
            result[i] = str;
        }
        results.add(result);
    }
    
    private void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private boolean backtrack(int k, int[] a){
        for(int i = 0; i < k; i++){
            if((a[i] - a[k]) == (k - i) || (a[k] - a[i]) == (k - i)){
            	return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
