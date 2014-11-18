import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        enumerate(0, num, results);
        return results;
    }
    
    private void enumerate(int k, int[] num, List<List<Integer>> results){
        if(k==num.length){
            process(num, results);
            return;
        }
        Set<Integer> seen = new HashSet<Integer>();      
        for(int i = k; i < num.length; i++){
            int curNum = num[i];
            if(seen.contains(curNum))
                continue;           
            seen.add(curNum);
            
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
    
    private void process(int[] num, List<List<Integer>> results){
        List<Integer> result = new ArrayList<Integer>();
        for(int i : num){
            result.add(i);
        }
        results.add(result);
    }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
