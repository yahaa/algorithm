/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;
import static java.lang.Character.*;
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
		String aaa="1234567";
		println(strToInt(aaa));

		println(tSum(9,5));
		int bb = 4;
		println(sum(10));


		int []a = {3, 2, 1, 3, 4, 4, 5, 5};
		int []res1 = new int[1];
		int []res2 = new int[1];
		findNumsAppearOnce(a, res1, res2);
		println(res1[0] + " " + res2[0]);


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

	public static int soo(int n, int k) {
		return n > 1 ? (soo(n - 1, k) + k) % n : 0;
	}

	public static int sum(int n) {
		int temp = 0;
		boolean t = (n > 0) && ((temp += sum(n - 1)) > 0);
		return n + temp;
	}

	public static int tSum(int a, int b) {
		int sum = 0, c = 0;
		do {
			sum = a ^ b;
			b = (a & b) << 1;    //jingwei
			a = sum;
		} while (b != 0);

		return sum;
	}

	public static int strToInt(String str){
		int res=0;
		int n=str.length();
		if(n<=0)return 0;
		Character z=str.charAt(0);
		int ng=1;
		int i=0;
		if(z=='+'){
			i++;
		}else if(z=='-'){
			ng=-1;
			i++;
		}
		for(;i<n;i++){
			Character c=str.charAt(i);
			if(!isDigit(c))return 0;
			res=res*10+((int)(c)-48);
		}

		return res*ng;

	}

	public static int[]multiply(int []a){
		
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
