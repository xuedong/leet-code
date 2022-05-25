class Solution {
    fun shortestBridge(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        
        val queue = ArrayDeque<IntArray>()
        var flag = false
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (grid[i][j] == 1) {
                    dfs(queue, grid, neighbors, n, m, i, j)
                    flag = true
                    break
                }
            }
            if (flag) break
        }

        val visited = Array(n) { IntArray(m) { 0 } }
        return bfs(queue, grid, visited, neighbors, n, m)
    }
    
    private fun dfs(queue: ArrayDeque<IntArray>, grid: Array<IntArray>, neighbors: Array<IntArray>, n: Int, m: Int, r: Int, c: Int): Unit {
        if (grid[r][c] == 1) {
            grid[r][c] = 2
            queue.add(intArrayOf(r, c, 0))
            
            for (neighbor in neighbors) {
                val x = r + neighbor[0]
                val y = c + neighbor[1]
                
                if (isValid(n, m, x, y)) {
                    dfs(queue, grid, neighbors, n, m, x, y)
                }
            }
        }
    }
    
    private fun bfs(queue: ArrayDeque<IntArray>, grid: Array<IntArray>, visited: Array<IntArray>, neighbors: Array<IntArray>, n: Int, m: Int): Int {
        while (!queue.isEmpty()) {
            val curr = queue.removeFirst()
            val r = curr[0]
            val c = curr[1]
            val dist = curr[2]
            
            if (grid[r][c] == 1) {
                return dist - 1
            } else {
                for (neighbor in neighbors) {
                    val x = r + neighbor[0]
                    val y = c + neighbor[1]
                    
                    if (isValid(n, m, x, y) && visited[x][y] == 0) {
                        visited[x][y] = 1
                        queue.add(intArrayOf(x, y, dist+1))
                    }
                }
            }
        }
        
        return -1
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
}

