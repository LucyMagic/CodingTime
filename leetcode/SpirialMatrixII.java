
public class SpirialMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==0) return matrix;
        
        int num =1;
        for(int layer = 0; layer < n/2; layer++){
            //top row
            for(int j = layer; j < n-1-layer; j++){
                matrix[layer][j] = num++;
            }
            //right col
            for(int i = layer; i < n-1-layer; i++){
                matrix[i][n-1-layer] = num++;
            }
            //bottom row
            for(int j = n-1-layer; j > layer; j--){
                matrix[n-layer-1][j] = num++;               
            }
            //left col
            for(int i = n-1-layer; i > layer; i--){
                matrix[i][layer] = num++;
            }
        }
        
        if(n%2!=0) matrix[n/2][n/2] = num;
        return matrix;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
