import java.util.*;
public class Pro4{
	public static void main(String[]args){
		int []a={1,2,3,4};
		int []b={4,3,5};
		findMedianSortedArrays(a,b);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n=nums1.length;
		int m=nums2.length;
        int []a=new int[n+m];
        System.arraycopy(nums1,0,a,0,n);
        System.arraycopy(nums2,0,a,n,m);
        Arrays.sort(a);
        double median=(double) ((n+m)%2==1? a[(n+m)>>1]:(a[(n+m-1)>>1]+a[(n+m)>>1])/2.0);
        return median;
    }
}