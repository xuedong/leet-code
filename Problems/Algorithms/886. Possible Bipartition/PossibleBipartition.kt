class Solution {
    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for (edge in dislikes) {
            val s = edge[0]
            val t = edge[1]
            
            if (!graph.containsKey(s)) {
                graph[s] = mutableListOf()
            }
            graph[s]!!.add(t)
            
            if (!graph.containsKey(t)) {
                graph[t] = mutableListOf()
            }
            graph[t]!!.add(s)
        }
        
        val color = IntArray(n) { 0 }
        val visited = BooleanArray(n) { false }
        
        val queue = ArrayDeque<Int>()
        for (i in 1..n) {
            if (!visited[i-1]) {
                color[i-1] = 1
                queue.add(i)
                
                while (!queue.isEmpty()) {
                    val curr = queue.removeFirst()
                    
                    if (visited[curr-1]) continue
                    visited[curr-1] = true
                    
                    if (!graph.containsKey(curr)) continue
                    for (neighbor in graph[curr]!!) {
                        if (color[neighbor-1] == color[curr-1]) return false
                        
                        if (color[curr-1] == 1) {
                            color[neighbor-1] = 2
                        } else {
                            color[neighbor-1] = 1
                        }
                        
                        queue.add(neighbor)
                    }
                }
            }
        }
        
        return true
    }
}

