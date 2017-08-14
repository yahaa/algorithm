import java.util.Arrays;
public class Pro581{
    public static void main(String []args){
        int []a={1,2,3,2};
        System.out.println(solve(a));
    }

    public static int solve(int []a){
        int n=a.length;
        int []t=new int[n];
        System.arraycopy(a,0,t,0,n);
        Arrays.sort(t);
        int start=0,end=n-1;
        while(start<n&&a[start]==t[start])start++;
        while(end>start&&a[end]==t[end])end--;
        return end-start+1;
    }
}
