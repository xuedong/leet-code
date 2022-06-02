class Solution {
    fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
        var bound = x + a + b
        val visited: HashSet<Pair<Int, Int>> = hashSetOf()
        for (position in forbidden) {
            visited.add(Pair(1, position))
            visited.add(Pair(-1, position))
            bound = maxOf(bound, position + a + b)
        }
        
        val queue = ArrayDeque<Pair<Int, Int>>()
        visited.add(Pair(1, 0))
        queue.add(Pair(1, 0))
        
        var steps = 0
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0..size-1) {
                val curr = queue.removeFirst()
                val direction = curr.first
                val position = curr.second
                if (position == x) {
                    return steps
                }
                
                val forward = Pair(1, position + a)
                if (position + a <= bound && !visited.contains(forward)) {
                    visited.add(forward)
                    queue.add(forward)
                }
                
                val backward = Pair(-1, position - b)
                if (direction == 1 && position - b >= 0 && !visited.contains(backward)) {
                    visited.add(backward)
                    queue.add(backward)
                }
            }
            
            steps++
        }
        
        return -1          
    }
}

