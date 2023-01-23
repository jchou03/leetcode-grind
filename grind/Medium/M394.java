package grind.Medium;
import java.util.*;

// decode string

public class M394 {
    class Pair{
        String s;
        int i;
        public Pair(String s, int i){
            this.s = s;
            this.i = i;
        }
    }
    public String decodeString(String s) {
        // stack which stores each "code" where further values on the stack are 
        Stack<Pair> stack = new Stack<Pair>();
        // final decoded resulting string
        stack.push(new Pair("", 1));
        // iterate over the string
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                // if come across number, get the integer and then store that to the stack
                int j = s.indexOf("[", i);
                // System.out.println(Integer.decode(s.substring(i,j)));
                stack.push(new Pair("", Integer.decode(s.substring(i, j))));
                i = j;
            } else if (s.charAt(i) == ']'){
                // if you come across the end bracket, take the string at the top of the stack, multiply it by the int at the top of the stack, and add it to the next value on the stack
                Pair temp = stack.pop();
                for(int j = 0; j < temp.i; j++){
                    stack.peek().s = stack.peek().s + temp.s;
                }
            } else {
                if(s.charAt(i) != '['){
                    // should be a normal character, then just add it to the top string in the stack
                    stack.peek().s = stack.peek().s + s.charAt(i);
                }
            }
        }
        return stack.pop().s;
    }
}
