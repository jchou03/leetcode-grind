package grind.Medium;

import java.util.Stack;

public class M150 {
    public int evalRPN(String[] tokens) {
        /*
            undersatnd
                evaluate an expression in reverse polish notation
                the operation will operate on the two numbers that come first

                could the expression be an invalid expression?
                are all tokens guaranteed to be either a number or operation?
            plan
                use a stack to keep track of numbers 
                pop the top 2 values off to perform operation and add to stack
        */
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            String tok = tokens[i];
            switch(tok){
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int den = stack.pop();
                    int num = stack.pop();
                    stack.push(num/den);
                    break;
                default:
                    int val = Integer.parseInt(tok);
                    stack.push(val);
                    break;
            }
        }
        return stack.pop();
    }
}
