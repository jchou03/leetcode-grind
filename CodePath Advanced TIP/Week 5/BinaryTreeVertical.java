/*
undersatnd
    given the root of a binary tree, return a list of lists that contain the vertical order
    the input could be null

Match
    in order traversal (recursion)

Plan
    use a stack to do dfs in order traversal
    - while cur node has left child, push cur onto stack to visit later then make cur cur.left
    - keep going to the left until we find the leftmost value (this is 0)
    -

 */
public class BinaryTreeVertical {
    
}
