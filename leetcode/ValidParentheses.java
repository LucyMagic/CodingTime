import java.util.*;
public class ValidParentheses {
	//*************Solution2*************//
	//more extensible code
	private static final Map<Character, Character> map;
	static{
		map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
	}	
	
	public boolean isValid1(String s){
		if(s==null) return false;
		ArrayDeque<Character> stack = new ArrayDeque<Character>();		
		for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)){
    			stack.push(c);
    		}else{
    			char left = map.get(c);
    			if(stack.isEmpty() || left!=stack.pop()) 
    				return false;
    		}
		}
		return stack.isEmpty();
	}

	//*************Solution2*************//
	//more concise code
    public boolean isValid2(String s) {
        if(s==null || s.length()==0) return true;
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch); continue;
            }
            if(stack.isEmpty()) return false;
            char top = stack.pop();
            if(ch==')'&&top!='(' || ch=='}'&&top!='{' || ch==']'&&top!='[')
                return false;
        }
        return stack.isEmpty();
    }
	
    //*************Solution2*************//
  	//methods decoupled
	public boolean isValid3(String s) {
        ArrayDeque<Character> leftParens = new ArrayDeque<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isLeftParens(c)){
                leftParens.push(c);
            }else{
                if(leftParens.isEmpty() || !isMatch(leftParens.pop(), c)){
                    return false;
                }
            }
        }
        return leftParens.isEmpty();
    }
    
    private boolean isLeftParens(char c){
        if(c == '(' || c == '[' || c == '{')
            return true;
        else
            return false;
    }
    
    private boolean isMatch(char left, char right){
        if(left == '(' && right == ')')
            return true;
        if(left == '[' && right == ']')
            return true;
        if(left == '{' && right == '}')
            return true;
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
