import java.util.*;
public class CombinationSumI {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSumSort(int[] candidates, int target) {
        result = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length ==0) return result;        
        Arrays.sort(candidates);
        getCombinations(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }
    private void getCombinations(int[] candidates, int target, int index, ArrayList<Integer> oneRet) {
        if(target == 0){
            result.add(new ArrayList<Integer>(oneRet));
            return;
        }
        if(target < 0 ||index >= candidates.length) return;
    
        int curVal = candidates[index];        
        for(int i = 0; i <= target/curVal; i++){
            for(int j = 0; j < i; j++){
                oneRet.add(curVal);         
            }            
            getCombinations(candidates, target-i*curVal, index+1, oneRet);
            //clean up
            for(int j = 0; j < i; j++){
                oneRet.remove(oneRet.size()-1);            
            }        
        }
    }    
    
//    private ArrayList<ArrayList<Integer>> result;
    //This works but takes more time
    public ArrayList<ArrayList<Integer>> combinationSumNoSort(int[] candidates, int target) {
        result = new ArrayList<ArrayList<Integer>> ();
        if(candidates==null || candidates.length==0 || target <= 0)
            return result;
        
        //Arrays.sort(candidates);
        enumerate(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }
    private void enumerate(int[] candidates, int index, int target, ArrayList<Integer> list){
        if(target == 0){
            ArrayList<Integer> oneCombination = new ArrayList<Integer>(list);
            Collections.sort(oneCombination);
            result.add(oneCombination);
            return;
        }
        if(index>=candidates.length) return;
        
        for(int i = 0; i <= target/candidates[index]; i++){
            for(int j = i; j > 0; j--){
                list.add(candidates[index]);
            }
            enumerate(candidates, index+1, target-i*candidates[index], list);
            for(int j = i; j > 0; j--){
                list.remove(list.size()-1);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
