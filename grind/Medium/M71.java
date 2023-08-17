package grind.Medium;

import java.util.Stack;

/*
 * simplify a file path
 */

public class M71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");
        
        for(int i = 0; i < strs.length; i++){
            String cur = strs[i];
            switch(cur){
                case "":
                    break;
                case "..":
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                case ".":
                    break;
                default:
                    stack.push(cur);
            }
        }
        
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }

        if(res == "") res = "/";
        return res;

        // for(int i = 0; i < strs.length; i++){
        //     stack.push(strs[i]);
        // }

        // /*
        // split the strings by '/' and put them onto the stack
        // from the stack, add into the resulting string based on the 
        // */
        // // System.out.println(Arrays.toString(strs));

        // String res = "";
        // int skips = 0;
        // while(!stack.isEmpty()){
        //     String cur = stack.pop();
        //     switch(cur){
        //         case "..":
        //             skips++;
        //             break;
        //         case ".":
        //             break;
        //         case "":
        //             break;
        //         default:
        //             if(skips == 0){
        //                 res = "/" + cur + res;
        //             }else{
        //                 skips--;
        //             }
        //     }
        // }
        // if(res == "") res = "/";
        // return res;
    }
}
