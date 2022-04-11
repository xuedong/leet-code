class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val n = grid[0].size
        val m = grid.size
        val shift = k % (n * m)
        val start = n * m - shift
        
        val result: MutableList<MutableList<Int>> = mutableListOf<MutableList<Int>>()
        for (i in start until n * m + start) {
            val j = i % (n * m)
            val row = j / n
            val col = j % n
            if ((i - start) % n == 0) {
                result.add(mutableListOf<Int>())
            }
            result.last().add(grid[row][col])
        }
        
        return result
    }
}

