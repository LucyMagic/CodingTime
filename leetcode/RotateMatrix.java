
public class RotateMatrix {

	//*************in space****************//
    public void rotateByLayer(int[][] matrix) {
        int n = matrix.length;        
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n-i-1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }        
    }
    
    public void rotateByTranspose(int[][] matrix) {
        int n = matrix.length;        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-i-1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = tmp;
            }
        }       
        for(int j = 0; j < n; j++){
            for(int i = 0; i < n/2; i++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
    }
	
	//*************Using extra space****************//
	public void rotate(int[][] matrix) {
        int N = matrix.length;        
        
        int[][] rotated = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                rotated[i][j] = matrix[i][j];
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                matrix[j][N-1-i] = rotated[i][j];
            }
        }
    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
