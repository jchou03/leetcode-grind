import java.util.Stack;

// reverse the words in a string
// runtime: 15%, memory: 44%

public class M151 {
    public String reverseWords(String s) {
        String res = "";
        Stack<String> stack = new Stack<String>();
        String curWord = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                if(curWord.length() > 0){
                    // System.out.println("curWord: " + curWord);
                    stack.push(curWord);
                    curWord = "";
                }
            }else{
                curWord += c;
            }
        }
        if(curWord.length() > 0) stack.push(curWord);

        while(!stack.isEmpty()){
            res += stack.pop();
            if(stack.size() > 0){
                res += " ";
            }
        }
        return res;
    }
}
