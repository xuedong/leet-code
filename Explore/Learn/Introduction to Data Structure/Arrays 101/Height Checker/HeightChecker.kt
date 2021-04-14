class Solution {
    fun heightChecker(heights: IntArray): Int {
        val length = heights.size
        val sortedHeights = heights.clone().sortedArray()
        
        var moves = 0
        for (i in heights.indices) {
            if (heights[i] != sortedHeights[i]) {
                moves++
            }
        }
        
        return moves
    }
}

