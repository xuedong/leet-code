class Solution {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        val n = grid1.size
        val m = grid1[0].size
        val visited = Array(n) { BooleanArray(m) { false } }
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        
        var ans = 0
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (!visited[i][j] && grid1[i][j] == 1 && grid2[i][j] == 1) {
                    var flag = true
                    val queue = ArrayDeque<IntArray>()
                    queue.add(intArrayOf(i, j))
                    
                    while (!queue.isEmpty()) {
                        for (k in 0..queue.size-1) {
                            val curr = queue.removeLast()
                            val row = curr[0]
                            val col = curr[1]
                        
                            visited[row][col] = true
                            for (neighbor in neighbors) {
                                val r = row + neighbor[0]
                                val c = col + neighbor[1]
                                if (r < 0 || r >= grid1.size || c < 0 || c >= grid1[0].size || grid2[r][c] == 0 || visited[r][c]) continue
                                
                                visited[r][c] = true
                                
                                if (grid1[r][c] == 0) flag = false
                                queue.add(intArrayOf(r, c))
                            }
                        }
                    }
                    
                    if (flag) ans++
                }
            }
        }
        
        return ans
    }
}

