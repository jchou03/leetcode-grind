package grind.Easy;
import java.util.*;

// matching parens
// runtime 64%, memory 56%

public class E20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty() || map.get(stack.pop()) != c){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    // public boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<Character>();
    //     for(int i = 0; i < s.length(); i++){
    //         char c = s.charAt(i);
    //         if(c == '{' || c == '(' || c == '['){
    //             stack.push(c);
    //         }else if(c == '}' || c == ')' || c == ']'){
    //            if(stack.empty() || !checkParens(stack.pop(), c)) return false;
    //         }
    //     }
    //     if(stack.empty()) {
    //         return true;
    //     }else{
    //         return false;            
    //     }

    // }
    // private boolean checkParens(char a, char b){
    //     if((a == '{' && b == '}') || (a == '(' && b == ')') || (a == '[' && b == ']')) return true;
    //     return false;
    // }
}
