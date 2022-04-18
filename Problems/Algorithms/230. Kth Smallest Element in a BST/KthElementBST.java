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
    private List<Integer> result;
    
    public int kthSmallest(TreeNode root, int k) {
        result = new ArrayList<>();
        
        aux(root, k);
        
        return result.get(k-1);
    }
    
    private void aux(TreeNode node, int k) {
        if (result.size() >= k || node == null) return;
        
        aux(node.left, k);
        result.add(node.val);
        aux(node.right, k);
    }
}

