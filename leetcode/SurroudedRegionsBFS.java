import java.util.*;
public class SurroudedRegionsBFS {

	private int length, height;
	private char[][] board;
    
    public void solve(char[][] board) {
        if(board == null || board.length ==0 || board[0].length == 0)
            return;
        length = board.length;
        height = board[0].length;
        this.board = board;
        
        ArrayDeque<Loc> openLoc = getOpenLocOnEdge(board);
        bfs(board, openLoc);
        captureRegion();
    }
    
    private void bfs(char[][] board, ArrayDeque<Loc> openLoc){
        for(Loc l : openLoc){
            board[l.row][l.col] = 'Y';    
        }        
        while(!openLoc.isEmpty()){
            Loc loc = openLoc.poll();
            for(Loc l : getAdj(loc)){
                if(board[l.row][l.col] != 'Y'){
                     board[l.row][l.col] = 'Y';
                     openLoc.offer(l);
                }
            }
        }       
    }
    
    private ArrayDeque<Loc> getAdj(Loc l){
        ArrayDeque<Loc> locations = new ArrayDeque<Loc>();
        //check up, down, left, right
        int row = l.row, col = l.col;
        if(row > 0 && board[row-1][col] == 'O')
            locations.add(new Loc(row-1, col));
        if(row < board[0].length - 1 && board[row+1][col] == 'O')
            locations.add(new Loc(row+1, col));
        if(col>0 && board[row][col-1] == 'O')
            locations.add(new Loc(row, col-1));
        if(col < board.length - 1 && board[row][col+1] == 'O')
            locations.add(new Loc(row, col+1));
        return locations;
    }
    
    private ArrayDeque<Loc> getOpenLocOnEdge(char[][] board){
        ArrayDeque<Loc> locations = new ArrayDeque<Loc>();
        for(int i = 0; i < length; i++){
            if(board[0][i] == 'O')
                locations.add(new Loc(0,i));
            if(board[height-1][i] == 'O')
                locations.add(new Loc(height-1, i));
        }
        
        for(int j = 0; j < height; j++){
            if(board[j][0] == 'O')
                locations.add(new Loc(j, 0));
            if(board[j][length-1] == 'O')
                locations.add(new Loc(j, length-1));
        }
        
        return locations;
    }
    
    private void captureRegion(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }
    
    private class Loc{
        int row;
        int col;
        public Loc(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
