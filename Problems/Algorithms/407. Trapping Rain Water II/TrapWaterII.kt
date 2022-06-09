class Solution {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val n = heightMap.size
        val m = heightMap[0].size
        
        val pq = PriorityQueue<IntArray>({ a, b -> a[2] - b[2] })
        val visited = Array(n) { BooleanArray(m) { false } }
        val neighbors = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        
        for (i in 0..n-1) {
            pq.offer(intArrayOf(i, 0, heightMap[i][0]))
            pq.offer(intArrayOf(i, m-1, heightMap[i][m-1]))
            visited[i][0] = true
            visited[i][m-1] = true
        }
        
        for (j in 0..m-1) {
            pq.offer(intArrayOf(0, j, heightMap[0][j]))
            pq.offer(intArrayOf(n-1, j, heightMap[n-1][j]))
            visited[0][j] = true
            visited[n-1][j] = true
        }
        
        var ans = 0
        while (!pq.isEmpty()) {
            val curr = pq.poll()
            
            for (neighbor in neighbors) {
                val x = curr[0] + neighbor[0]
                val y = curr[1] + neighbor[1]
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    visited[x][y] = true
                    ans += maxOf(0, curr[2] - heightMap[x][y])
                    pq.offer(intArrayOf(x, y, maxOf(heightMap[x][y], curr[2])))
                }
            }
        }
        
        return ans
    }
}

