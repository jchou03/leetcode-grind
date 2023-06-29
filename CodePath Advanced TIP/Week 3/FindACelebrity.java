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
    public int findCelebrity(int[] people){
        ArrayList<Integer> potentialCelebrities = new ArrayList<Integer>();
        
    }
}
