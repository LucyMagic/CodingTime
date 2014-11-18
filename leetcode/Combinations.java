import java.util.*;
public class Combinations {
    //*******************Solution 1***********************//
    private ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combine1(int n, int k) {
        this.result = new ArrayList<ArrayList<Integer>>();
        enumerate(n, k, new int[k]);
        return result;
    }
    private void enumerate(int n, int k, int[] oneSol){
        //check error case
        if(n < k) return;
        //check base case
        if(k==0){
            process(oneSol);
            return;
        }
        
        //include the current element
        oneSol[k-1] = n;
        enumerate(n-1, k-1, oneSol);
        
        //exclude the current element
        enumerate(n-1, k, oneSol);
    }
    private void process(int[] a){
    	ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i : a){
            res.add(i);
        }
        result.add(res);
    }
	
	public static void main(String[] args) {
		Combinations com = new Combinations();
		com.combine1(1, 1);

	}

}
