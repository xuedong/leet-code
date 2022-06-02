class Solution {
    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val redGraph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for (edge in redEdges) {
            if (!redGraph.containsKey(edge[0])) {
                redGraph[edge[0]] = mutableListOf()
            }
            redGraph[edge[0]]!!.add(edge[1])
        }
        
        val blueGraph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for (edge in blueEdges) {
            if (!blueGraph.containsKey(edge[0])) {
                blueGraph[edge[0]] = mutableListOf()
            }
            blueGraph[edge[0]]!!.add(edge[1])
        }
        
        val visited: HashSet<String> = hashSetOf()   
        val results = IntArray(n) { -1 }
        
        val queue = ArrayDeque<Pair<Int, String>>()
        queue.add(Pair(0, "null"))
        var steps = 0
        while (!queue.isEmpty()) {
            val length = queue.size
            for (i in 0..length-1) {
                val curr = queue.removeFirst()
                val node = curr.first
                val color = curr.second
                
                val key = node.toString() + "->" + color
                if (visited.contains(key)) {
                    continue
                }
                visited.add(key)
                
                if (results[node] == -1) {
                    results[node] = steps
                }
                
                if (color == "null" || color == "red") {
                    if (blueGraph[node] != null) {
                        for (neighbor in blueGraph[node]!!) {
                            queue.add(Pair(neighbor, "blue"))
                        }
                    } 
                }
                if (color == "null" || color == "blue") {
                    if (redGraph[node] != null) {
                        for (neighbor in redGraph[node]!!) {
                            queue.add(Pair(neighbor, "red"))
                        }
                    }
                }
            }
            
            steps++
        }
        
        return results
    }
}

