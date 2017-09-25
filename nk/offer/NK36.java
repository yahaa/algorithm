/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;
import java.util.
import java.util.Collections;

public class NK36 {
	public static Scanner input = new Scanner(System.in);
	public static int index = -1;

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		String s = "5,4,#,3,#,2";

	}

	public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) return res;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(pRoot);
		int s = 0, e = 1;
		ArrayList<Integer> row = new ArrayList<Integer>();
		int t = 1;
		while (!q.isEmpty()) {
			TreeNode tn = q.poll();
			row.add(tn.val);
			s++;
			if (tn.left != null) q.offer(tn.left);
			if (tn.right != null) q.offer(tn.right);
			if (s == e) {
				s = 0;
				e = q.size();
				if (t % 2 == 1) res.add(row);
				else {
					Collections.reverse(row);
					res.add(row);
				}
				t++;
				row = new ArrayList();
			}
		}
		return res;
	}



	public static String Serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder("");
		if (root == null)return sb.toString();
		ser(root, sb);
		return sb.toString();

	}

	public static void ser(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val + ",");
		ser(root.left, sb);
		ser(root.right, sb);
	}
	public static TreeNode Deserialize(String str) {
		index = -1;
		if (str.length() <= 0)return null;
		String []strs = str.split(",");
		return des(strs);

	}

	public static TreeNode des(String []str) {
		index++;
		if (index >= str.length || str[index].equals("#"))return null;
		int val = Integer.valueOf(str[index]);
		TreeNode node = new TreeNode(val);
		node.left = des(str);
		node.right = des(str);
		return node;
	}

}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}
