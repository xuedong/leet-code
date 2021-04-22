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
    private boolean partial(TreeNode node, int targetSum) {
        if (node == null) return false;
        if (node.val == targetSum && node.left == null && node.right == null) return true;
       
        int newSum = targetSum - node.val;
        if (node.left == null) {
            return partial(node.right, newSum);
        }
        if (node.right == null) {
            return partial(node.left, newSum);
        }
        return partial(node.left, newSum) || partial(node.right, newSum);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return partial(root, targetSum);
    }
}

