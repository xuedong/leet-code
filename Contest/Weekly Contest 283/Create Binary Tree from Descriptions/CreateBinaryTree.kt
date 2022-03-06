/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        var root = -1
        val map: MutableMap<Int, Pair<TreeNode, Boolean>> = mutableMapOf()
        
        for (description in descriptions) {
            val parent = description[0]
            val child = description[1]
            val isLeft = description[2]
            
            if (!map.containsKey(parent)) {
                map.put(parent, Pair(TreeNode(parent), false))
            }
            if (!map.containsKey(child)) {
                map.put(child, Pair(TreeNode(child), false))
            }
            map.put(child, Pair(map[child]!!.first, true))
            
            if (isLeft == 1) {
                map[parent]!!.first.left = map[child]!!.first
            } else {
                map[parent]!!.first.right = map[child]!!.first
            }
        }
        
        for ((key, value) in map) {
            if (!value.second) {
                root = key
                break
            }
        }
        
        return map[root]!!.first
    }
}

