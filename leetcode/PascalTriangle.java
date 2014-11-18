import java.util.*;
public class PascalTriangle {
	
	//**************Solution 1*************************//
	//process the triangle line by line
    public ArrayList<ArrayList<Integer>> generate1(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows==0) return result;
        
        ArrayList<Integer> firstrow = new ArrayList<Integer>();
        firstrow.add(1);
        result.add(firstrow);
        
        for(int i = 1; i < numRows; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int j = 1; j < i; j++){
                int num = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                row.add(num);
            }
            row.add(1);
            result.add(row);
        }        
        return result;
    }
    
    //**************Solution 2*************************//
  	//Using formula
    
    
	public static void main(String[] args) {

	}

}
