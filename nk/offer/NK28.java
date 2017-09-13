/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK28 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {

		int []a = {3, 32, 321};
		println(PrintMinNumber(a));


	}

	public static int moreThanHalfNum_Solution(int []arr) {
		if (arr.length <= 0)return 0;
		int c = 0;
		int t = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (c == 0) {
				t = arr[i];
				c++;
			} else {
				if (t == arr[i])c++;
				else c--;
			}
		}

		c = 0;
		for (int i = 0; i < arr.length; i++)if (arr[i] == t)c++;
		if (c + c <= arr.length)return 0;
		return t;
	}

	public static void qsort(int []arr) {
		qSortInner(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			print(arr[i] + " ");
		}
	}


	public static void qSortInner(int []arr, int left, int right) {
		if (left >= right)return;
		int i = left, j = right;
		int p = arr[left];
		while (i != j) {
			while (arr[j] >= p && i < j)j--;
			while (arr[i] <= p && i < j)i++;
			if (i < j)swap(arr, i, j);
		}
		swap(arr, i, left);
		qSortInner(arr, left, i - 1);
		qSortInner(arr, i + 1, right);
	}

	public static void swap(int []arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static int maxSumSubArray(int []arr) {
		int n = arr.length;
		if (n <= 0)return 0;
		int ans = arr[0], now = arr[0];
		for (int i = 1; i < n; i++) {
			if (now < 0)now = arr[i];
			else now += arr[i];
			if (now > ans)ans = now;

		}
		return ans;
	}

	public static int count1(int n) {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int t = i;
			while (t > 0) {
				if (t % 10 == 1)ans++;
				t /= 10;
			}
		}
		return ans;
	}

	public static String printMinNumber(int [] numbers) {
		ArrayList<Integer>num=new ArrayList<>();
		for(int i=0;i<numbers.length;i++){
			num.add(numbers[i]);
		}

		Collections.sort(num, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1.toString() + o2.toString();
				String s2 = o2.toString() + o1.toString();
				return s1.compareTo(s2);
			}
		});


		String res = "";
		for(Integer i:num){
			res+=i.toString();
		}
		return res;

	}

}
class Heap {

}