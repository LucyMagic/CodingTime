import java.util.*;
public class SpirialOrderI {
	//***************Solution 1 Recursion*************//
	ArrayList<Integer> result;
    public ArrayList<Integer> spiralOrderRec(int[][] matrix) {
        result = new ArrayList<Integer>();
        int M = matrix.length;
        if(M==0) return result;
        int N = matrix[0].length;
        spiralOrder(matrix, M, N, 0);
        return result;
    }
    private void spiralOrder(int[][] matrix, int M, int N, int k){
        if(M<=0 || N<=0) return;
        if(M==1){
            for(int j=0; j<N ;j++)
               result.add(matrix[k][k+j]); 
            return;
        }
        if(N==1){
            for(int i=0; i<M; i++)
                result.add(matrix[k+i][k]);
            return;
        }        
        //top row
        for(int j=0; j<N-1; j++){
            result.add(matrix[k][k+j]);
        }
        //left col
        for(int i=0; i<M-1; i++){
            result.add(matrix[k+i][k+N-1]);
        }
        //bottom row
        for(int j=N-1; j>0; j--){
            result.add(matrix[k+M-1][k+j]);
        }
        //right col
        for(int i=M-1; i>0; i--){
            result.add(matrix[k+i][k]);
        }
        spiralOrder(matrix, M-2, N-2, k+1);
    }
	
	//***************Solution 2 Iteration*************//
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;//height
        if(m==0) return result;
        int n = matrix[0].length;//length
        for(int i = 0; i < (n+1)/2 && i < (m+1)/2; i++){
        	//top row
            for(int j = i; j < n-i; j++){
                result.add(matrix[i][j]);
            }
            //right col
            for(int j = i+1; j < m-1-i; j++){
                result.add(matrix[j][n-1-i]);
            }
            //bottom row
            for(int j = n-1-i; j >= i && i!=(m-1-i); j--){
                result.add(matrix[m-1-i][j]);
            }
            //left col
            for(int j = m-2-i; j >= i+1 && i!=(n-1-i); j--){
                result.add(matrix[j][i]);
            }
        }        
        return result;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
