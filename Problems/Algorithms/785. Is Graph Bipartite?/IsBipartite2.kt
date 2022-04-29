class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val visited: MutableMap<Int, Int> = mutableMapOf()
        
        val iter = 0..graph.size-1
        return iter.all { visited.contains(it) || dfs(graph, it, 1, visited) }
    }
    
    private fun dfs(graph: Array<IntArray>, idx: Int, part: Int, visited: MutableMap<Int, Int>): Boolean {
        if (visited.contains(idx)) {
            return visited[idx] == part
        }
        visited.put(idx, part)
        
        return graph[idx].all { dfs(graph, it, -part, visited) }
    }
}

