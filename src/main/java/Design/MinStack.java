package Design;


import java.util.Stack;

public class MinStack {

    class Node {
        public int min;
        public int value;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<Node> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }

    public void push(int x) {
        int min = Math.min(getMin(), x);
        stack.push(new Node(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.pop().value;
    }

    public int getMin() {
        if(!stack.isEmpty())
            return stack.peek().value;
        else
            return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
