
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {       
        return isValidRow(board) && isValidColumn(board) && isValidBox(board);
    }
	
	private boolean isValidRow(char[][] board){
		char[] curRow = new char[9];
        for(int i = 0; i < 9; i++){
        	resetArray(curRow);
            for(int j = 0; j < 9; j++){
                char cur = board[i][j];
                if(cur == '.') continue;
                if(curRow[cur-'1'] == cur) return false;
                curRow[cur-'1'] = cur;
            }
        }
        return true;
	}
	
	private boolean isValidColumn(char[][] board){
		char[] curCol = new char[9];
        for(int i = 0; i < 9; i++){
            resetArray(curCol);
            for(int j = 0; j < 9; j++){
                char cur = board[j][i];
                if(cur == '.') continue;
                if(curCol[cur-'1'] == cur) return false;
                curCol[cur-'1'] = cur;
            }
        }
        return true;
	}

	private boolean isValidBox(char[][] board){
		char[] box = new char[9];
        for(int boxRow = 0; boxRow < 3; boxRow++){
            for(int boxCol = 0; boxCol < 3; boxCol++){
            	resetArray(box);
                int startRowIndex = boxRow * 3;
                int startColIndex = boxCol * 3;
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char cur = board[startRowIndex+i][startColIndex+j];
                        if(cur == '.') continue;
                        if(box[cur-'1'] == cur) return false;
                        box[cur-'1'] = cur;
                    }
                }
            }
        }
        return true;
	}
	
	private void resetArray(char[] a){
		for(int i = 0; i < a.length; i++){
			a[i] = '0';
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[9][9];
		char[] first = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		char[] second = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		char[] third = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		char[] fourth = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		char[] fifth = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		char[] sixth = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		char[] seventh = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		char[] eighth = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		char[] ninth = {'5', '3', '.', '.','7', '.', '.', '.', '.'};
		board[0] = first;
		board[1] = second;
		board[2] = third;
		board[3] = fourth;
		board[4] = fifth;
		board[5] = sixth;
		board[6] = seventh;
		board[7] = eighth;
		board[8] = ninth;
		ValidSudoku vs = new ValidSudoku();
		vs.isValidSudoku(board);
	}

}
