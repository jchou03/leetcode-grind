/*
Understand
    - implement a queue using a stack

Match
    - need to use stacks to implement all queue functions
    - could we use 2 stacks?

Plan
    - use 2 stacks to implement the queue, one for input, one for output
    - when pushing, push onto input stack
    - when popping, remove from output stack (if outpust stack empty, move all elements from input stack to output)



summary:
    - using multiple data structures (stacks)
    - don't be afraid of amoritized time outside of constraints
 */
import java.util.*;
public class QueueStack{
    Stack<Integer> input;
    Stack<Integer> output;
    public QueueStack(){
        input  = new Stack<Integer>();
        output = new Stack<Integer>();
    }

    public void push(int i){
        input.push(i);
    }

    public int pop(){
        helper();
        return output.pop();
    }

    public int peek(){
        helper();
        return output.peek();
    }

    public boolean empty(){
        return input.isEmpty() && output.isEmpty();
    }

    private void helper(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
    }
}
