package lintcode._528;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    private void pushListToStack(List<NestedInteger> nestedList) {
        Stack<NestedInteger> temp = new Stack<>();
        for (NestedInteger nested : nestedList) {
            temp.push(nested);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new Stack<>();
        pushListToStack(nestedList);
    }


    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushListToStack(stack.pop().getList());
        }

        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public void remove() {

    }
}
