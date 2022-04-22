class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>, inDegree: IntArray = IntArray(n)): List<Int> {
        return edges.map {
            inDegree[it[1]]++ 
        }.run {
            inDegree.withIndex().filter { 
                it.value == 0
            }.map { 
                it.index
            } 
        }
    }
}

