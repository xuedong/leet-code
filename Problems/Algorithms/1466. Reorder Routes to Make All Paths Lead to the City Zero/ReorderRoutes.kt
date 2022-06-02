class Solution {
    private var edges: Int
    
    init {
        edges = 0
    }
    
    fun minReorder(n: Int, connections: Array<IntArray>): Int {  
        val roads: HashSet<String> = hashSetOf()
        val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for (road in connections) {
            val s = road[0]
            val t = road[1]
            roads.add(s.toString() + "->" + t.toString())
            
            if (!graph.containsKey(s)) {
                graph[s] = mutableListOf()
            }
            graph[s]!!.add(t)
            
            if (!graph.containsKey(t)) {
                graph[t] = mutableListOf()
            }
            graph[t]!!.add(s)
        }
          
        dfs(0, -1, graph, roads)
        return edges
    }
    
    private fun dfs(current: Int, parent: Int, graph: Map<Int, List<Int>>, roads: HashSet<String>): Unit {
        val road = parent.toString() + "->" + current.toString()
        if (roads.contains(road)) {
            edges++
        }
        
        if (graph.containsKey(current)) {
            for (neighbor in graph[current]!!) {
                if (neighbor != parent) {
                    dfs(neighbor, current, graph, roads)
                }
            }
        }
    }
}

