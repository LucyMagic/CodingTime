import java.util.HashMap;
public class TwoSum {

    public int[] twoSum(int[] array, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = {-1,-1};
        HashMap<Integer, Integer> valuesIndexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            int curVal = array[i];
            if(valuesIndexMap.containsKey(sum-curVal)){
                result[0] = valuesIndexMap.get(sum-curVal)+1;
                result[1] = i+1;
                break;
            }else{
                valuesIndexMap.put(curVal, i);
            }
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
