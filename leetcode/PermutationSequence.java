public class PermutationSequence {
    private int counter = 0;
    public String getPermutation(int n, int k) {
        counter = 0; //reset field for leetcode
        String wholeString = "";
        for(int i = 1; i <= n; i++){
            wholeString += i;
        }
        return permute(k, "", wholeString);
    }
    
    private String permute(int k, String prefix, String rest){
        int n = rest.length();       
        if(n == 0){
            counter++;    
        }
        if(counter==k){
            return prefix;   
        }        
        for(int i = 0; i < n; i++){
            String curPerm = permute(k, prefix+rest.charAt(i), rest.substring(0, i) + rest.substring(i+1));
            if(curPerm!=null)
                return curPerm;
        }
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence ps = new PermutationSequence();
		String str = ps.getPermutation(2, 1);
		System.out.println(str);
	}

}
