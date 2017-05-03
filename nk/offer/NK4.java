

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class NK4{
    public static void main(String []args){
        int []pre= {1,2,4,7,3,5,6,8};
        int []in= {4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,in);


    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode node=tree(pre,in);
        bfs(node);
        return node;

    }

    public static TreeNode tree(int []pre,int []in){
        if(pre.length==0)return null;
        TreeNode node=new TreeNode(pre[0]);
        int l=0;
        while(in[l]!=pre[0])l++;
        int []inl=Arrays.copyOfRange(in,0,l);
        int []inr=Arrays.copyOfRange(in,l+1,in.length);

        int []prel=Arrays.copyOfRange(pre,1,1+l);
        int []prer=Arrays.copyOfRange(pre,1+l,pre.length);

        node.left=tree(prel,inl);
        node.right=tree(prer,inr);
        return node;

    }

    public static void bfs(TreeNode node){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode t=queue.poll();
            System.out.println(t.val);
            if(t.left!=null)queue.offer(t.left);
            if(t.right!=null)queue.offer(t.right);
        }
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
