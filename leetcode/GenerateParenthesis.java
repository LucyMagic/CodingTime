import java.util.ArrayList;

public class GenerateParenthesis {

	private ArrayList<String> allValidParens;
    private char[] a;
    public ArrayList<String> generateParenthesis(int n) {
        allValidParens = new ArrayList<String>();
        a = new char[2*n];
        enumerate(0, 0, n);
        return allValidParens;
    }
    
    private void enumerate(int leftP, int rightP, int num){
        if(rightP > leftP || leftP > num)//not allowed
            return;
        if(leftP == num && rightP == num){
            allValidParens.add(new String(a));
            return; // Note the need to return.
        }
        int index = leftP + rightP;
        a[index] = '(';
        enumerate(leftP+1, rightP, num);
        a[index] = ')';
        enumerate(leftP, rightP+1, num);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis gp = new GenerateParenthesis();
		gp.generateParenthesis(1);
	}

}
