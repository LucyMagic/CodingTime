
public class CountAndSay {

	public String countAndSay(int n) {
        String num = "1";
        
        for(int i=1; i<n; i++){
            StringBuilder newNum = new StringBuilder();
            int j =0;
            while(j<num.length()){
                int end = j;
                char c = num.charAt(j);
                while(end<num.length() && num.charAt(end)==c){
                    end++;
                }
                int numRepeats = end-j;
                newNum.append(Integer.toString(numRepeats));
                newNum.append(c);
                j=end;
            }           
            num = new String(newNum);
        }
        return num;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
