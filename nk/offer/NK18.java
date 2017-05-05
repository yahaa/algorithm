import java.util.Stack;
import java.util.Collections;

public class NK18{
    private Stack<Integer>s=new Stack();

    public void push(int node) {
       s.push(node);
    }

    public void pop() {
       s.pop();

    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return Collections.min(s);

    }
}
