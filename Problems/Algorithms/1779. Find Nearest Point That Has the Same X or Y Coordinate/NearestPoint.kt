class Solution {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        var ans = Int.MAX_VALUE
        var id = 0
        for (i in 0..points.size-1) {
            val point = points[i]
            if (point[0] == x) {
                if (Math.abs(point[1] - y) < ans) {
                    id = i
                    ans = Math.abs(point[1] - y)
                }
            } else if (point[1] == y) {
                if (Math.abs(point[0] - x) < ans) {
                    id = i
                    ans = Math.abs(point[0] - x)
                }
            }
        }
        
        if (ans == Int.MAX_VALUE) return -1
        return id
    }
}

