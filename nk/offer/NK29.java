/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK29 {
    public static Scanner input = new Scanner(System.in);
    public static int MAX=10000000;
    public static int []ug=new int[100000];


    public static <E> void print(E e) {
        System.out.print(e);
    }

    public static <E> void println(E e) {
        System.out.println(e);
    }

    public static void main(String []args) {
    	ug(15);
       
    }

    public static int ug(int index){
    	if(index<=0)return 0;
    	int []res=new int[index];
    	int count=0;
    	int t2=0,t3=0,t5=0;
    	res[0]=1;
    	int temp=0;
    	while(count<index-1){
    		temp=min(min(res[t2]*2,res[t3]*3),res[t5]*5);
    		
    		if(res[t2]*2==temp)t2++;
    		if(res[t3]*3==temp)t3++;
    		if(res[t5]*5==temp)t5++;
    		res[++count]=temp;
    	}

    	return res[index-1];
    }
}