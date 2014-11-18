public class WordSearch {
    private boolean[] visited;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        if(board==null || word==null) return false;
        //If return false when word is empty, need to specify explicitly. Otherwise DFS will return true
        if(word.length()==0) return false;
        
        //initialization
        this.board = board;
        int M = board.length;
        if(M==0) return false;
        int N = board[0].length;
        if(N==0) return false;
        visited = new boolean[M*N];
        
        //search
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(dfs(i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, String word, int index){
        //check base conditions
        if(index==word.length()) return true;
        int M = board.length;
        int N = board[0].length;
        if(i < 0 || i >= M || j < 0 || j >= N) return false;
        
        //check illegal state
        if(board[i][j]!=word.charAt(index)) return false;
        int key = i*N + j;
        if(visited[key]) return false;

        //start DFS
        visited[key] = true;
        if(dfs(i-1, j, word, index+1)) return true;
        if(dfs(i+1, j, word, index+1)) return true;
        if(dfs(i, j+1, word, index+1)) return true;
        if(dfs(i, j-1, word, index+1)) return true;
        visited[key] = false;//clean up
        
        return false;
    }
    
	public static void main(String[] args) {
		char[][] board = new char[1][0];
		board[0] = new char[]{'a'};
		WordSearch ws = new WordSearch();
		boolean b = ws.exist(board, "ab");
		System.out.println(b);
	}

}
