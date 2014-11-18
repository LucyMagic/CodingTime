import java.util.*;
public class ThreeSum {
	//**********************Solution 1*****************************//
	//O(N^2logN), binary search
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length<3) return result;
        int n = num.length;
        
        Arrays.sort(num);
        for(int i = 0; i < n-2; i++){
            if(i!=0 && num[i]==num[i-1]) continue;
            for(int j = i+1; j < n-1; j++){
                if(j!=i+1 && num[j]==num[j-1]) continue;
                int k = binarySearch(num, j+1, n-1, 0-num[i]-num[j]);
                if(k!=-1){
                    ArrayList<Integer> oneTriplet = new ArrayList<Integer>();
                    oneTriplet.add(num[i]);
                    oneTriplet.add(num[j]);
                    oneTriplet.add(num[k]);
                    result.add(oneTriplet);
                }
            }
        }
        return result;
    }    
    private int binarySearch(int[] num, int lo, int hi, int target){
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(num[mid] == target) return mid;
            else if(num[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }
	
	
	//************************Solution 2******************//
	//O(N^2) eliminate duplicates without using a set
	public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0) return triplets;
		
		Arrays.sort(num);
		for(int i = 0; i < num.length; i++){
		    if(num[i] > 0) break;
		    //avoid dup
		    if(i!=0 && num[i]==num[i-1]) continue;
		    
		    int target2Sum = 0 - num[i];
		    int j = i + 1, k = num.length-1;
		    while(j < k){               
		        int sum = num[j] + num[k];
		        if(sum == target2Sum){
		            int currentj = num[j];
		            int currentk = num[k];
		            ArrayList<Integer> tri = new ArrayList<Integer>();
		            tri.add(num[i]);
		            tri.add(currentj);
		            tri.add(currentk);
		            triplets.add(tri);                    
		             //avoid dup
		            while(j<k && num[j] == currentj) j++;
		            while(j<k && num[k] == currentk) k--;
		        }else if(sum > target2Sum){
		            k--;
		        }else{
		            j++;
		        }               
		    }            
		}        
		return triplets;
	}
	
	//**********************Solution 3*****************************//
	//eliminate duplicates with the use of a set
	public ArrayList<ArrayList<Integer>> threeSumSet3(int[] num) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return triplets;
        Set<ArrayList<Integer>> noDup = new HashSet<ArrayList<Integer>>();
        
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            if(num[i] > 0) break;            
            int target2Sum = 0 - num[i];
            int j = i + 1, k = num.length-1;
            while(j < k){
                int sum = num[j] + num[k];
                if(sum == target2Sum){
                    ArrayList<Integer> tri = new ArrayList<Integer>();
                    tri.add(num[i]);
                    tri.add(num[j]);
                    tri.add(num[k]);
                    if(!noDup.contains(tri)){
                        triplets.add(tri);
                        noDup.add(tri);
                    }                    
                    j++; k--;
                }else if(sum > target2Sum){
                    k--;
                }else{
                    j++;
                }
            }            
        }        
        return triplets;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {3,0,-2,-1,1,2};
		ThreeSum threeSum = new ThreeSum();
		ArrayList<ArrayList<Integer>> results = threeSum.threeSum(num);
		for(ArrayList<Integer> result: results){
			for(int i: result){
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
