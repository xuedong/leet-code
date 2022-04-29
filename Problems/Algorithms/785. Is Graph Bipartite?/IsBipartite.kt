class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val visited: MutableMap<Int, Int> = mutableMapOf()
        
        for (idx in 0..graph.size-1) {
            if (!visited.contains(idx) && !dfs(graph, idx, 1, visited)) {
                return false
            }
        }
        return true
    }
    
    private fun dfs(graph: Array<IntArray>, idx: Int, part: Int, visited: MutableMap<Int, Int>): Boolean {
        if (visited.contains(idx)) {
            return visited[idx] == part
        }
        visited.put(idx, part)
        
        for (neighbor in graph[idx]) {
            if (!dfs(graph, neighbor, -part, visited)) {
                return false
            }
        }
        return true
    }
}

