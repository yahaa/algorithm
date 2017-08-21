import java.util.*;
import static java.lang.Math.*;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] a) {
      int n=a.length;
      int []res=new int[n];
      int val=0;
      for(int i=0;i<n;i++){
        res[i]=1;
        for(int j=i;j>=0;j--){
          if(a[i]>a[j])res[i]=max(res[i],res[j]+1);
          val=max(res[i],val);
        }
      }
      return val;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }
}
