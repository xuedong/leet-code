/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
	// Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        
        var sb = StringBuilder()
        val queue = mutableListOf<TreeNode?>()
        queue.add(root)
        
        while (queue.size > 0) {
            val node = queue.removeAt(0)
            
            if (node != null) {
                queue.add(node?.left)
                queue.add(node?.right)
            }
            
            sb.append(node?.`val`)
            sb.append(",")
        }
        
        sb.deleteCharAt(sb.length-1)
        return sb.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == null) return null
        
        var str = data.split(",")
        if (str[0].equals("null") || str[0].equals("")) return null
        
        var idx = 0
        val root: TreeNode? = TreeNode(str[0].toInt())
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        
        while (!queue.isEmpty()) {
            var node = queue.removeFirst()
            
            val leftIdx = idx * 2 + 1
            val rightIdx = idx * 2 + 2
            
            if (leftIdx < str.size) {
                val curr = str[leftIdx]
                if (!curr.equals("null")) {
                    var left: TreeNode? = TreeNode(curr.toInt())
                    node?.left = left
                    queue.add(left)
                }
            }
            
            if (rightIdx < str.size) {
                val curr = str[rightIdx]
                if (!curr.equals("null")) {
                    var right: TreeNode? = TreeNode(curr.toInt())
                    node?.right = right
                    queue.add(right)
                }
            }
            
            idx++
        }
        
        return root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */
