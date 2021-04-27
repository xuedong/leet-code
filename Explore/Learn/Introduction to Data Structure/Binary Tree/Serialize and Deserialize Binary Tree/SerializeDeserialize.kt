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
        
        var str = StringBuilder()
        val queue = mutableListOf<TreeNode?>()
        queue.add(root)
        
        while (queue.size > 0) {
            val node = queue.removeAt(0)
            
            if (node != null) {
                queue.add(node!!.left)
                queue.add(node!!.right)
            }
            str.append(node?.`val`)
            str.append(",")
        }
        
        str.deleteCharAt(str.length-1)
        return str.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == null) return null
        
        var strArr = data.split(",")
        if (strArr[0].equals("null") || strArr[0].equals("")) return null
        
        var index = 0
        var root: TreeNode? = TreeNode(strArr[0].toInt())
        val queue = mutableListOf<TreeNode?>()
        queue.add(root)
        while (queue.size > 0) {
            var node: TreeNode? = queue.removeAt(0)
            
            val leftIndex = index * 2 + 1
            val rightIndex = index * 2 + 2
            
            if (leftIndex < strArr.size) {
                val curr = strArr[leftIndex]
                if (!curr.equals("null")) {
                    var left: TreeNode? = TreeNode(curr.toInt())
                    node?.left = left
                    queue.add(left)
                }
            }
            
            if (rightIndex < strArr.size) {
                val curr = strArr[rightIndex]
                if (!curr.equals("null")) {
                    var right: TreeNode? = TreeNode(curr.toInt())
                    node?.right = right
                    queue.add(right)
                }
            }
            
            index++
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
