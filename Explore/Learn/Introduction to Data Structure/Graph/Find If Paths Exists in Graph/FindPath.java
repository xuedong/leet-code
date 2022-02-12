class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int[] edge : edges) {
            if (!neighbors.containsKey(edge[0])) {
                neighbors.put(edge[0], new HashSet<>());
            }
            if (!neighbors.containsKey(edge[1])) {
                neighbors.put(edge[1], new HashSet<>());
            }
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(source);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                if (current == destination) return true;
                for (int neighbor : neighbors.get(current)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
                visited.add(current);
            }
        }
        
        return false;
    }
}

