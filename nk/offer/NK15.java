public class NK15{
    public ListNode Merge(ListNode list1,ListNode list2) {
       ListNode p=new ListNode(-999999);
       ListNode res=p;
       while(list1!=null||list2!=null){
           if(list1!=null&&list2!=null){
               if(list1.val>list2.val){
                   if(p!=null){
                       p.val=list2.val;
                   }else{
                       p=new ListNode(list2.val);
                   }

                   p=p.next;
                   list2=list2.next;
               } else{

                   if(p!=null){
                       p.val=list1.val;
                   }else{
                       p=new ListNode(list1.val);
                   }
                   p=p.next;
                   list1=list1.next;
               }
           }else {
               if(list1!=null){
                  if(p!=null){
                       p.val=list1.val;
                   }else{
                       p=new ListNode(list1.val);
                   }
                   list1=list1.next;
                   p=p.next;
               }else if(list2!=null){
                   if(p!=null){
                       p.val=list2.val;
                   }else{
                       p=new ListNode(list2.val);
                   }
                   list2=list2.next;
                   p=p.next;
               }
           }
       }
       if(res.val==-999999)return null;
       return res;

}
