
public class Sqrt {

    public int sqrt(int x) {
        if(x < 0) return 0;
        if(x == 0 || x == 1) return x;       
        return binarySearch(x, 1, x);
    }
    
    private int binarySearch(int x, int lo, int hi){
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(x/mid == mid){ 
                return mid;
            }else if(x/mid < mid){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }        
        if(x/lo < lo) return lo-1;
        return lo;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt s = new Sqrt();
		int i =s.sqrt(2147483647);
		System.out.println(i);
		int e = 8;
		if(7.5>7){
			System.out.println(e-0.5);
		}
	}

}
