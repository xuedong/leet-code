class Solution {
    private val results: MutableList<MutableList<Int>>
    private val path: MutableList<Int>
    
    init {
        results = mutableListOf()
        path = mutableListOf()
    }
    
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        path.add(0)
        aux(graph, 0, graph.size-1)
        return results
    }
    
    private fun aux(graph: Array<IntArray>, src: Int, target: Int): Unit {
        if (src == target) {
            results.add(ArrayList(path))
            return
        }
        
        if (graph[src].size == 0) {
            return
        }
        
        for (neighbor in graph[src]) {
            path.add(neighbor)
            aux(graph, neighbor, target)
            path.removeAt(path.size-1)
        }
    }
}

