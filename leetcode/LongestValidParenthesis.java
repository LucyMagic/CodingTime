import java.util.*;
public class LongestValidParenthesis {
	/* **************************Solution 1************************
	 * Note the initial value for variable lastRight. Have to consider the case when the first 
	 * char is a leftP
	 */
    public int longestValidParentheses1(String s) {
        if(s==null || s.length()==0) return 0;
        
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int max = 0, last = -1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(') stack.push(i);
            else{
                if(stack.isEmpty()){
                    last = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, i-last);
                    }else{
                    	max = Math.max(max, i-stack.peek());
                    }
                }
            }
        }
        return max;
    }
    
	/* **************************Solution 2************************
	 * Find out whether each parenthesis is a valid one, count the longest consecutive valid parens
	 */
    public int longestValidParentheses2(String s) {
        if(s==null || s.length()==0) return 0;
        boolean[] isValid = new boolean[s.length()];
        
        int leftP = 0; 
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(') leftP++;
            else if(leftP>0){
                leftP--;
                isValid[i] = true;
            }
        }
        
        int rightP = 0;
        for(int i = s.length()-1; i >= 0 ; i--){
            char ch = s.charAt(i);
            if(ch==')') rightP++;
            else if(rightP>0){
                rightP--;
                isValid[i] = true;
            }
        }
        
        int max = 0, count = 0;
        for(int i = 0; i < isValid.length; i++){
            if(isValid[i] == false){
                max = Math.max(max, count);
                count = 0;
            }else{
                count++;
            }
        }
        max = Math.max(count, max);
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
