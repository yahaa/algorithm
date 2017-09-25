/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK36 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {

	}

	 boolean isSymmetrical(TreeNode pRoot) {
		TreeNode t = mirrod(pRoot);
       return preOrder(pRoot,t);

	}

	public boolean preOrder(TreeNode root1,TreeNode root2) {
		if (root1 == null&&root2==null) return true;
        if((root1==null&&root2!=null)||(root1!=null&&root2==null))return false;
        if(root1.val!=root2.val)return false;
		return preOrder(root1.left,root2.left)&preOrder(root1.right,root2.right);
	}

	public TreeNode mirrod(TreeNode root) {
		if (root == null)return root;
        TreeNode res=new TreeNode(root.val);
        res.left=mirrod(root.right);
        res.right=mirrod(root.left);
		return res;

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
