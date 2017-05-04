import java.util.Stack;
public class NK14{
    public ListNode ReverseList(ListNode head) {
       Stack<Integer>t=new Stack<>();
       while(head!=null){
           t.push(head.val);
           head=head.next;
       }
       if(t.empty())return null;
       ListNode res=new ListNode(t.pop());
       ListNode p=res;
       while(!t.empty()){
           p.next=new ListNode(t.pop());
           p=p.next;
       }
       return res;
   }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
