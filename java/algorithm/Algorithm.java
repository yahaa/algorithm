import static java.util.Arrays.*;
import java.util.ArrayList;
import java.util.List;
public class Algorithm {
    public static final int N=10000;
    public static int []prime=new int[N];

    public static void main(String []args){
        List<Integer>res=solve();
        for(int i=0;i<100;i++){
            System.out.println(res.get(i));
        }

        for(int i=0;i<100;i++){
            System.out.println(i+" "+prime[i]);
        }
    }

    public static  List<Integer> solve(){
        fill(prime,1);
        prime[0]=0;
        prime[1]=0;
        List<Integer>res=new ArrayList<>();

        for(int i=2;i<N;i++){
            if(prime[i]==1){
                res.add(i);
                for(int k=i*i;k<N;k+=i)prime[k]=0;
            }
        }
        return res;
    }
}
