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
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int curr) {
        if (root == null) {
            return 0;
        }

        if (curr <= root.val) {
            return 1 + helper(root.left, root.val) + helper(root.right, root.val);
        } else {
            return helper(root.left, curr) + helper(root.right, curr);
        }
    }
}
