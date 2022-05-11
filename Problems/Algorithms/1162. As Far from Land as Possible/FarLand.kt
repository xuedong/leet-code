class Solution {
    fun maxDistance(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        val visited = Array(n) { BooleanArray(m) { false } }
        
        val queue = ArrayDeque<Pair<Int, Int>>()
        for (r in 0..n-1) {
            for (c in 0..m-1) {
                if (grid[r][c] == 1) {
                    queue.add(Pair(r, c))
                }
            }
        }
        
        var ans = -1
        while (!queue.isEmpty()){
            for (i in 1..queue.size) {
                val curr = queue.removeFirst()
                val x = curr.first
                val y = curr.second
                
                for (neighbor in neighbors) {
                    val r = x + neighbor[0]
                    val c = y + neighbor[1]
                    
                    if (isValid(n, m, r, c) && !visited[r][c] && grid[r][c] == 0) {
                        visited[r][c] = true
                        queue.add(Pair(r, c))
                    }
                }
            }
            ans++
        }
        
        if (ans <= 0) return -1
        return ans
    }
    
    private fun isValid(n: Int, m: Int, r: Int, c: Int): Boolean {
        return r >= 0 && r < n && c >= 0 && c < m
    }
}

