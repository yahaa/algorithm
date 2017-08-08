import java.util.*;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int cut(int[] parts) {
        PriorityQueue<Integer>queue=new PriorityQueue<Integer>();
        for (int i=0;i<parts.length;i++){
            queue.add(parts[i]);
        }

        int res=0;
        while(queue.size()!=1){
            int a=queue.peek();
            int b=queue.peek();
            res+=a+b;
            queue.add(a+b);
        }

        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));
    }
}


PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < parts.length; i++) {
            queue.add(parts[i]);
        }

        int res = 0;
        while (queue.size() != 1) {
            int a = queue.poll();
            int b = queue.poll();
            res += a + b;
            queue.add(a + b);
        }

        return res;
