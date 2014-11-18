import java.util.*;
public class UniquePaths {
	//***********Solution 1 Recursion + DP memorization********//
    private Map<Integer, Integer> cache;
    public int uniquePaths(int m, int n) {
        cache = new HashMap<Integer, Integer>();
        return enumerate(0, 0, m-1, n-1);
    }
    private int enumerate(int x, int y, int m, int n){
    	if(x>m || y>n) return 0;
    	if(x==m && y==n) return 1;
    	
        int key = y*m + x;
        if(cache.containsKey(key)) return cache.get(key);        
        
        int count = enumerate(x+1, y, m, n) + enumerate(x, y+1, m, n);
        cache.put(key, count);
        return count;
    }
    
    //*****************Solution 2 2D DP**************//
    public int uniquePathsDP2D(int m, int n) {
        if(m==0&&n==0) return 0;
        
        int[][] counts = new int[m][n];
        for(int i = 0; i < m; i++){
            counts[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            counts[0][j] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                counts[i][j] += counts[i-1][j] + counts[i][j-1];
            }
        }
        return counts[m-1][n-1];
    }
    
    //*****************Solution3 1D DP**************//
	
    
    
    
    //*****************Solution4: by formula*******************//
    public int getPathCounts(int m, int n){
    	return (int) (factorial(m+n-2)/(factorial(m-1)*factorial(n-1)));
    }
    
    private long factorial(int n){
    	long fact = 1;
    	for(int i = 1; i <= n; i++){
    		fact *= i;
    	}
    	return fact;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths up = new UniquePaths();
		int n = up.uniquePaths(1, 2);
		int m = up.getPathCounts(10, 10);
		System.out.println(n);
		System.out.println(m);
	}

}
