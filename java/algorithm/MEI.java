/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class MEI {
    public static Scanner input = new Scanner(System.in);

    public static <E> void print(E e) {
        System.out.print(e);
    }

    public static <E> void println(E e) {
        System.out.println(e);
    }

    public static void main(String []args) {
    	// int n=input.nextInt();
    	// int []d=new int[n];
    	// int c1=0;
    	// for(int i=0;i<n;i++){
    	// 	int t=input.nextInt();
    	// 	if(t==1)c1++;
    	// }

    	// if(c1%2==0)println("Alice");
    	// else println("Bob");
    	solve();
    }


    public static void solve(){
    	int n=input.nextInt();
    	long []t=new long[n];
    	for(int i=0;i<n;i++){
    		t[i]=input.nextLong();
    	}

    	int res=0;
    	for(int i=0;i<n;i++){
    		for(int j=i+1;j<n;j++){
    			String t1=t[i]+""+t[j];
    			String t2=t[j]+""+t[i];
    			res+=isOk(t1);
    			res+=isOk(t2);
    		}
    	}

    	println(res);
    }

    public static int isOk(String s){
    	Long v=Long.valueOf(s);
    	if(v%7==0)return 1;
    	return 0;
    }



}