/**
*	Author: zihua
**/
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Pro6 {
	public static Scanner input = new Scanner(System.in);

	public static List<Integer> prime = new ArrayList<>();

	public static int MAX = 100000;
	public static void init() {
		int []p = new int[MAX];
		Arrays.fill(p, 1);
		for (int i = 2; i < MAX; i++) {
			if (p[i] == 1) {
				prime.add(i);
				for (int j = i + i; j < MAX; j += i) {
					p[j] = 0;
				}
			}
		}

	}

	public static <E> void print(E e) {
		System.out.println(e);
	}

	public static void solve(long n) {

		ArrayList<Integer>res=new ArrayList<>();
		for(Integer t:prime){
			while(n%t==0){
				res.add(t);
				n/=t;
			}
		}

		for(Integer t:res){
			System.out.print(t+" ");
		}

	}

	public static void main(String []args) {
		init();
		while(input.hasNext()){
			solve(input.nextInt());
		}
	}
}