class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n = rooms.size
        val visited = BooleanArray(n) { false }
        visited[0] = true
        
        val stack = ArrayDeque<Int>()
        stack.add(0)
        
        while (!stack.isEmpty()) {
            val curr = stack.removeLast()
            
            for (neighbor in rooms.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    stack.add(neighbor)
                }
            }
        }
        
        for (v in visited) {
            if (!v) return false
        }
        return true
    }
}

