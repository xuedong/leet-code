class Solution {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        val len = connections.size
        if (len < n-1) return -1
        
        val visited = IntArray(n) { 0 }
        
        val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for (connection in connections) {
            val i = connection[0]
            val j = connection[1]
            if (map.containsKey(i)) {
                map.get(i)!!.add(j)
            } else {
                map.put(i, mutableListOf(j))
            }
            if (map.containsKey(j)) {
                map.get(j)!!.add(i)
            } else {
                map.put(j, mutableListOf(i))
            }
        }
        
        var ans = 0
        for (i in 0..n-1) {
            if (visited[i] == 0) ans++
            dfs(i, n, map, visited)
        }
        
        return ans - 1
    }
    
    private fun dfs(i: Int, n: Int, map: Map<Int, List<Int>>, visited: IntArray): Unit {
        if (visited[i] == 1) return
        visited[i] = 1
        
        if (map[i] != null) {
            for (j in map[i]!!) {
                if (visited[j] == 0) {
                    dfs(j, n, map, visited)
                }
            }
        }
    }
}

