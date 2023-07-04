/*
Understand
    - given a string s evaluate it for is mathematical value
    - expression may contain
        - parens "(", ")"
        - the "+" or "-" sign
        - non negative integers

    extra notes:
        - don't need to deal with pemdas, just need to deal with parens then execute 
        left to right
        - numbers could have multiple digits, so be sure to handle those
        - what happens if the input isn't properly formatted? (like an open paren)
            - assume properly formatted for now

    happy cases
        - "1 + 1" -> 2
        - "2 - 1 + 2" -> 3
        - "(1+(4+5+2)-3)+(6+8)" -> 23

    edge cases:
        - "" -> 0

match
    - string problem, so we could use an iterative solution
    - other solutions could include 2 pointer -> but probably not useful for this problem
    - hashmap -> but we don't really need to match things to keys

plan
    - iterate over each character of the string
        - switch depending on the character that is at index i
            - if current char is a digit, keep track of it (there may be more digits
            following in the same number)
                - if there has previously been a number, *10 plus the current digit
            - if the current char is a open paren, then find the corresponding closing paren
                - keep looking for the next index of '(' and ')', and compare the indices
                - recursevly call calculate on the substring
            - if the character is a function sign, then store the function sign
        - split into res, function, and num and execute function

 */
public class BasicCalculator {
    public static void main(String[] args){
        String[] tests = new String[]{
            "1+1",
            "2 - 1 + 2 ",
            "(1+(4+5+2)-3)+(6+8)"
        };
        int[] answers = new int[]{2,3,23};
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Beginning test %d\n", i+1);
            int res = calculate(tests[i]);
            System.out.printf("Test %s res: %d answer: %d\n\n", (res == answers[i] ? "Passed" : "Failed"), res, answers[i]);
        }
    }

    public static int calculate(String s){
        int res = 0;
        int curNum = 0;
        boolean adding = true; // boolean to represent whether we are adding or subtracting
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = (curNum * 10) + Character.digit(c, 10);
            }else{
                if(c == '('){
                    int left = s.indexOf('(', i + 1);
                    int right = s.indexOf(')', i + 1);
                    while(left != -1 && left < right){
                        left = s.indexOf('(', left + 1);
                        right = s.indexOf(')', right + 1);
                    }
                    curNum = calculate(s.substring(i + 1, right));
                    i = right; // (then i++ at the end of the loop)
                }else if(c == '+'){
                    adding = true;
                }else if(c == '-'){
                    adding = false;
                }
                if(adding){
                    res += curNum;
                }else{
                    res -= curNum;
                }
                curNum = 0;
                
            }            
        }
        if(curNum != 0){
            if(adding){
                    res += curNum;
                }else{
                    res -= curNum;
                }
                curNum = 0;
        }
        return res;
    }
}
