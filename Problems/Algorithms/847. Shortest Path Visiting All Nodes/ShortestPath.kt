class Solution {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val n = graph.size
        if (n == 1) return 0
        
        val endingMask = (1 shl n) - 1
        val visited = Array(n) { BooleanArray(endingMask+1) { false } }
        
        val queue = ArrayDeque<IntArray>()
        for (i in 0..n-1) {
            queue.add(intArrayOf(i, (1 shl i)))
            visited[i][(1 shl i)] = true
        }
        
        var ans = 0
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0..size-1) {
                val curr = queue.removeFirst()
                val node = curr[0]
                val mask = curr[1]
                
                if (mask == endingMask) return ans
                
                for (neighbor in graph[node]) {
                    val nextMask = mask or (1 shl neighbor)
                    
                    if (!visited[neighbor][nextMask]) {
                        visited[neighbor][nextMask] = true
                        queue.add(intArrayOf(neighbor, nextMask))
                    }
                }
            }
            
            ans++
        }
        
        return -1
    }
}

