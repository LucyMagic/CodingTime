
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if(height == 0) return false;
        int length = matrix[0].length;
        
        int N = length * height;
        int index = binarySearch(matrix, 0, N-1, target);
        return index==-1? false : true;
    }
    
    private int binarySearch(int[][] matrix, int lo, int hi, int target){
        if(lo > hi) return -1;
        int mid = lo + (hi - lo)/2;
        int value = getValueInMatrix(matrix, mid);
        if(target < value)
            return binarySearch(matrix, lo, mid-1, target);
        else if(target > value)
            return binarySearch(matrix, mid+1, hi, target);
        else 
            return mid;
    }
    
    private int getValueInMatrix(int[][] matrix, int index){
        int length = matrix[0].length;
        
        int i = index/length;
        int j = index%length;
        return matrix[i][j];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
