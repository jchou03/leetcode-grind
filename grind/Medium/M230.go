package medium

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func kthSmallest(root *TreeNode, k int) int {
	counter := 1
	count := &counter
	return helper(root, count, k)
}

func helper(node *TreeNode, count *int, k int) int {
	if node == nil {
		return -1
	}

	res1 := helper(node.Left, count, k)
	if res1 != -1 {
		return res1
	}
	if *count == k {
		return node.Val
	}
	*count++
	res2 := helper(node.Right, count, k)
	if res2 != -1 {
		return res2
	}
	return -1
}
