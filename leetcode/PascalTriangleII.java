import java.util.*;
public class PascalTriangleII {
	
	//****************Solution 1 O(K) space***********//
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> kRow = new ArrayList<Integer>(rowIndex+1);
        kRow.add(1);                
        for(int i = 1; i <= rowIndex; i++){
            kRow.add(1);
            for(int j = i-1; j > 0; j--){
                kRow.set(j, kRow.get(j)+kRow.get(j-1));
            }
        }        
        return kRow;
    }

    //******************Solution 2 too much space************//
    public ArrayList<Integer> getRow2(int rowIndex) {
        ArrayList<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        
        for(int i=1; i<=rowIndex; i++){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for(int j=1; j<i; j++){
                cur.add(prev.get(j) + prev.get(j-1));
            }
            cur.add(1);
            prev = cur;
        }
        return prev;        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
