/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK35 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {

	}

	public static ListNode deleteDuplication(ListNode pHead) {
		ListNode p = pHead;
		ListNode j = p;
		if (j == null || j.next == null)return p;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				j = p.next;
				p = p.next.next;
			} else break;
		}

		if (p == null)return p;
		if (j != p && j.val == p.val)p = p.next;

		j = p;
		while (j != null && j.next != null && j.next.next != null) {
			if (j.next.val == j.next.next.val)j.next = j.next.next.next;
			else j = j.next;
		}
		return p;

	}
}



class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
