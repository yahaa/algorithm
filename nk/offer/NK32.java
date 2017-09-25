/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK32 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		int []a = {1, 2, 3, 4, 5, 6, 7, 9};
		// println(binarySearch(a, 8));
		twoSum(a, 12);
		String s = "abcdefghjkl";
		println(leftRota(s, 10));

	}

	public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode n = null;
		while (pHead1 != null && n == null) {
			ListNode t = pHead2;
			while (t != null) {
				if (t.val == pHead1.val) {
					n = t;
					break;
				} else
					t = t.next;
			}
			pHead1 = pHead1.next;
		}
		return n;

	}

	public static int binarySearch(int []a, int target) {
		int left = 0, right = a.length - 1;
		int mid = left + (right - left) / 2;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (target == a[mid]) {
				while (mid > 0 && a[mid - 1] == target)mid--;
				return mid;
			} else if (a[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -(mid + 1);

	}

	public static ArrayList<Integer> twoSum(int []a, int su) {
		int n = a.length;
		ArrayList<Integer>res = new ArrayList<>();
		if (n < 2)return res;
		int m = su * su;
		int res1 = -1, res2 = -1;
		int []vi = new int[n];
		for (int i = 0; i < n; i++) {
			if (vi[i] == 0) {
				int t = su - a[i];
				int index = binarySearch(a, t);
				if (index >= 0 && index != i) {
					vi[i] = 1;
					vi[index] = 1;
					if (a[i] * a[index] < m) {
						m = a[i] * a[index];
						res1 = Math.min(a[i], a[index]);
						res2 = Math.max(a[i], a[index]);
					}
				}
			}
		}
		if (res1 == -1 || res2 == -1)return res;
		res.add(res1);
		res.add(res2);
		return res;
	}

	public static String leftRota(String str, int n) {
		String res = "";
		int len = str.length();
		if (len <= 0)return res;
		n %= len;
		res += str.substring(n);
		res += str.substring(0, n);
		return res;
	}


	public static String rev(String str){
		String res="";
		if(str==null||str.length()<=0)return res;
		String []t=str.split("[ ]+");
		for(int i=t.length-1;i>=0;i++)res+=t[i]+" ";
		return res;

	}

	public static boolean isGood(int []a){
		
	}
}



class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}