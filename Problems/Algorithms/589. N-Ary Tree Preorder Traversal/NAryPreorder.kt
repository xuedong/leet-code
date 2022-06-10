/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun preorder(root: Node?): List<Int> {
        if (root == null) return listOf()
        if (root?.children == null) return listOf(root?.`val`)
        
        return listOf(root?.`val`) + root?.children.flatMap { preorder(it) }
    }
}

