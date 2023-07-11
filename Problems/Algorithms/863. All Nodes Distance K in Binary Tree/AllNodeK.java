/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> graph;
    List<Integer> results;
    Set<Integer> visited;

    private void buildGraph(TreeNode curr, TreeNode parent) {
        if (curr != null && parent != null) {
            graph.computeIfAbsent(curr.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(curr.val);
        }

        if (curr.left != null) {
            buildGraph(curr.left, curr);
        }
        if (curr.right != null) {
            buildGraph(curr.right, curr);
        }
    }

    private void dfs(int curr, int distance, int k) {
        if (distance == k) {
            results.add(curr);
            return;
        }

        for (int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(neighbor, distance + 1, k);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);

        visited = new HashSet<>();
        visited.add(target.val);

        results = new ArrayList<>();

        dfs(target.val, 0, k);
        return results;
    }
}
