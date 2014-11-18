
public class SortColors {

    public void sortColors(int[] A) {
        int lt = 0, gt = A.length - 1;
        int i = 0;       
        while(i <= gt){
            if(A[i] > 1)        exch(A, i, gt--);
            else if(A[i] < 1)   exch(A, i++, lt++);
            else                i++;
        }
    }   
    private void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
