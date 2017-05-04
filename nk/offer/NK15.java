public class NK15{
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p1=list1,p2=list2;
        ListNode res=null;
        if(p1==null&&p2==null)return null;
        if(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                res=new ListNode(p1.val);
                p1=p1.next;
            }else{
                res=new ListNode(p2.val);
                p2=p2.next;
            }
        } else if(p1!=null){
            res=new ListNode(p1.val);
            p1=p1.next;
        } else if(p2!=null){
            res=new ListNode(p2.val);
            p2=p2.next;
        }

        ListNode p3=res;
        while(p1!=null||p2!=null){
            if(p1!=null&&p2!=null){
                if(p1.val<p2.val){
                    p3.next=new ListNode(p1.val);
                    p1=p1.next;
                }else{
                    p3.next=new ListNode(p2.val);
                    p2=p2.next;
                }

            } else if(p1!=null){
                p3.next=new ListNode(p1.val);
                p1=p1.next;
            } else if(p2!=null){
                p3.next=new ListNode(p2.val);
                p2=p2.next;
            }
            p3=p3.next;
        }
        return res;
    }
}
