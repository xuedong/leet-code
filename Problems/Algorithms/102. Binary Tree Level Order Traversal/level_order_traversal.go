/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    result := make([][]int, 0)

    traversal(root, &result, 0)
    return result
}

func traversal(root *TreeNode, result *[][]int, level int) {
    if root == nil {
        return
    }

    if len(*result) == level {
        *result = append(*result, []int{})
    }
    (*result)[level] = append((*result)[level], root.Val)
    traversal(root.Left, result, level+1)
    traversal(root.Right, result, level+1)
}
