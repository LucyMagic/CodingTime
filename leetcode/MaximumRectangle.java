import java.util.*;
public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null) return 0;
        int height = matrix.length;
        if(height==0) return 0;
        int length = matrix[0].length;
        if(length==0) return 0;
        
        int max = 0;
        int[] nums = new int[length];
        for(int i=0; i<height; i++){
            for(int j=0; j<length; j++){
                if(matrix[i][j]=='0'){
                    nums[j] = 0;
                }else{
                    nums[j] += 1;
                }
            }
            int maxArea = largestRectangleArea(nums);
            max = Math.max(max, maxArea);
        }
        return max;
    }    
    private int largestRectangleArea(int[] height) {
        int N = height.length;
        if(N==0) return 0;
                
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int maxArea = 0, i = 0;
        while(true){
            if(i<N && (stack.isEmpty() || height[i] >= height[stack.peek()])){
                stack.push(i++);
            }else{
                if(stack.isEmpty()) break;
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i-stack.peek()-1;
                maxArea = Math.max(maxArea, h*w);
            }
        }        
        return maxArea;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
