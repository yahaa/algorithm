import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NK16{
    public static void main(String[]args){

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

    }

    public void pre(TreeNode root,ArrayList<Integer>res){
        if(root==null)return;
        res.add(root.val);
        pre(root.left,res);
        pre(root.right,res);
    }

    public ArrayList<TreeNode> bfs(TreeNode root){
        if(root==null)return null;
        ArrayList<TreeNode>res=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.push(root);
        while(!queue.empty()){
            TreeNode tt=queue.pop();
            res.add(tt);
            if(tt.left!=null){
                queue.push(tt.left);
            }
            if(tt.right!=null){
                queue.push(tt.right);
            }
        }

    }


}
