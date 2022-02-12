class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val neighbors: HashMap<Int, MutableSet<Int>> = HashMap<Int, MutableSet<Int>>()
        for (edge in edges) {
            if (!neighbors.containsKey(edge[0])) {
                neighbors.put(edge[0], HashSet<Int>())
            }
            if (!neighbors.containsKey(edge[1])) {
                neighbors.put(edge[1], HashSet<Int>())
            }
            neighbors.get(edge[0])!!.add(edge[1])
            neighbors.get(edge[1])!!.add(edge[0])
        }
        
        val visited: HashSet<Int> = HashSet<Int>()
        val stack: ArrayDeque<Int> = ArrayDeque<Int>()
        
        stack.push(source)
        while (!stack.isEmpty()) {
            val current: Int = stack.pop()
            if (!visited.contains(current)) {
                if (current == destination) return true
                for (neighbor in neighbors.get(current)!!) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor)
                    }
                }
                visited.add(current)
            }
        }
        
        return false
    }
}

