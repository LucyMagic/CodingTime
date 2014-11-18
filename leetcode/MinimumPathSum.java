
public class MinimumPathSum {
	//***************Solution1 Recursion + DP memorization*************//
    private int[][] cache;
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        if(height == 0) return -1;
        int length = grid[0].length;
        if(length==0) return -1;
        cache = new int[height][length];
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < length; j++){
                cache[i][j] = Integer.MAX_VALUE;
            }
        }        
        dfs(grid, 0, 0, 0);
        return cache[height-1][length-1];
    }    
    private void dfs(int[][] grid, int i, int j, int prevSum){
        if(i < 0 || i > grid.length -1 || j < 0 || j > grid[0].length -1)
            return; 
        
        int curSum = prevSum + grid[i][j];
        if(curSum >= cache[i][j]) return;
        cache[i][j] = curSum;
             
        dfs(grid, i+1, j, curSum);
        dfs(grid, i, j+1, curSum);
    }
    
    //****************Solution2 2D DP*******************//
    public int minPathSum2DDP(int[][] grid) {
        if(grid==null) return 0;
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        if(n==0) return 0;
        
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            sum[i][0] = sum[i-1][0] + grid[i][0]; 
        }
        for(int j = 1; j < n; j++){
            sum[0][j] = sum[0][j-1] + grid[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                 sum[i][j] = grid[i][j] + Math.min(sum[i-1][j], sum[i][j-1]);
            }    
        }
        return sum[m-1][n-1];
    }
    
    //******************Solution3 1D DP******************//
    public int minPathSum1dDP(int[][] grid) {
        if(grid==null) return 0;
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        if(n==0) return 0;
        
        int[] sum = new int[n];
        sum[0] = grid[0][0];
        for(int j = 1; j < n; j++){
            sum[j] = grid[0][j] + sum[j-1];
        }
        
        for(int i = 1; i < m; i++){
            sum[0] += grid[i][0];
            for(int j = 1; j < n; j++){
                sum[j] = Math.min(sum[j], sum[j-1]) + grid[i][j];
            }
        }        
        return sum[n-1];
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[2][3];
		grid[0] = new int[]{1, 2, 5};
		grid[1] = new int[]{3, 2, 1};
		System.out.println(grid.length + " " +  grid[0].length);
	}

}
