import java.util.*;

public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> results =
                    new ArrayList<ArrayList<Integer>>();
        enumerate(0, num, results);
        return results;
    }
    
    private void enumerate(int k, int[] num, ArrayList<ArrayList<Integer>> results){
        int len = num.length;
        if(k==len){
            process(num, results);
            return;
        }
        
        for(int i = k; i < len; i++){
            exch(num, i, k);
            enumerate(k+1, num, results);
            exch(num, i, k);
        }
    }
    
    private void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private void process(int[] num, ArrayList<ArrayList<Integer>> results){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i : num){
            result.add(i);
        }
        results.add(result);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
