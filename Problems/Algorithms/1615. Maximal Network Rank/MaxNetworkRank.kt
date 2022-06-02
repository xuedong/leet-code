class Solution {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val degrees: MutableMap<Int, Int> = mutableMapOf()
        val edges: HashSet<String> = hashSetOf()
        for (road in roads) {
            val s = road[0]
            val t = road[1]
            
            degrees.put(s, degrees.getOrDefault(s, 0) + 1)
            degrees.put(t, degrees.getOrDefault(t, 0) + 1)
            
            if (s < t) {
                edges.add(s.toString() + "-" + t.toString())
            } else {
                edges.add(t.toString() + "-" + s.toString())
            }
        }
        
        var ans = 0
        for (i in 0..n-2) {
            for (j in i+1..n-1) {
                if (degrees.containsKey(i) && degrees.containsKey(j)) {
                    if (edges.contains(i.toString() + "-" + j.toString())) {
                        ans = maxOf(ans, degrees[i]!! + degrees[j]!! - 1)
                    } else {
                        ans = maxOf(ans, degrees[i]!! + degrees[j]!!)
                    }
                }
            }
        }
        
        return ans
    }
}

