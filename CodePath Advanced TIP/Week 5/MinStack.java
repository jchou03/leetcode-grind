/*
Understand
    - create a min stack class that is a stack that also supports getting the minimum element from the stack
    functions:
        push (add to top of stack)
        pop (remove top element)
        top (get top element)
        getMin (get min element from stack)
    all functions need to be in O(1) time

    assume that functions will be called on a non-empty stack

Match
    what data structures could we use in order to use memory to reduce runtime?
        - stack to hold standard stack functions (implemented using an array)
        - some sort of sorting or ordering needs to be implemented
        - hashmaps enable fast retaining, but doesn't solve ordering
        - heaps help with ordering, but it takes log time to add/remove
    USE PARALLEL DATA STRUCTURES TO KEEP TRACK OF DATA NEEDED

Plan
    use an extra stack to keep track of the min value at each level of the stack

 */
import java.util.*;

public class MinStack {
    // store the stack in an array
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int i){
        // add the new element to the stack
        stack.push(i);
        if(i < minStack.peek()){
            minStack.push(i);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

}
