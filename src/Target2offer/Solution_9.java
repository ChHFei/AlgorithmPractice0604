package Target2offer;
import java.util.Stack;


// 题目9：
//      用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

public class Solution_9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
            stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                int temp =stack1.pop();
                stack2.push(temp);
            }
        }
        if (stack2.isEmpty()){
            throw new  Exception("the queue is empty");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

    }

}
