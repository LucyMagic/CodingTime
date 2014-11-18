
public class NextPermutation {

    public void nextPermutation(int[] num) {
        if(num==null || num.length==0) return;
        
        int pivotIndex = findPartition(num);
        if(pivotIndex==0){
            reverseArray(num, 0, num.length-1);
        }else{
            exch(num, pivotIndex-1, findFirstLarger(num, pivotIndex-1));
            reverseArray(num, pivotIndex, num.length-1);
        }
    }
    private int findPartition(int[] num){
        for(int i=num.length-1; i>0; i--){
            if(num[i]>num[i-1]){
                return i;
            }
        }
        return 0;
    }
    private int findFirstLarger(int[] num, int index){
        int number = num[index];
        for(int i=num.length-1; i>index; i--){
            if(num[i]>number){
                return i;
            }
        }
	//shouldn't happen
        return num.length-1;
    }
    private void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private void reverseArray(int[] num, int start, int end){
        while(start<end){
            exch(num, start++, end--);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {5,1,1};
		NextPermutation np = new NextPermutation();
		np.nextPermutation(num);
		for(int i : num){
			System.out.println(i);
		}
	}

}
