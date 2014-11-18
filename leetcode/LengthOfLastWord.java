
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = s.length();
        int end = length-1;
        while(end>=0 && s.charAt(end)==' '){
            end--;
        }
        int start = end;
        while(start>=0 && s.charAt(start)!=' '){
            start--;
        }
        return end - start;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
