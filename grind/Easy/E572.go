package easy

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/*
Check if subroot is a subtree from the tree root

runtime: 91%, memory: 72%
*/

func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
	if root != nil && subRoot != nil {
		if root.Val == subRoot.Val && isEqual(root, subRoot) {
			return true
		} else {
			return isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot)
		}
	}
	return false
}

func isEqual(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	} else if p != nil && q != nil {
		return p.Val == q.Val && isEqual(p.Left, q.Left) && isEqual(p.Right, q.Right)
	} else {
		return false
	}
}
