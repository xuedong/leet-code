class Solution {
    val graph: MutableList<HashSet<Int>>

    init {
        graph = mutableListOf()
    }

    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        val subsum: IntArray = IntArray(n)
        val count: IntArray = IntArray(n) { 1 }
        val ans: IntArray = IntArray(n)

        for (i in 0..n-1) {
            graph.add(hashSetOf())
        }
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }

        dfsCount(0, -1, count, subsum)
        ans[0] = subsum[0]
        dfsSum(0, -1, n, count, ans)
        return ans
    }

    private fun dfsCount(node: Int, parent: Int, count: IntArray, subsum: IntArray) {
        for (child in graph[node]) {
            if (child != parent) {
                dfsCount(child, node, count, subsum)
                count[node] += count[child]
                subsum[node] += subsum[child] + count[child]
            }
        }
    }

    private fun dfsSum(node: Int, parent: Int, n: Int, count: IntArray, ans: IntArray) {
        for (child in graph[node]) {
            if (child != parent) {
                ans[child] = ans[node] - count[child] + n - count[child]
                dfsSum(child, node, n, count, ans)
            }
        }
    }
}
