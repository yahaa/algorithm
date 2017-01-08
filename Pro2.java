public class Pro2 {
	public static void main(String[]args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		ListNode l3 = addTwoNumbers(l2, l1);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = l1;
		int c = 0;
		while (l1 != null && l2 != null) {
			int tt = l1.val + l2.val + c;
			c = tt / 10;
			tt %= 10;
			l1.val = tt;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int tt = l1.val + c;
			c = tt / 10;
			tt %= 10;
			l1.val = tt;
			l1 = l1.next;
		}

		while (l2 != null) {
			int tt = l2.val + c;
			c = tt / 10;
			tt %= 10;
			l1.next = new ListNode(tt);
			l1 = l1.next;
			l2 = l2.next;

		}
		if (c == 0)return root;
		l1 = new ListNode(c);
		return root;

	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}