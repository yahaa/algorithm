public class NK13{
    public ListNode FindKthToTail(ListNode head,int k) {
        int n=0;
        ListNode tnode=head;
        ListNode res=head;
        while(tnode!=null){
            n++;
            tnode=tnode.next;
        }
        
        if(n-k<0)return null;
        int t=0;

        while(t!=(n-k)){
            t++;
            res=res.next;
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
