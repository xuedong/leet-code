class Solution {
    
    private var isPossible: Boolean
    private val colors: MutableMap<Int, Int>
    private val graph: MutableMap<Int, MutableList<Int>>
    private val topologicalOrder: MutableList<Int>
    
    init {
        isPossible = true
        colors = mutableMapOf()
        graph = mutableMapOf()
        topologicalOrder = mutableListOf()
    }
    
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        for (i in 0..numCourses-1) {
            colors.put(i, 0)
        }
        
        for (i in 0..prerequisites.size-1) {
            val curr = graph.getOrDefault(prerequisites[i][1], mutableListOf<Int>())
            curr.add(prerequisites[i][0])
            graph.put(prerequisites[i][1], curr)
        }
        
        for (i in 0..numCourses-1) {
            if (colors.get(i)!! == 0) {
                dfs(i)
            }
        }
        
        if (!isPossible) {
            return intArrayOf()
        }
        return topologicalOrder.reversed().toIntArray()
    }
    
    private fun dfs(node: Int) {
        if (!isPossible) return
        
        colors.put(node, 1)
        
        for (neighbor in graph.getOrDefault(node, mutableListOf<Int>())) {
            if (colors.get(neighbor)!! == 0) {
                dfs(neighbor)
            } else if (colors.get(neighbor)!! == 1) {
                isPossible = false
            }
        }
        
        colors.put(node, 2)
        topologicalOrder.add(node)
    }
    
}

