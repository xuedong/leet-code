class Solution {
    fun minTotalDistance(grid: Array<IntArray>): Int {
        val rows: MutableList<Int> = mutableListOf()
        val cols: MutableList<Int> = mutableListOf()

        val m = grid.size
        val n = grid[0].size
        for (i in 0..m-1) {
            for (j in 0..n-1) {
                if (grid[i][j] == 1) {
                    rows.add(i)
                    cols.add(j)
                }
            }
        }

        val row = rows.get(rows.size / 2)
        cols.sort()
        val col = cols.get(cols.size / 2)

        return minDistance1D(rows, row) + minDistance1D(cols, col)
    }

    private fun minDistance1D(points: List<Int>, source: Int): Int {
        var distance = 0
        for (point in points) {
            distance += Math.abs(point - source)
        }
        return distance
    }
}
