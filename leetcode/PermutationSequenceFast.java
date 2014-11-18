
public class PermutationSequenceFast {
	public String getPermutation(int n, int k) {
		int[] num = new int[n];
		int product = 1;
		for(int i = 0; i < n; i++){
			num[i] = i+1;
			product *= (i+1);
		}
		k--;
		for(int i = 0; i < n; i++){
			product /= (n-i);
			int curNum = k / product;
			int temp = num[i+curNum]; 
			//shift all element in num[]
			for(int j = curNum+i; j > i; j--){
				num[j] = num[j-1];
			}
			num[i] = temp;
			k %= product;
		}
		String result = "";
		for(int i : num){
			result += i;
		}
		return result;
	}

	public String getPermutation(int n, int k) {
        	int count = 1;
       		for(int i = 1; i<=n; i++){
            		count = count*i;
        	}
       		if(k>count) return "";
        
        	String result ="";
        	List<Integer> numbers = getList(n);
       	 	while(numbers.size()>1){
            		count /= n;
            		int index = (k+count-1)/count;
            		result += numbers.remove(index);
            		k -= (index-1)*count;
        	    	n--;
        		}
        	return result;
   	 }
    	private List<Integer> getList(int n){
       		List<Integer> list = new ArrayList<Integer>(n+1);
       		for(int i = 0; i <= n; i++){
            		list.add(i);
        	}
        	return list;
    	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequenceFast ps = new PermutationSequenceFast();
		String str = ps.getPermutation(3, 2	);
		System.out.println(str);
	}

}
