class Solution {
    private val adj: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()
    
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        for (edge in times) {
            val src = edge[0]
            val dest = edge[1]
            val time = edge[2]
            
            val neighbors = adj.getOrDefault(src, mutableListOf())
            neighbors.add(Pair(time, dest))
            adj.put(src, neighbors)
        }
        
        val timeTo = IntArray(n+1) { Int.MAX_VALUE }
        
        dijkstra(timeTo, k, n)
        
        var ans = 0
        for (i in 1..n) {
            ans = maxOf(ans, timeTo[i])
        }
        
        if (ans == Int.MAX_VALUE) return -1
        return ans
    }
    
    private fun dijkstra(timeTo: IntArray, src: Int, n: Int) {
        val pq = PriorityQueue<Pair<Int, Int>>( { a, b -> a.first - b.first } )
        pq.add(Pair(0, src))
        
        timeTo[src] = 0
        
        while (!pq.isEmpty()) {
            val top = pq.remove()
            val time = top.first
            val node = top.second
            
            if (time > timeTo[node]) {
                continue
            }
            
            if (!adj.containsKey(node)) {
                continue
            }
            
            for (neighbor in adj.get(node)!!) {
                val neighborTime = neighbor.first
                val neighborNode = neighbor.second
                
                if (timeTo[neighborNode] > time + neighborTime) {
                    timeTo[neighborNode] = time + neighborTime
                    pq.add(Pair(timeTo[neighborNode], neighborNode))
                }
            }
        }
    }
}

