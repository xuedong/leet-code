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
    private int res = 100000;
    private int pre = -100000;

    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }

        res = Math.min(res, root.val - pre);
        pre = root.val;

        if (root.right != null) {
            getMinimumDifference(root.right);
        }

        return res;
    }
}
