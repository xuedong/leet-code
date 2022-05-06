class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val visited = Array(n) { BooleanArray(m) { false } }
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        
        var ans = 0
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++
                    val queue = ArrayDeque<IntArray>()
                    queue.add(intArrayOf(i, j))
                    
                    while (!queue.isEmpty()) {
                        for (k in 0..queue.size-1) {
                            val curr = queue.removeLast()
                            val row = curr[0]
                            val col = curr[1]
                        
                            visited[row][col] = true
                            for (neighbor in neighbors) {
                                mark(queue, row+neighbor[0], col+neighbor[1], visited, grid)
                            }
                        }
                    }
                }
            }
        }
        
        return ans
    }
    
    private fun mark(queue: ArrayDeque<IntArray>, i: Int, j: Int, visited: Array<BooleanArray>, grid: Array<CharArray>): Unit {
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == '0' || visited[i][j]) return
        
        visited[i][j] = true;
        queue.add(intArrayOf(i, j))
    }
}

