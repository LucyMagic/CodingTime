
public class SetMatrixZeros {
	//*****************Use O(2) space**************//
	public void setZeroesO2(int[][] matrix) {
        int M = matrix.length;
        if(M==0) return;
        int N = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        
        for(int i = 0; i < M; i++){
            if(matrix[i][0]==0){
                firstCol = true;
                break;
            }
        }
        for(int j = 0; j < N; j++){
            if(matrix[0][j]==0){
                firstRow = true;
                break;
            }
        }
        
        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstRow){
            for(int j = 0; j < N; j++){
                matrix[0][j] = 0;
            } 
        }
        
        if(firstCol){
            for(int i = 0; i < M; i++){
                matrix[i][0] = 0;
            }
        }
    }
	
	//*******************Use O(1) space****************//
	public void setZeroesO1(int[][] matrix) {
        if(matrix==null) return;
        int M = matrix.length;
        if(M==0) return;
        int N = matrix[0].length;
        if(N==0) return;
        
        int firstRow = -1;
        //check status for first row
        for(int j = 0; j < N;  j++){
            if(matrix[0][j]==0){
                firstRow = 0;
                break;
            }
        }
        
        //check status for the rest of the matrix
        for(int i = 1; i < M; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        //set status for matrix except first row and first col
        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j] = 0;
            }
        }
        
        //set first column
        if(matrix[0][0]==0){
            for(int i = 0; i < M; i++){
                matrix[i][0] = 0;
            }
        }
        
        //set first row
        if(firstRow == 0){
            for(int j = 0; j < N; j++){
                matrix[0][j] = 0;
            }
        }
    }
	
	//*****************Using O(m+n)space*************//
    public void setZeroesMoreSpace(int[][] matrix) {
        int M = matrix.length;
        if(M==0) return;
        int N = matrix[0].length;
        boolean[] rows = new boolean[M];
        boolean[] cols = new boolean[N];
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(rows[i] || cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }        
    }
	
	public static void main(String[] args) {
		
	}
}
