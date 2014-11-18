import java.util.*;
public class SubsetII {
    private ArrayList<ArrayList<Integer>> allSubsets;
    private ArrayList<Integer> subset;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        allSubsets = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0) return allSubsets;
        subset = new ArrayList<Integer>();
        
        Arrays.sort(num);
        enumerate(num, 0);
        return allSubsets;
    }
    private void enumerate(int[] num, int index){
        if(index == num.length){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.addAll(subset);
            allSubsets.add(result);
            return;
        }
        
        int current = num[index];
        int count = 0, start = index;
        while(start<num.length && num[start++]==current) count++;
        for(int i = 0; i <= count; i++){
            for(int j = i; j>0; j--){
                subset.add(current);
            }
            enumerate(num, index+count);
            //clean up
            for(int j = i; j>0; j--){
                subset.remove(subset.size()-1);
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
