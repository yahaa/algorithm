/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK33 {
	public static int res = 0;
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {

		int []a={3,2,1,3,4,4,5,5};
		int []res1=new int[1];
		int []res2=new int[1];
		findNumsAppearOnce(a,res1,res2);
		println(res1[0]+" "+res2[0]);


	}

	public static void deep(TreeNode root, int dp) {
		if (root == null)return;
		res = Math.max(res, dp);
		deep(root.left, dp + 1);
		deep(root.right, dp + 1);

	}

	public static int deep(TreeNode root) {
		int res = 0;
		if (root == null)return res;
		res = 1;
		return res += Math.max(deep(root.left), deep(root.right));

	}

	public static boolean isBalanced_Solution(TreeNode root) {
		boolean res = true;
		if (root == null) return res;
		int d1 = deep(root.left);
		int d2 = deep(root.right);
		res &= Math.abs(d1 - d2) <= 1;
		return res &= isBalanced_Solution(root.left) & isBalanced_Solution(root.right);

	}


	public static void findNumsAppearOnce(int [] array, int num1[] , int num2[]) {
		if (array == null || array.length <= 1) {
			num1[0] = num2[0] = 0;
			return;
		}
		int len = array.length, index = 0, sum = 0;
		for (int i = 0; i < len; i++) {
			sum ^= array[i];
		}

		for (index = 0; index < 32; index++) {

			if ((sum & (1 << index)) != 0) break;
		}
		for (int i = 0; i < len; i++) {
			if ((array[i] & (1 << index)) != 0) {
				num2[0] ^= array[i];
			} else {
				num1[0] ^= array[i];
			}
		}
	}
}


class Value {
	public int v = 0;
}


class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}
