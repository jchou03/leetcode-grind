package easy

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/*
Get the max depth of a binary search tree

runtime: 100%, memory: 100%
*/

func isSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	} else if p != nil && q != nil {
		return p.Val == q.Val && isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
	} else {
		return false
	}
}
