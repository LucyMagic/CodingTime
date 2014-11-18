
public class SolveSudoku {
	public void solveSudoku(char[][] board) {
        enumerate(0, board);
    }
    
    private boolean enumerate(int k, char[][] board){
        if(k == 81){
            return true;
        }
        
        int row = k/9;
        int col = k%9;
        
        if(board[row][col] != '.'){
            return enumerate(k+1, board);
        }
        
        for(char i = '1'; i <= '9'; i++){
            board[row][col] = i;
            if(isValidSudoku(i, row, col, board)){
                if(enumerate(k+1, board))
                    return true;
            }
        }
        
        board[row][col] = '.';
        return false;
    }
    
    private boolean isValidSudoku(char val, int row, int col, char[][] board) {       
        return isValidRow(val, row, col, board) && isValidColumn(val, row, col, board) && isValidBox(val, row, col, board);
    }
    
    private boolean isValidRow(char val, int row, int col, char[][] board){
        for(int j = 0; j < 9; j++){
            if(j == col) continue;
            char cur = board[row][j];
            if(cur == '.') continue;
            if(cur == val) return false;
        }
        return true;
	}
	
	private boolean isValidColumn(char val, int row, int col, char[][] board){
        for(int j = 0; j < 9; j++){
        	if(j == row) continue;
            char cur = board[j][col];
            if(cur == '.') continue;
            if(cur == val) return false;
        }
        return true;
	}

	private boolean isValidBox(char val, int row, int col, char[][] board){
        int startRowIndex = (row / 3) * 3;
        int startColIndex = (col /3 ) * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int curRow = startRowIndex+i;
            	int curCol = startColIndex+j;
            	if(curRow == row && curCol == col) continue;
                char cur = board[curRow][curCol];
                if(cur == '.') continue;
                if(cur == val) return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
