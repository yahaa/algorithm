import java.util.*;
public class Pro119{
    public static int [][]c=new int[50][50];

    public static void init(){
        c[0][0]=1;
        for(int i=1;i<50;i++){
            c[0][i]=1;
            for(int j=1;j<=i;j++){
                c[j][i]=c[j-1][i-1]+c[j][i-1];
            }
        }

        // for(int i=0;i<30;i++){
        //     for(int j=0;j<=i;j++){
        //         System.out.print(c[j][i]+" ");
        //     }
        //     System.out.println();
        // }
    }


    public static void t(){
        int []a=new int[4];
        a[0]=1;
        for(int i=1;i<4;i++){
            for(int j=i;j>=1;j--){
                a[j]+=a[j-1];
                System.out.println(a[j]);
            }

        }
    }



    public static void main(String []args){
        t();
        // List<Integer>res=getRow(1);
        // // System.out.println(res.size());
        // for(int i=0;i<res.size();i++){
        //     System.out.println(res.get(i));
        // }

    }

    public static List<Integer>getRow(int rowIndex){
        t();
        init();
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            int r=c[i][rowIndex];
            res.add(r);
        }
        return res;

    }

    public static int cnm(int n,int m){
        int t1=1;
        for(int i=n;i>n-m;i--){
            t1*=i;
        }
        // System.out.println(t1);
        int t2=factorial(m);
        return t1/t2;
    }

    public static int factorial(int n){
        int res=1;
        for(int i=1;i<=n;i++){
            res*=i;
        }
        return res;
    }
}
