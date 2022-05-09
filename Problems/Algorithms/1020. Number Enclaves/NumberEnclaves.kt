class Solution {
    fun numEnclaves(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val visited = Array(n) { BooleanArray(m) { false } }
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        
        var ans = 0
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    var flag = false
                    var count = 0
                    val queue = ArrayDeque<IntArray>()
                    queue.add(intArrayOf(i, j))
                    
                    while (!queue.isEmpty()) {
                        for (k in 0..queue.size-1) {
                            val curr = queue.removeLast()
                            val row = curr[0]
                            val col = curr[1]
                            count++
                        
                            visited[row][col] = true
                            for (neighbor in neighbors) {
                                val r = row + neighbor[0]
                                val c = col + neighbor[1]
                                if (r < 0 || r >= n || c < 0 || c >= m) {
                                    flag = true
                                    continue
                                }
                                
                                if (grid[r][c] == 0 || visited[r][c]) continue
                                
                                visited[r][c] = true
                                queue.add(intArrayOf(r, c))
                            }
                        }
                    }
                    
                    if (!flag) {
                        ans += count
                    }
                }
            }
        }
        
        return ans
    }
}

