public class Solution {
    /********First solution: linear search*/
    public int findMinLinear(int[] num) {
        for(int i=0; i<num.length-1; i++){
            if(num[i+1]<num[i]){
                return num[i+1];
            }
        }
        return num[0];
    }

    /********Second solution: binary search*/
    public int findMinBinary(int[] num) {
        int length = num.length;
        if(num[length-1]>num[0]) {
            return num[0];
        }
        return findMin(num, 0, length-1);
    }
    private int findMin(int[] num, int lo, int hi){
        int bestSoFar = num[lo];
        while(lo<=hi){
            int mid = (lo+hi+1)/2;
            if(num[mid]>num[lo]){
                bestSoFar = Math.min(num[lo], bestSoFar);
                lo = mid+1;
            }else{
                bestSoFar = Math.min(num[mid], bestSoFar);
                hi = mid-1;
            }
        }
        return bestSoFar;
    }
}
