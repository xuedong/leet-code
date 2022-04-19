/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        
        partial(root, targetSum, new ArrayList<>());
        return result;
    }
    
    private void partial(TreeNode node, int sum, List<Integer> visited) {
        if (node == null) return;
        
        visited.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(visited));
            visited.remove(visited.size()-1);
            return;
        }
        
        partial(node.left, sum-node.val, visited);
        partial(node.right, sum-node.val, visited);
        visited.remove(visited.size()-1);
    }
}

