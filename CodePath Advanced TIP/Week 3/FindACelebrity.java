/*
Understand:
    given an array of n people (0 -> n-1)
    given a function knows(a, b) which returns a boolean of whether or not person A knows person 
    a celebrity is someone who everyone else at the party knows but they don't know anyone else
    find a solution that minimizes the number of calls to knows(a, b) asymptotically

Match:

Plan:
    - O(n^2) trivial solution is to ask everybody for everyone they know, then we can check who is a celebrity
    - better solution is to ask everyone if they know A, and if they do, they aren't a celebrity
        - ask potential celebrities if they know B (and if they do, remove them from potential celebrity list)
        - repeat until we are left with a list of potential celebrities who know nobody
        - then ask everyone if they know these celebrities (and if one person doesn't remove them from the list and start with next one) 

 */
import java.util.*;

public class FindACelebrity {
    public int findCelebrity(int n){
        // approach this problem by trying to reduce the number of celebrity candidates
        // use a stack to keep track of the potential candidates
        // while the stack has potential candidates, take the top two and ask if a knows b
            // if a knows b, then a isn't a celebrity but b might be (push back onto the stack)
            // if a doesn't know b, then b isn't a celebrity but a might be (push back onto the stack)
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < n; i++){
            stack.push(i);
        }

        int a, b;
        // when the stack is bigger than 1, there are more than 1 candidates
        while(stack.size() > 1){
            a = stack.pop();
            b = stack.pop();
            if(knows(a, b)){
                // a knows b, so a isn't a celebrity but b is still a candidate
                stack.push(b);
            }else{
                // a doesn't know b, so b isn't a celebrity but a might be
                stack.push(a);
            }
        }
        // now the stack has the last celebrity candidate
        // verify they are a celebrity by checking whether or not they don't know everyone (and that everyone else knows them)
        int c = stack.pop();
        for(int i = 0; i < n; i++){
            if(!knows(i, c) || knows(c, i)){
                return -1;
            }
        }

        return 1;

    }
    // function to let code compile, checks if a knows b by checking the underlying graph
    public static boolean knows(int a, int b){
        return false;
    }
}
