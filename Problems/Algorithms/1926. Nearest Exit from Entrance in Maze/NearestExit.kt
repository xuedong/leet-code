class Solution {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val n = maze.size
        val m = maze[0].size
        
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        val visited = Array(n) { BooleanArray(m) { false } }
        
        val queue = ArrayDeque<IntArray>()
        queue.add(intArrayOf(entrance[0], entrance[1], 0))
        visited[entrance[0]][entrance[1]] = true
        
        while (!queue.isEmpty()) {
            val curr = queue.removeFirst()
            val r = curr[0]
            val c = curr[1]
            val d = curr[2]
            
            if (d != 0 && (r == 0 || r == n-1 || c == 0 || c == m-1)) {
                return d
            }
            
            for (neighbor in neighbors) {
                val x = r + neighbor[0]
                val y = c + neighbor[1]
                if (isValid(n, m, x, y) && !visited[x][y] && maze[x][y] == '.') {
                    visited[x][y] = true
                    queue.add(intArrayOf(x, y, d+1))
                }
            }
        }
        
        return -1
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && c >= 0 && r < n && c < m
    }
}

