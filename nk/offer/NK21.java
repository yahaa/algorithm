import java.util.ArrayList;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class NK21{
    public static void main(String[]args){
        int []a={1,2,3,4,5};
        int []b={4,5,3,2,1};
        System.out.println(isPopOrder(a,b));

    }

    public static boolean isPopOrder(int [] pushA,int [] popA) {
        Queue<Integer>qu=new LinkedList<>();
        for(int i:pushA)qu.offer(i);
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<popA.length;i++){
            if(st.empty()){
                while(!qu.isEmpty()){
                    int t=qu.poll();
                    if(t==popA[i])break;
                    else st.push(t);
                }
            }else {
                if(st.peek()==popA[i])st.pop();
                else{
                    while(!qu.isEmpty()){
                        int t=qu.poll();
                        if(t==popA[i])break;
                        else st.push(t);
                    }
                }
            }
        }
        return st.empty();
    }
}
