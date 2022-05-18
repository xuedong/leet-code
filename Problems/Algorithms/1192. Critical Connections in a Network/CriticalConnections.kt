class Solution {
    private var time: Int
    private val results: MutableList<List<Int>>
    
    init {
        time = 1
        results = mutableListOf()
    }
    
    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val graph = createGraph(n, connections)
        
        val rank = IntArray(n) { 0 }
        val low = IntArray(n) { 0 }
        
        dfs(0, -1, graph, rank, low)
        
        return results
    }
    
    private fun createGraph(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = mutableListOf()
        
        for (i in 0..n-1) {
            ans.add(mutableListOf())
        }
        
        for (connection in connections) {
            val u = connection.get(0)
            val v = connection.get(1)
            
            ans.get(u).add(v)
            ans.get(v).add(u)
        }
        
        return ans
    }
    
    private fun dfs(node: Int, parent: Int, graph: List<List<Int>>, rank: IntArray, low: IntArray): Unit {
        rank[node] = time
        low[node] = time
        time++
        
        for (neighbor in graph.get(node)) {
            if (neighbor == parent) continue
            
            if (rank[neighbor] == 0) {
                dfs(neighbor, node, graph, rank, low)
            }
            
            low[node] = minOf(low[node], low[neighbor])
        }
        
        if (parent != -1 && low[node] > rank[parent]) {
            results.add(listOf(parent, node))
        }
    }
}

