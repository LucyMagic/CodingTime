import java.util.*;
public class Triangle {
	//*******************Solution1 Using only O(n) space**************//
	public int minimumTotal1(ArrayList<ArrayList<Integer>> triangle) {
        int size = triangle.size();
        if(size == 0) return 0;
        
        int[] minTotals = new int[size];
        minTotals[0] = triangle.get(0).get(0);
        for(int i = 1; i < size; i++){
            ArrayList<Integer> row = triangle.get(i);
            minTotals[i] = minTotals[i-1] + row.get(i);
            for(int j = i-1; j>0; j--){
                minTotals[j] = row.get(j) + Math.min(minTotals[j], minTotals[j-1]);
            }
            minTotals[0] = minTotals[0] + row.get(0);
        }
        
        int minValue = minTotals[0];
        for(int i = 1; i < minTotals.length; i++){
            if(minTotals[i] < minValue) minValue = minTotals[i];
        }
        return minValue;
    }
	
	//****************Solution 2 using 2 ArrayList for sum of 2 consecutive rows**********//
    public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        int sz = triangle.size();
        if(sz==0) return 0;
        
        ArrayList<Integer> prevSum = new ArrayList<Integer>();
        prevSum.addAll(triangle.get(0));
        
        for(int i=1; i<sz; i++){
            ArrayList<Integer> curSum = new ArrayList<Integer>();
            curSum.add(triangle.get(i).get(0)+prevSum.get(0));
            for(int j=1; j<i; j++){
                int val = triangle.get(i).get(j);
                int min = Math.min(prevSum.get(j-1), prevSum.get(j));
                curSum.add(min+val);
            }
            curSum.add(triangle.get(i).get(i)+prevSum.get(i-1));
            prevSum = curSum;
        }
        
        int minSum = prevSum.get(0);
        for(int i: prevSum){
            if(i<minSum){
                minSum=i;
            }
        }
        
        return minSum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
