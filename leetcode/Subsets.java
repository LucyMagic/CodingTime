import java.util.*;
public class Subsets {

	//********************Solution1*************************//
	//Direct conversion from binary number [0, 2^n-1]
	public ArrayList<ArrayList<Integer>> subsets1(int[] S) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length==0) return subsets;
        
        Arrays.sort(S);
        int maxCount = 1<<S.length;
        for(int i = 0; i < maxCount; i++){
            subsets.add(convertBinary(i, S));
        }
        
        return subsets;
    }
    private ArrayList<Integer> convertBinary(int num, int[] S){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int index = 0;
        for(int k = S.length-1; k>=0; k--){
            int temp = num>>k;
            if((temp & 1) == 1){
                ret.add(S[index]);
            }
            index++;
        }        
        return ret;
    }
	
    //***********************Solution 2*********************//
    //Combinatorics
    private ArrayList<ArrayList<Integer>> subsets;
    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        Arrays.sort(S);
        subsets = new ArrayList<ArrayList<Integer>>();
        enumerate(S, 0, new ArrayList<Integer>());
        return subsets;
    }
    private void enumerate(int[] S, int index, ArrayList<Integer> subset){
        if(index==S.length){
            ArrayList<Integer> oneRes = new ArrayList<Integer>(subset);
            subsets.add(oneRes);
            return;
        }
        
        //not to include the current element
        enumerate(S, index+1, subset);
        
        //to include the current element
        subset.add(S[index]);
        enumerate(S, index+1, subset);
        
        //clean up
        subset.remove(subset.size()-1);
    }
       
    //***********************Solution 3*********************//
    //Iteration
    public ArrayList<ArrayList<Integer>> subsets3(int[] S) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        Arrays.sort(S);
        
        for(int i = 0; i < S.length; i++){
        	//Note that we need a temp holder for all added subsets, since we cannot modify 
        	//subsets when we are iterating through the variable. 
        	//This will raise run time exception "java.util.ConcurrentModificationException"
            ArrayList<ArrayList<Integer>> addedSubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> prev : subsets){
                ArrayList<Integer> newSubset = new ArrayList<Integer>(prev);
                newSubset.add(S[i]);
                addedSubsets.add(newSubset);
            }
            subsets.addAll(addedSubsets);
        }
        return subsets;
    }
    
    //**************************Solution 4******************//
    //Recursion
    public ArrayList<ArrayList<Integer>> subsetsRec(int[] S) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        Arrays.sort(S);
        
        return getAllSubsetsRec(S, 0);
    }
    private ArrayList<ArrayList<Integer>> getAllSubsetsRec(int[] S, int index){
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        if(index == S.length){
            subsets.add(new ArrayList<Integer>());
            return subsets;
        }        
        ArrayList<ArrayList<Integer>> subsequent = getAllSubsetsRec(S, index+1);
        subsets.addAll(subsequent);
        for(ArrayList<Integer> list : subsequent){
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.add(S[index]);
            newList.addAll(list);
            subsets.add(newList);
        }
        return subsets;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets ss = new Subsets();
		int[] S = {0};
		ss.subsets3(S);
	}

}
