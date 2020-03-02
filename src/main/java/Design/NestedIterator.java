package Design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
 interface NestedInteger {
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();
      // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();
      // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {

        if(nestedList != null) {
            for(int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

    }

    @Override
    public Integer next() {

        return stack.pop().getInteger();

    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {

            NestedInteger node = stack.peek();

            if(node.isInteger()) {
                return true;
            }

            node = stack.pop();

            List<NestedInteger> nestedList = node.getList();
            for(int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }

        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
