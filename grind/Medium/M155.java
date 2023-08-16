package grind.Medium;


/*
 * min stack implementation that keeps track of the minimum value within the stack
 * O(1) for all operations (asymptotic, O(n) in certain edge cases)
 * runtime: 83%, memory: 82%
 */

import java.util.Stack;

    public class M155 {
        class MinStack {
        Stack<Integer> stack;
        int min;
        int minPos;
        public MinStack() {
            stack = new Stack<Integer>();
            min = Integer.MAX_VALUE;
            minPos = -1;
        }
        
        public void push(int val) {
            stack.push(val);
            if(val < min){
                min = val;
                minPos = stack.size();
            }
        }
        
        public void pop() {
            int val = stack.pop();
            if(stack.size() < minPos){
                Stack<Integer> temp = new Stack<Integer>();
                min = Integer.MAX_VALUE;
                minPos = -1;
                while(!stack.isEmpty()){
                    temp.push(stack.pop());
                }
                while(!temp.isEmpty()){
                    this.push(temp.pop());
                }
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return min;
        }
    }
}
