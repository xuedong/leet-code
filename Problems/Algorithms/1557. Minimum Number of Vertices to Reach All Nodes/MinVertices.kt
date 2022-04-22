class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val results: MutableList<Int> = mutableListOf()
        
        val ins = IntArray(n) { 0 }
        for (edge in edges) {
            ins[edge[1]]++
        }
        
        for (i in 0..n-1) {
            if (ins[i] == 0) results.add(i)
        }
        
        return results
    }
}

