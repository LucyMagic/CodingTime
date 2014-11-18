public class PalindromeNumber {
    public boolean isPalindrome2(int x){
    	if(x<0) return false;
		int div = 1;
		while(x/div>=10){
			div *= 10;
		}
		
		while(x>0){
			int lo = x%10;
			int hi = x/div;
			if(lo!=hi) return false;
			x = (x-lo-hi*div)/10;
			div /= 100;
		}
		return true;
	}
		
    public boolean isPalindrome1(int x) {
        if(x<0) return false;
        int numOfDigits = 0;
        int temp = x;
        while(temp>0){
            numOfDigits++;
            temp/=10;
        }
        
        while(x>0){
            int lo = x%10;
        	int hi = (int)(x/Math.pow(10,numOfDigits-1));
        	if(lo!=hi) return false;
        	x = (int)(x-lo-(hi*Math.pow(10,numOfDigits-1)))/10;
            numOfDigits-=2;
        }
        return true;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber pn = new PalindromeNumber();
		boolean b = pn.isPalindrome2(101);
		System.out.println(b);
	}

}
