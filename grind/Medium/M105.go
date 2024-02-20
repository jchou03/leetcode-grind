package medium

/*
	understand:
	- given list of nodes
	- preorder traversal
	- inorder traversal
	- need to build the TreeNodes
	- are node values unique (yes)

	plan:
	- need to iterate over one of the lists in order to construct the tree, and reference the other one in order to determine where to place nodes
	- use a map to store the indices of each node number inorder
	- use recursion to solve the problem
	- at each step, create the given node (root)
	- use a pointer to keep track of index in preorder list
	- keep track of the left and right range within the inorder list that is being searched
*/
func buildTree(preorder []int, inorder []int) *TreeNode {
	var inmap = make(map[int]int)
	for i := 0; i < len(inorder); i++ {
		inmap[inorder[i]] = i
	}
	var c = 0
	return helper(preorder, &c, inmap, 0, len(preorder)-1)
}

func helper(preorder []int, preindex *int, inmap map[int]int, left int, right int) *TreeNode {

	if *preindex >= len(preorder) || left > right {
		return nil
	}

	var curVal = preorder[*preindex]
	var root = TreeNode{Val: curVal}
	*preindex++

	if left < right {
		root.Left = helper(preorder, preindex, inmap, left, inmap[curVal]-1)
		root.Right = helper(preorder, preindex, inmap, inmap[curVal]+1, right)
	}

	return &root
}
