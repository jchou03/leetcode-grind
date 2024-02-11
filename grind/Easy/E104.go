package easy

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/*
Get the max depth of a binary search tree

runtime: 67%, memory: 75%
*/

func maxDepth(root *TreeNode) int {
	return helper(root)
}

func helper(root *TreeNode) int {
	if root == nil {
		return 0
	} else {
		return max(helper(root.Left), helper(root.Right)) + 1
	}
}
