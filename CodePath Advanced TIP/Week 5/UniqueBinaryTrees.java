/*
Undersatnd
    - given an integer, give the number of unique binary trees that could be created with values 1 through n
    - how we can can calculate the number of possible binary trees of values 1 through n
        - there will be a configuration where each node is the root
            - for each of these configurations, we need to take the product of the possible configurations of the nodes on the left and the nodes on the right
        - sum these up for each root configuration
        - we could use dp solution to store the possible binary trees with m nodes
    - how can we break this problem into smaller simpler problems?
    
    happy case:
        n = 1 -> 1
        n = 2 -> 2
        n = 3 -> 5
        n = 4 -> 

    edge case:
        n = 0 -> 0
 */
public class UniqueBinaryTrees {
    public int numTrees(int n) {
        int[] numTrees = new int[n + 1];
        numTrees[0] = 1;
        numTrees[1] = 1;
        // first populate the dp solution
        for(int i = 2; i <= n; i++){
            // for each number of nodes, iterate over the possible trees for each different possible root
            int tempSum = 0;
            for(int j = 1; j <= i; j++){
                tempSum += (j - 1 >= 1 ? numTrees[j - 1] : 1) * (i - j >= 1 ? numTrees[i - j] : 1);
                // System.out.println("j: " + j + " tempsum: " + tempSum);
            }
            numTrees[i] = tempSum;
            
        }
        // return solution
        // System.out.println(Arrays.toString(numTrees));
        return numTrees[n];
    }
}
