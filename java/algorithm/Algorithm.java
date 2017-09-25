import static java.util.Arrays.*;
import java.util.ArrayList;
import java.util.List;
public class Algorithm {
    public static final int N = 10000;
    public static int []prime = new int[N];

    public static void main(String []args) {
        // int []a = {1, 7, 15, 20, 3, 3, 4, 5, 7,100,2,44,22,2,34,5,6,7};
        // mergeSort(a);
        // for (int i = 0; i < a.length; i++) {
        //     System.out.print(a[i] + " ");
        // }
        int []a={1,2,3,4,6};
        System.out.println(isGood(a));
    }

    public static  List<Integer> solve() {
        fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        List<Integer>res = new ArrayList<>();

        for (int i = 2; i < N; i++) {
            if (prime[i] == 1) {
                res.add(i);
                for (int k = i * i; k < N; k += i)prime[k] = 0;
            }
        }
        return res;
    }


    public static void merge(int []a, int left, int mid, int right, int []t) {
        if (a.length != t.length)return;
        int k = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (a[i] < a[j])t[k++] = a[i++];
            else t[k++] = a[j++];
        }

        while (i <= mid)t[k++] = a[i++];
        while (j <= right)t[k++] = a[j++];
        for (int tk = 0; tk < k; tk++) {
            a[left + tk] = t[tk];
        }
    }

    public static void mergeSort(int []a) {
        int n=a.length;
        int []t=new int[n];
        mergeSortInner(a,0,n-1,t);
    }

    public static void mergeSortInner(int []a, int left, int right, int []tm) {
        if(left>=right)return;
        int mid=left+(right-left)/2;
        mergeSortInner(a,left,mid,tm);
        mergeSortInner(a,mid+1,right,tm);
        merge(a,left,mid,right,tm);
    }

    public static boolean isGood(int []a){
        mergeSort(a);
        int z=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0)z++;
        }

        int mm=-1000;
        for(int i=1;i<5;i++){
            if(a[i]>0&&a[i-1]>0)
                mm=Math.max(a[i]-a[i-1],mm);
        }

        if(z>=4)return true;
        if(z==3&&mm<=4)return true;
        if(z==2&&mm<=3)return true;
        if(z==1&&mm<=2)return true;
        if(z==0&&mm<=1)return true;
        return false;
    }
}
