class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val fresh = mutableSetOf<Pair<Int, Int>>()
        val rotten = ArrayDeque<Pair<Int, Int>>()
        
        for (i in 0..grid.size-1) {
            for (j in 0..grid[0].size-1) {
                if (grid[i][j] == 1) fresh.add(Pair(i, j))
                if (grid[i][j] == 2) rotten.add(Pair(i, j))
            }
        }
        
        var ans = 0
        while (!fresh.isEmpty() && !rotten.isEmpty()) {
            ans++
            
            val currSize = rotten.size
            for (k in 0..currSize-1) {
                val (i, j) = rotten.removeFirst()
                
                for (neighbor in arrayOf(Pair(i-1, j), Pair(i+1, j), Pair(i, j-1), Pair(i, j+1))) {
                    if (fresh.contains(neighbor)) {
                        fresh.remove(neighbor)
                        rotten.add(neighbor)
                    }
                }
            }
        }
        
        if (!fresh.isEmpty()) return -1
        return ans
    }
}

