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
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()

        val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        val queue: ArrayDeque<Pair<TreeNode?, Int>> = ArrayDeque()
        queue.add(Pair(root, 0))
        map.put(0, mutableListOf(root!!.`val`))

        while (!queue.isEmpty()) {
            val size = queue.size
            val tempMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

            for (i in 0..size-1) {
                val pair = queue.removeFirst()
                val node = pair.first
                val col = pair.second

                if (node!!.left != null) {
                    queue.add(Pair(node.left, col - 1))
                    tempMap.getOrPut(col - 1, { mutableListOf() }).add(node.left!!.`val`)
                }

                if (node.right != null) {
                    queue.add(Pair(node.right, col + 1))
                    tempMap.getOrPut(col + 1, { mutableListOf() }).add(node.right!!.`val`)
                }
            }

            for (key in tempMap.keys) {
                val list = tempMap[key]!!
                list.sort()
                map.getOrPut(key, { mutableListOf() }).addAll(list)
            }
        }

        val results: MutableList<List<Int>> = mutableListOf()
        val keys = map.keys
        keys.sorted().forEach {
            results.add(map[it]!!)
        }

        return results
    }
}
