class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val safe = BooleanArray(n) { false }
        
        val ngraph: MutableList<MutableList<Int>> = mutableListOf()
        val rgraph: MutableList<MutableList<Int>> = mutableListOf()
        for (i in 0..n-1) {
            ngraph.add(mutableListOf())
            rgraph.add(mutableListOf())
        }
        
        val queue = ArrayDeque<Int>()
        for (i in 0..n-1) {
            if (graph[i].size == 0) {
                queue.add(i)
            }
            
            for (j in graph[i]) {
                ngraph.get(i).add(j)
                rgraph.get(j).add(i)
            }
        }
        
        while (!queue.isEmpty()) {
            val i = queue.removeFirst()
            safe[i] = true
            
            for (j in rgraph.get(i)) {
                ngraph.get(j).remove(i)
                if (ngraph.get(j).isEmpty()) {
                    queue.add(j)
                }
            }
        }
        
        val results: MutableList<Int> = mutableListOf()
        for (i in 0..n-1) {
            if (safe[i]) results.add(i)
        }
        
        return results
    }
}

