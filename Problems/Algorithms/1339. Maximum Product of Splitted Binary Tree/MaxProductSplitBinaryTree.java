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
    private long max = 0;
    private long total = 0;

    public int maxProduct(TreeNode root) {
        dfs(root);
        update(root);

        return (int) (max % 1000000007);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        total += root.val;
        dfs(root.left);
        dfs(root.right);
    }

    private int update(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = update(root.left);
        int right = update(root.right);
        int sum = left + right + root.val;
        max = Math.max(max, sum * (total - sum));
        return sum;
    }
}