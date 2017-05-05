import java.util.Arrays;
import java.lang.Math;
public class NK23{
    public static void main(String[]args){
        int []a={1,2,3,4,5};
        System.out.println(isLRD(a));
    }

    public static boolean isLRD(int []a){
        int n=a.length;
        if(n<=2)return true;
        int li=0,ri=n-1;
        while((li<n-2)&&a[li]<a[n-1])li++;
        while((ri-1)>=0&&a[ri-1]>a[n-1])ri--;

        System.out.println("li---  "+li);
        System.out.println("ri--- "+ri);
        if(Math.abs(ri-li)>1)return false;
        int []lefta=Arrays.copyOfRange(a,0,li);
        int []righta=Arrays.copyOfRange(a,ri,n-1);
        return isLRD(lefta)&isLRD(righta);
    }
}
