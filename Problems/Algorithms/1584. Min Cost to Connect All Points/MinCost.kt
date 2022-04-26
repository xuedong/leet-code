class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        
        val heap = PriorityQueue<Pair<Int, Int>>({ a, b -> a.second - b.second })
        
        val visited = BooleanArray(n) { false }
        heap.add(Pair(0, 0))
        
        var count = 0
        var cost = 0
        while (count < n) {
            val top = heap.poll()
            val weight = top.second
            val curr = top.first
            
            if (visited[curr]) {
                continue
            }
            
            visited[curr] = true
            cost += weight
            count++
            
            for (next in 0..n-1) {
                if (!visited[next]) {
                    val nextWeight = Math.abs(points[curr][0] - points[next][0]) + Math.abs(points[curr][1] - points[next][1])
                    
                    heap.add(Pair(next, nextWeight))
                }
            }
        }
        
        return cost
    }
}

