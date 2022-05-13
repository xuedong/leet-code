class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        if (n == 1 && m == 1) {
            if (grid[0][0] == 0) return 1
            return -1
        }
        
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1
        
        val neighbors: Array<IntArray> = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, 1), intArrayOf(-1, -1))
        val visited = Array(n) { BooleanArray(m) { false } }
        
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(Pair(0, 0))
        visited[0][0] = true
        
        var ans = 1
        while (!queue.isEmpty()) {
            for (i in 1..queue.size) {
                val curr = queue.removeFirst()
                val r = curr.first
                val c = curr.second
            
                for (neighbor in neighbors) {
                    val x = r + neighbor[0]
                    val y = c + neighbor[1]
                
                    if (isValid(n, m, x, y) && !visited[x][y] && grid[x][y] == 0) {
                        if (x == n-1 && y == m-1) return ans + 1
                        queue.add(Pair(x, y))
                        visited[x][y] = true
                    }
                }
            }
            
            ans++
        }
        
        return -1
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
}

