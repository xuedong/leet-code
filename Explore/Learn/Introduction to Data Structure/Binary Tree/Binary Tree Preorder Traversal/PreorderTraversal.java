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
    List<Integer> res = new ArrayList<>();
    
    public void aux(TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        aux(node.left);
        aux(node.right);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        aux(root);
        return res;
    }
}

