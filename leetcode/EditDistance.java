
public class EditDistance {

	//*******************Solution 1 2D DP*****************//
    public int minDistance2DDP(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        int[][] distance = new int[M+1][N+1];
        
        for(int i = 0; i <= M; i++){
            distance[i][0] = i;
        }
        for(int j = 1; j <= N; j++){
            distance[0][j] = j;
        }
        
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                int deletion = distance[i-1][j] + 1;
                int insertion = distance[i][j-1] + 1;
                int substitution = distance[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)) substitution++;
                
                distance[i][j] = min(deletion, insertion, substitution);
            }
        }
        
        return distance[M][N];
    }    
    private int min(int i1, int i2, int i3){
        return Math.min(i1, Math.min(i2, i3));
    }
    
    //**************Solution2 Recursion****************************//
    public int minDistanceRecursion(String word1, String word2) {
        if(word1==null||word2==null) return 0;
        return minDistance(word1, word1.length(), word2, word2.length());
    }
    private int minDistance(String word1, int i1, String word2, int i2){
        if(i1==0) return i2;
        if(i2==0) return i1;
        
        int insertCount = minDistance(word1, i1, word2, i2-1)+1;
        int deleteCount = minDistance(word1, i1-1, word2, i2)+1;
        int replaceCount = minDistance(word1, i1-1, word2, i2-1)+
                           ((word1.charAt(i1)==word2.charAt(i2)) ? 0 : 1);
        return min(insertCount, deleteCount, replaceCount);            
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed = new EditDistance();
		int min = ed.minDistance2DDP("a", "ab");
		System.out.println(min);
	}

}
