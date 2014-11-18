
public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        
        int mid1Index = (m+n-1)/2, mid2Index = (m+n)/2;
        int mid1 = 0, mid2 = 0;
        int i = 0, j =0;
        for(int k = 0; k <= mid2Index; k++){
            int kth = 0;
            if(i==m)               kth = B[j++];
            else if(j==n)          kth = A[i++];
            else if(A[i]>B[j])     kth = B[j++];
            else if(A[i]<=B[j])    kth = A[i++];
            
            if(k==mid1Index) mid1 = kth;
            if(k==mid2Index) mid2 = kth;            
        }
        return (mid1+mid2)/2.0;
    }
    
    
	public static void main(String[] args) {
		int[] A = {};
		int[] B = {2,3};
		MedianOfTwoSortedArray ms = new MedianOfTwoSortedArray();
		double d = ms.findMedianSortedArrays(A, B);
		System.out.println(d);
	}

}
