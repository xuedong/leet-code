/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

func findNext(node *Node) *Node {
    if node == nil {
        return nil
    }

    next := node.Next
    for next != nil {
        if next.Left != nil {
            return next.Left
        }
        if next.Right != nil {
            return next.Right
        }
        next = next.Next
    }

    return nil
}

func linkChildren(node *Node) {
    if node == nil {
        return
    }

    if node.Left != nil {
        if node.Right != nil {
            node.Left.Next = node.Right
        } else {
            node.Left.Next = findNext(node)
        }
    }

    if node.Right != nil {
        node.Right.Next = findNext(node)
    }
}

func connect(root *Node) *Node {
    if root == nil {
        return nil
    }

    node := root
    for node != nil {
        linkChildren(node)
        node = node.Next
    }

    connect(root.Left)
    connect(root.Right)

    return root
}
