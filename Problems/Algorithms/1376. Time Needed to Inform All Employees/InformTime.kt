class Solution {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val graph: MutableList<MutableList<Int>> = mutableListOf()
        for (i in 0..n-1) {
            graph.add(mutableListOf())
        }
        for (i in 0..n-1) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i)
            }
        }
        
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(Pair(headID, 0))
        
        var ans = 0
        while (!queue.isEmpty()) {
            val curr = queue.removeFirst()
            val node = curr.first
            val time = curr.second
            ans = maxOf(ans, time)
            
            for (neighbor in graph.get(node)) {
                queue.add(Pair(neighbor, informTime[node]+time))
            }
        }
        
        return ans
    }
}

