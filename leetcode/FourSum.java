import java.util.*;

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int targetSum){
		 ArrayList<ArrayList<Integer>> results = 
		            new ArrayList<ArrayList<Integer>>();
		 Arrays.sort(num);
	     HashSet<Integer> seen = new HashSet<Integer>();
	     for(int i = 0; i < num.length; i++){
	    	 int curNum = num[i];
             if(seen.contains(curNum))
                 continue;
             seen.add(curNum);
	         int triSum = targetSum - curNum;
	         ArrayList<ArrayList<Integer>> triSumResults = 
	        		 findThreeSum(triSum, num, i+1);
	         for(ArrayList<Integer> triSumResult : triSumResults){
	        	 ArrayList<Integer> fourSumResult  = new ArrayList<Integer>();
	        	 fourSumResult.add(curNum);
	        	 fourSumResult.addAll(triSumResult);
	        	 results.add(fourSumResult);
	         }
	     }
	     return results;
	}
	
	private ArrayList<ArrayList<Integer>> findThreeSum(int triSum, int[] num, int startIndex) {
        ArrayList<ArrayList<Integer>> results = 
            new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        HashSet<Integer> seen = new HashSet<Integer>();
        for(int i = startIndex; i < num.length; i++){
            int curNum = num[i];
            if(seen.contains(curNum))
                continue;
            seen.add(curNum);
            int twoSum = triSum - curNum;
            Set<ArrayList<Integer>> twoSumResults 
                        = findTwoSum(twoSum, num, i+1);
            for(ArrayList<Integer> twoSumResult : twoSumResults){
                ArrayList<Integer> threeSumResult = new ArrayList<Integer>();
                threeSumResult.add(curNum);
                threeSumResult.addAll(twoSumResult);
                results.add(threeSumResult);
            }
        }
        return results;
    }
    
    private Set<ArrayList<Integer>> findTwoSum(int sum, int[] num, int startIndex){
        Set<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
        int i = startIndex;
        int j = num.length -1;
        while(i < j){
            if(num[i] + num[j] > sum){
                j--;
            }else if(num[i] + num[j] < sum){
                i++;
            }else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]); temp.add(num[j]);
                results.add(temp);
                i++; j--;
            }
        }
        return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
