import java.util.*;
public class LargestRectangelInHistogram {
	//******************brute force with pruning*************//
    public int largestRectangleArea1(int[] height) {
        int length = height.length;
        if(length == 0) return 0;
        int maxArea = 0;
        
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(height[j] >= height[j-1]){
                    i = j;
                }else{
                    i = j - 1;
                    break;
                }
            }            
            int lowest = height[i];
            for(int k = i; k >= 0; k--){
                if(height[k]<lowest) lowest = height[k];
                int area = lowest * (i-k+1);
                if(area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }
    
    //******************Solution 2 use stack*************//
	/*Solution 2 and solution 3 uses the same idea with a stack. 
	 * Code in solution 2 is more readable and easy to understand*/
    public int largestRectangleArea2(int[] height) {
        int N = height.length;
        if(N==0) return 0;
        
        int maxArea = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < N; i++){
            if(stack.isEmpty() || height[i] >= height[stack.peek()]){
                stack.push(i);
            }else{//current element is smaller than top of stack
                while(!stack.isEmpty() && height[i] < height[stack.peek()]){
                    int h = height[stack.pop()];
                    int w = stack.isEmpty() ? i : i-stack.peek()-1 ;
                    maxArea = Math.max(maxArea, h*w);
                }
                stack.push(i);
            }
        }
        //process the rest of the elements left on stack
        while(!stack.isEmpty()){
            int last = stack.pop();
            int h = height[last];
            int w = stack.isEmpty() ? N : N-stack.peek()-1;
            maxArea = Math.max(maxArea, h*w);
        }        
        return maxArea;
    }
    
    
    //******************Solution 3 use stack*************//
    /* This solution is very concise and eliminate duplicate code
     */
    public int largestRectangleArea3(int[] height) {
        int N = height.length;
        if(N==0) return 0;
                
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int maxArea = 0, i = 0;
        while(true){
            if(i<N && (stack.isEmpty() || height[i] >= height[stack.peek()])){
                stack.push(i++);
            }else{
            	//Only when the stack is empty will we break out of the loop
            	//No need for while loop since we do not forward pointer for i in this branch
                if(stack.isEmpty()) break;
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i-stack.peek()-1;
                maxArea = Math.max(maxArea, h*w);
            }
        }        
        return maxArea;
    }
        
	public static void main(String[] args) {

	}

}
