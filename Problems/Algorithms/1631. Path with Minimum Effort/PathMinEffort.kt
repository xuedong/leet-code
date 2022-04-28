class Solution {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val n = heights.size
        val m = heights[0].size
        
        val deltas = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        
        val visited = Array(n) { BooleanArray(m) { false } }
        val dp = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        val heap = PriorityQueue<IntArray>({ a, b -> a[2] - b[2] })
        
        heap.add(intArrayOf(0, 0, 0))
        dp[0][0] = 0
        while (!heap.isEmpty()) {
            val curr = heap.poll()
            val row = curr[0]
            val col = curr[1]
            val effort = curr[2]
            
            if (!visited[row][col]) {
                visited[row][col] = true
                
                for (neighbor in deltas) {
                    val newRow = row + neighbor[0]
                    val newCol = col + neighbor[1]
                    
                    if (isValid(n, m, newRow, newCol, visited)) {
                        val newEffort = maxOf(effort, Math.abs(heights[newRow][newCol]-heights[row][col]))
                        
                        if (newEffort < dp[newRow][newCol]) {
                            dp[newRow][newCol] = newEffort
                            heap.add(intArrayOf(newRow, newCol, newEffort))
                        }
                    }
                }
            }
        }
        
        return dp[n-1][m-1]
    }
    
    private fun isValid(n: Int, m: Int, i: Int, j: Int, visited: Array<BooleanArray>): Boolean {
        return i >= 0 && i < n && j >= 0 && j < m && !visited[i][j]
    }
}

