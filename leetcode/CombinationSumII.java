import java.util.*;
public class CombinationSumII {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
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
        if(target < 0 ||index >= candidates.length)
            return;
    
        int curVal = candidates[index];
        int count = 0;
        for(int i = index; i < candidates.length && curVal == candidates[i]; i++){
            count++;
        }
        for(int i = 0; i <= count; i++){
            for(int j = 0; j < i; j++){
                oneRet.add(curVal);         
            }            
            getCombinations(candidates, target-i*curVal, index+count, oneRet);
            //clean up
            for(int j = 0; j < i; j++){
                oneRet.remove(oneRet.size()-1);            
            }        
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
