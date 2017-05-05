import java.util.ArrayList;
import static java.util.Collections.*;
public class NK3{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       ArrayList<Integer> res=new ArrayList<Integer>();
       while(listNode!=null){
           res.add(listNode.val);
           listNode=listNode.next;
       }
       reverse(res);
       
       return res;

   }
}

class LIstNode{
    int val;
    LIstNode next=null;
    LIstNode(int va){
        this.val=val;
    }
}
