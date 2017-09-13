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
		println(binarySearch(a, 8));

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
}



class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}