/**
*	Author: zihua
**/
import java.util.*;

public class Pro10 {
    public static Scanner input = new Scanner(System.in);

    public static <E> void print(E e) {
        System.out.print(e);
    }

    public static <E> void println(E e) {
        System.out.println(e);
    }

    public static void main(String []args) {
    	int []u=new int[128];
    	while(input.hasNext()){
    		Arrays.fill(u,0);
    		String s=input.nextLine();
    		int n=s.length();
    		int res=0;
    		for(int i=0;i<n;i++){
    			int t=(int)s.charAt(i);
    			if(t>=0&&t<=127&&u[t]==0){
    				u[t]++;
    				res++;
    			}
    		}
    		println(res);
    	}
    }
}