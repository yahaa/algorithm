import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;
public class Main {
  public static Scanner input=new Scanner(System.in);
  public static int []mm=new int[3];
  public static void main(String []args){
    mm[0]=input.nextInt();
    mm[1]=input.nextInt();
    mm[2]=input.nextInt();
    Arrays.sort(mm);
    int n=input.nextInt();
    List<Model> models=new ArrayList<>();
    while(n-->0){
      Model t=new Model();
      t.price=input.nextInt();
      t.m[0]=input.nextInt();
      t.m[1]=input.nextInt();
      t.m[2]=input.nextInt();
      Arrays.sort(t.m);
      models.add(t);
    }

    int total1=2000;
    int res=0;
    for(Model t:models){
      if(!cmp(t.m,mm)||t.price>2000){
        System.out.println(-1);
        break;
      }else{
        
      }

    }

  }

  //b is system
  public static boolean cmp(int []a,int []b){
    for(int i=0;i<a.length;i++){
      if(a[i]>b[i])return false;
    }
    return true;
  }


}

class Model{
  int price;
  int [] m=new int[3];
}