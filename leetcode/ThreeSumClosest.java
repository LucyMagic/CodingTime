import java.util.*;

public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        if(num.length < 3)
            return 0;
        int closestSum = num[0] + num[1] + num[2];
        Arrays.sort(num);
        
        for(int k = 0; k < num.length; k++){
            int curNum = num[k];
            
            int i = k+1;
            int j = num.length-1;
            while(i < j){
                int tempSum = curNum + num[i] + num[j];
                if(tempSum == target){
                    return target;
                }
                if(Math.abs(target-closestSum) > Math.abs(target - tempSum)){
                    closestSum = tempSum;
                }
                if(tempSum > target){
                    j--;
                }else if(tempSum < target){
                    i++;
                }
            }
        }
        return closestSum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
