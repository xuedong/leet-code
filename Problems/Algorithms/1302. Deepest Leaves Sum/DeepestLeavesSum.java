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
    public int deepestLeavesSum(TreeNode root) {
        int h = height(root);
        return aux(root, h);
    }
    
    private int aux(TreeNode root, int h) {
        if (root == null) return 0;
        if (h == 1) return root.val;
        return aux(root.left, h-1) + aux(root.right, h-1);
    } 
    
    private int height(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

