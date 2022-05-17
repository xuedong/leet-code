class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            
            for (int neighbor : rooms.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.add(neighbor);
                }
            }
        }
        
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}

