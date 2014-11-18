import java.util.*;
public class UniquePathsII {
	//******************Solution1**************//
    //recursion + DP memorization
    private int[][] grid;
    public int uniquePathsWithObstaclesRec(int[][] obstacleGrid) {
        grid = obstacleGrid;
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        return uniquePaths(0, 0, m-1, n-1, new HashMap<Integer, Integer>());
    }
    
    private int uniquePaths(int x, int y, int m, int n, Map<Integer, Integer> cache){
        if(x > m || y > n || grid[x][y]==1) return 0;
        if(x==m && y==n) return 1;
                
        int index = y*(m+1) + x; //Note the +1
        if(cache.containsKey(index)) return cache.get(index);   
        
        int count = uniquePaths(x+1, y, m, n, cache) + uniquePaths(x, y+1, m, n, cache);
        
        cache.put(index, count);
        return count;
    }
    
    //******************Solution2**************//
    //2 dimensional DP
    public int uniquePathsWithObstacles2DP(int[][] obstacleGrid) {
        if(obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        if(m==0) return 0;
        int n = obstacleGrid[0].length;
        
        int[][] counts = new int[m][n];
        if(obstacleGrid[0][0] == 0) counts[0][0] = 1;
        for(int i = 1; i < m; i++){            
            if(counts[i-1][0] == 0 || obstacleGrid[i][0] == 1){
                counts[i][0] = 0;
            }else{
                counts[i][0] = 1;
            }
        }
        for(int j = 1; j < n; j++){
            if(counts[0][j-1] == 0 || obstacleGrid[0][j] == 1){
                counts[0][j] = 0;
            }else{
                counts[0][j] = 1;
            }
        }        
        for(int i = 1; i < m; i++){
            int total = counts[i][0];
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j]==0)
                    counts[i][j] += counts[i-1][j] + counts[i][j-1];
                total += counts[i][j];
            }
            if(total==0) return 0;
        }
        return counts[m-1][n-1];
    }
    
    //******************Solution3: one dimensional DP*****************************//
    public int uniquePathsWithObstacles1DP(int[][] obstacleGrid) {
        if(obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        if(m==0) return 0;
        int n = obstacleGrid[0].length;
        if(n==0) return 0;

        int[] counts = new int[n];
        counts[0] = 1 ^ obstacleGrid[0][0];
        int total = 0;
        for(int i = 0; i < m; i++){
            counts[0] = (counts[0]==0 || obstacleGrid[i][0] == 1) ? 0 : 1;
            total = counts[0];
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    counts[j] = 0;
                }else{
                    counts[j] += counts[j-1];
                }
                total += counts[j];
            }
            if(total == 0) return 0;
        }        
        return counts[n-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
